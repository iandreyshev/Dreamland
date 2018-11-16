package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureAccountApi.useCase.ISignInUseCase
import javax.inject.Inject

class SignInViewModel
@Inject constructor(
        private val navigator: IAccountNavigator,
        private val signInUseCase: ISignInUseCase
) : ViewModel() {

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val errorObservable: LiveData<SignInResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = MutableLiveData<SignInResult>()

    fun onStartSignIn(properties: SignInProperties) {
        mWaitingObservable.start()
        signInUseCase(properties)
                .doOnSuccess(::handleSignInResult)
                .doOnError(::handleSignInError)
                .subscribe { _, _ ->
                    mWaitingObservable.stop()
                }
    }

    fun onErrorClosed() {
        mErrorObservable.value = null
    }

    private fun handleSignInResult(result: SignInResult) = when (result) {
        SignInResult.SUCCESS ->
            navigator.onSignInSuccess()
        SignInResult.USER_NOT_EXISTS,
        SignInResult.NO_CONNECTION,
        SignInResult.INCORRECT_DATA,
        SignInResult.UNKNOWN ->
            mErrorObservable.setValue(result)
    }

    private fun handleSignInError(error: Throwable) {
        error.printStackTrace()
        mErrorObservable.value = SignInResult.UNKNOWN
    }

}

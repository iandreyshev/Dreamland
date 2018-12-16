package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.ioToMain
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

    val waiting: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val error: LiveData<SignInResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = MutableLiveData<SignInResult>()

    private var mSignInTask: Disposable? = null

    fun onStartSignIn(properties: SignInProperties) {
        mWaitingObservable.start()
        mSignInTask = signInUseCase(properties)
                .ioToMain()
                .subscribe { result, error ->
                    result?.let(::handleSignInResult)
                    error?.let(::handleSignInError)
                    mWaitingObservable.stop()
                }
    }

    fun onErrorClosed() {
        mErrorObservable.value = null
    }

    override fun onCleared() {
        mSignInTask?.dispose()
    }

    private fun handleSignInResult(result: SignInResult) = when (result) {
        SignInResult.SUCCESS ->
            navigator.onSignInSuccess()
        SignInResult.ERROR_USER_NOT_EXISTS,
        SignInResult.ERROR_NO_CONNECTION,
        SignInResult.ERROR_INCORRECT_DATA,
        SignInResult.ERROR_INCORRECT_EMAIL,
        SignInResult.ERROR_INCORRECT_PASSWORD,
        SignInResult.ERROR_UNKNOWN ->
            mErrorObservable.setValue(result)
    }

    private fun handleSignInError(error: Throwable) {
        error.printStackTrace()
        mErrorObservable.value = SignInResult.ERROR_UNKNOWN
    }

}

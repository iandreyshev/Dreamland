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

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val errorObservable: LiveData<SignInResult>
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

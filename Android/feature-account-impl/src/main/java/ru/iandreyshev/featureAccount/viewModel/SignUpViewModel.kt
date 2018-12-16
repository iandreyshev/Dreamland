package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveTypedEvent
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureAccountApi.useCase.ISignUpUseCase
import javax.inject.Inject

class SignUpViewModel
@Inject constructor(
        private val navigator: IAccountNavigator,
        private val signUpUseCase: ISignUpUseCase
) : ViewModel() {

    val waiting: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val error: LiveData<SignUpResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = SingleLiveTypedEvent<SignUpResult>()

    private var mSignUpTask: Disposable? = null

    fun startSignUp(properties: SignUpProperties) {
        mWaitingObservable.start()
        mSignUpTask = signUpUseCase(properties)
                .ioToMain()
                .subscribe { result, error ->
                    result?.let(::handleSignUpResult)
                    error?.let(::handleSignUpError)
                    mWaitingObservable.stop()
                }
    }

    override fun onCleared() {
        mSignUpTask?.dispose()
    }

    private fun handleSignUpResult(result: SignUpResult) {
        when (result) {
            SignUpResult.SUCCESS ->
                navigator.onSignUpSuccess()
            SignUpResult.ERROR_USER_ALREADY_EXISTS,
            SignUpResult.ERROR_INCORRECT_DATA,
            SignUpResult.ERROR_NO_CONNECTION,
            SignUpResult.ERROR_UNKNOWN ->
                mErrorObservable.setValue(result)
        }
    }

    private fun handleSignUpError(error: Throwable) {
        error.printStackTrace()
        mErrorObservable.value = SignUpResult.ERROR_UNKNOWN
    }

}

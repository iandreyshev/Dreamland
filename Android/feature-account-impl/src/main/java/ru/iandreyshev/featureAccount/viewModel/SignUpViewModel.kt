package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
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

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val errorObservable: LiveData<SignUpResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = SingleLiveEvent<SignUpResult>()

    fun startSignUp(properties: SignUpProperties) {
        mWaitingObservable.start()
        signUpUseCase(properties)
                .doOnSuccess(::handleSignUpResult)
                .doOnError(::handleSignUpError)
                .subscribe { _ ->
                    mWaitingObservable.stop()
                }
    }

    private fun handleSignUpResult(result: SignUpResult) = when (result) {
        SignUpResult.SUCCESS ->
            navigator.onSignUpSuccess()
        SignUpResult.USER_ALREADY_EXISTS,
        SignUpResult.INCORRECT_DATA,
        SignUpResult.NO_CONNECTION,
        SignUpResult.UNKNOWN ->
            mErrorObservable.setValue(result)
    }

    private fun handleSignUpError(error: Throwable) {
        error.printStackTrace()
        mErrorObservable.value = SignUpResult.UNKNOWN
    }

}

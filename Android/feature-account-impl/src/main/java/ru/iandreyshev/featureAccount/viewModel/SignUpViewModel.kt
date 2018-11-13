package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroidUtils.SingleLiveEvent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.navigation.IAccountNavigator
import ru.iandreyshev.featureAccountApi.repository.IAuthRepository
import ru.iandreyshev.featureAccountApi.repository.ISignUpProperties
import ru.iandreyshev.featureAccountApi.repository.SignUpResult
import ru.iandreyshev.viewModel.WaitingViewModel
import javax.inject.Inject

class SignUpViewModel
@Inject constructor(
        private val authRepository: IAuthRepository,
        private val navigator: IAccountNavigator
) : ViewModel() {

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val errorObservable: LiveData<SignUpResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = SingleLiveEvent<SignUpResult>()

    init {
        FeatureAccountComponent.get().inject(this)
    }

    fun startSignUp(properties: ISignUpProperties) {
        mWaitingObservable.start()
        authRepository.signUp(properties)
                .doOnSuccess(::handleSignUpResult)
                .doOnError(::handleSignUpError)
                .subscribe { _ ->
                    mWaitingObservable.stop()
                }
    }

    private fun handleSignUpResult(result: SignUpResult) {
        when (result) {
            SignUpResult.SUCCESS ->
                navigator.onSignUpSuccess()
            SignUpResult.USER_ALREADY_EXISTS,
            SignUpResult.NO_CONNECTION,
            SignUpResult.UNKNOWN ->
                mErrorObservable.setValue(result)
        }
    }

    private fun handleSignUpError(error: Throwable) {
        error.printStackTrace()
        mErrorObservable.value = SignUpResult.UNKNOWN
    }

}

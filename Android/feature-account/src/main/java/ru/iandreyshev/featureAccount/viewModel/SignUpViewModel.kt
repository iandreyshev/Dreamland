package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroidUtils.SingleLiveEvent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.presentation.data.AuthError
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccount.repository.ISignUpProperties
import ru.iandreyshev.featureAccount.repository.impl.SignUpResult
import ru.iandreyshev.viewModel.WaitViewModel
import javax.inject.Inject

class SignUpViewModel
@Inject constructor(
        private val authRepository: IAuthRepository
) : ViewModel() {

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingViewModel.observable

    val errorObservable: LiveData<AuthError>
        get() = mErrorViewModel

    private val mWaitingViewModel = WaitViewModel()
    private val mErrorViewModel = SingleLiveEvent<AuthError>()

    init {
        FeatureAccountComponent.get().inject(this)
    }

    fun startSignUp(properties: ISignUpProperties) {
        mWaitingViewModel.start()
        authRepository.signUp(properties)
                .doOnSuccess(::handleSignUpResult)
                .doOnError(::handleSignUpError)
                .subscribe { _ ->
                    mWaitingViewModel.stop()
                }
    }

    private fun handleSignUpResult(result: SignUpResult) {
    }

    private fun handleSignUpError(error: Throwable) {
    }

}

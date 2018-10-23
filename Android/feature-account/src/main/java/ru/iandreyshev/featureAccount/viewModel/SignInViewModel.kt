package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroidUtils.SingleLiveEvent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.presentation.data.AuthError
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccount.repository.ISignInProperties
import ru.iandreyshev.featureAccount.repository.impl.SignInResult
import ru.iandreyshev.rx.ioToMain
import ru.iandreyshev.viewModel.WaitViewModel
import javax.inject.Inject

class SignInViewModel
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

    fun startSignIn(properties: ISignInProperties) {
        mWaitingViewModel.start()
        authRepository.signIn(properties)
                .doOnSuccess(::handleSignInResult)
                .doOnError(::handleSignInError)
                .subscribe { _ ->
                    mWaitingViewModel.stop()
                }
    }

    private fun handleSignInResult(result: SignInResult) {
        when (result) {
            SignInResult.SUCCESS -> {}
            SignInResult.ERROR -> {
                mErrorViewModel.postValue(AuthError("Title", "Message"))
            }
        }
    }

    private fun handleSignInError(error: Throwable) {
        error.printStackTrace()
    }

}

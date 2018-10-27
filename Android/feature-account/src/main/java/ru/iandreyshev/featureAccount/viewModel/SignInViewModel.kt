package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroidUtils.SingleLiveEvent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.navigation.IAuthNavigator
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccount.repository.ISignInProperties
import ru.iandreyshev.featureAccount.repository.SignInResult
import ru.iandreyshev.viewModel.WaitingViewModel
import javax.inject.Inject

class SignInViewModel
@Inject constructor(
        private val authRepository: IAuthRepository,
        private val navigator: IAuthNavigator
) : ViewModel() {

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val errorObservable: LiveData<SignInResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = SingleLiveEvent<SignInResult>()

    init {
        FeatureAccountComponent.get().inject(this)
    }

    fun startSignIn(properties: ISignInProperties) {
        mWaitingObservable.start()
        authRepository.signIn(properties)
                .doOnSuccess(::handleSignInResult)
                .doOnError(::handleSignInError)
                .subscribe { _ ->
                    mWaitingObservable.stop()
                }
    }

    private fun handleSignInResult(result: SignInResult) {
        when (result) {
            SignInResult.SUCCESS ->
                navigator.onSignInSuccess()
            SignInResult.USER_NOT_EXISTS,
            SignInResult.NO_CONNECTION,
            SignInResult.UNKNOWN ->
                mErrorObservable.setValue(result)
        }
    }

    private fun handleSignInError(error: Throwable) {
        error.printStackTrace()
        mErrorObservable.value = SignInResult.UNKNOWN
    }

}

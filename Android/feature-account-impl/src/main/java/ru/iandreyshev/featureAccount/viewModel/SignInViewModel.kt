package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroidUtils.SingleLiveEvent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.navigation.IAccountNavigator
import ru.iandreyshev.featureAccountApi.repository.IAuthRepository
import ru.iandreyshev.featureAccountApi.repository.ISignInProperties
import ru.iandreyshev.featureAccountApi.repository.SignInResult
import ru.iandreyshev.viewModel.WaitingViewModel
import javax.inject.Inject

class SignInViewModel
@Inject constructor(
        private val authRepository: IAuthRepository,
        private val navigator: IAccountNavigator
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

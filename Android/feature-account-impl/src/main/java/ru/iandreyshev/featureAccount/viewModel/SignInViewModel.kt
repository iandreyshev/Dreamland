package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureAccountApi.useCase.ISignInUseCase
import javax.inject.Inject

class SignInViewModel : ViewModel() {

    @Inject
    lateinit var mNavigator: IAccountNavigator
    @Inject
    lateinit var mSignInUseCase: ISignInUseCase

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val errorObservable: LiveData<SignInResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = SingleLiveEvent<SignInResult>()

    init {
        FeatureAccountComponent.get().inject(this)
    }

    fun startSignIn(properties: SignInProperties) {
        mWaitingObservable.start()
        mSignInUseCase(properties)
                .doOnSuccess(::handleSignInResult)
                .doOnError(::handleSignInError)
                .subscribe { _ ->
                    mWaitingObservable.stop()
                }
    }

    private fun handleSignInResult(result: SignInResult) = when (result) {
        SignInResult.SUCCESS ->
            mNavigator.onSignInSuccess()
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

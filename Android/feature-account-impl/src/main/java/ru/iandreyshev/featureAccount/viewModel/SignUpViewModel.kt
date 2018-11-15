package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import javax.inject.Inject

class SignUpViewModel : ViewModel() {

    @Inject
    lateinit var mAuthRepository: IAuthRepository
    @Inject
    lateinit var mNavigator: IAccountNavigator

    val waitingObservable: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val errorObservable: LiveData<SignUpResult>
        get() = mErrorObservable

    private val mWaitingObservable = WaitingViewModel()
    private val mErrorObservable = SingleLiveEvent<SignUpResult>()

    init {
        FeatureAccountComponent.get().inject(this)
    }

    fun startSignUp(properties: SignUpProperties) {
        mWaitingObservable.start()
        mAuthRepository.signUp(properties)
                .doOnSuccess(::handleSignUpResult)
                .doOnError(::handleSignUpError)
                .subscribe { _ ->
                    mWaitingObservable.stop()
                }
    }

    private fun handleSignUpResult(result: SignUpResult) {
        when (result) {
            SignUpResult.SUCCESS ->
                mNavigator.onSignUpSuccess()
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

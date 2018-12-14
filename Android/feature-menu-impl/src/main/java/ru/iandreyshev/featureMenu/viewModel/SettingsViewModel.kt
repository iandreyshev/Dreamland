package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureAccountApi.data.DeleteUserResult
import ru.iandreyshev.featureAccountApi.useCase.IDeleteUserUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import javax.inject.Inject

class SettingsViewModel
@Inject constructor(
        private val logOutUseCase: ILogOutUseCase,
        private val deleteUserUseCase: IDeleteUserUseCase,
        private val navigator: IMenuNavigator
) : ViewModel() {

    val waiting: LiveData<Boolean>
        get() = mWaitingObservable.observable

    val deleteResult: LiveData<DeleteUserResult>
        get() = mDeleteUserResult

    private val mWaitingObservable = WaitingViewModel()
    private val mDeleteUserResult = MutableLiveData<DeleteUserResult>()

    private var mLogOutUseCaseSubscription: Disposable? = null
    private var mDeleteUserUseCaseSubscription: Disposable? = null

    fun onLogOut() {
        mLogOutUseCaseSubscription = logOutUseCase()
                .ioToMain()
                .doOnSubscribe { mWaitingObservable.start() }
                .subscribe {
                    mWaitingObservable.stop()
                    navigator.onLogout()
                }
    }

    fun onDeleteUser() {
        mDeleteUserUseCaseSubscription = deleteUserUseCase()
                .ioToMain()
                .doOnSubscribe { mWaitingObservable.start() }
                .subscribe { result, error ->
                    result?.let(::handleDeleteUserResult)
                    error?.let(::handleDeleteUserError)
                    mWaitingObservable.stop()
                }

    }

    private fun handleDeleteUserResult(result: DeleteUserResult?) {
        when (result) {
            DeleteUserResult.SUCCESS ->
                navigator.onDeleteUser()
            DeleteUserResult.NO_CONNECTION,
            DeleteUserResult.UNKNOWN ->
                mDeleteUserResult.setValue(result)
        }
    }

    private fun handleDeleteUserError(error: Throwable?) {
        mDeleteUserResult.value = DeleteUserResult.UNKNOWN
    }

}

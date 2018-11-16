package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureAccountApi.observable.IUserApi
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import javax.inject.Inject

class MenuViewModel @Inject constructor(
        private val logoutUseCase: ILogOutUseCase,
        private val menuNavigator: IMenuNavigator,
        userObservableApi: IUserApi
) : ViewModel() {

    // Data
    val user: LiveData<User>
        get() = mUser

    // Events
    val backEvent: LiveData<Unit>

    private val mBackEvent = SingleLiveEvent<Unit>()
    private val mUser = MutableLiveData<User>()

    init {
        backEvent = mBackEvent
        userObservableApi.observable.subscribe { mUser.value = it }
    }

    fun onCreateDreamClick() =
            menuNavigator.onCreateDream()

    fun onLogoutClick() {
        logoutUseCase().subscribe {
            mBackEvent.call()
            menuNavigator.onLogout()
        }
    }

}

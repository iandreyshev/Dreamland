package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import ru.iandreyshev.featureMenu.model.User
import ru.iandreyshev.vext.liveData.liveDataOf
import javax.inject.Inject

class MenuViewModel @Inject constructor(
        private val logoutUseCase: ILogoutUseCase,
        private val menuNavigator: IMenuNavigator
) : ViewModel() {

    // Data
    val userObservable: LiveData<User> = liveDataOf()

    // Events
    val backEvent: LiveData<Unit>

    private val mBackEvent = SingleLiveEvent<Unit>()

    init {
        backEvent = mBackEvent
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

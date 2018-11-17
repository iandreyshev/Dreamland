package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureAccountApi.observable.IUserApi
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class MenuViewModel @Inject constructor(
        private val menuNavigator: IMenuNavigator,
        userObservableApi: IUserApi
) : ViewModel() {

    enum class MenuState {
        DREAMS,
        SETTINGS
    }

    val user: LiveData<User>
        get() = mUser

    val menuState: LiveData<MenuState>
        get() = mMenuState

    private val mUser = MutableLiveData<User>()
    private val mMenuState = mutableLiveDataOf(MenuState.DREAMS)

    private var mUserSubscription: Disposable? = null

    init {
        mUserSubscription = userObservableApi.observable
                .subscribe { mUser.value = it }
    }

    fun onCreateDream() = menuNavigator.onCreateDream()

    fun onNewMenuState(state: MenuState) {
        mMenuState.value = state
    }

}

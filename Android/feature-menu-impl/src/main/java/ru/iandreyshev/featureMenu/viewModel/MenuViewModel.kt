package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureAccountApi.api.IUserApi
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class MenuViewModel
@Inject constructor(
        private val menuNavigator: IMenuNavigator,
        dreamsRepository: IDreamsRepository,
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
    val dreamsAvailability: LiveData<Boolean>
        get() = mDreamsAvailability

    private val mUser = MutableLiveData<User>()
    private val mMenuState = mutableLiveDataOf(MenuState.DREAMS)
    private val mDreamsAvailability = mutableLiveDataOf(false)

    private val mUserSubscription: Disposable
    private val mDreamsCountSubscription: Disposable

    init {
        mUserSubscription = userObservableApi.observable
                .subscribe { mUser.value = it }
        mDreamsCountSubscription = dreamsRepository.dreamsObservable
                .map { it.isNotEmpty() }
                .subscribe { mDreamsAvailability.value = it }
    }

    fun onCreateDream() = menuNavigator.onCreateDream()

    fun onNewMenuState(state: MenuState) {
        mMenuState.value = state
    }

    override fun onCleared() {
        mUserSubscription.dispose()
        mDreamsCountSubscription.dispose()
    }

}

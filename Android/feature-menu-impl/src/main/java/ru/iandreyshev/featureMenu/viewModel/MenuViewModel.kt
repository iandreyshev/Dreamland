package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureMenu.model.User
import ru.iandreyshev.featureMenuApi.navigation.IMenuNavigator
import ru.iandreyshev.vext.liveData.liveDataOf
import javax.inject.Inject

class MenuViewModel
@Inject constructor(
        private val menuNavigator: IMenuNavigator
) : ViewModel() {

    val userObservable: LiveData<User> = liveDataOf()

    fun onCreateDreamClick() =
            menuNavigator.onCreateDream()

    fun onLogoutClick() {
    }

}

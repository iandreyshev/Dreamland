package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreDatabase.api.ICoreDatabaseApi
import ru.iandreyshev.coreDatabase.api.IUserDatabaseApi
import ru.iandreyshev.featureMenu.di.IFeatureMenuDependencies
import ru.iandreyshev.featureMenu.model.User
import ru.iandreyshev.featureMenu.navigation.IMenuNavigator
import javax.inject.Inject

internal class MenuViewModel
@Inject constructor(
        private val menuNavigator: IMenuNavigator,
        private val coreDb: IUserDatabaseApi
) : ViewModel() {

    val userObservable: LiveData<User> = TODO()

    fun openAccount() = menuNavigator.openAccount()

}

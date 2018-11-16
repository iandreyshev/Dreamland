package ru.iandreyshev.dreamland.proxy.navigation

import android.app.Application
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity
import ru.iandreyshev.featureAccount.ui.activity.AuthActivity
import ru.iandreyshev.featureMenu.di.dependencies.ISplashNavigator
import javax.inject.Inject

class FeatureMenuSplashNavigator
@Inject constructor(
        private val application: Application
) : ISplashNavigator {

    override fun onUserSignedIn() {
        application.startActivity<MenuActivity>()
    }

    override fun onUserDoesNotExists() {
        application.startActivity<AuthActivity>()
    }

}
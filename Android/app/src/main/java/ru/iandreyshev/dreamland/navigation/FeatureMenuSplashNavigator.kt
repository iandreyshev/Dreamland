package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity
import ru.iandreyshev.featureAccount.ui.activity.AuthActivity
import ru.iandreyshev.featureMenu.di.dependencies.ISplashNavigator
import javax.inject.Inject

class FeatureMenuSplashNavigator
@Inject constructor(
        private val context: Context
) : ISplashNavigator {

    override fun onUserSignedIn() {
        context.startActivity<MenuActivity>()
    }

    override fun onUserDoesNotExists() {
        context.startActivity<AuthActivity>()
    }

}
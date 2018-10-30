package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity
import ru.iandreyshev.featureAccount.presentation.activity.AuthActivity
import javax.inject.Inject

class SplashNavigator
@Inject constructor(
        private val context: Context
) : ISplashNavigator {

    override fun onUserInSignedIn() {
        context.startActivity<MenuActivity>()
    }

    override fun onUserDoesNotExists() {
        context.startActivity<AuthActivity>()
    }

}
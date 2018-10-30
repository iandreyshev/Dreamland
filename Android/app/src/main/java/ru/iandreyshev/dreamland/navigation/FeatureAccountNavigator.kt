package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureAccount.navigation.IAccountNavigator
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity

class FeatureAccountNavigator(
        private val context: Context
) : IAccountNavigator {

    override fun onSignInSuccess() {
        context.startActivity<MenuActivity>()
    }

    override fun onSignUpSuccess() {
        context.startActivity<MenuActivity>()
    }

}
package ru.iandreyshev.dreamland.proxy.navigation

import android.app.Application
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity
import javax.inject.Inject

class FeatureAccountNavigator
@Inject constructor(
        private val application: Application
) : IAccountNavigator {

    override fun onSignInSuccess() {
        application.startActivity<MenuActivity>()
    }

    override fun onSignUpSuccess() {
        application.startActivity<MenuActivity>()
    }

}
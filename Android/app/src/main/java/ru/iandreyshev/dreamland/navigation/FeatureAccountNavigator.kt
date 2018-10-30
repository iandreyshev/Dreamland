package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureAccountApi.IAccountNavigator
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity
import javax.inject.Inject

class FeatureAccountNavigator
@Inject constructor(
        private val context: Context
) : IAccountNavigator {

    override fun onSignInSuccess() {
        context.startActivity<MenuActivity>()
    }

    override fun onSignUpSuccess() {
        context.startActivity<MenuActivity>()
    }

}
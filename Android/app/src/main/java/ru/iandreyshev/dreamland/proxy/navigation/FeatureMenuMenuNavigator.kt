package ru.iandreyshev.dreamland.proxy.navigation

import android.app.Application
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureAccount.ui.activity.AuthActivity
import ru.iandreyshev.featureDreams.fragment.DreamConstructorActivity
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import javax.inject.Inject

class FeatureMenuMenuNavigator
@Inject constructor(
        private val application: Application
) : IMenuNavigator {

    override fun onCreateDream() {
        application.startActivity<DreamConstructorActivity>()
    }

    override fun onLogout() {
        application.startActivity<AuthActivity>()
    }

}

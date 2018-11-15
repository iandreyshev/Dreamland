package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureAccount.ui.activity.AuthActivity
import ru.iandreyshev.featureDreams.fragment.DreamConstructorActivity
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import javax.inject.Inject

class FeatureMenuMenuNavigator
@Inject constructor(
        private val context: Context
) : IMenuNavigator {

    override fun onCreateDream() {
        context.startActivity<DreamConstructorActivity>()
    }

    override fun onLogout() {
        context.startActivity<AuthActivity>()
    }

}

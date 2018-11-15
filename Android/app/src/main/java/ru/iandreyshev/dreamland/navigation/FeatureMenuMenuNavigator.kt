package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureDreams.fragment.CreateDreamActivity
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import javax.inject.Inject

class FeatureMenuMenuNavigator
@Inject constructor(
        private val context: Context
) : IMenuNavigator {

    override fun onCreateDream() {
        context.startActivity<CreateDreamActivity>()
    }

    override fun onLogout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

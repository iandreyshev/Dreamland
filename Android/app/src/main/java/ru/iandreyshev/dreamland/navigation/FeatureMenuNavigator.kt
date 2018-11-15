package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.dreams.presentation.fragment.CreateDreamActivity
import ru.iandreyshev.featureMenuApi.navigation.IMenuNavigator
import javax.inject.Inject

class FeatureMenuNavigator
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

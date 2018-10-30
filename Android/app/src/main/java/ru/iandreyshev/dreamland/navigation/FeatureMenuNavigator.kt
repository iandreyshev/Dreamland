package ru.iandreyshev.dreamland.navigation

import android.content.Context
import org.jetbrains.anko.startActivity
import ru.iandreyshev.featureAccount.presentation.activity.AccountActivity
import ru.iandreyshev.featureMenuApi.navigation.IMenuNavigator
import javax.inject.Inject

class FeatureMenuNavigator
@Inject constructor(
        private val context: Context
) : IMenuNavigator {

    override fun openAccount() =
            context.startActivity<AccountActivity>()

}

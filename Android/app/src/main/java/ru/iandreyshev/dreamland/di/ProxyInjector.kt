package ru.iandreyshev.dreamland.di

import android.content.Context
import ru.iandreyshev.coreDatabase.di.CoreDatabaseComponent
import ru.iandreyshev.coreDatabase.di.DaggerCoreDatabaseComponent
import ru.iandreyshev.dreamland.navigation.FeatureAccountNavigator
import ru.iandreyshev.dreamland.navigation.FeatureMenuNavigator
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent_DependenciesComponent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureMenu.di.DaggerFeatureMenuComponent
import ru.iandreyshev.featureMenu.di.DaggerFeatureMenuComponent_DependenciesComponent
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import javax.inject.Inject

class ProxyInjector
@Inject constructor(
        private val context: Context,
        private val menuNavigator: FeatureMenuNavigator,
        private val accountNavigator: FeatureAccountNavigator
) {

    fun featureAccountComponent(): FeatureAccountComponent =
            DaggerFeatureAccountComponent.builder()
                    .iFeatureAccountDependencies(DaggerFeatureAccountComponent_DependenciesComponent.builder()
                            .iAccountNavigator(accountNavigator)
                            .build())
                    .build()

    fun featureMenuComponent(): FeatureMenuComponent {
        return DaggerFeatureMenuComponent.builder()
                .iFeatureMenuDependencies(DaggerFeatureMenuComponent_DependenciesComponent.builder()
                        .iMenuNavigator(menuNavigator)
                        .build())
                .build()
    }

    fun coreDatabaseComponent(): CoreDatabaseComponent {
        return DaggerCoreDatabaseComponent.builder()
                .context(context)
                .build()
    }

}
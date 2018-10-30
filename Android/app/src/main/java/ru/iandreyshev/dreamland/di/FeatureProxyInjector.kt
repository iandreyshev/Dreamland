package ru.iandreyshev.dreamland.di

import android.content.Context
import ru.iandreyshev.dreamland.navigation.FeatureAccountNavigator
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent_FeatureAccountDependenciesComponent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureMenu.di.DaggerFeatureMenuComponent
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent

class FeatureProxyInjector(
        private val context: Context
) {

    fun featureAccountComponent(): FeatureAccountComponent =
            DaggerFeatureAccountComponent.builder()
                    .iFeatureAccountDependencies(DaggerFeatureAccountComponent_FeatureAccountDependenciesComponent
                            .builder()
                            .iAccountNavigator(FeatureAccountNavigator(context))
                            .build())
                    .build()

    fun featureMenuComponent(context: Context): FeatureMenuComponent {
        return DaggerFeatureMenuComponent.builder()
                .dependenciesComponent(FeatureMenuDependences(context))
                .build()
    }

}
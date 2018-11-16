package ru.iandreyshev.dreamland.proxy

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import ru.iandreyshev.coreNetwork.di.CoreNetworkComponent
import ru.iandreyshev.dreamland.navigation.FeatureAccountNavigator
import ru.iandreyshev.dreamland.navigation.FeatureMenuMenuNavigator
import ru.iandreyshev.dreamland.navigation.FeatureMenuSplashNavigator
import ru.iandreyshev.featureDreams.di.DaggerFeatureDreamsComponent
import ru.iandreyshev.featureDreams.di.DaggerFeatureDreamsComponent_DependenciesComponent
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent_DependenciesComponent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.di.dependencies.IContextProvider
import ru.iandreyshev.featureMenu.di.DaggerFeatureMenuComponent
import ru.iandreyshev.featureMenu.di.DaggerFeatureMenuComponent_DependenciesComponent
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import javax.inject.Inject

class ProxyInjector
@Inject constructor(
        private val context: Context,
        private val menuNavigator: FeatureMenuMenuNavigator,
        private val splashNavigator: FeatureMenuSplashNavigator,
        private val accountNavigator: FeatureAccountNavigator,
        private val viewModelFactory: ViewModelProvider.Factory
) {

    fun featureAccountComponent(): FeatureAccountComponent =
            DaggerFeatureAccountComponent.builder()
                    .iFeatureAccountDependencies(DaggerFeatureAccountComponent_DependenciesComponent.builder()
                            .iAccountNavigator(accountNavigator)
                            .iCoreNetworkApi(CoreNetworkComponent.get())
                            .factory(viewModelFactory)
                            .iContextProvider(object : IContextProvider {
                                override val applicationContext: Context = context
                            })
                            .build())
                    .build()

    fun featureMenuComponent(): FeatureMenuComponent =
            DaggerFeatureMenuComponent.builder()
                    .iFeatureMenuDependencies(DaggerFeatureMenuComponent_DependenciesComponent.builder()
                            .iFeatureAccountApi(FeatureAccountComponent.get())
                            .iFeatureDreamsApi(FeatureDreamsComponent.get())
                            .iSplashNavigator(splashNavigator)
                            .iMenuNavigator(menuNavigator)
                            .factory(viewModelFactory)
                            .build())
                    .build()

    fun featureDreamsComponent(): FeatureDreamsComponent =
            DaggerFeatureDreamsComponent.builder()
                    .iFeatureDreamsDependencies(DaggerFeatureDreamsComponent_DependenciesComponent.builder()
                            .factory(viewModelFactory)
                            .build())
                    .build()

}
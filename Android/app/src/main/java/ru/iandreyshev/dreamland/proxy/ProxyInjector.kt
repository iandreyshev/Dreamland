package ru.iandreyshev.dreamland.proxy

import android.app.Application
import ru.iandreyshev.coreAndroid.di.context.asProvider
import ru.iandreyshev.coreNetwork.di.CoreNetworkComponent
import ru.iandreyshev.coreNetwork.di.DaggerCoreNetworkComponent
import ru.iandreyshev.coreNetwork.di.DaggerCoreNetworkComponent_DependenciesComponent
import ru.iandreyshev.dreamland.proxy.navigation.FeatureAccountNavigator
import ru.iandreyshev.dreamland.proxy.navigation.FeatureMenuMenuNavigator
import ru.iandreyshev.dreamland.proxy.navigation.FeatureMenuSplashNavigator
import ru.iandreyshev.featureDreams.di.DaggerFeatureDreamsComponent
import ru.iandreyshev.featureDreams.di.DaggerFeatureDreamsComponent_DependenciesComponent
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent_DependenciesComponent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureMenu.di.DaggerFeatureMenuComponent
import ru.iandreyshev.featureMenu.di.DaggerFeatureMenuComponent_DependenciesComponent
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import javax.inject.Inject

class ProxyInjector
@Inject constructor(
        private val application: Application,
        private val menuNavigator: FeatureMenuMenuNavigator,
        private val splashNavigator: FeatureMenuSplashNavigator,
        private val accountNavigator: FeatureAccountNavigator
) {

    fun coreNetworkComponent(): CoreNetworkComponent =
            DaggerCoreNetworkComponent.builder()
                    .iCoreNetworkDependencies(DaggerCoreNetworkComponent_DependenciesComponent.builder()
                            .iContextProvider(application.asProvider())
                            .build())
                    .build()

    fun featureAccountComponent(): FeatureAccountComponent =
            DaggerFeatureAccountComponent.builder()
                    .iFeatureAccountDependencies(DaggerFeatureAccountComponent_DependenciesComponent.builder()
                            .iAccountNavigator(accountNavigator)
                            .iCoreNetworkApi(CoreNetworkComponent.get())
                            .iContextProvider(application.asProvider())
                            .iFeatureDreamsApi(FeatureDreamsComponent.get())
                            .build())
                    .build()

    fun featureMenuComponent(): FeatureMenuComponent =
            DaggerFeatureMenuComponent.builder()
                    .iFeatureMenuDependencies(DaggerFeatureMenuComponent_DependenciesComponent.builder()
                            .iFeatureAccountApi(FeatureAccountComponent.get())
                            .iFeatureDreamsApi(FeatureDreamsComponent.get())
                            .iSplashNavigator(splashNavigator)
                            .iMenuNavigator(menuNavigator)
                            .build())
                    .build()

    fun featureDreamsComponent(): FeatureDreamsComponent =
            DaggerFeatureDreamsComponent.builder()
                    .iFeatureDreamsDependencies(DaggerFeatureDreamsComponent_DependenciesComponent.builder()
                            .iContextProvider(application.asProvider())
                            .build())
                    .build()

}
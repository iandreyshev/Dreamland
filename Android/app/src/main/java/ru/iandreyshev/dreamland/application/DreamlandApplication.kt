package ru.iandreyshev.dreamland.application

import android.app.Application
import ru.iandreyshev.coreNetwork.di.CoreNetworkComponent
import ru.iandreyshev.coreNetwork.di.DaggerCoreNetworkComponent
import ru.iandreyshev.dreamland.di.DaggerAppComponent
import ru.iandreyshev.dreamland.di.AppComponent
import ru.iandreyshev.dreamland.proxy.ProxyInjector
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import javax.inject.Inject

class DreamlandApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    @Inject
    internal lateinit var proxyInjector: ProxyInjector

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppComponent.init(DaggerAppComponent.create())
        AppComponent.get().inject(this)

        CoreNetworkComponent.init(DaggerCoreNetworkComponent.create())
        FeatureAccountComponent.init(proxyInjector.featureAccountComponent())
        FeatureDreamsComponent.init(proxyInjector.featureDreamsComponent())
        FeatureMenuComponent.init(proxyInjector.featureMenuComponent())
    }

}

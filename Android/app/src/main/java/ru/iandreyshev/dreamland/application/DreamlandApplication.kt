package ru.iandreyshev.dreamland.application

import android.app.Application
import ru.iandreyshev.coreNetwork.di.CoreNetworkComponent
import ru.iandreyshev.dreamland.di.DaggerAppComponent
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

        DaggerAppComponent.builder().create(this).inject(this)

        CoreNetworkComponent.init(proxyInjector.coreNetworkComponent())
        FeatureDreamsComponent.init(proxyInjector.featureDreamsComponent())
        FeatureAccountComponent.init(proxyInjector.featureAccountComponent())
        FeatureMenuComponent.init(proxyInjector.featureMenuComponent())
    }

}

package ru.iandreyshev.dreamland.application

import android.app.Application
import ru.iandreyshev.coreDatabase.di.CoreDatabaseComponent
import ru.iandreyshev.coreDatabase.di.DaggerCoreDatabaseComponent
import ru.iandreyshev.coreNetwork.di.CoreNetworkComponent
import ru.iandreyshev.coreNetwork.di.DaggerCoreNetworkComponent
import ru.iandreyshev.dreamland.di.DaggerAppComponent
import ru.iandreyshev.dreamland.di.AppComponent
import ru.iandreyshev.dreamland.di.FeatureProxyInjector
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent

class DreamlandApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        val proxyInjector = FeatureProxyInjector(applicationContext)

        AppComponent.init(DaggerAppComponent.create())
        CoreNetworkComponent.init(DaggerCoreNetworkComponent.create())
        CoreDatabaseComponent.init(DaggerCoreDatabaseComponent.create())
        FeatureAccountComponent.init(proxyInjector.featureAccountComponent())
        FeatureMenuComponent.init(proxyInjector.featureMenuComponent(applicationContext))

        AppComponent.get().inject(this)
    }

}

package ru.iandreyshev.dreamland.application

import android.app.Application
import ru.iandreyshev.dreamland.di.DaggerAppComponent
import ru.iandreyshev.dreamland.di.AppComponent
import ru.iandreyshev.dreamland.di.FeatureProxyInjector
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent

class DreamlandApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppComponent.init(DaggerAppComponent.create())

        val featureAccountComponent = FeatureProxyInjector
                .featureAccountComponent(applicationContext)
        FeatureAccountComponent.init(featureAccountComponent)

        AppComponent.get().inject(this)
    }

}

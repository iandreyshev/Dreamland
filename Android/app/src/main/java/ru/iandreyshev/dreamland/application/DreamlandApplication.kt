package ru.iandreyshev.dreamland.application

import android.app.Application
import android.content.Context
import io.objectbox.BoxStore
import ru.iandreyshev.dreamland.di.DaggerAppComponent
import ru.iandreyshev.dreamland.di.AppComponent
import javax.inject.Inject

class DreamlandApplication : Application() {

    @Inject
    lateinit var mBoxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        AppComponent.init(DaggerAppComponent.create())
        AppComponent.get().inject(this)
    }

    companion object {
        lateinit var appContext: Context
    }

}

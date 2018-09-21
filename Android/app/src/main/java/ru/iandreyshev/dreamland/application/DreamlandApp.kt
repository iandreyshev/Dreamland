package ru.iandreyshev.dreamland.application

import android.app.Application
import android.content.Context
import io.objectbox.BoxStore
import ru.iandreyshev.featureAccount.model.storage.MyObjectBox

class DreamlandApp : Application() {

    private lateinit var mBoxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        initBoxStore()
    }

    private fun initBoxStore() {
        mBoxStore = MyObjectBox.builder()
                .androidContext(this)
                .build()
    }

}

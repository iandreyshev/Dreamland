package ru.iandreyshev.dreamland.application

import android.app.Application
import android.content.Context
import dagger.android.DaggerApplication
import io.objectbox.BoxStore
import ru.iandreyshev.dreamland.di.AppComponent
import ru.iandreyshev.dreamland.di.MainViewModelFactory
import ru.iandreyshev.dreamland.di.MenuViewModelFactory
import ru.iandreyshev.featureAccount.model.repository.IUserRepository
import ru.iandreyshev.featureAccount.model.storage.MyObjectBox

class DreamlandApplication : Application() {

    private lateinit var mBoxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
        )

        initBoxStore()
        initAccountRepository()
        initMainVMFactory()
        initMenuVMFactory()
    }

    private fun initBoxStore() {
        mBoxStore = MyObjectBox.builder()
                .androidContext(this)
                .build()
    }

    private fun initAccountRepository() {
        accountRepository = IUserRepository.builder()
                .withStore(mBoxStore)
                .build()
    }

    private fun initMainVMFactory() {
        mainViewModelFactory = MainViewModelFactory(accountRepository)
    }

    private fun initMenuVMFactory() {
        menuViewModelFactory = MenuViewModelFactory()
    }

    companion object {
        lateinit var appContext: Context
        lateinit var accountRepository: IUserRepository
        lateinit var mainViewModelFactory: MainViewModelFactory
        lateinit var menuViewModelFactory: MenuViewModelFactory
    }

}
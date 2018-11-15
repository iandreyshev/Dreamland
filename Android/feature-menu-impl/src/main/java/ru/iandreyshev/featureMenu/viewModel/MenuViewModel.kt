package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import ru.iandreyshev.featureMenu.di.dependencies.ISplashNavigator
import ru.iandreyshev.featureMenu.model.User
import ru.iandreyshev.vext.liveData.liveDataOf
import javax.inject.Inject

class MenuViewModel : ViewModel() {

    @Inject
    lateinit var mLogoutUseCase: ILogoutUseCase
    @Inject
    lateinit var mMenuNavigator: IMenuNavigator

    val userObservable: LiveData<User> = liveDataOf()

    init {
        FeatureMenuComponent.get().inject(this)
    }

    fun onCreateDreamClick() =
            mMenuNavigator.onCreateDream()

    fun onLogoutClick() =
            mLogoutUseCase().subscribe(mMenuNavigator::onCreateDream)

}

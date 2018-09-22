package ru.iandreyshev.dreamland.di

import android.support.v4.app.FragmentActivity
import ru.iandreyshev.coreAndroidUtils.viewModelFor
import ru.iandreyshev.dreamland.viewModel.main.MainViewModel
import ru.iandreyshev.featureAccount.model.repository.IUserRepository

class MainViewModelFactory(
        private val mUserRepository: IUserRepository
) {

    fun getFor(activity: FragmentActivity) = viewModelFor(activity) {
        MainViewModel(mUserRepository)
    }

}

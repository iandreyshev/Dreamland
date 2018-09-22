package ru.iandreyshev.dreamland.di

import android.support.v4.app.FragmentActivity
import ru.iandreyshev.coreAndroidUtils.viewModelFor
import ru.iandreyshev.dreamland.viewModel.main.MainViewModel

class MainViewModelFactory {

    fun getFor(activity: FragmentActivity) = viewModelFor(activity) {
        MainViewModel()
    }

}

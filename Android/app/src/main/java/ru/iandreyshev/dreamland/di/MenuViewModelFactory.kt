package ru.iandreyshev.dreamland.di

import android.support.v4.app.FragmentActivity
import ru.iandreyshev.coreAndroidUtils.viewModelFor
import ru.iandreyshev.dreamland.viewModel.menu.MenuViewModel

class MenuViewModelFactory {

    fun create(activity: FragmentActivity) = viewModelFor(activity) {
        MenuViewModel()
    }

}

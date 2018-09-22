package ru.iandreyshev.dreamland.viewModel.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroidUtils.mutableLiveDataOf

class MainViewModel : ViewModel() {

    private val state = mutableLiveDataOf<MainViewModelState>(MainViewModelState.WaitState)

    fun observeState(lifecycleOwner: LifecycleOwner, observer: (MainViewModelState) -> Unit) {
    }

    fun signIn() {
    }

}

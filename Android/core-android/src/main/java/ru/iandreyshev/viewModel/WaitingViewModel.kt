package ru.iandreyshev.viewModel

import android.arch.lifecycle.LiveData
import ru.iandreyshev.vext.liveData.mutableLiveDataOf

class WaitingViewModel(default: Boolean = false) {

    val observable: LiveData<Boolean>
        get() = mWaitState

    private val mWaitState = mutableLiveDataOf(default)

    fun start() {
        mWaitState.value = true
    }

    fun stop() {
        mWaitState.value = false
    }

}
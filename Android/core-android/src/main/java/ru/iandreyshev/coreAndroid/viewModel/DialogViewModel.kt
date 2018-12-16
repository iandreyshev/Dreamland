package ru.iandreyshev.coreAndroid.viewModel

import android.arch.lifecycle.LiveData
import ru.iandreyshev.vext.liveData.mutableLiveDataOf

class DialogViewModel<T>(
        default: T? = null
) {

    val observable: LiveData<T>
        get() = mMutableLiveData

    private val mMutableLiveData = mutableLiveDataOf(default)

    fun update(data: T) {
        mMutableLiveData.value = data
    }

    fun close() {
        mMutableLiveData.value = null
    }

}

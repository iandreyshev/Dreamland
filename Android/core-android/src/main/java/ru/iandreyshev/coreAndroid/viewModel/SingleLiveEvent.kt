package ru.iandreyshev.coreAndroid.viewModel

class SingleLiveEvent : SingleLiveTypedEvent<Unit>() {
    fun postCall() {
        postValue(Unit)
    }

    operator fun invoke() {
        postCall()
    }
}

package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureDreams.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase

class DreamEditorViewModel(
        private val saveDreamUseCase: ISaveDreamUseCase,
        private val bundle: Bundle?
) : ViewModel() {

    val saveWaiting: LiveData<Boolean>
        get() = mWaitingViewModel.observable
    val closeEvent: LiveData<Unit>
        get() = mCloseEvent

    private val mWaitingViewModel = WaitingViewModel()
    private val mCloseEvent = SingleLiveEvent<Unit>()

    private var mSaveDreamSubscription: Disposable? = null

    fun saveDream(dream: DreamProperties) {
        mWaitingViewModel.start()
        mSaveDreamSubscription = saveDreamUseCase(dream)
                .subscribe { result, error ->
                    result?.let(::handleSaveResult)
                    error?.let(::handleSaveError)
                    mWaitingViewModel.stop()
                    mCloseEvent.postValue(Unit)
                }
    }

    override fun onCleared() {
        mSaveDreamSubscription?.dispose()
    }

    private fun handleSaveResult(result: SaveDreamResult) {
    }

    private fun handleSaveError(error: Throwable) {
        error.printStackTrace()
    }

}

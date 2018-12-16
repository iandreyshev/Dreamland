package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.coreAndroid.rx.subscribe
import ru.iandreyshev.coreAndroid.viewModel.DialogViewModel
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import ru.iandreyshev.featureDreamsApi.domain.DreamKey

class DreamEditorViewModel(
        private val saveDreamUseCase: ISaveDreamUseCase,
        bundle: Bundle?
) : ViewModel() {

    val saveResult: LiveData<SaveDreamResult>
        get() = mErrorViewModel.observable
    val saveWaiting: LiveData<Boolean>
        get() = mWaitingViewModel.observable
    val closeEvent: LiveData<Unit>
        get() = mCloseEvent

    private val mDreamKey: DreamKey? = DreamKey.create(bundle)

    private val mErrorViewModel = DialogViewModel<SaveDreamResult>()
    private val mWaitingViewModel = WaitingViewModel()
    private val mCloseEvent = SingleLiveEvent()

    private var mSaveDreamSubscription: Disposable? = null

    fun saveDream(dream: DreamProperties) {
        mWaitingViewModel.start()
        mSaveDreamSubscription = saveDreamUseCase(dream, mDreamKey)
                .ioToMain()
                .subscribe(::handleSaveResult, ::handleSaveError) {
                    mWaitingViewModel.stop()
                }
    }

    fun onCloseSaveResult() {
        mErrorViewModel.close()
    }

    override fun onCleared() {
        mSaveDreamSubscription?.dispose()
    }

    private fun handleSaveResult(result: SaveDreamResult) {
        if (result == SaveDreamResult.SUCCESS) {
            mCloseEvent()
            return
        }
        mErrorViewModel.update(result)
    }

    private fun handleSaveError(error: Throwable) {
        mErrorViewModel.update(SaveDreamResult.ERROR_UNDEFINED)
        error.printStackTrace()
    }

}

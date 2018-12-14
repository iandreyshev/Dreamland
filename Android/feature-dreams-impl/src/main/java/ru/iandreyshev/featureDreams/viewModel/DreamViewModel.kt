package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.subscribe
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveEvent
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureDreams.domain.*
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.domain.*
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class DreamViewModel
@Inject constructor(
        private val deleteUseCase: IDeleteDreamUseCase,
        dreamsRepository: IDreamsRepository,
        bundle: Bundle?
) : ViewModel() {

    val deleteDreamWaiting: LiveData<Boolean>
        get() = mDeleteWaitingViewModel.observable
    val dream: LiveData<DreamProperties>
        get() = mDreamViewModel

    val loadingErrorEvent: LiveData<Unit>
        get() = mLoadingErrorEvent
    val unknownErrorEvent: LiveData<Unit>
        get() = mUnknownErrorEvent

    private val mDream: Dream? = Dream.create(bundle)

    private val mDeleteWaitingViewModel = WaitingViewModel()
    private val mDreamViewModel = mutableLiveDataOf(mDream?.properties)

    private val mLoadingErrorEvent = SingleLiveEvent()
    private val mUnknownErrorEvent = SingleLiveEvent()

    private var mLoadDreamSubscription: Disposable? = null
    private var mDeleteDreamSubscription: Disposable? = null

    init {
        if (mDream == null) {
            mLoadingErrorEvent.call()
        } else {
            mLoadDreamSubscription = dreamsRepository.getDreamObservable(mDream.key)
                    .subscribe(::handleLoadDreamResult, ::handleLoadDreamError)
        }
    }

    fun delete() {
        mDream ?: return

        mDeleteWaitingViewModel.start()
        mDeleteDreamSubscription = deleteUseCase.invoke(mDream.key)
                .subscribe(::handleDeleteResult, ::handleDeleteError) {
                    mDeleteWaitingViewModel.stop()
                }
    }

    override fun onCleared() {
        mDeleteDreamSubscription?.dispose()
    }

    private fun handleLoadDreamResult(result: LoadDreamResult) {
        when (result) {
            is LoadingDreamCompleted -> {
            }
            is UpdateDreamCompleted -> {
                mDreamViewModel.value = result.properties
            }
            is ErrorDreamDeleted -> mLoadingErrorEvent.call()
        }
    }

    private fun handleLoadDreamError(error: Throwable) {
        // TODO: Handle unknown error
        error.printStackTrace()
    }

    private fun handleDeleteResult(result: DeleteDreamResult) {
    }

    private fun handleDeleteError(error: Throwable) {
        // TODO: Handle unknown error
        error.printStackTrace()
    }

}

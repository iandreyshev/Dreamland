package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.coreAndroid.rx.subscribe
import ru.iandreyshev.coreAndroid.viewModel.SingleLiveTypedEvent
import ru.iandreyshev.featureDreams.domain.FetchDreamsResult
import ru.iandreyshev.featureDreams.useCase.IFetchDreamsUseCase
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.domain.Dream
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class DreamListViewModel
@Inject constructor(
        repository: IDreamsRepository,
        private val fetchDreamsUseCase: IFetchDreamsUseCase
) : ViewModel() {

    val dreams: LiveData<List<Dream>>
        get() = mDreams
    val refreshing: LiveData<Boolean>
        get() = mRefreshing
    val optionsTarget: LiveData<Dream>
        get() = mOptionsTarget
    val fetchResult: LiveData<FetchDreamsResult>
        get() = mFetchResult

    private val mDreams = MutableLiveData<List<Dream>>()
    private val mRefreshing = mutableLiveDataOf(false)
    private val mOptionsTarget = MutableLiveData<Dream>()
    private val mFetchResult = SingleLiveTypedEvent<FetchDreamsResult>()

    private val mDreamsSubscription: Disposable
    private var mRefreshingSubscription: Disposable? = null

    init {
        mDreamsSubscription = repository.dreamsObservable
                .subscribe { mDreams.value = it }
    }

    fun onRefresh() {
        mRefreshingSubscription = fetchDreamsUseCase()
                .ioToMain()
                .doOnSubscribe { mRefreshing.value = true }
                .subscribe(::handleResult, ::handleFetchError) {
                    mRefreshing.value = false
                }
    }

    fun onCloseDreamOptions() {
        mOptionsTarget.value = null
    }

    override fun onCleared() {
        mDreamsSubscription.dispose()
        mRefreshingSubscription?.dispose()
    }

    private fun handleResult(result: FetchDreamsResult) {
        mFetchResult.postValue(result)
    }

    private fun handleFetchError(throwable: Throwable) {
        throwable.printStackTrace()
    }

}

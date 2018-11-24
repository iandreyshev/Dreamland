package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.data.DreamListItem
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class DreamListViewModel
@Inject constructor(
        private val repository: IDreamsRepository
) : ViewModel() {

    val dreams: LiveData<List<DreamListItem>>
        get() = mDreams
    val refreshing: LiveData<Boolean>
        get() = mRefreshing

    private val mDreams = MutableLiveData<List<DreamListItem>>()
    private val mRefreshing = mutableLiveDataOf(false)

    private val mDreamsSubscription: Disposable
    private var mRefreshingSubscription: Disposable? = null

    init {
        mDreamsSubscription = repository.dreamsObservable
                .subscribe { mDreams.value = it }
    }

    fun onRefresh() {
        mRefreshingSubscription = repository.refresh()
                .doOnSubscribe { mRefreshing.value = true }
                .subscribe { mRefreshing.value = false }
    }

    override fun onCleared() {
        mDreamsSubscription.dispose()
        mRefreshingSubscription?.dispose()
    }

}

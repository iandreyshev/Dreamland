package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.featureDreamsApi.IDreamsRepository
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class MyDreamsViewModel @Inject constructor(
        private val repository: IDreamsRepository
) : ViewModel() {

    val refreshing: LiveData<Boolean>
        get() = mRefreshing
    val dreamsAvailability: LiveData<Boolean>
        get() = mDreamsAvailability

    private val mRefreshing = mutableLiveDataOf(false)
    private val mDreamsAvailability = mutableLiveDataOf(false)

    private val mDreamsCountSubscription: Disposable
    private var mRefreshingSubscription: Disposable? = null

    init {
        mDreamsCountSubscription = repository.countObservable
                .subscribe { mDreamsAvailability.value = it > 0 }
    }

    fun onRefresh() {
        mRefreshingSubscription = repository.refresh()
                .doOnSubscribe { mRefreshing.value = true }
                .subscribe { mRefreshing.value = false }
    }

    override fun onCleared() {
        mDreamsCountSubscription.dispose()
        mRefreshingSubscription?.dispose()
    }

}

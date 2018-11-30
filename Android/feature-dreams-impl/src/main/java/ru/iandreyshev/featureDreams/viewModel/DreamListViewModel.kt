package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import ru.iandreyshev.featureDreams.useCase.IFetchDreamsUseCase
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.data.DreamListItem
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class DreamListViewModel
@Inject constructor(
        private val repository: IDreamsRepository,
        private val fetchDreamsUseCase: IFetchDreamsUseCase,
        private val deleteDreamUseCase: IDeleteDreamUseCase
) : ViewModel() {

    val dreams: LiveData<List<DreamListItem>>
        get() = mDreams
    val refreshing: LiveData<Boolean>
        get() = mRefreshing
    val optionsTarget: LiveData<DreamListItem>
        get() = mOptionsTarget

    private val mDreams = MutableLiveData<List<DreamListItem>>()
    private val mRefreshing = mutableLiveDataOf(false)
    private val mOptionsTarget = MutableLiveData<DreamListItem>()

    private val mDreamsSubscription: Disposable
    private var mRefreshingSubscription: Disposable? = null

    init {
        mDreamsSubscription = repository.dreamsObservable
                .subscribe { mDreams.value = it }
    }

    fun onRefresh() {
        mRefreshingSubscription = fetchDreamsUseCase()
                .ignoreElement()
                .doOnSubscribe { mRefreshing.value = true }
                .subscribe { mRefreshing.value = false }
    }

    fun onOpenDream(dream: DreamListItem) {
    }

    fun onEditDream() {
    }

    fun onDeleteDream() {
    }

    fun onOpenDreamOptions(dream: DreamListItem) {
        mOptionsTarget.value = dream
    }

    fun onCloseDreamOptions() {
        mOptionsTarget.value = null
    }

    override fun onCleared() {
        mDreamsSubscription.dispose()
        mRefreshingSubscription?.dispose()
    }

}

package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import ru.iandreyshev.featureDreams.useCase.IFetchDreamsUseCase
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.domain.Dream
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class DreamListViewModel
@Inject constructor(
        repository: IDreamsRepository,
        private val fetchDreamsUseCase: IFetchDreamsUseCase,
        private val deleteDreamUseCase: IDeleteDreamUseCase
) : ViewModel() {

    val dreams: LiveData<List<Dream>>
        get() = mDreams
    val refreshing: LiveData<Boolean>
        get() = mRefreshing
    val optionsTarget: LiveData<Dream>
        get() = mOptionsTarget

    private val mDreams = MutableLiveData<List<Dream>>()
    private val mRefreshing = mutableLiveDataOf(false)
    private val mOptionsTarget = MutableLiveData<Dream>()

    private val mDreamsSubscription: Disposable
    private var mRefreshingSubscription: Disposable? = null

    init {
        mDreamsSubscription = repository.dreamsObservable
                .subscribe { mDreams.value = it }
    }

    fun onRefresh() {
        mRefreshingSubscription = fetchDreamsUseCase()
                .ioToMain()
                .ignoreElement()
                .doOnSubscribe { mRefreshing.value = true }
                .subscribe { mRefreshing.value = false }
    }

    fun onEditDream() {
    }

    fun onDeleteDream() {
    }

    fun onOpenDreamOptions(dream: Dream) {
        if (mOptionsTarget.value == null) {
            mOptionsTarget.value = dream
        }
    }

    fun onCloseDreamOptions() {
        mOptionsTarget.value = null
    }

    override fun onCleared() {
        mDreamsSubscription.dispose()
        mRefreshingSubscription?.dispose()
    }

}

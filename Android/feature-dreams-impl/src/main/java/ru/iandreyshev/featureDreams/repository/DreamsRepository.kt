package ru.iandreyshev.featureDreams.repository

import io.reactivex.Completable
import io.reactivex.Observable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.useCase.IRefreshDreamsUseCase
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.data.DreamListItem
import javax.inject.Inject

class DreamsRepository
@Inject constructor(
        private val refreshDreamsUseCase: IRefreshDreamsUseCase,
        private val storage: IDreamsStorage
) : IDreamsRepository {

    override val dreamsObservable: Observable<List<DreamListItem>>
        get() = storage.dreamObservable
                .map { list ->
                    list.map { entity ->
                        DreamListItem(entity.description)
                    }
                }
                .ioToMain()

    override fun refresh(): Completable =
            refreshDreamsUseCase().ignoreElement()

}

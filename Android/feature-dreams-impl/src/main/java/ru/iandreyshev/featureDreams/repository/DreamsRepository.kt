package ru.iandreyshev.featureDreams.repository

import io.reactivex.Observable
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.domain.*
import javax.inject.Inject

class DreamsRepository
@Inject constructor(
        private val storage: IDreamsStorage
) : IDreamsRepository {

    override val dreamsObservable: Observable<List<Dream>>
        get() = storage.dreamObservable
                .map { list ->
                    list.map { entity ->
                        val properties = DreamProperties(entity.description)
                        val key = DreamKey(entity.id)
                        Dream(key, properties)
                    }
                }

    override fun getDreamObservable(key: DreamKey): Observable<LoadDreamResult> {
        return Observable.create {  }
    }

}

package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Completable
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreamsApi.useCase.IClearDreamsStorageUseCase
import javax.inject.Inject

class ClearDreamsStorageUseCase
@Inject constructor(
        private val storage: IDreamsStorage
) : IClearDreamsStorageUseCase {

    override fun invoke(): Completable = Completable.create {
        Thread.sleep(1000)
        storage.clear()
        it.onComplete()
    }

}

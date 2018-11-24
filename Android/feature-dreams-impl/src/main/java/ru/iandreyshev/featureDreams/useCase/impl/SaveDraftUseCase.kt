package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Completable
import ru.iandreyshev.featureDreams.storage.IDraftStorage
import ru.iandreyshev.featureDreams.useCase.ISaveDraftUseCase
import ru.iandreyshev.featureDreams.domain.DreamProperties
import javax.inject.Inject

class SaveDraftUseCase
@Inject constructor(
        private val draftStorage: IDraftStorage
) : ISaveDraftUseCase {

    override fun invoke(draft: DreamProperties): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
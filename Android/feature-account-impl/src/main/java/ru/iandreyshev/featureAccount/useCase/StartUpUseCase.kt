package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccountApi.useCase.IStartUpUseCase
import ru.iandreyshev.featureDreamsApi.useCase.IClearDreamsStorageUseCase
import javax.inject.Inject

class StartUpUseCase
@Inject constructor(
        private val storage: IUserStorage,
        private val clearDreamsStorageUseCase: IClearDreamsStorageUseCase
) : IStartUpUseCase {

    override fun invoke(): Single<Boolean> = Single.create<Boolean> {
        val isUserExists = storage.isUserExists
        if (!isUserExists) {
            clearDreamsStorageUseCase().subscribe {
                it.onSuccess(isUserExists)
            }
        }
        it.onSuccess(isUserExists)
    }

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Completable
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase
import javax.inject.Inject

class LogOutUseCase
@Inject constructor(
        private val mStorage: IUserStorage
) : ILogOutUseCase {

    override fun invoke(): Completable = Completable.create {
        Thread.sleep(1000)
        mStorage.clear()
        it.onComplete()
    }

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Completable
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase
import javax.inject.Inject

class LogOutUseCase
@Inject constructor(
        private val mDatabase: IUserDatabase
) : ILogOutUseCase {

    override fun invoke(): Completable = Completable.create {
        mDatabase.clear()
        it.onComplete()
    }

}
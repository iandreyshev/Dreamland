package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Completable
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import javax.inject.Inject

class LogoutUseCase
@Inject constructor(
        private val mDatabase: IUserDatabase
) : ILogoutUseCase {

    override fun invoke(): Completable = Completable.create {
        mDatabase.clear()
        it.onComplete()
    }

}

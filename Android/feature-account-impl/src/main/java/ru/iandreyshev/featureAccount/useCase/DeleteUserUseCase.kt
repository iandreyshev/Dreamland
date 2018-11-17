package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.network.IUserServer
import ru.iandreyshev.featureAccountApi.data.DeleteUserResult
import ru.iandreyshev.featureAccountApi.useCase.IDeleteUserUseCase
import javax.inject.Inject

class DeleteUserUseCase
@Inject constructor(
        private val database: IUserDatabase,
        private val server: IUserServer
) : IDeleteUserUseCase {

    override fun invoke(): Single<DeleteUserResult> = Single.create {
        Thread.sleep(1000)
        database.clear()
        it.onSuccess(DeleteUserResult.SUCCESS)
    }

}

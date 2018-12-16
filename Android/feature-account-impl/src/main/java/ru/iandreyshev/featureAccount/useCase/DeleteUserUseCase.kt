package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccount.mapping.toResult
import ru.iandreyshev.featureAccount.network.IUserServerApi
import ru.iandreyshev.featureAccount.network.request.DeleteRequest
import ru.iandreyshev.featureAccountApi.data.DeleteUserResult
import ru.iandreyshev.featureAccountApi.useCase.IDeleteUserUseCase
import javax.inject.Inject

class DeleteUserUseCase
@Inject constructor(
        private val storage: IUserStorage,
        private val serverApi: IUserServerApi
) : IDeleteUserUseCase {

    override fun invoke(): Single<DeleteUserResult> = Single.create<DeleteUserResult> {
        val user = storage.user

        if (user == null) {
            it.onSuccess(DeleteUserResult.UNKNOWN)
            return@create
        }

        val request = DeleteRequest(user.accountId, user.password)
        val responseFromServer = serverApi.delete(request)
        val result = responseFromServer.toResult()

        return@create when (result) {
            DeleteUserResult.SUCCESS -> {
                storage.clear()
                it.onSuccess(DeleteUserResult.SUCCESS)
                return@create
            }
            DeleteUserResult.NO_CONNECTION,
            DeleteUserResult.UNKNOWN -> {
                it.onSuccess(result)
            }
        }
    }

}

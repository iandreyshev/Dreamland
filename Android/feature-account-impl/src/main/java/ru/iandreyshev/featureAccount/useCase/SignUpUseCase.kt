package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.mapping.toDatabaseEntity
import ru.iandreyshev.featureAccount.mapping.toRequest
import ru.iandreyshev.featureAccount.mapping.toResult
import ru.iandreyshev.featureAccount.network.IUserServer
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.featureAccountApi.useCase.ISignUpUseCase
import javax.inject.Inject

class SignUpUseCase
@Inject constructor(
        private val database: IUserDatabase,
        private val server: IUserServer
) : ISignUpUseCase {

    override fun invoke(signUpProperties: SignUpProperties): Single<SignUpResult> = Single.create {
        val responseFromServer = server.signUp(signUpProperties.toRequest())

        val serverError = responseFromServer.error
        if (serverError != null) {
            it.onSuccess(serverError.toResult())
            return@create
        }

        val serverAccount = responseFromServer.account
        if (serverAccount == null) {
            it.onSuccess(SignUpResult.UNKNOWN)
            return@create
        }

        Thread.sleep(1000)

        val databaseEntity = serverAccount.toDatabaseEntity(signUpProperties.password)
        database.saveUser(databaseEntity)

        it.onSuccess(SignUpResult.SUCCESS)
    }

}

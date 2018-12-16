package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccount.mapping.toStorageEntity
import ru.iandreyshev.featureAccount.network.IUserServerApi
import ru.iandreyshev.featureAccount.mapping.toRequest
import ru.iandreyshev.featureAccount.mapping.toResult
import ru.iandreyshev.featureAccount.useCase.validation.isValidUserEmail
import ru.iandreyshev.featureAccount.useCase.validation.isValidUserPassword
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult
import ru.iandreyshev.featureAccountApi.useCase.ISignInUseCase
import javax.inject.Inject

class SignInUseCase
@Inject constructor(
        private val serverApi: IUserServerApi,
        private val userStorage: IUserStorage
) : ISignInUseCase {

    override fun invoke(properties: SignInProperties): Single<SignInResult> = Single.create {
        val signInProperties = properties.clear()
        signInProperties.validate()?.run {
            it.onSuccess(this)
            return@create
        }

        val responseFromServer = serverApi.signIn(signInProperties.toRequest())

        val serverError = responseFromServer.error
        if (serverError != null) {
            it.onSuccess(serverError.toResult())
            return@create
        }

        val serverAccount = responseFromServer.account
        if (serverAccount == null) {
            it.onSuccess(SignInResult.ERROR_UNKNOWN)
            return@create
        }

        val entity = serverAccount.toStorageEntity(signInProperties.password)
        userStorage.saveUser(entity)
        it.onSuccess(SignInResult.SUCCESS)
    }

    private fun SignInProperties.clear() =
            copy(email = email.trim())

    private fun SignInProperties.validate(): SignInResult? =
            when {
                !email.isValidUserEmail -> SignInResult.ERROR_INCORRECT_EMAIL
                !password.isValidUserPassword -> SignInResult.ERROR_INCORRECT_PASSWORD
                else -> null
            }

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccount.mapping.toStorageEntity
import ru.iandreyshev.featureAccount.mapping.toRequest
import ru.iandreyshev.featureAccount.mapping.toResult
import ru.iandreyshev.featureAccount.network.IUserServerApi
import ru.iandreyshev.featureAccount.useCase.validation.isValidUserEmail
import ru.iandreyshev.featureAccount.useCase.validation.isValidUserPassword
import ru.iandreyshev.featureAccount.useCase.validation.isValidUserName
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.featureAccountApi.useCase.ISignUpUseCase
import javax.inject.Inject

class SignUpUseCase
@Inject constructor(
        private val storage: IUserStorage,
        private val serverApi: IUserServerApi
) : ISignUpUseCase {

    override fun invoke(properties: SignUpProperties): Single<SignUpResult> = Single.create<SignUpResult> {
        val signUpProperties = properties.clear()

        signUpProperties.getPropertiiesError()?.run {
            it.onSuccess(this)
            return@create
        }

        val responseFromServer = serverApi.signUp(signUpProperties.toRequest())

        val serverError = responseFromServer.error
        if (serverError != null) {
            it.onSuccess(serverError.toResult())
            return@create
        }

        val serverAccount = responseFromServer.account
        if (serverAccount == null) {
            it.onSuccess(SignUpResult.ERROR_UNKNOWN)
            return@create
        }

        val entity = serverAccount.toStorageEntity(signUpProperties.password)
        storage.saveUser(entity)

        it.onSuccess(SignUpResult.SUCCESS)
    }

    private fun SignUpProperties.clear() =
            copy(email = email.trim(), name = name.trim())

    private fun SignUpProperties.getPropertiiesError(): SignUpResult? =
            when {
                !email.isValidUserEmail -> SignUpResult.ERROR_INCORRECT_EMAIL
                !password.isValidUserPassword -> SignUpResult.ERROR_INCORRECT_PASSWORD
                !name.isValidUserName -> SignUpResult.ERROR_INCORRECT_NAME
                else -> null
            }

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccount.mapping.toStorageEntity
import ru.iandreyshev.featureAccount.mapping.toRequest
import ru.iandreyshev.featureAccount.mapping.toResult
import ru.iandreyshev.featureAccount.network.IUserServerApi
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.featureAccountApi.useCase.ISignUpUseCase
import javax.inject.Inject

class SignUpUseCase
@Inject constructor(
        private val storage: IUserStorage,
        private val serverApi: IUserServerApi
) : ISignUpUseCase {

    override fun invoke(signUpProperties: SignUpProperties): Single<SignUpResult> = Single.create<SignUpResult> {
        val responseFromServer = serverApi.signUp(signUpProperties.toRequest())

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

        val entity = serverAccount.toStorageEntity(signUpProperties.password)
        storage.saveUser(entity)

        it.onSuccess(SignUpResult.SUCCESS)
    }.ioToMain()

}

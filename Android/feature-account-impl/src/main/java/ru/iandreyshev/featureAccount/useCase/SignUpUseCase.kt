package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.mapping.toDatabaseEntity
import ru.iandreyshev.featureAccount.mapping.toRequest
import ru.iandreyshev.featureAccount.mapping.toResult
import ru.iandreyshev.featureAccount.network.IUserServer
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.featureAccountApi.useCase.ISignUpUseCase
import javax.inject.Inject

class SignUpUseCase : ISignUpUseCase {

    @Inject
    lateinit var mDatabase: IUserDatabase
    @Inject
    lateinit var mServer: IUserServer

    init {
        FeatureAccountComponent.get().inject(this)
    }

    override fun invoke(signUpProperties: SignUpProperties): Single<SignUpResult> = Single.create {
        val responseFromServer = mServer.signUp(signUpProperties.toRequest())

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

        val databaseEntity = serverAccount.toDatabaseEntity(signUpProperties.password)
        mDatabase.saveUser(databaseEntity)
    }

}

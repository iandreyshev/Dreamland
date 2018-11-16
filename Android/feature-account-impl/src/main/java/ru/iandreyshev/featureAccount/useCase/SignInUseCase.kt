package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.mapping.toDatabaseEntity
import ru.iandreyshev.featureAccount.network.IUserServer
import ru.iandreyshev.featureAccount.mapping.toRequest
import ru.iandreyshev.featureAccount.mapping.toResult
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult
import ru.iandreyshev.featureAccountApi.useCase.ISignInUseCase
import javax.inject.Inject

class SignInUseCase : ISignInUseCase {

    @Inject
    lateinit var mDatabase: IUserDatabase
    @Inject
    lateinit var mServer: IUserServer

    init {
        FeatureAccountComponent.get().inject(this)
    }

    override fun invoke(signInProperties: SignInProperties): Single<SignInResult> = Single.create {
        val responseFromServer = mServer.signIn(signInProperties.toRequest())

        val serverError = responseFromServer.error
        if (serverError != null) {
            it.onSuccess(serverError.toResult())
            return@create
        }

        val serverAccount = responseFromServer.account
        if (serverAccount == null) {
            it.onSuccess(SignInResult.UNKNOWN)
            return@create
        }

        val databaseEntity = serverAccount.toDatabaseEntity(signInProperties.password)
        mDatabase.saveUser(databaseEntity)
    }

}

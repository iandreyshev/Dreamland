package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult
import ru.iandreyshev.featureAccountApi.useCase.ISignInUseCase
import javax.inject.Inject

class SignInUseCase : ISignInUseCase {

    @Inject
    lateinit var mAuthRepository: IAuthRepository

    override fun invoke(signInProperties: SignInProperties): Single<SignInResult> =
            mAuthRepository.signIn(signInProperties)

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.featureAccountApi.useCase.ISignUpUseCase
import javax.inject.Inject

class SignUpUseCase : ISignUpUseCase {

    @Inject
    lateinit var mAuthRepository: IAuthRepository

    init {
        FeatureAccountComponent.get().inject(this)
    }

    override fun invoke(signUpProperties: SignUpProperties): Single<SignUpResult> =
            mAuthRepository.signUp(signUpProperties)

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Completable
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.repository.IUserRepository
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import javax.inject.Inject

class LogoutUseCase : ILogoutUseCase {

    @Inject
    lateinit var mUserRepository: IUserRepository

    init {
        FeatureAccountComponent.get().inject(this)
    }

    override fun invoke(): Completable {
        return mUserRepository.logout()
    }

}

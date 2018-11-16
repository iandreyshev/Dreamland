package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Completable
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import javax.inject.Inject

class LogoutUseCase : ILogoutUseCase {

    @Inject
    lateinit var mDatabase: IUserDatabase

    init {
        FeatureAccountComponent.get().inject(this)
    }

    override fun invoke(): Completable = Completable.create {
        mDatabase.clear()
        it.onComplete()
    }

}

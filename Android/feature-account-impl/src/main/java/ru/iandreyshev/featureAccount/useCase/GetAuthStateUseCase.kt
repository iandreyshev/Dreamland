package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import javax.inject.Inject

class GetAuthStateUseCase
@Inject constructor(
        private val database: IUserDatabase
) : IGetAuthStateUseCase {

    override fun invoke(): Single<Boolean> = Single.create<Boolean> {
        Thread.sleep(1000)
        it.onSuccess(database.isUserExists)
    }.ioToMain()

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import javax.inject.Inject

class GetAuthStateUseCase
@Inject constructor(
        private val storage: IUserStorage
) : IGetAuthStateUseCase {

    override fun invoke(): Single<Boolean> = Single.create<Boolean> {
        Thread.sleep(1000)
        it.onSuccess(storage.isUserExists)
    }.ioToMain()

}

package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase

class GetAuthStateUseCase : IGetAuthStateUseCase {

    override fun invoke(): Single<Boolean> {
        return Single.fromCallable {
            Thread.sleep(500)
            true
        }.ioToMain()
    }

}

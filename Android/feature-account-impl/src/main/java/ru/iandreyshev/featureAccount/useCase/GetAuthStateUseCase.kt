package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Single
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import javax.inject.Inject

class GetAuthStateUseCase
@Inject constructor() : IGetAuthStateUseCase {

    override fun invoke(): Single<Boolean> {
        return Single.fromCallable {
            Thread.sleep(500)
            true
        }.ioToMain()
    }

}

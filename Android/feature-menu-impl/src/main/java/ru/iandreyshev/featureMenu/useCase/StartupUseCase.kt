package ru.iandreyshev.featureMenu.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.api.IUserApi
import ru.iandreyshev.featureDreamsApi.useCase.IClearDreamsStorageUseCase
import javax.inject.Inject

class StartupUseCase
@Inject constructor(
        private val userApi: IUserApi,
        private val clearDreamsStorageUseCase: IClearDreamsStorageUseCase
) : IStartupUseCase {

    override fun invoke(): Single<Boolean> = Single.create {
        val isUserExists = userApi.user != null

        if (!isUserExists) {
            it.setDisposable(clearDreamsStorageUseCase().subscribe {
                it.onSuccess(false)
            })
            return@create
        }

        it.onSuccess(isUserExists)
    }

}

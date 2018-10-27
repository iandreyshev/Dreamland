package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Completable
import ru.iandreyshev.featureAccount.repository.IUserRepository
import ru.iandreyshev.rx.ioToMain
import javax.inject.Inject

class RefreshUserUseCase @Inject constructor(
        private val repository: IUserRepository
) : IRefreshUserUseCase {

    override fun refresh() = Completable.create {
        repository.refresh()
        it.onComplete()
    }.ioToMain()

}
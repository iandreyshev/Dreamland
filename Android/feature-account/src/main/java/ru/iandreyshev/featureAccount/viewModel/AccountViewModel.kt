package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureAccount.repository.IUser
import ru.iandreyshev.featureAccount.useCase.IBackFromAccountUseCase
import ru.iandreyshev.featureAccount.useCase.IRefreshUserUseCase
import ru.iandreyshev.viewModel.WaitingViewModel
import javax.inject.Inject

class AccountViewModel @Inject constructor(
        private val refreshUserUseCase: IRefreshUserUseCase,
        private val backUseCase: IBackFromAccountUseCase,
        val accountObservable: LiveData<IUser>
) : ViewModel() {

    val refreshWaitingObservable: LiveData<Boolean>
        get() = mRefreshWaitingViewModel.observable

    private val mRefreshWaitingViewModel = WaitingViewModel()

    fun refresh() {
        mRefreshWaitingViewModel.start()
        refreshUserUseCase.refresh()
                .doFinally(mRefreshWaitingViewModel::stop)
                .subscribe()
    }

    fun back() = backUseCase.back()

}
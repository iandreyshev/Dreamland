package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureAccount.useCase.IRefreshUserUseCase
import ru.iandreyshev.viewModel.WaitingViewModel
import javax.inject.Inject

class AccountViewModel
@Inject constructor(
        private val refreshUserUseCase: IRefreshUserUseCase
) : ViewModel() {

    private val mRefreshWaitingViewModel = WaitingViewModel()

    fun refresh() {
        mRefreshWaitingViewModel.start()
        refreshUserUseCase.refresh()
                .doFinally(mRefreshWaitingViewModel::stop)
                .subscribe()
    }

}
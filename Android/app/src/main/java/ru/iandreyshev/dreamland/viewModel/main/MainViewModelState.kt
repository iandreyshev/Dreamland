package ru.iandreyshev.dreamland.viewModel.main

import ru.iandreyshev.featureAccount.model.repository.IAccount

sealed class MainViewModelState {

    object WaitState : MainViewModelState()

    class CompleteState(val account: IAccount?) : MainViewModelState()

    class ErrorState(val error: String) : MainViewModelState()

}

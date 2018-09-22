package ru.iandreyshev.dreamland.viewModel.main

sealed class MainViewModelState {

    object WaitState : MainViewModelState()

    class CompleteState(val isSignIn: Boolean) : MainViewModelState()

}

package ru.iandreyshev.dreamland.viewModel.main

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.dreamland.navigation.ISplashNavigator
import ru.iandreyshev.featureAccount.repository.IUserRepository
import ru.iandreyshev.viewModel.WaitingViewModel
import javax.inject.Inject

class SplashViewModel
@Inject constructor(
        userRepository: IUserRepository,
        private val navigator: ISplashNavigator
) : ViewModel() {

    val waitViewModel: WaitingViewModel = WaitingViewModel(true)

    init {
        userRepository.getUserAuthState()
                .singleOrError()
                .subscribe(::handleAuthState, ::handleError)
    }

    private fun handleAuthState(isAuth: Boolean) {
        waitViewModel.stop()
        when (isAuth) {
            true -> navigator.onUserInSignedIn()
            false -> navigator.onUserDoesNotExists()
        }
    }

    private fun handleError(error: Throwable) {
        waitViewModel.stop()
        error.printStackTrace()
    }

}

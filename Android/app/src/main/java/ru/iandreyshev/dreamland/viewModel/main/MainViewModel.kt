package ru.iandreyshev.dreamland.viewModel.main

import android.app.Application
import android.arch.lifecycle.ViewModel
import org.jetbrains.anko.startActivity
import ru.iandreyshev.dreamland.presentation.activity.MenuActivity
import ru.iandreyshev.featureAccount.presentation.activity.AuthActivity
import ru.iandreyshev.featureAccount.repository.IUserRepository
import ru.iandreyshev.featureAccount.repository.impl.AuthState
import ru.iandreyshev.viewModel.WaitViewModel
import javax.inject.Inject

class MainViewModel
@Inject constructor(
        userRepository: IUserRepository,
        private val application: Application
) : ViewModel() {

    val waitViewModel: WaitViewModel = WaitViewModel(true)

    init {
        userRepository.getUserAuthState()
                .singleOrError()
                .subscribe(::handleAuthState, ::handleError)
    }

    private fun handleAuthState(state: AuthState) {
        waitViewModel.stop()
        when (state) {
            AuthState.SIGNED_IN -> application.startActivity<MenuActivity>()
            AuthState.NOT_EXISTS -> application.startActivity<AuthActivity>()
        }
    }

    private fun handleError(error: Throwable) {
        waitViewModel.stop()
        error.printStackTrace()
    }

}

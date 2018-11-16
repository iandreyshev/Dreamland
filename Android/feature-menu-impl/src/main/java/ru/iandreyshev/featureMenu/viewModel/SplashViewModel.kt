package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.coreAndroid.viewModel.WaitingViewModel
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureMenu.di.dependencies.ISplashNavigator
import javax.inject.Inject

class SplashViewModel
@Inject constructor(
        private val navigator: ISplashNavigator,
        getAuthStateUseCase: IGetAuthStateUseCase
): ViewModel() {

    val waitViewModel: WaitingViewModel = WaitingViewModel(true)

    init {
        getAuthStateUseCase().subscribe(::handleAuthState, ::handleError)
    }

    private fun handleAuthState(isAuth: Boolean) {
        waitViewModel.stop()
        when (isAuth) {
            true -> navigator.onUserSignedIn()
            false -> navigator.onUserDoesNotExists()
        }
    }

    private fun handleError(error: Throwable) {
        waitViewModel.stop()
        error.printStackTrace()
    }

}

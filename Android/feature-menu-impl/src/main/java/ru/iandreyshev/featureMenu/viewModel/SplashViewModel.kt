package ru.iandreyshev.featureMenu.viewModel

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureMenu.di.dependencies.ISplashNavigator
import ru.iandreyshev.featureMenu.useCase.IStartupUseCase
import javax.inject.Inject

class SplashViewModel
@Inject constructor(
        private val navigator: ISplashNavigator,
        getAuthStateUseCase: IStartupUseCase
) : ViewModel() {

    private val mGetAuthStateDisposable: Disposable

    init {
        mGetAuthStateDisposable = getAuthStateUseCase()
                .ioToMain()
                .subscribe(::handleAuthState, ::handleError)
    }

    override fun onCleared() {
        mGetAuthStateDisposable.dispose()
    }

    private fun handleAuthState(isAuth: Boolean) {
        when (isAuth) {
            true -> navigator.onUserSignedIn()
            false -> navigator.onUserDoesNotExists()
        }
    }

    private fun handleError(error: Throwable) {
        error.printStackTrace()
    }

}

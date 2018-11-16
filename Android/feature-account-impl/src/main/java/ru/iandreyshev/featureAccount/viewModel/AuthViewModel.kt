package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class AuthViewModel
@Inject constructor(): ViewModel() {

    enum class Screen {
        SIGN_IN,
        SIGN_UP
    }

    val screen: LiveData<Screen>
        get() = mScreenViewModel

    private val mScreenViewModel = mutableLiveDataOf(Screen.SIGN_IN)

    fun wantSignIn() {
        mScreenViewModel.value = Screen.SIGN_IN
    }

    fun wantSignUp() {
        mScreenViewModel.value = Screen.SIGN_UP
    }

}

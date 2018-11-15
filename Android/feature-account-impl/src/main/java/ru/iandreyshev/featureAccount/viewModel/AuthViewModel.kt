package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Inject

class AuthViewModel : ViewModel() {

    enum class Screen {
        SIGN_IN,
        SIGN_UP
    }

    lateinit var mAuthRepository: IAuthRepository

    init {
        FeatureAccountComponent.get().inject(this)
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

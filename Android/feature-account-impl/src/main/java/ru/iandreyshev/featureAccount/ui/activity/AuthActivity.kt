package ru.iandreyshev.featureAccount.ui.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_auth.*
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureAccount.R
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.vext.view.invisible
import ru.iandreyshev.vext.view.visible

class AuthActivity : BaseAppCompatActivity() {

    private val mViewModel by lazy { viewModel<AuthViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        FeatureAccountComponent.get().inject(this)

        mViewModel.apply {
            observeNotNull(screen, ::screenObserver)
        }
    }

    private fun screenObserver(screen: AuthViewModel.Screen) {
        when (screen) {
            AuthViewModel.Screen.SIGN_IN -> {
                fragment_sign_in.view?.visible()
                fragment_sign_up.view?.invisible()
            }
            AuthViewModel.Screen.SIGN_UP -> {
                fragment_sign_up.view?.visible()
                fragment_sign_in.view?.invisible()
            }
        }
    }

}
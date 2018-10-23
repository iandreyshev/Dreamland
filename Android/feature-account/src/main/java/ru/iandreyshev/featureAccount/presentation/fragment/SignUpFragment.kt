package ru.iandreyshev.featureAccount.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sign_up.*
import ru.iandreyshev.coreAndroidUtils.observeNotNull
import ru.iandreyshev.featureAccount.R
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.repository.ISignUpProperties
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.featureAccount.viewModel.SignUpViewModel
import ru.iandreyshev.fragment.BaseFragment
import ru.iandreyshev.vext.view.invisibleIf
import ru.iandreyshev.vext.view.visibleIf
import ru.iandreyshev.vext.view.visibleIfOrGone
import ru.iandreyshev.view.setOnClickListener

class SignUpFragment : BaseFragment() {

    private lateinit var mAuthViewModel: AuthViewModel
    private lateinit var mSignUpViewModel: SignUpViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_sign_up, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureAccountComponent.get().inject(this)

        mAuthViewModel = activityViewModel {
            signUpFields_btnSignIn.setOnClickListener(::wantSignIn)
        }

        mSignUpViewModel = viewModel {
            signUpFields_btnStart.setOnClickListener {
                startSignUp(getProperties())
            }
            observeNotNull(waitingObservable, ::handleWaiting)
        }
    }

    private fun getProperties() = object : ISignUpProperties {
        override val email = signUpFields_email_field.text.toString()
        override val login = signUpFields_login_field.text.toString()
        override val password = signUpFields_password_field.text.toString()
    }

    private fun handleWaiting(isWait: Boolean) {
        signUpFields_btnStart.visibleIf(!isWait)
        signUpFields_btnStart.invisibleIf(isWait)

        signUpFields_btnSignIn.visibleIf(!isWait)
        signUpFields_btnSignIn.invisibleIf(isWait)

        signUpFields_login_field.isEnabled = !isWait
        signUpFields_login_field.clearFocus()

        signUpFields_email_field.isEnabled = !isWait
        signUpFields_email_field.clearFocus()

        signUpFields_password.isPasswordVisibilityToggleEnabled = !isWait
        signUpFields_password_field.isEnabled = !isWait
        signUpFields_password_field.clearFocus()

        signUpFields_progressBar.visibleIfOrGone(isWait)
    }

}

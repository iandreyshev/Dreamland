package ru.iandreyshev.featureAccount.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import ru.iandreyshev.coreAndroidUtils.observeNotNull
import ru.iandreyshev.featureAccount.R
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccountApi.repository.ISignInProperties
import ru.iandreyshev.featureAccountApi.repository.SignInResult
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.featureAccount.viewModel.SignInViewModel
import ru.iandreyshev.fragment.BaseFragment
import ru.iandreyshev.vext.view.invisibleIf
import ru.iandreyshev.vext.view.visibleIf
import ru.iandreyshev.vext.view.visibleIfOrGone
import ru.iandreyshev.view.setOnClickListener

class SignInFragment : BaseFragment() {

    private lateinit var mAuthViewModel: AuthViewModel
    private lateinit var mSignInViewModel: SignInViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_sign_in, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureAccountComponent.get().inject(this)

        mAuthViewModel = activityViewModel {
            signInFields_btnSignUp.setOnClickListener(::wantSignUp)
        }

        mSignInViewModel = viewModel {
            signInFields_btnStart.setOnClickListener {
                startSignIn(getProperties())
            }
            observeNotNull(waitingObservable, ::handleWaiting)
            observeNotNull(errorObservable, ::handleError)
        }
    }

    private fun getProperties() = object : ISignInProperties {
        override val login = signInFields_login_field.text.toString()
        override val password = signInFields_password_field.text.toString()
    }

    private fun handleWaiting(isWait: Boolean) {
        signInFields_btnStart.visibleIf(!isWait)
        signInFields_btnStart.invisibleIf(isWait)

        signInFields_btnSignUp.visibleIf(!isWait)
        signInFields_btnSignUp.invisibleIf(isWait)

        signInFields_login_field.isEnabled = !isWait
        signInFields_login_field.clearFocus()

        signInFields_password.isPasswordVisibilityToggleEnabled = !isWait
        signInFields_password_field.isEnabled = !isWait
        signInFields_password_field.clearFocus()

        signInFields_progressBar.visibleIfOrGone(isWait)
    }

    private fun handleError(error: SignInResult) {
        activity?.alert {
            titleResource = R.string.sign_in_error_title
            messageResource = when (error) {
                SignInResult.SUCCESS -> return@alert
                SignInResult.USER_NOT_EXISTS -> R.string.sign_in_error_user_not_exists
                SignInResult.INCORRECT_DATA -> R.string.sign_in_error_incorrect_data
                SignInResult.NO_CONNECTION -> R.string.sign_in_error_no_connection
                SignInResult.UNKNOWN -> R.string.sign_in_error_unknown
            }
            okButton { }
        }?.show()
    }

}
package ru.iandreyshev.featureAccount.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureAccount.R
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.featureAccount.viewModel.SignUpViewModel
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.vext.view.invisibleIf
import ru.iandreyshev.vext.view.visibleIf
import ru.iandreyshev.vext.view.visibleIfOrGone
import ru.iandreyshev.coreAndroid.ui.view.setOnClickListener

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
            observeNotNull(waiting, ::handleWaiting)
            observeNotNull(error, ::handleError)
        }
    }

    private fun getProperties() = SignUpProperties(
            signUpFields_email_field.text.toString(),
            signUpFields_full_name_field.text.toString(),
            signUpFields_password_field.text.toString()
    )

    private fun handleWaiting(isWait: Boolean) {
        signUpFields_btnStart.visibleIf(!isWait)
        signUpFields_btnStart.invisibleIf(isWait)

        signUpFields_btnSignIn.visibleIf(!isWait)
        signUpFields_btnSignIn.invisibleIf(isWait)

        signUpFields_full_name_field.isEnabled = !isWait
        signUpFields_full_name_field.clearFocus()

        signUpFields_email_field.isEnabled = !isWait
        signUpFields_email_field.clearFocus()

        signUpFields_password.isPasswordVisibilityToggleEnabled = !isWait
        signUpFields_password_field.isEnabled = !isWait
        signUpFields_password_field.clearFocus()

        signUpFields_progressBar.visibleIfOrGone(isWait)
    }

    private fun handleError(error: SignUpResult) {
        activity?.alert {
            titleResource = R.string.sign_up_error_title
            messageResource = when (error) {
                SignUpResult.SUCCESS -> return@alert
                SignUpResult.ERROR_USER_ALREADY_EXISTS -> R.string.sign_up_error_user_already_exists
                SignUpResult.ERROR_INCORRECT_DATA -> R.string.sign_up_error_incorrect_data
                SignUpResult.ERROR_NO_CONNECTION -> R.string.sign_up_error_no_connection
                SignUpResult.ERROR_UNKNOWN -> R.string.sign_up_error_unknown
                SignUpResult.ERROR_INCORRECT_PASSWORD -> R.string.sign_in_error_incorrect_password
                SignUpResult.ERROR_INCORRECT_EMAIL -> R.string.sign_in_error_incorrect_email
                SignUpResult.ERROR_INCORRECT_NAME -> R.string.sign_in_error_incorrect_name
            }
            okButton { }
        }?.show()
    }

}

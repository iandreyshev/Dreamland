package ru.iandreyshev.featureMenu.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_settings.*
import org.jetbrains.anko.cancelButton
import org.jetbrains.anko.okButton
import ru.iandreyshev.coreAndroid.ui.dialog.buildAlert
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.coreAndroid.ui.view.setOnClickListener
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.coreAndroid.viewModel.viewModel
import ru.iandreyshev.featureAccountApi.data.DeleteUserResult
import ru.iandreyshev.featureMenu.R
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import ru.iandreyshev.featureMenu.viewModel.SettingsViewModel
import ru.iandreyshev.vext.view.goneIfOrVisible
import ru.iandreyshev.vext.view.visibleIfOrGone

class SettingsFragment : BaseFragment() {

    private lateinit var mViewModel: SettingsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureMenuComponent.get().inject(this)

        mViewModel = viewModel(viewModelFactory)

        btnDeleteProfile.setOnClickListener(::onDeleteUserClick)
        btnLogOut.setOnClickListener(::onLogOutClick)

        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        mViewModel.apply {
            observeNotNull(waiting, ::handleWaiting)
            observeNotNull(deleteResult, ::handleDeleteUserResult)
        }
    }

    private fun onDeleteUserClick() {
        buildAlert {
            title = "Delete profile"
            message = "Do you really want to delete profile?"
            positiveButton(R.string.log_out_alert_btn_ok) { mViewModel.onDeleteUser() }
            cancelButton { }
        }?.show()
    }

    private fun onLogOutClick() {
        buildAlert {
            titleResource = R.string.log_out_alert_title
            messageResource = R.string.log_out_alert_message
            positiveButton(R.string.log_out_alert_btn_ok) { mViewModel.onLogOut() }
            cancelButton { }
        }?.show()
    }

    private fun handleWaiting(isWaiting: Boolean) {
        progressBar.visibleIfOrGone(isWaiting)
        btnLogOut.goneIfOrVisible(isWaiting)
        btnDeleteProfile.goneIfOrVisible(isWaiting)
    }

    private fun handleDeleteUserResult(result: DeleteUserResult) {
        buildAlert {
            title = "Profile deleting"
            message = result.toString()
            okButton { }
        }?.show()
    }

}

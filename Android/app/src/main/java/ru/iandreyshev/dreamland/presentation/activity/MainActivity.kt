package ru.iandreyshev.dreamland.presentation.activity

import android.os.Bundle
import org.jetbrains.anko.intentFor
import ru.iandreyshev.coreAndroidUtils.activity.BaseAppCompatActivity
import ru.iandreyshev.dreamland.R
import ru.iandreyshev.dreamland.application.DreamlandApplication
import ru.iandreyshev.dreamland.viewModel.main.MainViewModel
import ru.iandreyshev.dreamland.viewModel.main.MainViewModelState
import ru.iandreyshev.featureAccount.presentation.activity.LoginActivity

class MainActivity : BaseAppCompatActivity(R.layout.activity_main) {

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = DreamlandApplication.mainViewModelFactory.getFor(this)
        mViewModel.observeState(this@MainActivity) { newState ->
            when (newState) {
                is MainViewModelState.WaitState -> onWaitState(newState)
                is MainViewModelState.CompleteState -> onCompleteState(newState)
            }
        }
    }

    private fun onWaitState(state: MainViewModelState.WaitState) {}

    private fun onCompleteState(state: MainViewModelState.CompleteState) {
        if (state.isSignIn) {
            startActivity(intentFor<MenuActivity>())
        } else {
            startActivity(intentFor<LoginActivity>())
        }
    }

}

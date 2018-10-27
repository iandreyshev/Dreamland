package ru.iandreyshev.dreamland.presentation.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroidUtils.observeNotNull
import ru.iandreyshev.coreAndroidUtils.viewModel
import ru.iandreyshev.dreamland.R
import ru.iandreyshev.dreamland.di.AppComponent
import ru.iandreyshev.dreamland.viewModel.main.SplashViewModel
import ru.iandreyshev.vext.view.visibleIfOrGone

class SplashActivity : BaseAppCompatActivity() {

    private lateinit var mViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppComponent.get().inject(this)

        mViewModel = viewModel(viewModelFactory) {
            observeNotNull(waitViewModel.observable, progressBar::visibleIfOrGone)
        }
    }

}

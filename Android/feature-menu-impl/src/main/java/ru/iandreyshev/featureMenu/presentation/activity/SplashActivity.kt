package ru.iandreyshev.featureMenu.presentation.activity

import android.os.Bundle
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.featureMenu.R
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import ru.iandreyshev.featureMenu.viewModel.SplashViewModel

class SplashActivity : BaseAppCompatActivity() {

    private val mViewModel by lazy { viewModel<SplashViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        FeatureMenuComponent.get().inject(this)

        mViewModel
    }

}

package ru.iandreyshev.featureDreams.ui.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dream.*
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureDreams.ui.extension.dateViewString
import ru.iandreyshev.featureDreams.viewModel.DreamViewModel
import ru.iandreyshev.featureDreams.viewModel.IViewModelFactory
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties
import javax.inject.Inject

class DreamActivity : BaseAppCompatActivity() {

    @Inject
    lateinit var mViewModelFactory: IViewModelFactory

    private lateinit var mViewModel: DreamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dream)

        FeatureDreamsComponent.get().inject(this)

        initActionBar()

        val bundleWithDream = intent.extras?.getBundle(KEY_DREAM)
        mViewModel = mViewModelFactory.dreamViewModel(this, bundleWithDream).apply {
            observeNotNull(dream, ::handleDreamProperties)
        }
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun handleDreamProperties(properties: DreamProperties) {
        tvDescription.text = properties.description
        tvDate.text = properties.dateViewString
    }

    companion object {
        const val KEY_DREAM = "key_list_item"
    }

}

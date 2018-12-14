package ru.iandreyshev.featureDreams.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_dream_editor.*
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties
import ru.iandreyshev.featureDreams.viewModel.DreamEditorViewModel
import ru.iandreyshev.featureDreams.viewModel.IViewModelFactory
import ru.iandreyshev.vext.view.visibleIfOrGone
import javax.inject.Inject

class DreamEditorActivity : BaseAppCompatActivity() {

    @Inject
    lateinit var mViewModelFactory: IViewModelFactory

    private lateinit var mViewModel: DreamEditorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dream_editor)

        FeatureDreamsComponent.get().inject(this)

        initActionBar()

        mViewModel = mViewModelFactory.dreamEditorViewModel(this, savedInstanceState).apply {
            observeNotNull(saveWaiting, ::handleSaveWaiting)
            observeNotNull(closeEvent) { finish() }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_dream_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.menu_item_save -> {
                mViewModel.saveDream(createDream())
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
    }

    private fun handleSaveWaiting(isWait: Boolean) {
        progressBar.visibleIfOrGone(isWait)
    }

    private fun createDream(): DreamProperties {
        return DreamProperties(
                description = dream_text.text.toString()
        )
    }

}
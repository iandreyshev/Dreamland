package ru.iandreyshev.featureDreams.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_dream_constructor.*
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureDreams.viewModel.DreamConstructorViewModel
import javax.inject.Inject

class DreamConstructorActivity : BaseAppCompatActivity() {

    @Inject
    lateinit var mViewModel: DreamConstructorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dream_constructor)

        FeatureDreamsComponent.get().inject(this)

        initViewModel()
        initActionBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_dream_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.home -> {
                finish()
                return true
            }
            R.id.menu_item_save -> {
                // TODO: Save dream
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initViewModel() {
        mViewModel = viewModel {  }
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

}
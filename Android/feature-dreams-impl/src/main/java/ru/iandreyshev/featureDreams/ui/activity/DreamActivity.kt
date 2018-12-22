package ru.iandreyshev.featureDreams.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_dream.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.noButton
import org.jetbrains.anko.okButton
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.ui.dialog.buildAlert
import ru.iandreyshev.coreAndroid.ui.dialog.customizeAndShow
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureDreams.domain.DeleteDreamResult
import ru.iandreyshev.featureDreams.ui.extension.dateViewString
import ru.iandreyshev.featureDreams.viewModel.DreamViewModel
import ru.iandreyshev.featureDreams.viewModel.IViewModelFactory
import ru.iandreyshev.featureDreamsApi.domain.Dream
import ru.iandreyshev.vext.view.visibleIfOrGone
import java.lang.IllegalStateException
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
            observeNotNull(deleteDreamWaiting, progressBar::visibleIfOrGone)
            observeNotNull(deletingResultEvent, ::handleDeleteDreamResult)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dream, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> supportFinishAfterTransition()
            R.id.menu_item_edit -> startEditActivity()
            R.id.menu_item_delete -> showDeletePopup()
            else -> return super.onOptionsItemSelected(item)
        }

        return true
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun handleDreamProperties(dream: Dream) {
        tvDescription.text = dream.properties.description
        tvDate.text = dream.dateViewString
    }

    private fun handleDeleteDreamResult(result: DeleteDreamResult) {
        if (result == DeleteDreamResult.SUCCESS) {
            finish()
            return
        }

        buildAlert {
            titleResource = R.string.delete_error_title
            messageResource = when (result) {
                DeleteDreamResult.SUCCESS -> throw IllegalStateException()
                DeleteDreamResult.ERROR_NO_CONNECTION -> R.string.delete_error_no_connection
                DeleteDreamResult.ERROR_UNDEFINED -> R.string.delete_error_undefined
            }
            okButton { }
        } customizeAndShow {}
    }

    private fun startEditActivity() {
        mViewModel.dream.value?.toBundle()?.let { dreamBundle ->
            intentFor<DreamEditorActivity>()
                    .putExtra(DreamEditorActivity.KEY_DREAM, dreamBundle)
                    .let(::startActivity)
        }
    }

    private fun showDeletePopup() {
        buildAlert {
            titleResource = R.string.dream_delete_popup_title
            messageResource = R.string.dream_delete_popup_message
            okButton { mViewModel.delete() }
            noButton { }
        } customizeAndShow {
            setCanceledOnTouchOutside(true)
            setCancelable(false)
        }
    }

    companion object {
        const val KEY_DREAM = "key_list_item"
    }

}

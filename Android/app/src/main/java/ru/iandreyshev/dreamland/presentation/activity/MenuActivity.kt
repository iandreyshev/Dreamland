package ru.iandreyshev.dreamland.presentation.activity

import android.os.Bundle
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroidUtils.viewModel
import ru.iandreyshev.dreamland.R
import ru.iandreyshev.dreamland.di.AppComponent
import ru.iandreyshev.dreamland.presentation.tools.NavigationActivityPageController
import ru.iandreyshev.dreamland.viewModel.menu.MenuViewModel

class MenuActivity : BaseAppCompatActivity() {

    private lateinit var mViewModel: MenuViewModel
    private lateinit var mPagesController: NavigationActivityPageController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        AppComponent.get().inject(this)

        mViewModel = viewModel(viewModelFactory)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(LAST_PAGE_KEY, mPagesController.currentPage)
    }

    companion object {
        private const val LAST_PAGE_KEY = "LAST_PAGE_KEY"
    }

}

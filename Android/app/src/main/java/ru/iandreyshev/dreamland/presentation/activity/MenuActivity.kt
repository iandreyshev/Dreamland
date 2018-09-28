package ru.iandreyshev.dreamland.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_navigation.*
import ru.iandreyshev.dreamland.R
import ru.iandreyshev.dreamland.presentation.tools.NavigationActivityPageController

class MenuActivity : AppCompatActivity() {

    private lateinit var mPagesController: NavigationActivityPageController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        initPagesController(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(LAST_PAGE_KEY, mPagesController.currentPage)
    }

    private fun initPagesController(savedInstanceState: Bundle?) {
        val lastPage = savedInstanceState?.getInt(
                LAST_PAGE_KEY, NavigationActivityPageController.DEFAULT_PAGE)

        mPagesController = NavigationActivityPageController(
                fragment_feed.view!!, fragment_dreams.view!!, fragment_profile.view!!, bottomNavigationView, lastPage)

        bottomNavigationView.setOnNavigationItemSelectedListener(mPagesController::onBottomMenuClick)
    }

    companion object {
        private const val LAST_PAGE_KEY = "LAST_PAGE_KEY"
    }

}

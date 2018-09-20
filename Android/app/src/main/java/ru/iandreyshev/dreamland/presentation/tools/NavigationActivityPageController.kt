package ru.iandreyshev.dreamland.presentation.tools

import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.view.View
import ru.iandreyshev.coreAndroidUtils.goneAll
import ru.iandreyshev.coreAndroidUtils.visible
import ru.iandreyshev.dreamland.R

class NavigationActivityPageController(
        private val feedPage: View,
        private val dreamsPage: View,
        private val profilePage: View,
        bottomNavigationItemView: BottomNavigationView,
        startPage: Int?
) {

    var currentPage: Int = DEFAULT_PAGE
        private set

    private val mMenuItems by lazy {
        listOf(R.id.menu_application_feed, R.id.menu_application_dreams, R.id.menu_application_profile)
    }
    private val mPages: List<View> by lazy {
        listOf(feedPage, dreamsPage, profilePage)
    }

    init {
        bottomNavigationItemView.selectedItemId = startPage ?: DEFAULT_PAGE
        onPageClick(startPage ?: DEFAULT_PAGE)
    }

    fun onBottomMenuClick(menuItem: MenuItem): Boolean {
        if (menuItem.itemId !in mMenuItems) {
            return false
        }
        onPageClick(menuItem.itemId)
        return true
    }

    private fun onPageClick(pageId: Int) {
        goneAll(mPages)
        when (pageId) {
            R.id.menu_application_feed -> feedPage.visible()
            R.id.menu_application_dreams -> dreamsPage.visible()
            R.id.menu_application_profile -> profilePage.visible()
        }
        currentPage = pageId
    }

    companion object {
        const val DEFAULT_PAGE = R.id.menu_application_dreams
    }

}

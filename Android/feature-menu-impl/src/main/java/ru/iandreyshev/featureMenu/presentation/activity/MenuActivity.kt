package ru.iandreyshev.featureMenu.presentation.activity

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.view_drawer_header.view.*
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureMenu.R
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import ru.iandreyshev.featureMenu.viewModel.MenuViewModel
import ru.iandreyshev.coreAndroid.ui.view.setOnClickListener
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureDreamsApi.api.IDreamsDiaryFragmentFactory
import ru.iandreyshev.vext.view.gone
import ru.iandreyshev.vext.view.visible
import javax.inject.Inject

class MenuActivity : BaseAppCompatActivity() {

    companion object {
        private const val MAIN_FRAGMENT_TAG = "fragment.main"
    }

    @Inject
    lateinit var mMainFragmentFactory: IDreamsDiaryFragmentFactory

    private val mViewModel by lazy { viewModel<MenuViewModel>() }

    private val mDrawerHeader: View?
        get() = nav_view.getHeaderView(0)
    private val mMainFragment: Fragment?
        get() = supportFragmentManager.findFragmentByTag(MAIN_FRAGMENT_TAG)
    private var mActionBarLayoutParams: AppBarLayout.LayoutParams? = null
    private val mMenuItems by lazy {
        listOf(
                nav_view.menu.findItem(R.id.drawer_item_dreams),
                nav_view.menu.findItem(R.id.drawer_item_settings)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        FeatureMenuComponent.get().inject(this)

        initActionBar()
        initDrawer()
        initMainFragment()
        initFabButton()

        subscribeToViewModel()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
            return
        } else if (mViewModel.menuState.value != MenuViewModel.MenuState.DREAMS) {
            mViewModel.onNewMenuState(MenuViewModel.MenuState.DREAMS)
            drawer.closeDrawer(GravityCompat.START)
            return
        }

        super.onBackPressed()
    }

    private fun subscribeToViewModel() {
        mViewModel.apply {
            observeNotNull(user, ::handleAccount)
            observeNotNull(menuState, ::handleMenuState)
            observeNotNull(dreamsAvailability, ::handleDreamsAvailability)
        }
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        mActionBarLayoutParams = toolbar.layoutParams as? AppBarLayout.LayoutParams
    }

    private fun initDrawer() {
        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.drawer_item_dreams -> {
                    mViewModel.onNewMenuState(MenuViewModel.MenuState.DREAMS)
                }
                R.id.drawer_item_settings -> {
                    mViewModel.onNewMenuState(MenuViewModel.MenuState.SETTINGS)
                }
            }
            drawer.closeDrawers()
            true
        }
    }

    private fun initMainFragment() {
        if (mMainFragment == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_placeholder, mMainFragmentFactory.create(), MAIN_FRAGMENT_TAG)
                    .commit()
        }
    }

    private fun initFabButton() {
        floating_action_button.setOnClickListener(mViewModel::onCreateDream)
    }

    private fun handleAccount(account: User) {
        mDrawerHeader?.drawerHeader_fullName?.text = account.fullName
    }

    private fun handleMenuState(state: MenuViewModel.MenuState) {
        mMainFragment?.view?.gone()
        floating_action_button.gone()
        fragment_settings.view?.gone()
        mMenuItems.forEach { it.isChecked = false }

        when (state) {
            MenuViewModel.MenuState.DREAMS -> setupDreamsViewState()
            MenuViewModel.MenuState.SETTINGS -> setupSettingsViewState()
        }

        refreshActionBar()
    }

    private fun handleDreamsAvailability(isAvailable: Boolean) {
        refreshActionBar()
    }

    private fun refreshActionBar() {
        val isDreamsAvailable = mViewModel.dreamsAvailability.value ?: false
        val isDreamsOpen = mViewModel.menuState.value == MenuViewModel.MenuState.DREAMS

        if (isDreamsOpen && isDreamsAvailable) {
            mActionBarLayoutParams?.scrollFlags =
                    AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
        } else {
            mActionBarLayoutParams?.scrollFlags = 0
        }

        appBar.requestLayout()
    }

    private fun setupDreamsViewState() {
        mMainFragment?.view?.visible()
        floating_action_button.visible()
        toolbar.setTitle(R.string.drawer_menu_item_dreams)
        nav_view.menu.findItem(R.id.drawer_item_dreams).isChecked = true
    }

    private fun setupSettingsViewState() {
        fragment_settings?.view?.visible()
        toolbar.setTitle(R.string.drawer_menu_item_settings)
        nav_view.menu.findItem(R.id.drawer_item_settings).isChecked = true
    }

}

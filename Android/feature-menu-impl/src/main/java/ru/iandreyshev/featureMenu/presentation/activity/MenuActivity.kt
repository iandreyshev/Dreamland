package ru.iandreyshev.featureMenu.presentation.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.view_drawer_header.*
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroidUtils.observeNotNull
import ru.iandreyshev.coreAndroidUtils.viewModel
import ru.iandreyshev.featureMenu.R
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import ru.iandreyshev.featureMenu.model.User
import ru.iandreyshev.featureMenu.viewModel.MenuViewModel
import ru.iandreyshev.featureMenuApi.navigation.IMainPageFragmentProvider
import ru.iandreyshev.view.setOnClickListener
import javax.inject.Inject

class MenuActivity : BaseAppCompatActivity() {

    companion object {
        private const val MAIN_FRAGMENT_TAG = "fragment.main"
    }

    @Inject
    lateinit var mMainPageFragmentProvider: IMainPageFragmentProvider

    private lateinit var mViewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        FeatureMenuComponent.get().inject(this)

        initViewModel()
        initActionBar()
        initDrawer()
        initMainPageList()
        initFabButton()
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> {
            drawer.openDrawer(GravityCompat.START)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    private fun initViewModel() {
        mViewModel = viewModel(viewModelFactory) {
            observeNotNull(userObservable, ::handleAccount)
        }
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    private fun initDrawer() {
        nav_view.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            true
        }
    }

    private fun initMainPageList() {
        val mainFragment = supportFragmentManager.findFragmentByTag(MAIN_FRAGMENT_TAG)

        if (mainFragment == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_placeholder, mMainPageFragmentProvider.getFragment(), MAIN_FRAGMENT_TAG)
                    .commit()
        }
    }

    private fun initFabButton() {
        floating_action_button.setOnClickListener(mViewModel::onCreateDreamClick)
    }

    private fun handleAccount(account: User) {
        drawerHeader_fullName.text = account.fullName
    }

}

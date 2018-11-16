package ru.iandreyshev.featureMenu.presentation.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.view_drawer_header.view.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.cancelButton
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.coreAndroid.viewModel.viewModel
import ru.iandreyshev.featureMenu.R
import ru.iandreyshev.featureMenu.di.FeatureMenuComponent
import ru.iandreyshev.featureMenu.viewModel.MenuViewModel
import ru.iandreyshev.coreAndroid.ui.view.setOnClickListener
import ru.iandreyshev.coreAndroid.viewModel.observe
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureDreamsApi.data.IDreamsDiaryFragmentFactory
import javax.inject.Inject

class MenuActivity : BaseAppCompatActivity() {

    companion object {
        private const val MAIN_FRAGMENT_TAG = "fragment.main"
    }

    @Inject
    lateinit var mMainFragmentFactory: IDreamsDiaryFragmentFactory

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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_toolbar, menu)
//        return true
//    }

    private fun initViewModel() {
        mViewModel = viewModel(viewModelFactory) {
            observeNotNull(user, ::handleAccount)
            observe(backEvent) { finish() }
        }
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    private fun initDrawer() {
        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.drawer_item_log_out -> onLogOutClick()
            }
            drawer.closeDrawers()
            true
        }
    }

    private fun initMainPageList() {
        val mainFragment = supportFragmentManager.findFragmentByTag(MAIN_FRAGMENT_TAG)

        if (mainFragment == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_placeholder, mMainFragmentFactory.create(), MAIN_FRAGMENT_TAG)
                    .commit()
        }
    }

    private fun initFabButton() {
        floating_action_button.setOnClickListener(mViewModel::onCreateDreamClick)
    }

    private fun handleAccount(account: User) {
        drawer.drawerHeader_fullName?.text = account.fullName
    }

    private fun onLogOutClick() {
        alert {
            titleResource = R.string.log_out_alert_title
            messageResource = R.string.log_out_alert_message
            positiveButton(R.string.log_out_alert_btn_ok) { mViewModel.onLogoutClick() }
            cancelButton { }
        }.show()
    }

}

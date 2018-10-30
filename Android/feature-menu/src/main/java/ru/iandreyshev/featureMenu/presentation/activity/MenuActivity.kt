package ru.iandreyshev.featureMenu.presentation.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
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

class MenuActivity : BaseAppCompatActivity() {

    private lateinit var mViewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        FeatureMenuComponent.get().inject(this)

        initViewModel()
        initActionBar()
        initDrawer()
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> {
            drawer.openDrawer(GravityCompat.START)
            true
        }
        else -> super.onOptionsItemSelected(item)
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
        drawerHeader.setOnClickListener {
            mViewModel.openAccount()
        }
        nav_view.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawer.closeDrawers()
            true
        }
    }

    private fun handleAccount(account: User) {
        drawerHeader_fullName.text = account.fullName
    }

}

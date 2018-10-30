package ru.iandreyshev.featureAccount.presentation.activity

import android.os.Bundle
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.featureAccount.R
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import ru.iandreyshev.featureAccount.viewModel.AccountViewModel

class AccountActivity : BaseAppCompatActivity() {

    private lateinit var mViewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        FeatureAccountComponent.get().inject(this)

        mViewModel = viewModel {}
    }

}
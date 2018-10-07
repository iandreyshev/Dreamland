package ru.iandreyshev.featureAccount.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.iandreyshev.featureAccount.R
import ru.iandreyshev.featureAccount.viewModel.LoginViewModel
import ru.iandreyshev.featureAccount.viewModel.ViewModelFactory
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelFactory()[this]
    }

}
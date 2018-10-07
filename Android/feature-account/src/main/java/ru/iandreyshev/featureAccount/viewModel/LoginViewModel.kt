package ru.iandreyshev.featureAccount.viewModel

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureAccount.model.repository.IUserRepository

class LoginViewModel(
        repository: IUserRepository
) : ViewModel()

package ru.iandreyshev.dreamland.viewModel.menu

import android.app.Application
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class MenuViewModel
@Inject constructor(
        private val application: Application
) : ViewModel()

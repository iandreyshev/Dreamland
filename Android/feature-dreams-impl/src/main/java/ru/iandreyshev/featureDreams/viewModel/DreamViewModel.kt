package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import javax.inject.Inject

class DreamViewModel
@Inject constructor(
        private val deleteUseCase: IDeleteDreamUseCase
) : ViewModel()

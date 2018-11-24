package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureDreams.useCase.ISaveDraftUseCase
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import javax.inject.Inject

class EditDreamViewModel
@Inject constructor(
        private val saveDreamUseCase: ISaveDreamUseCase,
        private val saveDraftUseCase: ISaveDraftUseCase
): ViewModel() {



}

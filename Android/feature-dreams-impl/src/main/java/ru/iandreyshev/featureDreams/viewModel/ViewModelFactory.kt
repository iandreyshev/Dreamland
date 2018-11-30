package ru.iandreyshev.featureDreams.viewModel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.iandreyshev.coreAndroid.viewModel.viewModel
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import javax.inject.Inject

class ViewModelFactory
@Inject constructor(
        private val saveDreamUseCase: ISaveDreamUseCase
) : IViewModelFactory {

    override fun editorViewModel(activity: AppCompatActivity, bundle: Bundle?, body: DreamEditorViewModel.() -> Unit): DreamEditorViewModel =
            activity.viewModel {
                DreamEditorViewModel(saveDreamUseCase, bundle)
            }

}

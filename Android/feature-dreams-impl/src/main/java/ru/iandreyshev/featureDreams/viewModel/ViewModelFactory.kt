package ru.iandreyshev.featureDreams.viewModel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.iandreyshev.coreAndroid.viewModel.viewModel
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import javax.inject.Inject

class ViewModelFactory
@Inject constructor(
        private val saveDreamUseCase: ISaveDreamUseCase,
        private val deleteDreamUseCase: IDeleteDreamUseCase,
        private val dreamsRepository: IDreamsRepository
) : IViewModelFactory {

    override fun dreamViewModel(activity: AppCompatActivity, bundle: Bundle?): DreamViewModel =
            activity.viewModel {
                DreamViewModel(deleteDreamUseCase, dreamsRepository, bundle)
            }

    override fun dreamEditorViewModel(activity: AppCompatActivity, bundle: Bundle?): DreamEditorViewModel =
            activity.viewModel {
                DreamEditorViewModel(saveDreamUseCase)
            }.apply {
                setDreamToEdit(bundle)
            }

}

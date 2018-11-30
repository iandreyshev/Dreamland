package ru.iandreyshev.featureDreams.viewModel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

interface IViewModelFactory {
    fun editorViewModel(activity: AppCompatActivity, bundle: Bundle?, body: DreamEditorViewModel.() -> Unit): DreamEditorViewModel
}

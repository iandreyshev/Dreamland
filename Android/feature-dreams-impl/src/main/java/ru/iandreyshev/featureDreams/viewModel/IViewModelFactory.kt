package ru.iandreyshev.featureDreams.viewModel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

interface IViewModelFactory {
    fun dreamViewModel(activity: AppCompatActivity, bundle: Bundle?): DreamViewModel
    fun dreamEditorViewModel(activity: AppCompatActivity, bundle: Bundle?): DreamEditorViewModel
}

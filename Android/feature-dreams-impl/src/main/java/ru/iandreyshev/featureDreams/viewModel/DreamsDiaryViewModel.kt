package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent

class DreamsDiaryViewModel : ViewModel() {

    init {
        FeatureDreamsComponent.get().inject(this)
    }

}

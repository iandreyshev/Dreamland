package ru.iandreyshev.featureDreams.viewModel

import android.arch.lifecycle.ViewModel
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import javax.inject.Inject

class DreamConstructorViewModel @Inject constructor(): ViewModel() {

    init {
        FeatureDreamsComponent.get().inject(this)
    }

}

package ru.iandreyshev.featureDreams.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent

class DreamFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_dream, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureDreamsComponent.get().inject(this)

        retainInstance = true
    }

}

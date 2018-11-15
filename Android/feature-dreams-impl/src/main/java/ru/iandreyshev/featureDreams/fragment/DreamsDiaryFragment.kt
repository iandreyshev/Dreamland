package ru.iandreyshev.featureDreams.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dreams_diary.*
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureDreams.dreamsList.adapter.DreamsListAdapter
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.featureDreams.viewModel.DreamsDiaryViewModel

class DreamsDiaryFragment : BaseFragment() {

    private lateinit var mViewModel: DreamsDiaryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_dreams_diary, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureDreamsComponent.get().inject(this)

        retainInstance = true
        mViewModel = viewModel {}

        initDreamsList()
    }

    private fun initDreamsList() {
        dreamsList.adapter = DreamsListAdapter()
    }

}

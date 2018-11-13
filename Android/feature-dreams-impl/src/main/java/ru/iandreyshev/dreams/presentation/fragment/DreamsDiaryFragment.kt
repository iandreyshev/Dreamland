package ru.iandreyshev.dreams.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dreams_diary.*
import ru.iandreyshev.dreams.R
import ru.iandreyshev.dreams.di.FeatureDreamsComponent
import ru.iandreyshev.dreams.dreamsList.adapter.DreamsListAdapter
import ru.iandreyshev.dreams.presentation.BaseFragment
import ru.iandreyshev.dreams.viewModel.DreamsDiaryViewModel

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

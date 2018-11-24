package ru.iandreyshev.featureDreams.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my_dreams.*
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureDreams.ui.adapter.dreams.DreamsListAdapter
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureDreams.viewModel.DreamListViewModel
import ru.iandreyshev.featureDreamsApi.data.DreamListItem
import ru.iandreyshev.vext.view.goneIfOrVisible
import ru.iandreyshev.vext.view.visibleIfOrGone

class MyDreamsFragment : BaseFragment() {

    private val mViewModel by lazy { viewModel<DreamListViewModel>() }
    private val mDreamsAdapter by lazy { DreamsListAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_my_dreams, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureDreamsComponent.get().inject(this)

        retainInstance = true
        initDreamsList()
        initRefreshers()

        subscribeToViewModel()
    }

    private fun initDreamsList() {
        dreamsList.adapter = mDreamsAdapter
    }

    private fun initRefreshers() {
        list_refresher.setOnRefreshListener(mViewModel::onRefresh)
        empty_refresher.setOnRefreshListener(mViewModel::onRefresh)
    }

    private fun subscribeToViewModel() {
        mViewModel.apply {
            observeNotNull(dreams, ::handleDreams)
            observeNotNull(refreshing, ::handleRefreshing)
        }
    }

    private fun handleDreams(dreams: List<DreamListItem>) {
        val isAvailable = dreams.isNotEmpty()
        list_refresher.visibleIfOrGone(isAvailable)
        empty_refresher.goneIfOrVisible(isAvailable)

        mDreamsAdapter.dreams = dreams
        mDreamsAdapter.notifyDataSetChanged()
    }

    private fun handleRefreshing(isRefresh: Boolean) {
        list_refresher.isRefreshing = isRefresh
        empty_refresher.isRefreshing = isRefresh
    }

}

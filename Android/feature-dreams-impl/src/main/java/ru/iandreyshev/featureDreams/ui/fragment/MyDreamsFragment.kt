package ru.iandreyshev.featureDreams.ui.fragment

import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my_dreams.*
import kotlinx.android.synthetic.main.view_dream_diary_item.view.*
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast
import ru.iandreyshev.coreAndroid.ui.dialog.buildAlert
import ru.iandreyshev.coreAndroid.ui.dialog.customizeAndShow
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreams.di.FeatureDreamsComponent
import ru.iandreyshev.featureDreams.ui.adapter.dreams.DreamsListAdapter
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.coreAndroid.viewModel.observeNotNull
import ru.iandreyshev.featureDreams.domain.FetchDreamsResult
import ru.iandreyshev.featureDreams.ui.activity.DreamActivity
import ru.iandreyshev.featureDreams.viewModel.DreamListViewModel
import ru.iandreyshev.featureDreamsApi.domain.Dream
import ru.iandreyshev.vext.view.goneIfOrVisible
import ru.iandreyshev.vext.view.visibleIfOrGone

class MyDreamsFragment : BaseFragment() {

    private val mViewModel by lazy { viewModel<DreamListViewModel>() }
    private val mDreamsAdapter by lazy { DreamsListAdapter(DreamActionListener()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_my_dreams, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FeatureDreamsComponent.get().inject(this)

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

    private fun subscribeToViewModel() = mViewModel.apply {
        observeNotNull(dreams, ::handleDreams)
        observeNotNull(refreshing, ::handleRefreshing)
        observeNotNull(optionsTarget, ::handleOptionsTarget)
        observeNotNull(fetchResult, ::handleFetchResult)
    }

    private fun handleDreams(dreams: List<Dream>) {
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

    private fun handleOptionsTarget(target: Dream) {
        buildAlert {
            title = "Dream options"
            onCancelled { mViewModel.onCloseDreamOptions() }
        } customizeAndShow {
            setCancelable(false)
            setCanceledOnTouchOutside(true)
        }
    }

    private fun handleFetchResult(result: FetchDreamsResult) {
        toast(when (result) {
            FetchDreamsResult.SUCCESS -> return
            FetchDreamsResult.ERROR_NO_CONNECTION -> R.string.fetch_error_no_connection
            FetchDreamsResult.ERROR_UNDEFINED -> R.string.fetch_error_undefined
        })
    }

    private inner class DreamActionListener : DreamsListAdapter.IDreamActionListener {
        override fun onClick(view: View, dream: Dream) {
            val intent = intentFor<DreamActivity>()
            intent.putExtra(DreamActivity.KEY_DREAM, dream.toBundle())

            val sharedDescription = Pair.create(view.tvDescription as View, "trans_key_dream_description")
            val sharedDate = Pair.create(view.tvDate as View, "trans_key_dream_date")
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity ?: return, sharedDescription, sharedDate)

            startActivity(intent, options.toBundle())
        }

        override fun onLongClick(dream: Dream): Boolean {
//            mViewModel.onOpenDreamOptions(dream)
            return true
        }
    }

}

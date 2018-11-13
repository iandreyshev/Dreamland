package ru.iandreyshev.dreams.viewModel

import android.arch.lifecycle.ViewModel
import android.support.v7.widget.RecyclerView
import javax.inject.Inject

class DreamsDiaryViewModel
@Inject constructor() : ViewModel() {

    internal var listState: RecyclerView.SavedState? = null

}

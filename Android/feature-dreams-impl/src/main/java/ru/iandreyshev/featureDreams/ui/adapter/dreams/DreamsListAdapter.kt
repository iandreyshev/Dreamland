package ru.iandreyshev.featureDreams.ui.adapter.dreams

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.iandreyshev.featureDreams.R
import ru.iandreyshev.featureDreamsApi.data.DreamListItem

class DreamsListAdapter(
        private val actionListener: IDreamActionListener? = null
) : RecyclerView.Adapter<DreamListViewHolder>() {

    var dreams: List<DreamListItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamListViewHolder =
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_dream_diary_item, parent, false)
                    .let { DreamListViewHolder(it) }

    override fun onBindViewHolder(viewHolder: DreamListViewHolder, position: Int) {
        viewHolder.setItem(dreams[position])
                .onClick { actionListener?.onClick(it) }
                .onLongClick { actionListener?.onLongClick(it) ?: false }
    }

    override fun getItemCount(): Int = dreams.count()

    interface IDreamActionListener {
        fun onClick(dream: DreamListItem)
        fun onLongClick(dream: DreamListItem): Boolean = false
    }

}

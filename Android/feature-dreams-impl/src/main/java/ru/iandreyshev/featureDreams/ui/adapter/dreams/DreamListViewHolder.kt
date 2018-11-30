package ru.iandreyshev.featureDreams.ui.adapter.dreams

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.view_dream_diary_item.view.*
import ru.iandreyshev.featureDreamsApi.data.DreamListItem

class DreamListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var mItem: DreamListItem

    fun setItem(item: DreamListItem): DreamListViewHolder {
        mItem = item
        itemView.description.text = item.description
        return this
    }

    fun onClick(action: (DreamListItem) -> Unit): DreamListViewHolder {
        itemView.setOnClickListener { action(mItem) }
        return this
    }

    fun onLongClick(action: (DreamListItem) -> Boolean): DreamListViewHolder {
        itemView.setOnLongClickListener { action(mItem) }
        return this
    }

}

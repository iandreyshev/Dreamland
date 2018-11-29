package ru.iandreyshev.featureDreams.ui.adapter.dreams

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.view_dream_diary_item.view.*
import ru.iandreyshev.featureDreamsApi.data.DreamListItem

class DreamListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: DreamListItem) {
        itemView.description.text = item.description
    }

}

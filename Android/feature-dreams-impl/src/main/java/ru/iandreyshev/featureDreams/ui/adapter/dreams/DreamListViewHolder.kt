package ru.iandreyshev.featureDreams.ui.adapter.dreams

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.view_dream_diary_item.view.*
import ru.iandreyshev.featureDreams.ui.extension.dateViewString
import ru.iandreyshev.featureDreamsApi.domain.Dream

class DreamListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var mItem: Dream

    fun setItem(item: Dream): DreamListViewHolder {
        mItem = item
        itemView.tvDescription.text = item.properties.description
        itemView.tvDate.text = item.dateViewString
        return this
    }

    fun onClick(action: (View, Dream) -> Unit): DreamListViewHolder {
        itemView.setOnClickListener { action(itemView, mItem) }
        return this
    }

    fun onLongClick(action: (Dream) -> Boolean): DreamListViewHolder {
        itemView.setOnLongClickListener { action(mItem) }
        return this
    }

}

package ru.iandreyshev.dreams.dreamsList.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.iandreyshev.dreams.R

class DreamsListAdapter : RecyclerView.Adapter<DreamsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamsListViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_dream_diary_item, parent, false)
        return DreamsListViewHolder(view)
    }

    override fun onBindViewHolder(p0: DreamsListViewHolder, p1: Int) {
    }

    override fun getItemCount(): Int {
        return 100
    }

}

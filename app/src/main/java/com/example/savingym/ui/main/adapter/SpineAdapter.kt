package com.example.savingym.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.savingym.R
import com.example.savingym.data.Entity.Exercises
import kotlinx.android.synthetic.main.item_main_rv.view.*

class SpineAdapter (
    private var items: List<Exercises>
): RecyclerView.Adapter<SpineAdapter.ImageHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder =
        ImageHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_main_rv,
                parent,
                false
            )
        )

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: SpineAdapter.ImageHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Exercises) {
            itemView.iv_exp.setImageResource(item.id ?: 0)
            itemView.tv_exp.text = item.title
        }
    }
}
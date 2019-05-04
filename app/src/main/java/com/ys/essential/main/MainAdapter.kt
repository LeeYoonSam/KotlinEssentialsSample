package com.ys.essential.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ys.essential.R

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val titles = arrayOf(
        "Activity State Changes",
        "Saving and Restoring the State",
        "View Groups and Layouts",
        "Working with ConstraintLayout Chains and Ratios"
    )

    private val details = arrayOf(
        "Item one details",
        "Item two details",
        "Item three details",
        "Item four details",
        "Item five details",
        "Item six details",
        "Item seven details",
        "Item eight details"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = titles[position]
        holder.itemTitle.text = title
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener { v: View ->
                var position: Int = adapterPosition
                Snackbar.make(v, "Click detected on item $position", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
            }
        }
    }
}
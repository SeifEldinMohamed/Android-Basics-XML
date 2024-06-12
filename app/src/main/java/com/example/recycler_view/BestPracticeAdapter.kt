package com.example.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstsession.R


class BestPracticeAdapter : RecyclerView.Adapter<BestPracticeAdapter.ViewHolder>() {
    private var itemsList: List<String> = emptyList()

    var onItemClick: OnItemClick<String>? = null
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val textView: TextView = itemView.findViewById(R.id.textView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.rv_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.textView.text = itemsList[position]
         holder.itemView.setOnClickListener {
             onItemClick?.onItemClick(itemsList[position], position)
         }
    }
    override fun getItemCount(): Int = itemsList.size

    // Return the view type of the item at position for the purposes of view recycling.
    // The default implementation of this method returns 0, making the assumption of a single view type for the adapter.
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun updateList(newList: List<String>) {
        val diffUtilCallBack = MyDiffUtil(this.itemsList, newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallBack)
        this.itemsList = newList
        diffUtilResult.dispatchUpdatesTo(this)
    }

}
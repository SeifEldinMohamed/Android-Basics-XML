package com.example.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstsession.R
import com.example.firstsession.databinding.RvItemBinding


class BestPracticeAdapter : RecyclerView.Adapter<BestPracticeAdapter.ViewHolder>() {
    private var itemsList: List<String> = emptyList()

    var onItemClick: OnItemClick<String>? = null
    class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(text:String){
            binding.textView.text = text
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "text = $text", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // holder.textView.text = itemsList[position]
         holder.itemView.setOnClickListener {
             onItemClick?.onItemClick(itemsList[position], position)
         }
        holder.bind(itemsList[position])
    }
    override fun getItemCount(): Int = itemsList.size

    // Return the view type of the item at position for the purposes of view recycling.
    // The default implementation of this method returns 0, making the assumption of a single view type for the adapter.
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun updateList(newList: List<String>) {
        val diffUtilCallBack = MyDiffUtil(oldList = this.itemsList, newList = newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallBack)
        this.itemsList = newList
        diffUtilResult.dispatchUpdatesTo(this)
//         this.itemsList = newList
//        notifyDataSetChanged()
    }

}
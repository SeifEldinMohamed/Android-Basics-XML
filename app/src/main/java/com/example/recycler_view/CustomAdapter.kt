package com.example.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstsession.R

// This part inherits from RecyclerView.Adapter. This means MyAdapter acts as an adapter for a RecyclerView,
// providing the data and views for its elements.
class MyAdapter(private val items: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val textView: TextView = itemView.findViewById(R.id.textView)
    }
    // This defines an inner class named ViewHolder that extends RecyclerView.ViewHolder.
    // ViewHolder holds references to the views that make up each item in your list.
    // The constructor takes a View argument, which represents the root layout of a single item in the RecyclerView.
    // Inside the constructor, it initializes a property named textView of type TextView. This retrieves the
    // TextView element with the ID R.id.textView from the itemView. This textView will likely be used to
    // display the text content of each list item.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.rv_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    // This method is called by the RecyclerView whenever a new view needs to be created for an item.

    // parent: This is the ViewGroup that will hold the new view.

    // viewType: This is an integer value that can be used for different types
    // of view layouts within the adapter (not used in this example).

    // The method inflates the layout resource list_item.xml using the
    // LayoutInflater and returns a new ViewHolder instance.

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.textView.text = items[position]
        // itemView: A ViewHolder describes an item view and metadata about its place within the RecyclerView.
         holder.itemView.setOnClickListener {
             Toast.makeText(
                 holder.itemView.context,
                 "position: ${items[position]}",
                 Toast.LENGTH_SHORT
             ).show()
         }
    }

    // This method is called by the RecyclerView to bind the data to a specific view holder (item).

    // holder: This is the ViewHolder instance for the current item.

    // position: This is the position of the item within the data list.

    // This method sets the text of the textView in the holder to the corresponding string
    // from the items list at the given position.

    // It also sets an OnClickListener on the entire item view (holder.itemView).
    // When the item is clicked, it calls the clickListener function and passes
    // the clicked item's string data as an argument.

    override fun getItemCount(): Int = items.size

    // This method simply returns the size of the items list,
    // indicating the total number of items in the dataset.

}
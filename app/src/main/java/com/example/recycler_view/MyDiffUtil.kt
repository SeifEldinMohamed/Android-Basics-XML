package com.example.recycler_view

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil<String>(
    private val oldList: List<String>,
    private val newList: List<String>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int { // Returns the size of the old list.
        return oldList.size
    }

    override fun getNewListSize(): Int { // Returns the size of the new list.
        return newList.size
    }

    // Called by the DiffUtil to decide whether two object represent the same Item.
    // For example, if your items have unique ids, this method should check their id equality.
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    // Called by the DiffUtil when it wants to check whether two items have the same data.
    // DiffUtil uses this information to detect if the contents of an item has changed.
    // DiffUtil uses this method to check equality instead of Object.equals(Object) so that
    // you can change its behavior depending on your UI.
    // For example, if you are using DiffUtil with a RecyclerView.Adapter,
    // you should return whether the items' visual representations are the same.
    // This method is called only if areItemsTheSame(int, int) returns true for these items.

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
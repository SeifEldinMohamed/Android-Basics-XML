package com.example.recycler_view

interface OnItemClick<String> {
    fun onItemClick(item: String, position: Int)
}
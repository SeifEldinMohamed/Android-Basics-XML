package com.example.list_view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstsession.R
import com.example.firstsession.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    val binding = ActivityListViewBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Basic Usage
        val items = listOf("Item 1", "Item 2", "Item 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Clicked: $item", Toast.LENGTH_SHORT).show()
        }

    }
}
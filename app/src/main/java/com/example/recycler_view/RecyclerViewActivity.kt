package com.example.recycler_view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstsession.R
import com.example.firstsession.databinding.ActivityListViewBinding
import com.example.firstsession.databinding.ActivityRecyclerViewBinding
import kotlinx.coroutines.delay

class RecyclerViewActivity : AppCompatActivity(), OnItemClick<String>  {
    private val bestPracticeAdapter by lazy { BestPracticeAdapter() }
    private lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bestPracticeAdapter.onItemClick = this

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
       // binding.recyclerView.adapter = MyAdapter(getItems())
        // This implementation provides basic
        // animations on remove, add, and move events that happen to the items in  a RecyclerView.
        // RecyclerView uses a DefaultItemAnimator by default.

         binding.recyclerView.adapter = bestPracticeAdapter
         bestPracticeAdapter.updateList(getMoreItems())
         //binding.recyclerView.itemAnimator = DefaultItemAnimator() // there by default

       // Thread.sleep(3000)

    }
    private fun getItems(): List<String> {
        return listOf("Item 1", "Item 2", "Item 3")
    }
    private fun getMoreItems(): List<String> {
        return listOf("Item 1", "Item 2", "Item 3", "Item4", "Item5", "Item6")
    }

    override fun onItemClick(item: String, position: Int) {
        bestPracticeAdapter.updateList(getItems())
        Toast.makeText(this, "itemClicked: $item of position $position", Toast.LENGTH_SHORT).show()

    }
}
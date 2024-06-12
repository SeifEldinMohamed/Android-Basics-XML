package com.example.firstsession

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstsession.databinding.ActivityMainSession2Binding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainSession2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main_session2)
        setContentView(binding.root)
        //binding.textView.text = "Hello, World!"
        val s = ";asldjf"
        Log.d("val", s)

        binding.btnAdd.setOnClickListener {
            Log.d("val", it.toString())
        }

       val adapter =  ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
            //R.layout.custom_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // customAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item)
        binding.spinnerItems.adapter = adapter

        binding.spinnerItems.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}
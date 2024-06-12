package com.example

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import com.example.firstsession.R
import com.example.firstsession.databinding.ActivityMainSession3Binding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainSession3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            // val d =  group[checkedId] as RadioButton
            Toast.makeText(this, "Selected: ${radioButton.text}", Toast.LENGTH_SHORT).show()
            //Toast.makeText(this, "Selected: ${d.text}", Toast.LENGTH_SHORT).show()
        }

        binding.checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // Code to handle checked state
            } else {
                // Code to handle unchecked state
            }
        }
        binding.checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // Code to handle checked state
            } else {
                // Code to handle unchecked state
            }
        }
    }
    // Inflate the menu resource file into the ToolBar.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Converts the XML menu resource into actual menu items in the ToolBar.
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        return true // Indicates that the menu should be displayed.
    }

    // Handle the actions when a menu item is selected.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Handle settings action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        // item.itemId: Retrieves the ID of the selected menu item.
        // R.id.action_settings: Checks if the selected item is the "Settings" menu item.
        // true: Indicates that the click event is handled.
        // super.onOptionsItemSelected(item): Calls the superclass implementation for unhandled items.
    }
}
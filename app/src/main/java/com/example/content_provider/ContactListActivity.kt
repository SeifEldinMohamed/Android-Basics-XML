package com.example.content_provider

import android.Manifest
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.firstsession.R

class ContactListActivity : AppCompatActivity() {
    private val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        // Checking and requesting permissions in an Activity.
        // checkSelfPermission: Determine whether you have been granted a particular permission.
        // ContextCompat is a utility class in Android that provides backward-compatible versions
        // of various methods related to context.
        // Simplifies checking and requesting permissions, especially since the introduction of
        // runtime permissions in Android 6.0 (API level 23).
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED // Class for retrieving various kinds of information related to the application packages that are currently installed on the device.
        ) {
            // Permission is not granted
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS
            )
        } else {
            // Permission has already been granted
            loadContacts()
        }

    }

    // Callback for the result from requesting permissions.
    // This method is invoked for every call on requestPermissions(Activity, String[], int).
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                loadContacts()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadContacts() {
        val contentResolver: ContentResolver = contentResolver
        val cursor: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER),// elements you need
            null,
            null,
            null
        )
// Executes the given block function on this resource and then closes it down correctly whether an exception is thrown or not.
        cursor?.use {
            val contactsList = mutableListOf<String>()
            val nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

            while (cursor.moveToNext()) {
                val name = cursor.getString(nameIndex)
                val number = cursor.getString(numberIndex)
                contactsList.add("$name: $number")
            }

            // Display contacts (e.g., in a RecyclerView)
            displayContacts(contactsList)
        }
    }

    private fun displayContacts(contacts: List<String>) {
        Log.d("contacts list", contacts.toString())
    }
}
package com.example.content_provider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class MyContentProvider : ContentProvider() {

    companion object {
        const val PROVIDER_NAME = "com.example.myprovider" //  The authority part of the content provider's URI.
        const val URL = "content://$PROVIDER_NAME/items" // The full content URI.
        val CONTENT_URI: Uri = Uri.parse(URL) // Parsed URI based on the URL

        // Constants to represent the URI paths for all items and a single item respectively.
        const val ITEMS = 1
        const val ITEM_ID = 2

        //  An instance of UriMatcher that helps to match the URI to determine the
        //  action (query, insert, delete, etc.) based on the URI pattern.
        // NO_MATCH is used to signify that the URI does not match any patterns initially.
        val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(PROVIDER_NAME, "items", ITEMS) // Adds a URI pattern for all items.
            addURI(PROVIDER_NAME, "items/#", ITEM_ID) //  Adds a URI pattern for a single item identified by its ID.
        }
    }

    // This method is called when the content provider is first created. Typically used to perform one-time initialization.
    override fun onCreate(): Boolean {
        // Initialize your data source, e.g., a database
        return true
    }
// Handles query requests from clients. This method should return a Cursor object containing the
// results of the query. For now, it returns null which indicates no data.
    override fun query(
        uri: Uri, 
        projection: Array<out String>?, 
        selection: String?, 
        selectionArgs: Array<out String>?, 
        sortOrder: String?
    ): Cursor? {
        // Handle query requests from clients
        return null
    }

    // Returns the MIME type of the data at the given URI. Used by the system to determine the
    // type of data provided by this content provider.
    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            ITEMS -> "vnd.android.cursor.dir/vnd.example.items"
            ITEM_ID -> "vnd.android.cursor.item/vnd.example.items"
            else -> throw IllegalArgumentException("Unsupported URI: $uri")
        }
    }

    // Handles requests to insert a new row. This should return the URI for the newly inserted item.
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        // Handle insert requests from clients
        return null
    }

    // Handles requests to delete one or more rows. Returns the number of rows affected.
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        // Handle delete requests from clients
        return 0
    }

    // Handles requests to update one or more rows. Returns the number of rows affected.
    override fun update(
        uri: Uri, 
        values: ContentValues?, 
        selection: String?, 
        selectionArgs: Array<out String>?
    ): Int {
        // Handle update requests from clients
        return 0
    }
}
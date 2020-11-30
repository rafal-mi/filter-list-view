package com.example.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {

    lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.my_list)
        val myList = listOf("Eraser", "Books", "Pencil", "Pen", "Copy", "Ruler")

        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList)
        listView.adapter = arrayAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        val menuItem = menu?.findItem(R.id.search_icon)
        val searchView = menuItem?.actionView as SearchView
        searchView.queryHint = "Search Here"

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                arrayAdapter.filter.filter(newText)
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }
}
package com.aleangelozi.searchableexposeddropdownmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf("Canada", "USA", "Brazil", "Mexico", "Israel")
        val textView = findViewById<TextView>(R.id.textView)

        val adapter = CustomAdapter(this, R.layout.support_simple_spinner_dropdown_item, list)
        val dropdownMenu = findViewById<AutoCompleteTextView>(R.id.input)
        dropdownMenu.setAdapter(adapter)
        dropdownMenu.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = p0?.getItemAtPosition(p2).toString()
            }
        })
    }
}
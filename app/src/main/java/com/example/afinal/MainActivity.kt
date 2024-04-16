package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.project.historyinfo


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of linking to my second activity using a button click
        val button = findViewById<Button>(R.id.transfer)
        button.setOnClickListener {

            //Creating the intent to link
            val intent = Intent(this, historyinfo::class.java)
            startActivity(intent)
        }
    }
}
package com.example.cookbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val add = findViewById<Button>(R.id.add_recipe)
        add.setOnClickListener{
            val intent = Intent(this, AddRecipe::class.java)
            startActivity(intent)
        }
    }
}
package com.example.cookbook

import android.content.Context
import android.content.ContextWrapper
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.io.File

class AddRecipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        val read = findViewById<Button>(R.id.add_photo)
        val image = findViewById<ImageView>(R.id.image)

        read.setOnClickListener{
            var cw: ContextWrapper = ContextWrapper(this)
            var directory: File = cw.getDir("imageDir", Context.MODE_PRIVATE)
            var file: File = File(directory, "image" + ".png")

            image.setImageDrawable(Drawable.createFromPath(file.toString()))
        }
    }
}
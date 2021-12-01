package com.example.cookbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = Firebase.auth

        var email = findViewById<EditText>(R.id.email)
        var pass = findViewById<EditText>(R.id.pass)
        var submit = findViewById<Button>(R.id.register);

        submit.setOnClickListener{
            var mail = email.text.toString();
            var pass = pass.text.toString();

            auth.createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this){ task ->
                    if(task.isSuccessful){
                        val intent = Intent(this, MainMenu::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this, "registration failed!", Toast.LENGTH_LONG).show()
                    }
                }


        }


    }
}
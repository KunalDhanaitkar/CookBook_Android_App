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

class MainActivity : AppCompatActivity() {
private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        val register = findViewById<Button>(R.id.reg_button);
        register.setOnClickListener{
            val intent = Intent(this, Register::class.java);
            startActivity(intent);
        }

        val about = findViewById<Button>(R.id.about_us);
        about.setOnClickListener{
            val intent = Intent(this, About::class.java);
            startActivity(intent);
        }
        val contact = findViewById<Button>(R.id.contact);
        contact.setOnClickListener{
            val intent = Intent(this, Contact::class.java);
            startActivity(intent)
        }

        var email = findViewById<EditText>(R.id.email)
        var pass = findViewById<EditText>(R.id.password)
        var login = findViewById<Button>(R.id.sign_button)

        login.setOnClickListener{
            var mail = email.text.toString()
            var password = pass.text.toString()

            auth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        var intent = Intent(this, MainMenu::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "User does not exist, please try again", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
}
package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var validatedText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val premiertextView : TextView = findViewById(R.id.editTextText)
        val txtSaisi = premiertextView.text.toString()
        val layoutPrincipal : ConstraintLayout = findViewById(R.id.main)
        val deuxiemeTextView : TextView = TextView(this)
        val premierBouton : Button = findViewById(R.id.btn1)
        premierBouton.setOnClickListener{
            premiertextView.text = "Nouveau texte avec le bouton"
            layoutPrincipal.addView(deuxiemeTextView)
        }
        val validateButton = findViewById<Button>(R.id.btnvalidate)
        val EXTRA_TEXT = "text_to_display"
        val nextButton = findViewById<Button>(R.id.btnNext)

        validateButton.setOnClickListener{
            validatedText = premiertextView.text.toString()
            if (validatedText.isNullOrEmpty()){
                premiertextView.error = "Le texte ne peut pas être vide"
            } else{
                nextButton.isEnabled = true
            }
        }

        nextButton.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, "Hello, MainActivity2!")
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_TEXT = "text_to_display"
    }
}
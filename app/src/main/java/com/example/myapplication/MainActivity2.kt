package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = intent
        val data = intent.getStringExtra(MainActivity.EXTRA_TEXT)
        val receivedText = intent.getStringExtra(MainActivity.EXTRA_TEXT)

        val EXTRA_TEXT = "text_to_display"
        val textView = findViewById<TextView>(R.id.display_label)
        textView.text = data ?: "Aucune donnée reçue"
        val backButton = findViewById<Button>(R.id.btnPrecedent)
        backButton.setOnClickListener{
            finish()
        }
    }
}
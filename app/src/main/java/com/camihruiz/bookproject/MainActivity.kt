package com.camihruiz.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookNameEditText : EditText = findViewById(R.id.book_name_edit_text)
        val saveButton : Button = findViewById(R.id.save_button)
        val infoTextView : TextView = findViewById(R.id.info_text_view)

        saveButton.setOnClickListener{
            val nameBook : String = bookNameEditText.text.toString()
            infoTextView.text = nameBook
        }
    }
}
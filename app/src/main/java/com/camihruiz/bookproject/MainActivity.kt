package com.camihruiz.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
import com.camihruiz.bookproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var mainBinding : ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // val bookNameEditText : EditText = findViewById(R.id.book_name_edit_text)
        
        with (mainBinding) {
            saveButton.setOnClickListener {
        
                if (bookNameEditText.text.isEmpty() || authorNameEditText.text.isEmpty() || pagesEditText.text?.isEmpty() == true) {
                    Toast.makeText(applicationContext,"Debe digital nombre, autor y número de páginas",Toast.LENGTH_SHORT).show()
                } else {
                    val nameBook: String = bookNameEditText.text.toString()
                    val author = authorNameEditText.text.toString()
                    val pages = pagesEditText.text.toString().toInt()
                    val abstract = abstractInputText.text.toString()
    
                    infoTextView.text =
                        "Name: " + nameBook + "Author: " + author + "Pages: " + pages + " Abstract: " + abstract
                }
            }
        }
    }
}
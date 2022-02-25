package com.camihruiz.bookproject

//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.camihruiz.bookproject.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var mainBinding : ActivityMainBinding
    private var calendar = Calendar.getInstance()
    private var publicationDate = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // val bookNameEditText : EditText = findViewById(R.id.book_name_edit_text)
        
        val dateSetListener = DatePickerDialog.OnDateSetListener{_, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            
            val format = "yyyy-MM-dd"
            val simpleDateFormat = SimpleDateFormat(format, Locale.US)
            publicationDate = simpleDateFormat.format(calendar.time).toString()
            mainBinding.publicationDateButton.text = publicationDate
        }
        
        with (mainBinding) {
            publicationDateButton.setOnClickListener {
                DatePickerDialog(
                    this@MainActivity ,
                    dateSetListener ,
                    calendar.get(Calendar.YEAR) ,
                    calendar.get(Calendar.MONTH) ,
                    calendar.get(Calendar.DAY_OF_YEAR)
                ).show()
            }
            
            
            saveButton.setOnClickListener {
                if (bookNameEditText.text?.isEmpty() == true || authorNameEditText.text?.isEmpty() == true || pagesEditText.text?.isEmpty() == true) {
                    Toast.makeText(applicationContext,"Debe digital nombre, autor y número de páginas",Toast.LENGTH_SHORT).show()
                } else {
                    val nameBook: String = bookNameEditText.text.toString() // no es necesario poner : String porque la variable infiere desde toString()
                    val author = authorNameEditText.text.toString()
                    val pages = pagesEditText.text.toString().toInt()
                    val abstract = abstractEditText.text.toString()
                    
                    var genre = ""
                    if (childCheckBox.isChecked) genre += "Infantil "
                    if (fantasyCheckBox.isChecked) genre += "Fantasía "
                    if (terrorCheckBox.isChecked) genre += "Terror "
                    if (dramaCheckBox.isChecked) genre += "Drama "
                    if (scienceFictionCheckBox.isChecked) genre += "Ciencia Ficción "
                    if (thrillerCheckBox.isChecked) genre += "Suspenso "
                    
                    val score = when {
                        radioButton1.isChecked -> 1
                        radioButton2.isChecked -> 2
                        radioButton3.isChecked -> 3
                        radioButton4.isChecked -> 4
                        else -> 5
                    }
                    
                    infoTextView.text = getString(R.string.info, nameBook, author, pages, abstract, genre, score, publicationDate)
                }
            }
        }
    }
}
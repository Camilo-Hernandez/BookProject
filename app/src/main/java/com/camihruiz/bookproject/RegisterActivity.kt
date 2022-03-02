package com.camihruiz.bookproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.camihruiz.bookproject.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
	
	private lateinit var registerBinding: ActivityRegisterBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
		setContentView(registerBinding.root)
		
		with(registerBinding){
			registerButton.setOnClickListener {
				val email = emailInputText.text.toString()
				val password = passwordInputText.text.toString()
				val repPassword = repPasswordInputText.text.toString()
				
				if(password!=repPassword){
					Toast.makeText(applicationContext, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
				} else{
					val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
					intent.putExtra("Email", email)
					intent.putExtra("Contraseña", password)
					startActivity(intent)
				}
				
				
				
			}
		}
		
	}
}
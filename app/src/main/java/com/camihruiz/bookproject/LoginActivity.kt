package com.camihruiz.bookproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.camihruiz.bookproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
	
	private lateinit var loginBinding: ActivityLoginBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		loginBinding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(loginBinding.root)
		var emailReceived : String? = ""
		var passwordReceived : String? = ""
		val credentials = intent.extras
		if (credentials!=null){
			emailReceived = credentials.getString("Email")
			passwordReceived = credentials.getString("Contraseña")
		}
		
		with(loginBinding){
			registerTextView.setOnClickListener {
				val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
				startActivity(intent)
			}
			loginButton.setOnClickListener {
				val email = emailInputText.text.toString()
				val password = passwordInputText.text.toString()
				
				if(email != emailReceived || password != passwordReceived || email.isEmpty() || password.isEmpty()){
					Toast.makeText(this@LoginActivity , "Correo o contraseña incorrectos" , Toast.LENGTH_SHORT).show()
				} else {
					val intent = Intent(this@LoginActivity, MainActivity::class.java)
					intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_CLEAR_TASK
					startActivity(intent)
				}
			}
		}
	}
}
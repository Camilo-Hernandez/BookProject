package com.camihruiz.bookproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.camihruiz.bookproject.databinding.ActivitySplashBinding
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
	
	private lateinit var splashBinding: ActivitySplashBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		splashBinding = ActivitySplashBinding.inflate(layoutInflater)
		setContentView(splashBinding.root)
		
		val timer = Timer() // necesita la librería java.util.*
		timer.schedule(
			timerTask {
				goToLoginActivity()
			}, 2000
		)
	}
	
	private fun goToLoginActivity() {
		val intent = Intent(this , LoginActivity::class.java)
		intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_CLEAR_TASK // limpiar la pila produce que el back button se vaya de la app
		startActivity(intent)
		//finish() // Para que no se pueda regresar a ella, se destruye la actividad !
	}
}
package com.example.svibe.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.svibe.MainActivity
import com.example.svibe.R

class GuestLoginActivity : AppCompatActivity() {

    private lateinit var btnGuestLogin: Button
    private lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_login)

        // Inicializar botones
        btnGuestLogin = findViewById(R.id.btnGuestLogin)
        btnSignIn = findViewById(R.id.btnSignIn)

        // Acción: Entrar como invitado
        btnGuestLogin.setOnClickListener {
            // Guardar en preferencias que es invitado
            val sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
            sharedPref.edit().putBoolean("is_guest", true).apply()

            // Mostrar mensaje
            Toast.makeText(this, getString(R.string.guest_toast), Toast.LENGTH_SHORT).show()

            // Redirigir a MainActivity (pantalla de inicio)
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        // Acción: Iniciar sesión / Registrarse (placeholder)
        btnSignIn.setOnClickListener {
            Toast.makeText(this, getString(R.string.development_toast), Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.svibe

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val webView = findViewById<WebView>(R.id.webViewMapa)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        // RECIBIR UBICACIÓN
        val ubicacion = intent.getStringExtra("ubicacion")

        // SI VIENE UNA UBICACIÓN -> ABRIR ESA
        // SI NO -> MAPA GENERAL
        if (ubicacion != null) {

            val urlUbicacion =
                "https://www.google.com/maps/search/?api=1&query=" +
                        ubicacion.replace(" ", "+")

            webView.loadUrl(urlUbicacion)

        } else {

            webView.loadUrl(
                "https://www.google.com/maps/d/u/0/edit?mid=1HS0rEL_dtDyoiWT4iZI4kd5ofLiJiPk&usp=sharing"
            )
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.selectedItemId = R.id.mapa

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.inicio -> {

                    startActivity(
                        Intent(this, MainActivity::class.java)
                    )

                    true
                }

                R.id.mapa -> true

                R.id.oculto -> {

                    startActivity(
                        Intent(this, OcultosActivity::class.java)
                    )

                    true
                }

                else -> true
            }
        }
    }
}
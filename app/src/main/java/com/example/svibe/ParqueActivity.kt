package com.example.svibe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.cardview.widget.CardView
import com.google.android.material.bottomsheet.BottomSheetDialog

class ParqueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalle_parque)

        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHora = findViewById<TextView>(R.id.txtHora)
        val cardEstado = findViewById<CardView>(R.id.cardEstado)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.inicio -> {

                    startActivity(
                        Intent(this, MainActivity::class.java)
                    )

                    true
                }

                R.id.mapa -> {

                    startActivity(
                        Intent(this, MapActivity::class.java)
                    )

                    true
                }

                R.id.oculto -> {

                    startActivity(
                        Intent(this, OcultosActivity::class.java)
                    )

                    true
                }

                R.id.ra -> {

                    // Pendiente cuando crees la pantalla RA
                    true
                }

                R.id.perfil -> {

                    // Pendiente cuando crees la pantalla Perfil
                    true
                }

                else -> true
            }
        }

        txtEstado.text = "Abierto hoy"
        txtHora.text = "Abierto las 24 horas"



        txtEstado.setTextColor(Color.parseColor("#2E7D32"))

        cardEstado.setOnClickListener {

            val dialog = BottomSheetDialog(this)

            val view = layoutInflater.inflate(
                R.layout.bottom_sheet_parque,
                null
            )

            dialog.setContentView(view)
            dialog.show()
        }
    }
}
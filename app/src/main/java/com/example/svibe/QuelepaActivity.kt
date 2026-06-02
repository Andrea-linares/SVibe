package com.example.svibe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.widget.TextView
import java.util.Calendar
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class QuelepaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_quelepa)
        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHoraCierre = findViewById<TextView>(R.id.txtHoraCierre)

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

        val horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        if (horaActual in 9..15) {

            txtEstado.text = "Abierto hoy"
            txtEstado.setTextColor(Color.parseColor("#2E7D32"))

            txtHoraCierre.text = "Cierra a las 4:00 pm"

        } else {

            txtEstado.text = "Cerrado"
            txtEstado.setTextColor(Color.RED)

            txtHoraCierre.text = "Abre mañana a las 9:00 am"
        }
    }
}
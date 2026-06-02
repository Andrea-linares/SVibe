package com.example.svibe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChorrosCaleraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalle_calera)

        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHora = findViewById<TextView>(R.id.txtHoraCierre)
        val txtMantenimiento = findViewById<TextView>(R.id.txtMantenimiento)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.selectedItemId = R.id.oculto

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

        // Horario: 8:00 AM - 5:00 PM
        if (horaActual in 8..16) {

            txtEstado.text = "Abierto hoy"
            txtHora.text = "Cierra a las 5:00 PM"
            txtMantenimiento.text = "Abierto al público"

        } else {

            txtEstado.text = "Cerrado"
            txtHora.text = "Abre mañana a las 8:00 AM"
            txtMantenimiento.text = "Fuera de horario"

        }
    }
}
package com.example.svibe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView


class MiradorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalle_mirador)

        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHora = findViewById<TextView>(R.id.txtHoraCierre)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.selectedItemId = R.id.inicio

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

                R.id.ra -> true

                R.id.perfil -> true

                else -> true
            }
        }

        val horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        // Horario: 8 AM - 10 PM
        if (horaActual in 8..21) {

            txtEstado.text = "Abierto hoy"
            txtHora.text = "Cierra a las 10:00 PM"

        } else {

            txtEstado.text = "Cerrado"
            txtHora.text = "Abre mañana a las 8:00 AM"

        }
    }
}
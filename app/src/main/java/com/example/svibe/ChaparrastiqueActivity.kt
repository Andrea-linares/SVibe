package com.example.svibe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.content.Intent
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog

class ChaparrastiqueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalle_chaparrastique)

        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHora = findViewById<TextView>(R.id.txtHoraCierre)
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

        val horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        // Horario: 8 AM - 5 PM
        if (horaActual in 8..16) {

            txtEstado.text = "Abierto hoy"
            txtHora.text = "Cierra a las 5:00 PM"

        } else {

            txtEstado.text = "Cerrado"
            txtHora.text = "Abre mañana a las 8:00 AM"

        }


        // Mostrar precios al tocar la tarjeta de estado
        cardEstado.setOnClickListener {

            val dialog = BottomSheetDialog(this)

            val view = layoutInflater.inflate(
                R.layout.bottom_sheet_chaparrastique,
                null
            )

            dialog.setContentView(view)
            dialog.show()

        }
    }
}
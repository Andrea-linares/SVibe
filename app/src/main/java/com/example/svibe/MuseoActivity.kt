package com.example.svibe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.content.Intent
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
class MuseoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalle_museo)

        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHora = findViewById<TextView>(R.id.txtHora)
        val cardEstado = findViewById<CardView>(R.id.cardEstado)


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.inicio -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }

                R.id.mapa -> {
                    startActivity(Intent(this, MapActivity::class.java))
                    true
                }

                R.id.oculto -> {
                    startActivity(Intent(this, OcultosActivity::class.java))
                    true
                }

                R.id.ra -> true

                R.id.perfil -> true

                else -> true
            }
        }

        val calendar = Calendar.getInstance()
        val hora = calendar.get(Calendar.HOUR_OF_DAY)
        val dia = calendar.get(Calendar.DAY_OF_WEEK)

        val abierto = when (dia) {

            Calendar.TUESDAY,
            Calendar.WEDNESDAY,
            Calendar.THURSDAY,
            Calendar.FRIDAY -> hora in 8..15

            Calendar.SATURDAY -> hora in 8..11

            else -> false
        }

        if (abierto) {

            txtEstado.text = "Abierto hoy"
            txtHora.text = "Cierra a las 4:00 pm"

        } else {

            txtEstado.text = "Cerrado ahora"
            txtHora.text = "Abrirá mañana"


        }


        // Mostrar precios al tocar la tarjeta de estado
        cardEstado.setOnClickListener {

            val dialog = BottomSheetDialog(this)

            val view = layoutInflater.inflate(
                R.layout.bottom_sheet_museo,
                null
            )

            dialog.setContentView(view)
            dialog.show()
        }
    }
}
package com.example.svibe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.content.Intent
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.graphics.Color

class CatedralActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_catedral)

        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHorarioActual = findViewById<TextView>(R.id.txtHoraCierre)
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

        val calendar = Calendar.getInstance()
        val horaActual = calendar.get(Calendar.HOUR_OF_DAY)
        val minutoActual = calendar.get(Calendar.MINUTE)

        val horaEnMinutos = horaActual * 60 + minutoActual

        val dia = calendar.get(Calendar.DAY_OF_WEEK)

        var apertura = 0
        var cierre = 0

        when (dia) {

            // Domingo
            Calendar.SUNDAY -> {
                apertura = 5 * 60 + 30
                cierre = 20 * 60
            }

            // Jueves
            Calendar.THURSDAY -> {
                apertura = 5 * 60 + 30
                cierre = 17 * 60 + 30
            }

            // Sábado
            Calendar.SATURDAY -> {
                apertura = 5 * 60 + 30
                cierre = 18 * 60 + 30
            }

            // Lunes, martes, miércoles y viernes
            else -> {
                apertura = 5 * 60 + 30
                cierre = 18 * 60
            }
        }

        if (horaEnMinutos >= apertura && horaEnMinutos < cierre) {

            txtEstado.text = "Abierto hoy"
            txtEstado.setTextColor(Color.parseColor("#2E7D32"))

            val horaCierre = cierre / 60
            val minutoCierre = cierre % 60

            txtHorarioActual.text =
                "Cierra a las %02d:%02d".format(horaCierre, minutoCierre)

        } else {

            txtEstado.text = "Cerrado"
            txtEstado.setTextColor(Color.RED)

            val horaApertura = apertura / 60
            val minutoApertura = apertura % 60

            txtHorarioActual.text =
                "Abre a las %02d:%02d".format(horaApertura, minutoApertura)
        }


        // Mostrar precios al tocar la tarjeta de estado
        cardEstado.setOnClickListener {

            val dialog = BottomSheetDialog(this)

            val view = layoutInflater.inflate(
                R.layout.bottom_sheet_catedral,
                null
            )

            dialog.setContentView(view)
            dialog.show()
        }
    }
}
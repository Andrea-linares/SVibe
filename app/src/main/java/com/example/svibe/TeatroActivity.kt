package com.example.svibe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.content.Intent
import android.widget.Button
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.app.Dialog
import android.widget.ImageView

class TeatroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalle_teatro)

        val txtEstado = findViewById<TextView>(R.id.txtEstado)
        val txtHora = findViewById<TextView>(R.id.txtHora)
        val cardEstado = findViewById<CardView>(R.id.cardEstado)
        val btnLeyendaTeatro = findViewById<Button>(R.id.btnLeyendaTeatro)

        val btnGaleria =
            findViewById<Button>(R.id.btnGaleriaCompleta)

        btnGaleria.setOnClickListener {

            val intent =
                Intent(this, GaleriaActivity::class.java)

            intent.putExtra("lugar","teatro")

            startActivity(intent)
        }


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
        val hora = calendar.get(Calendar.HOUR_OF_DAY)
        val dia = calendar.get(Calendar.DAY_OF_WEEK)

        // Lunes a viernes 8am - 4pm

        val abierto = when (dia) {

            Calendar.MONDAY,
            Calendar.TUESDAY,
            Calendar.WEDNESDAY,
            Calendar.THURSDAY,
            Calendar.FRIDAY -> hora in 8..15

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
                R.layout.bottom_sheet_teatro,
                null
            )

            dialog.setContentView(view)
            dialog.show()
        }
        val btnLeerMas = findViewById<Button>(R.id.btnLeerMas)

        btnLeerMas.setOnClickListener {

            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_detalle)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            // IMAGEN
            val imgDialog = dialog.findViewById<ImageView>(R.id.imgDialog)

            // DESCRIPCION
            val txtDescripcion = dialog.findViewById<TextView>(R.id.txtDescripcionDialog)

            // DATOS
            imgDialog.setImageResource(R.drawable.teatro4)


            txtDescripcion.text = "El teatro destaca por su elegante arquitectura y valor histórico."

            dialog.show()

            // HACERLO MÁS ANCHO
            dialog.window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.90).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        btnLeyendaTeatro.setOnClickListener {

            val dialog = Dialog(this)

            dialog.setContentView(R.layout.dialog_leyenda)

            dialog.window?.setBackgroundDrawableResource(
                android.R.color.transparent
            )

            val imgLeyenda =
                dialog.findViewById<ImageView>(R.id.imgLeyenda)

            val txtTituloLeyenda =
                dialog.findViewById<TextView>(R.id.txtTituloLeyenda)

            val txtDescripcionLeyenda =
                dialog.findViewById<TextView>(R.id.txtDescripcionLeyenda)

            imgLeyenda.setImageResource(R.drawable.teatroley)

            txtTituloLeyenda.text = "Leyenda"

            txtTituloLeyenda.text = "Leyenda"

            txtDescripcionLeyenda.text =
                "La leyenda cuenta que por las noches se escuchan pasos y murmullos en el teatro. Según la tradición, serían antiguos artistas que aún permanecen ligados a este lugar."

            dialog.show()

            dialog.window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.90).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }
}
package com.example.svibe

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import android.app.Dialog

data class FotoHistorica(
    val imagen: Int,
    val anio: String,
    val descripcion: String
)

class GaleriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_galeria)

        val contenedor = findViewById<LinearLayout>(R.id.contenedorGaleria)

        val lugar = intent.getStringExtra("lugar")

        val fotos = when (lugar) {

            "teatro" -> listOf(

                FotoHistorica(
                    R.drawable.teatro,
                    "2022",
                    "Fachada principal"
                ),

                FotoHistorica(
                    R.drawable.teatro2,
                    "2022",
                    "Interior del teatro"
                ),

                FotoHistorica(
                    R.drawable.teatro3,
                    "2022",
                    "Interior del teatro"
                ),

                FotoHistorica(
                    R.drawable.teatro4,
                    "2022",
                    "Fachada principal de noche"
                ),

                FotoHistorica(
                    R.drawable.teatro5,
                    "2022",
                    "Interior del teatro"
                ),

                FotoHistorica(
                    R.drawable.teatro6,
                    "2022",
                    "Terraza exterior"
                ),

                FotoHistorica(
                    R.drawable.tearo7,
                    "2022",
                    "Busto de Gerardo barrios"
                ),

                FotoHistorica(
                    R.drawable.teatro8,
                    "2022",
                    "Vestibulo"
                ),

                FotoHistorica(
                    R.drawable.teatro9,
                    "2022",
                    "Foyer"
                ),

                FotoHistorica(
                    R.drawable.teatro10,
                    "2022",
                    "Interir en tono turquesa"
                ),

                FotoHistorica(
                    R.drawable.teatro11,
                    "2022",
                    "Vestibulo con mobiliario de epoca"
                ),

                FotoHistorica(
                    R.drawable.teatro12,
                    "2022",
                    "Gran sala en forma de lira"
                ),

                FotoHistorica(
                    R.drawable.teatro13,
                    "2022",
                    "Gran sala"
                ),


                FotoHistorica(
                    R.drawable.teatro14,
                    "2021",
                    "Funcion de ballet"
                ),

                FotoHistorica(
                    R.drawable.teatro15,
                    "2022",
                    "Funcion de ballet"
                )


            )

            else -> emptyList()
        }

        for (foto in fotos) {

            // Contenedor para imagen + pie de foto
            val contenedorFoto = LinearLayout(this)
            contenedorFoto.orientation = LinearLayout.VERTICAL

            val paramsContenedor = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            // Espacio entre imágenes
            paramsContenedor.setMargins(
                0,
                0,
                0,
                24
            )

            contenedorFoto.layoutParams = paramsContenedor

            // Frame para imagen + texto encima
            val frame = android.widget.FrameLayout(this)

            frame.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    600
                )

// Imagen
            val imageView = ImageView(this)

            imageView.setImageResource(foto.imagen)

            imageView.layoutParams =
                android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT
                )

            imageView.scaleType = ImageView.ScaleType.CENTER_CROP

// Fondo oscuro semitransparente
            val overlay = LinearLayout(this)

            imageView.setOnClickListener {

                val dialog = Dialog(this)

                val imagenGrande = ImageView(this)

                imagenGrande.setImageResource(foto.imagen)

                imagenGrande.layoutParams =
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )

                imagenGrande.scaleType = ImageView.ScaleType.FIT_CENTER

                dialog.setContentView(imagenGrande)

                dialog.window?.setLayout(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )

                dialog.show()
            }

            overlay.orientation = LinearLayout.VERTICAL

            overlay.setBackgroundColor(
                android.graphics.Color.parseColor("#99000000")
            )

            val overlayParams =
                android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
                )

            overlayParams.gravity = android.view.Gravity.BOTTOM

            overlay.layoutParams = overlayParams

            overlay.setPadding(
                16,
                12,
                16,
                12
            )

// Año
            val txtAnio = TextView(this)

            txtAnio.text = foto.anio
            txtAnio.setTextColor(android.graphics.Color.WHITE)
            txtAnio.textSize = 16f

// Descripción
            val txtDescripcion = TextView(this)

            txtDescripcion.text = foto.descripcion
            txtDescripcion.setTextColor(android.graphics.Color.WHITE)
            txtDescripcion.textSize = 13f

            overlay.addView(txtAnio)
            overlay.addView(txtDescripcion)

            frame.addView(imageView)
            frame.addView(overlay)

            contenedorFoto.addView(frame)
            // Agregar al layout principal
            contenedor.addView(contenedorFoto)
        }
    }
}
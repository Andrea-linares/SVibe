package com.example.svibe

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.net.Uri
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_inicio)

        //sidebar
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //tarjetas
        val cardMuseo = findViewById<CardView>(R.id.cardMuseo)
        val cardTeatro = findViewById<CardView>(R.id.cardTeatro)
        val cardParque = findViewById<CardView>(R.id.cardParque)
        val cardCapilla = findViewById<CardView>(R.id.cardCapilla)
        val cardCatedral = findViewById<CardView>(R.id.cardCatedral)
        val cardRosales = findViewById<CardView>(R.id.cardRosales)
        val cardQuelepa = findViewById<CardView>(R.id.cardQuelepa)
        val cardChaparrastique = findViewById<CardView>(R.id.cardChaparrastique)
        val cardJocotal = findViewById<CardView>(R.id.cardJocotal)
        val cardMirador = findViewById<CardView>(R.id.cardMirador)
        //carrusel
        val cardLaguna = findViewById<CardView>(R.id.cardLaguna)
        val cardCienGradas = findViewById<CardView>(R.id.cardCienGradas)
        val cardRauda = findViewById<CardView>(R.id.cardRauda)
        val cardCuevas = findViewById<CardView>(R.id.cardCuevas)


        cardMuseo.setOnClickListener {

            val intent = Intent(this, MuseoActivity::class.java)
            startActivity(intent)

        }

        cardTeatro.setOnClickListener {

            val intent = Intent(this, TeatroActivity::class.java)
            startActivity(intent)

        }

        cardParque.setOnClickListener {

            val intent = Intent(this, ParqueActivity::class.java)
            startActivity(intent)

        }

        cardCapilla.setOnClickListener {

            val intent = Intent(this, CapillaActivity::class.java)
            startActivity(intent)

        }

        cardCatedral.setOnClickListener {

            val intent = Intent(this, CatedralActivity::class.java)
            startActivity(intent)

        }

        cardRosales.setOnClickListener {

            val intent = Intent(this, RosalesActivity::class.java)
            startActivity(intent)

        }

        cardQuelepa.setOnClickListener {

            val intent = Intent(this, QuelepaActivity::class.java)
            startActivity(intent)

        }

        cardChaparrastique.setOnClickListener {

            val intent = Intent(this, ChaparrastiqueActivity::class.java)
            startActivity(intent)

        }

        cardJocotal.setOnClickListener {

            val intent = Intent(this, JocotalActivity::class.java)
            startActivity(intent)

        }

        cardMirador.setOnClickListener {

            val intent = Intent(this, MiradorActivity::class.java)
            startActivity(intent)

        }

        cardLaguna.setOnClickListener {

            val intent = Intent(this, LagunaAlegriaActivity::class.java)
            startActivity(intent)

        }

        cardCienGradas.setOnClickListener {

            val intent = Intent(this, CienGradasActivity::class.java)
            startActivity(intent)

        }

        cardRauda.setOnClickListener {

            val intent = Intent(this, RaudaActivity::class.java)
            startActivity(intent)

        }

        cardCuevas.setOnClickListener {

            val intent = Intent(this, CuevasActivity::class.java)
            startActivity(intent)

        }
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.mapa -> {

                    val intent = Intent(this, MapActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.oculto -> {

                    val intent = Intent(this, OcultosActivity::class.java)
                    startActivity(intent)

                    true
                }
                else -> true
            }

        }
        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.nav_favoritos -> {
                    // Abrir Favoritos
                }

                R.id.nav_descargas -> {
                    // Abrir Descargas
                }

                R.id.nav_logros -> {
                    // Abrir Logros
                }

                R.id.nav_quizz -> {
                    // Abrir Quizz
                }

                R.id.nav_sugerencias -> {
                    // Abrir Sugerencias
                }

                R.id.nav_reporte -> {
                    // Abrir Reporte
                }

                R.id.nav_foro -> {
                    // Abrir Foro
                }

                R.id.nav_calendario -> {
                    // Abrir Calendario
                }

                R.id.nav_acerca -> {
                    // Abrir Acerca de
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}
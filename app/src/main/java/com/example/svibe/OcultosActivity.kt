package com.example.svibe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView

class OcultosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ocultos)

        //sidebar
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val toolbar = findViewById<Toolbar>(R.id.toolbarOcultos)

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

        // CARDS
        val cardImposible = findViewById<CardView>(R.id.cardImposible)
        val cardTercios = findViewById<CardView>(R.id.cardTercios)
        val cardComasagua = findViewById<CardView>(R.id.cardComasagua)
        val cardPuertaDiablo = findViewById<CardView>(R.id.cardPuertaDiablo)
        val cardCalera = findViewById<CardView>(R.id.cardCalera)
        val cardLagunaVerde = findViewById<CardView>(R.id.cardLagunaVerde)

        // BOSQUE EL IMPOSIBLE
        cardImposible.setOnClickListener {

            val intent = Intent(this, BosqueImposibleActivity::class.java)
            startActivity(intent)

        }

        // CASCADA LOS TERCIOS
        cardTercios.setOnClickListener {

            val intent = Intent(this, CascadaTerciosActivity::class.java)
            startActivity(intent)

        }

        // PEÑON COMASAGUA
        cardComasagua.setOnClickListener {

            val intent = Intent(this, PenonComasaguaActivity::class.java)
            startActivity(intent)

        }

        // PUERTA DEL DIABLO
        cardPuertaDiablo.setOnClickListener {

            val intent = Intent(this, PuertaDiabloActivity::class.java)
            startActivity(intent)

        }

        // CHORROS DE LA CALERA
        cardCalera.setOnClickListener {

            val intent = Intent(this, ChorrosCaleraActivity::class.java)
            startActivity(intent)

        }

        // LAGUNA VERDE
        cardLagunaVerde.setOnClickListener {

            val intent = Intent(this, LagunaVerdeActivity::class.java)
            startActivity(intent)

        }

        // BOTTOM MENU
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

                R.id.oculto -> true

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
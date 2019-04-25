package com.tillduo.frequencia

import android.annotation.SuppressLint
import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CalendarView
import android.widget.DigitalClock
import android.widget.TextView
import bd.BancoDados
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Estava dando erro ao tentar executar
//        val db = Room.databaseBuilder(
//            applicationContext,
//            BancoDados::class.java, "banco_dados_frequencia"
//        ).build()

        fab.setOnClickListener {
            val intent= Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.acao_notificacoes -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.novo_grupo -> {
                // Handle the camera action
            }
            R.id.meus_grupos -> {

            }
            R.id.registro_mensal -> {

            }
            R.id.contatos -> {

            }
            R.id.configuracao -> {

            }
            R.id.duvidas -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun sair(){
        // Está ocorrendo um erro, finaliza a aplicação.
        Log.i("info", "SAINDO PARA A TELA INICIAL.")
        val intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
package com.example.motorriders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
private lateinit var toogle: ActionBarDrawerToggle
private lateinit var dlVista: DrawerLayout
private lateinit var navVista: NavigationView

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    dlVista = findViewById(R.id.drawerLayout)
    toogle = ActionBarDrawerToggle(this, dlVista, R.string.abrir_drawer, R.string.cerrar_drawer)
    toogle.syncState()

    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    navVista = findViewById(R.id.nav_Vista)
    navVista.setNavigationItemSelectedListener {
        when(it.itemId){
            R.id.nav_Inicio->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fcv_Vista, InicioFragment())
                    commit()
                }
            }
            R.id.nav_Agregar->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fcv_Vista, AgregarFragment())
                    commit()
                }
            }
            R.id.nav_Ver->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fcv_Vista, VerFragment())
                    commit()
                }
            }
            R.id.nav_Venta->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fcv_Vista, VentaFragment())
                    commit()
                }
            }
            R.id.nav_Acercade->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fcv_Vista, AcercaDeFragment())
                    commit()
                }
            }
        }
        dlVista.closeDrawer(GravityCompat.START)
        true
    }
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if(toogle.onOptionsItemSelected(item)) {
        return true
    }
    return onOptionsItemSelected(item)
}
}
package com.example.proyecto_dam.usuarioActivities

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import android.media.audiofx.PresetReverb.Settings
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.adaptador.ComidaAdapter
import com.example.proyecto_dam.adminActivities.MainAdminActivity
import com.example.proyecto_dam.base.BurgerBD
import com.example.proyecto_dam.controlador.ArregloComida
import com.example.proyecto_dam.entidad.Comida
import com.example.proyecto_dam.entidad.Usuario

class NavegacionActivity : AppCompatActivity() {


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_navigation,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
                R.id.bottom_menu_home -> {
                    Toast.makeText(this, "JAAA", Toast.LENGTH_LONG).show()
                    return true
                }
            R.id.bottom_menu_book -> {

                val intent = Intent(this, DatosActivity::class.java)
                startActivity(intent)
                    return true
            }

        }


        return super.onOptionsItemSelected(item)
    }
}

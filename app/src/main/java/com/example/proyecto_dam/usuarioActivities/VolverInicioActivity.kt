package com.example.proyecto_dam.usuarioActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.adaptador.ComidaAdapter
import com.example.proyecto_dam.base.BurgerBD
import com.example.proyecto_dam.controlador.ArregloComida
import com.example.proyecto_dam.entidad.Comida

class VolverInicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compra_mensaje)
    }
}
package com.example.proyecto_dam.adminActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.adaptador.ComidaAdminAdapter
import com.example.proyecto_dam.controlador.ArregloComida

class MainAdminActivity : AppCompatActivity() {
    private lateinit var rvMenus:RecyclerView
    private lateinit var btnNuevo:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comida_admin_main)
        rvMenus=findViewById(R.id.rvCompras)
        btnNuevo=findViewById(R.id.btnNuevo)
        btnNuevo.setOnClickListener{ nuevo()}
        //invocar al metodo listado
        var datos= ArregloComida().listado()
        //crear objeto de la clase ComidaAdapter
        var adaptador= ComidaAdminAdapter(datos)
        //estilo tipo fila para visualizar datos en rvMenu
        rvMenus.layoutManager=LinearLayoutManager(this)
        rvMenus.adapter=adaptador
    }

    fun nuevo(){
        val intent= Intent(this, NuevoActivity::class.java)
        startActivity(intent)
    }
}
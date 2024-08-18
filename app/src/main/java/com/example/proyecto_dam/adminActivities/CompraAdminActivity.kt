package com.example.proyecto_dam.adminActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.adaptador.CompraAdminAdapter
import com.example.proyecto_dam.controlador.ArregloCompra

class CompraAdminActivity : AppCompatActivity() {
    private lateinit var rvCompras:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compra_admin_main)
        rvCompras=findViewById(R.id.rvCompras)
        //invocar al metodo listado
        var datos= ArregloCompra().listado()
        //crear objeto de la clase ComidaAdapter
        var adaptador= CompraAdminAdapter(datos)
        //estilo tipo fila para visualizar datos en rvMenu
        rvCompras.layoutManager=LinearLayoutManager(this)
        rvCompras.adapter=adaptador
    }


}
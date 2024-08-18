package com.example.proyecto_dam.adminActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.adaptador.ComidaAdapter
import com.example.proyecto_dam.controlador.ArregloComida

class AdminActivity : AppCompatActivity() {
    private lateinit var btnCrud1:Button
    private lateinit var btnCrud2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_admin)
        btnCrud1=findViewById(R.id.btnCrud1)
        btnCrud2=findViewById(R.id.btnCrud2)
        btnCrud1.setOnClickListener{ CrudComida()}
        btnCrud2.setOnClickListener{ CrudCompras()}
        //invocar al metodo listado
    }

    fun CrudComida(){
        val intent= Intent(this, MainAdminActivity::class.java)
        startActivity(intent)
    }
    fun CrudCompras(){
        val intent= Intent(this, CompraAdminActivity::class.java)
        startActivity(intent)
    }
}
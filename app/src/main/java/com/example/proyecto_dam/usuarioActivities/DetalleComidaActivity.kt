package com.example.proyecto_dam.usuarioActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.entidad.Comida

class DetalleComidaActivity : AppCompatActivity() {
    private lateinit var tvTitulo:TextView
    private lateinit var tvCategoria:TextView
    private lateinit var tvPrecio:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)
        tvTitulo = findViewById(R.id.tvTituloD)
        tvCategoria = findViewById(R.id.tvCategoriaD)
        tvPrecio = findViewById(R.id.tvPrecioD)

        var comida = intent.getSerializableExtra("comida") as? Comida

        if (comida != null){
            actualizarIntefaz(comida)
        }


    }

    private fun actualizarIntefaz(comida: Comida){
        val tit = comida.nombre
        val cat = comida.codigoCategoria.toString()
        val pre = comida.precio.toString()

        // Asigna los valores a las vistas
        tvTitulo.text = tit
        tvCategoria.text = cat
        tvPrecio.text = pre
    }





}
package com.example.proyecto_dam.usuarioActivities

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.adaptador.CarritoAdapter
import com.example.proyecto_dam.controlador.ArregloCompra
import com.example.proyecto_dam.entidad.Comida
import com.example.proyecto_dam.entidad.Compra

class CarritoActivity : AppCompatActivity() {
    private lateinit var rvCarrito:RecyclerView
    private lateinit var tvTot:TextView
    private lateinit var adapter:CarritoAdapter
    private lateinit var btncompra: Button

    var data = ArrayList<Comida>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carrito_comida)
        btncompra = findViewById(R.id.btnPagar)
        rvCarrito = findViewById(R.id.rvCarrito)
        tvTot = findViewById(R.id.tvTotal)

        btncompra.setOnClickListener{comprar()}

        data = intent.getSerializableExtra("carro_compras") as ArrayList<Comida>

        rvCarrito.layoutManager= LinearLayoutManager(this)
        adapter = CarritoAdapter(data, tvTot)
        rvCarrito.adapter = adapter
    }

    fun comprar(){
        var total = adapter.total
        var compra = Compra(null, cantidad = data.size , precio = total)

        val arregloCompra = ArregloCompra()
        val resultado = arregloCompra.Comprar(compra)

        if (resultado != -1) {
            mostrarMensajeCompraExitosa()
        } else {
            mostrarMensajeErrorCompra()
        }
    }

    private fun mostrarMensajeErrorCompra() {
        Toast.makeText(this, "Error al realizar la compra ", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarMensajeCompraExitosa() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val view = inflater.inflate(R.layout.fragment_pop_up, null)

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

        val dialog = builder.create()
        val positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE)

        // Ajusta la gravedad del botón al centro
        positiveButton?.gravity = Gravity.CENTER
        dialog.show()
    }


}
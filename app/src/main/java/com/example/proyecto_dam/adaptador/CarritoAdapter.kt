package com.example.proyecto_dam.adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.proyecto_dam.R
import com.example.proyecto_dam.ViewAdminComida
import com.example.proyecto_dam.entidad.Comida

class CarritoAdapter(var data:ArrayList<Comida>, var tvTotal:TextView): RecyclerView.Adapter<ViewCarrito>() {
    var total: Double = 0.0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCarrito {
       val vista = LayoutInflater.from(parent.context) .inflate(R.layout.menu_item_carro, parent, false)
        total = 0.0

        data.forEach{
            total += it.precio
        }

        tvTotal.text = "$$total"

        return ViewCarrito(vista)
    }

    override fun onBindViewHolder(holder: ViewCarrito, position: Int) {
        val comida = data[position]

        holder.tvNombre.text=comida.nombre
        holder.tvCategoria.text=comida.codigoCategoria.toString()
        holder.tvPrecio.text ="$${comida.precio}"
    }

    override fun getItemCount(): Int {
        return data.size
    }



}
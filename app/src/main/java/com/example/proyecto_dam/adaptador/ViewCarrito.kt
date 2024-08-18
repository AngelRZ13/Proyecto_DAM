package com.example.proyecto_dam.adaptador

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R

class ViewCarrito(item: View): RecyclerView.ViewHolder(item) {

    var tvNombre: TextView
    var tvPrecio: TextView
    var tvCategoria: TextView
    init{
        tvNombre=item.findViewById(R.id.tvTopMenuItemName)
        tvCategoria=item.findViewById(R.id.tvTopMenuItemCategory)
        tvPrecio=item.findViewById(R.id.tvTopMenuItemPrice)

    }

}
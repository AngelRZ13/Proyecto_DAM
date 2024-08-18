package com.example.proyecto_dam.adaptador

import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R

class ViewComida(item:View):RecyclerView.ViewHolder(item) {
    var tvNombre:TextView
    var tvPrecio:TextView
    var imgFoto:ImageView
    var tvCategoria:TextView
    var cbCarro:CheckBox
    init{
        tvNombre=item.findViewById(R.id.tvTopMenuItemName)
        tvCategoria=item.findViewById(R.id.tvTopMenuItemCategory)
        tvPrecio=item.findViewById(R.id.tvTopMenuItemPrice)
        imgFoto=item.findViewById(R.id.ivTopMenuItemPizza)
        cbCarro = item.findViewById(R.id.cbCarro)

    }



}
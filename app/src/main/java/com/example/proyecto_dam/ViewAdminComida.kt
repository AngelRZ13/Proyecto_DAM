package com.example.proyecto_dam

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewAdminComida(item:View):RecyclerView.ViewHolder(item) {
    //declarar 4 atributos (textview)
    var tvCodigo:TextView
    var tvNombre:TextView
    var tvCategoria:TextView
    var tvPrecio:TextView
    var imgFoto:ImageView

    //referenciar atributos con los controles de la pantalla
    init {
    tvCodigo=item.findViewById(R.id.tvCodigoC)
    tvNombre=item.findViewById(R.id.tvCantidadC)
    tvCategoria=item.findViewById(R.id.tvCategoria)
    tvPrecio=item.findViewById(R.id.tvTotalC)
    imgFoto=item.findViewById(R.id.imgFoto)
    }
}
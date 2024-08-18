package com.example.proyecto_dam.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R

class ViewAdminCompra(item:View):RecyclerView.ViewHolder(item) {
    //declarar 4 atributos (textview)
    var tvCodigo:TextView
    var tvCantidad:TextView
    var tvTotal:TextView

    //referenciar atributos con los controles de la pantalla
    init {
    tvCodigo=item.findViewById(R.id.tvCodigoC)
        tvCantidad=item.findViewById(R.id.tvCantidadC)
        tvTotal=item.findViewById(R.id.tvTotalC)
    }
}
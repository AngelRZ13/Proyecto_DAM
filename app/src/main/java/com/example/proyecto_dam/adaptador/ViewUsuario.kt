package com.example.proyecto_dam.adaptador

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R

class ViewUsuario(item: View): RecyclerView.ViewHolder(item) {

    var tvNombre:TextView
    var tvApellido:TextView
    var tvGenero:TextView
    var tvUsuario:TextView
    var tvContrasena:TextView

    init {
        tvNombre = item.findViewById(R.id.tvNombre)
        tvApellido = item.findViewById(R.id.tvApellido)
        tvGenero = item.findViewById(R.id.tvGenero)
        tvUsuario = item.findViewById(R.id.tvUsuario)
        tvContrasena = item.findViewById(R.id.tvContrasena)
    }
}
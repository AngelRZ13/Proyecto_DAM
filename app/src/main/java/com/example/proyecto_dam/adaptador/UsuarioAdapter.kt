package com.example.proyecto_dam.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.entidad.Usuario
import com.example.proyecto_dam.usuarioActivities.DatosActivity
import com.example.proyecto_dam.usuarioActivities.DetalleComidaActivity
import com.example.proyecto_dam.utils.appConfig

class UsuarioAdapter(var data:ArrayList<Usuario>): RecyclerView.Adapter<ViewUsuario>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewUsuario {
        var vista= LayoutInflater.from(parent.context).inflate(R.layout.login_usuario,parent,false)
        return ViewUsuario(vista)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewUsuario, position: Int) {
        var usuario = data[position]

        holder.tvNombre.text=data.get(position).nombre
        holder.tvApellido.text=data.get(position).apellido
        holder.tvGenero.text =data.get(position).genero
        holder.tvUsuario.text = data.get(position).usuario
        holder.tvContrasena.text = data.get(position).contrasena

        holder.itemView.setOnClickListener(){
            abrirDatos(usuario)
        }

    }

    private fun abrirDatos(usuario: Usuario){

        var intent = Intent(appConfig.CONTEXT, DatosActivity::class.java)
        intent.putExtra("usuario", usuario)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK  // Agrega la bandera necesaria
        ContextCompat.startActivity(appConfig.CONTEXT, intent, null)
    }
}
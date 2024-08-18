package com.example.proyecto_dam.adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.ViewAdminComida
import com.example.proyecto_dam.adminActivities.EditarActivity
import com.example.proyecto_dam.entidad.Comida
import com.example.proyecto_dam.utils.appConfig

class ComidaAdminAdapter(var data:ArrayList<Comida>):RecyclerView.Adapter<ViewAdminComida>() {
    //1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdminComida {
        //inflar la vista "item.comida.xml"
        var vista= LayoutInflater.from(parent.context).inflate(R.layout.item_admin_comida,parent,false)
        return ViewAdminComida(vista)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    //2
    override fun onBindViewHolder(holder: ViewAdminComida, position: Int) {
        holder.tvCodigo.text = data.get(position).codigo.toString()
        holder.tvNombre.text = data.get(position).nombre
        holder.tvCategoria.text = data.get(position).codigoCategoria.toString()
        holder.tvPrecio.text = data.get(position).precio.toString()
        //contexto de viewDocente
        var contexto: Context = holder.itemView.context
        //identificador para la iamgen
        var IMG = -1
        IMG = contexto.resources.getIdentifier(
            data.get(position).foto,
            "drawable",
            contexto.packageName
        )
        holder.imgFoto.setImageResource(IMG)
        //asignar el evento click al objeto holder
        holder.itemView.setOnClickListener{
           var intent = Intent(appConfig.CONTEXT, EditarActivity::class.java)
            intent.putExtra("comida",data.get(position))
            ContextCompat.startActivity(appConfig.CONTEXT,intent,null)
        }
    }
}
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
import com.example.proyecto_dam.entidad.Compra
import com.example.proyecto_dam.utils.appConfig

class CompraAdminAdapter(var data:ArrayList<Compra>):RecyclerView.Adapter<ViewAdminCompra>() {
    //1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdminCompra {
        //inflar la vista "item.comida.xml"
        var vista= LayoutInflater.from(parent.context).inflate(R.layout.item_admin_compra,parent,false)
        return ViewAdminCompra(vista)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    //2
    override fun onBindViewHolder(holder: ViewAdminCompra, position: Int) {
        holder.tvCodigo.text = data.get(position).codigo.toString()
        holder.tvCantidad.text = data.get(position).cantidad.toString()
        holder.tvTotal.text = data.get(position).precio.toString()
        //contexto de viewDocente
        var contexto: Context = holder.itemView.context
        //identificador para la iamgen

        //asignar el evento click al objeto holder
        holder.itemView.setOnClickListener{
           var intent = Intent(appConfig.CONTEXT, null)
            intent.putExtra("compra",data.get(position))
            ContextCompat.startActivity(appConfig.CONTEXT,intent,null)
        }
    }
}
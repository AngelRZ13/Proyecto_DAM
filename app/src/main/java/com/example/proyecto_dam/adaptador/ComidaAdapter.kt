package com.example.proyecto_dam.adaptador


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.entidad.Comida
import com.example.proyecto_dam.usuarioActivities.CarritoActivity
import com.example.proyecto_dam.usuarioActivities.DetalleComidaActivity
import com.example.proyecto_dam.utils.appConfig
import org.w3c.dom.Text

class ComidaAdapter(var data:ArrayList<Comida>, var carroCompras:ArrayList<Comida>,var tvCantProductos:TextView, var btnVerCarro:ImageView):RecyclerView.Adapter<ViewComida>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewComida {


        var vista=LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent,false)
        return ViewComida(vista)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewComida, position: Int) {
        var comida = data[position]

        holder.tvNombre.text=data.get(position).nombre
        holder.tvCategoria.text=data.get(position).codigoCategoria.toString()
        holder.tvPrecio.text =data.get(position).precio.toString()

        var contexto : Context=holder.itemView.context

        var IMG=1
        IMG=contexto.resources.getIdentifier(data.get(position).foto,"drawable",contexto.packageName)
        holder.imgFoto.setImageResource(IMG)

        holder.cbCarro.setOnCheckedChangeListener{ compoundButton, b ->
            if(holder.cbCarro.isChecked){
                tvCantProductos.text = "${Integer.parseInt(tvCantProductos.text.toString().trim()) + 1}"
                carroCompras.add(data[position])
            }else{
                tvCantProductos.text = "${Integer.parseInt(tvCantProductos.text.toString().trim()) - 1}"
                carroCompras.remove(data[position])
            }

            }

            btnVerCarro.setOnClickListener{
            val intent = Intent(contexto,CarritoActivity::class.java )
            intent.putExtra("carro_compras", carroCompras)
                contexto.startActivity(intent)


        }
        holder.itemView.setOnClickListener{
            abrirDetalles(comida)
        }

    }

    private fun abrirDetalles(comida : Comida)
    {

        var intent = Intent(appConfig.CONTEXT, DetalleComidaActivity::class.java)
        intent.putExtra("comida", comida)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK  // Agrega la bandera necesaria
        ContextCompat.startActivity(appConfig.CONTEXT, intent, null)


    }
}
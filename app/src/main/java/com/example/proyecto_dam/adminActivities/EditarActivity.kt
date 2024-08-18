package com.example.proyecto_dam.adminActivities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_dam.R
import com.example.proyecto_dam.controlador.ArregloCategoria
import com.example.proyecto_dam.controlador.ArregloComida
import com.example.proyecto_dam.entidad.Comida
import com.google.android.material.textfield.TextInputEditText

class EditarActivity: AppCompatActivity(),AdapterView.OnItemClickListener {
    private lateinit var txtCodigoA:TextInputEditText
    private lateinit var txtNombreA: TextInputEditText
    private lateinit var txtPrecioA: TextInputEditText
    private lateinit var atvCategoriaA: AutoCompleteTextView

    private lateinit var btnActualizarA: Button
    private lateinit var btnEliminarA:Button
    private lateinit var btnSalirA: Button
    //
    private lateinit var posCat:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_admin_comida)
        txtCodigoA=findViewById(R.id.txtCodigoA)
        txtNombreA=findViewById(R.id.txtNombreA)
        txtPrecioA=findViewById(R.id.txtPrecioA)
        atvCategoriaA=findViewById(R.id.atvCategoriaA)
        btnActualizarA=findViewById(R.id.btnActualizarA)
        btnEliminarA=findViewById(R.id.btnEliminarA)
        btnSalirA=findViewById(R.id.btnSalirA)
        //
        btnActualizarA.setOnClickListener { actualizar() }
        btnEliminarA.setOnClickListener { eliminar() }
        btnSalirA.setOnClickListener { salir() }
        //asignar evento al combo de Categoria
        atvCategoriaA.setOnItemClickListener(this)
        //
        cargarCategoria()
        //
        obtenerDatos()
    }

    fun actualizar(){
        //variables
        var nom="";var pre:Double; var cod:Int
        //leer cajas
        cod=txtCodigoA.text.toString().toInt()
        nom=txtNombreA.text.toString()
        pre=txtPrecioA.text.toString().toDouble()

        // crear objeto de la clase Docente
        var com = Comida(cod,nom,pre,"",posCat)
        //invocar al metodo
        var estado= ArregloComida().actualizar(com)
        //validar estado
        if(estado>0)
            Toast.makeText(this,"Comida Actualizada", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Error en la Actualizacion", Toast.LENGTH_LONG).show()
    }

    fun eliminar(){
        val dialogo1: AlertDialog.Builder = AlertDialog.Builder(this)
        dialogo1.setTitle("Sistema")
        dialogo1.setMessage("¿ Seguro de Eliminar?")
        dialogo1.setCancelable(false)
        dialogo1.setPositiveButton("Aceptar",
            DialogInterface.OnClickListener { dialogInterface: DialogInterface, i: Int ->
                var cod:Int
                cod=txtCodigoA.text.toString().toInt()
                var estado=ArregloComida().eliminar(cod)
                //validar estado
                if(estado>0)
                    Toast.makeText(this,"Comida Eliminada",Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this,"Error en la Eliminacion",Toast.LENGTH_LONG).show()
            })
        dialogo1.setNegativeButton("Cancelar",
            DialogInterface.OnClickListener { dialogo1, id -> })
        dialogo1.setIcon(android.R.drawable.ic_dialog_alert)
        dialogo1.show()
    }
    fun salir(){
        var intent= Intent(this, MainAdminActivity::class.java)
        startActivity(intent)
    }

    fun cargarCategoria(){
        //invocar al metodo
        var data= ArregloCategoria().listadoCategoria()
        //crear un adaptador con los valores de data
        var adaptador= ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
        //enviar el objeto "adaptador" al atributo atvCategoria
        atvCategoriaA.setAdapter(adaptador)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        posCat=p0?.adapter?.getItem(p2).toString()
    }

    fun obtenerDatos(){
        var bundle = intent.getSerializableExtra("comida") as Comida
        // Mostrar en los controles el valor de bundle
        txtCodigoA.setText(bundle.codigo.toString())
        txtNombreA.setText(bundle.nombre)
        txtPrecioA.setText(bundle.precio.toString())
        atvCategoriaA.setText(bundle.codigoCategoria, false)
    }
}
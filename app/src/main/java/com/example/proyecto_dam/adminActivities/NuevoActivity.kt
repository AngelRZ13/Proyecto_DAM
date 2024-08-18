package com.example.proyecto_dam.adminActivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_dam.R
import com.example.proyecto_dam.controlador.ArregloCategoria
import com.example.proyecto_dam.controlador.ArregloComida
import com.example.proyecto_dam.entidad.Comida
import com.google.android.material.textfield.TextInputEditText

class NuevoActivity:AppCompatActivity(),AdapterView.OnItemClickListener {
      private lateinit var txtNombre:TextInputEditText
      private lateinit var txtPrecio:TextInputEditText
      private lateinit var atvCategoria:AutoCompleteTextView

      private lateinit var btnGrabar:Button
      private lateinit var btnSalir:Button
      //
      private lateinit var posCat:String

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.nueva_admin_comida)
            txtNombre=findViewById(R.id.txtNombre)
            txtPrecio=findViewById(R.id.txtPrecio)
            atvCategoria=findViewById(R.id.atvCategoria)
            btnGrabar=findViewById(R.id.btnGrabar)
            btnSalir=findViewById(R.id.btnSalir)
            //
            btnGrabar.setOnClickListener { grabar() }
            btnSalir.setOnClickListener { salir() }

            //asignar evento al combo de distrito
            atvCategoria.setOnItemClickListener(this)

            //cargar categoria
            cargarCategoria()
      }

      fun grabar(){
          //variables
            var nom="";var pre:Double
            //leer cajas
            nom=txtNombre.text.toString()
            pre=txtPrecio.text.toString().toDouble()

            // crear objeto de la clase Docente
            var com= Comida(0,nom,pre,"",posCat)
            //invocar al metodo
            var estado= ArregloComida().adicionar(com)
            //validar estado
            if(estado>0)
                  Toast.makeText(this,"Comida Registrada", Toast.LENGTH_LONG).show()
            else
                  Toast.makeText(this,"Error en el Registro", Toast.LENGTH_LONG).show()
      }
      fun salir(){
            var intent= Intent(this, MainAdminActivity::class.java)
            startActivity(intent)
      }

      fun cargarCategoria(){
          //invocar al metodo
            var data= ArregloCategoria().listadoCategoria()
            //crear un adaptador con los valores de data
            var adaptador=ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
            //enviar el objeto "adaptador" al atributo atvCategoria
            atvCategoria.setAdapter(adaptador)
      }

      override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            posCat=p0?.adapter?.getItem(p2).toString()
      }
}
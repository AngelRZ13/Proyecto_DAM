package com.example.proyecto_dam.usuarioActivities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import android.widget.Toast
import com.example.proyecto_dam.LoginActivity

import com.example.proyecto_dam.R

import com.example.proyecto_dam.entidad.Usuario
import com.google.android.material.bottomnavigation.BottomNavigationView

class DatosActivity : AppCompatActivity() {
    private lateinit var tvNombre: TextView
    private lateinit var tvApellido: TextView
    private lateinit var tvGenero: TextView
    private lateinit var tvUsuario: TextView
    private lateinit var tvContrasena: TextView
    private lateinit var btnCerrarSesion:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datos_usuario)
        tvNombre = findViewById(R.id.tvNombre)
        tvApellido = findViewById(R.id.tvApellido)
        tvGenero = findViewById(R.id.tvGenero)
        tvUsuario = findViewById(R.id.tvUsuario)
        tvContrasena = findViewById(R.id.tvContrasena)
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener{cerrarSesion()}

        loadAndDisplayUserData()
        val bottomNavigationView:BottomNavigationView = findViewById(R.id.btvPizzaMenu)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_menu_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }

        }
    }

    private fun loadAndDisplayUserData(){
        val intent: Intent = intent
        val usuario: Usuario? = intent.getSerializableExtra("usuario") as? Usuario

        if (usuario != null) {
            // Aquí puedes acceder a las propiedades del usuario y mostrarlas en las vistas
            tvNombre.text = "Nombre: ${usuario.nombre}"
            tvApellido.text = "Apellido: " + usuario.apellido
            tvGenero.text = "Género: " + usuario.genero
            tvUsuario.text = "Usuario: " + usuario.usuario
            tvContrasena.text = "Contraseña: " + usuario.contrasena

    }
        else {
            // Si no se pasa correctamente el usuario, mostrar un mensaje o tomar alguna acción
            Toast.makeText(this, "Usuario no autenticado", Toast.LENGTH_SHORT).show()
        }

    }
    private fun cerrarSesion(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
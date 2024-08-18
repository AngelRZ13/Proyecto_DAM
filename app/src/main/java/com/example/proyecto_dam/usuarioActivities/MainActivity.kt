package com.example.proyecto_dam.usuarioActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_dam.R
import com.example.proyecto_dam.adaptador.ComidaAdapter
import com.example.proyecto_dam.adminActivities.CompraAdminActivity
import com.example.proyecto_dam.controlador.ArregloComida
import com.example.proyecto_dam.entidad.Comida
import com.example.proyecto_dam.entidad.Usuario
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBurger:RecyclerView
    private lateinit var adapter: ComidaAdapter
    private lateinit var tvCant: TextView
    private lateinit var btnVerCarro:ImageView

    private val carroCompra:ArrayList<Comida> = ArrayList()

    private var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usuario = obtenerUsuarioDesdeIntent()

        rvBurger = findViewById(R.id.rvPizzaMenuTopMenu)
        tvCant = findViewById(R.id.tvCantProductos)

        btnVerCarro = findViewById(R.id.btnVerCarro)
        val bottomNavigationView:BottomNavigationView = findViewById(R.id.btvPizzaMenu)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_menu_home -> {
                    // Acción para la opción "Home"
                    // Puedes abrir una nueva actividad u realizar alguna acción aquí
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bottom_menu_book ->{
                    val usuarioActual = usuario
                    if (usuarioActual != null) {
                            // Si el usuario no es administrador, inicia DatosActivity
                            val userDataIntent = Intent(this, DatosActivity::class.java)
                            userDataIntent.putExtra("usuario", usuarioActual)
                            startActivity(userDataIntent)

                    } else {
                        Toast.makeText(this, "Usuario no autenticado", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                R.id.bottom_menu_profile -> {
                    val intent = Intent(this, CompraAdminActivity::class.java)
                    startActivity(intent)
                    true
                }

                else ->false
            }
        }


        var datos=ArregloComida().listado()
        adapter = ComidaAdapter(datos, carroCompra, tvCant, btnVerCarro)

        rvBurger.layoutManager=LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        rvBurger.adapter=adapter
    }


    private fun obtenerUsuarioDesdeIntent(): Usuario? {
        val intent: Intent = intent
        return intent.getSerializableExtra("usuario") as? Usuario
    }


}
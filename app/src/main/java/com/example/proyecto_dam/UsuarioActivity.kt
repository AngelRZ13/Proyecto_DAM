package com.example.proyecto_dam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import com.example.proyecto_dam.controlador.ArregloUsuario
import com.example.proyecto_dam.entidad.Usuario
import com.google.android.material.textfield.TextInputEditText

private lateinit var txtNombreR:TextInputEditText
private lateinit var txtApelldoR:TextInputEditText
private lateinit var rbtMasculino:RadioButton
private lateinit var rbtFemenino:RadioButton
private lateinit var txtUsuarioR:TextInputEditText
private lateinit var txtContrasenaR:TextInputEditText
private lateinit var btnRegistrarR:Button
private lateinit var btnVolverR:Button


class UsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrar_usuario)

        txtNombreR = findViewById(R.id.txtNombre)
        txtApelldoR = findViewById(R.id.txtApellido)
        rbtMasculino = findViewById(R.id.rbtMasculino)
        rbtFemenino = findViewById(R.id.rbtFemenino)
        txtUsuarioR = findViewById(R.id.txtUsuarioR)
        txtContrasenaR = findViewById(R.id.txtContrasenaR)
        btnRegistrarR = findViewById(R.id.btnRegistrarR)
        btnVolverR = findViewById(R.id.btnVolverR)

        //
        btnRegistrarR.setOnClickListener{Registrar()}
        btnVolverR.setOnClickListener{Volver()}
    }


    fun Registrar() {
        val nom = txtNombreR.text.toString().trim()
        val ape = txtApelldoR.text.toString().trim()
        val usu = txtUsuarioR.text.toString().trim()
        val con = txtContrasenaR.text.toString().trim()

        if (nom.isEmpty() || ape.isEmpty() || usu.isEmpty() || con.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_LONG).show()
            return
        }

        var gen = ""
        if (rbtMasculino.isChecked) {
            gen = "Masculino"
        } else if (rbtFemenino.isChecked) {
            gen = "Femenino"
        } else {
            Toast.makeText(this, "Por favor, selecciona un género", Toast.LENGTH_LONG).show()
            return
        }

        // Puedes agregar más validaciones según tus requisitos, por ejemplo, verificar la fortaleza de la contraseña.

        val usua = Usuario(null, nom, ape, gen, usu, con)

        val arregloUsuario = ArregloUsuario()

        // Verificar si el usuario ya existe
        if (arregloUsuario.existeUsuario(usu)) {
            Toast.makeText(this, "El nombre de usuario ya está en uso, por favor elige otro", Toast.LENGTH_LONG).show()
            return
        }

        val estado = arregloUsuario.Registrar(usua)

        if (estado > 0) {
            Toast.makeText(this, "Usuario registrado", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Error en el registro", Toast.LENGTH_LONG).show()
        }
    }

    fun Volver(){
        var intent= Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }


}
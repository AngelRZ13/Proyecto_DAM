package com.example.proyecto_dam

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_dam.adminActivities.AdminActivity
import com.example.proyecto_dam.base.BurgerBD
import com.example.proyecto_dam.entidad.Usuario
import com.example.proyecto_dam.usuarioActivities.DatosActivity
import com.example.proyecto_dam.usuarioActivities.MainActivity
import com.example.proyecto_dam.utils.appConfig
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    private lateinit var txtUsuarioL: TextInputEditText
    private lateinit var txtContrasenaL: TextInputEditText
    private lateinit var btnIngresar: Button
    private lateinit var btnRegistrar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_usuario)

        txtUsuarioL = findViewById(R.id.txtUsuario)
        txtContrasenaL = findViewById(R.id.txtContrasena)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        //
        btnIngresar.setOnClickListener{Ingresar()}
        btnRegistrar.setOnClickListener{Registrar()}
    }

    @SuppressLint("Range")
    fun Ingresar() {
        val usuario = txtUsuarioL.text.toString()
        val contrasena = txtContrasenaL.text.toString()

        // Consulta la base de datos para verificar el inicio de sesión
        val db = BurgerBD(appConfig.CONTEXT).readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT * FROM tb_usuario WHERE usu_log=? AND con_log=?",
            arrayOf(usuario, contrasena)
        )

        if (cursor.moveToFirst()) {
            val esAdminIndex = cursor.getColumnIndex("es_admin")
            val esAdmin = cursor.getInt(esAdminIndex)

            if (esAdmin == 1) {
                // Usuario administrador, ir a la actividad AdminActivity
                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
            } else {
                // Usuario normal, ir a la actividad DatosActivity
                val userDataIntent = Intent(this, MainActivity::class.java)

                // Crear un objeto Usuario y agregarlo al Intent
                if (cursor.moveToFirst()) {
                val usuario = Usuario(
                    codigo = cursor.getString(cursor.getColumnIndex("cod_usu")),
                    nombre = cursor.getString(cursor.getColumnIndex("nom_usu")),
                    apellido = cursor.getString(cursor.getColumnIndex("ape_usu")),
                    genero = cursor.getString(cursor.getColumnIndex("cod_gen")),
                    usuario = cursor.getString(cursor.getColumnIndex("usu_log")),
                    contrasena = cursor.getString(cursor.getColumnIndex("con_log")),
                            esAdmin = cursor.getInt(cursor.getColumnIndex("es_admin"))
                )

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("usuario", usuario)
                    startActivity(intent)
            }
            }
            cursor.close()
            db.close()
        } else {

    }}


    fun Registrar(){
        var intent= Intent(this,UsuarioActivity::class.java)
        startActivity(intent)
    }




}
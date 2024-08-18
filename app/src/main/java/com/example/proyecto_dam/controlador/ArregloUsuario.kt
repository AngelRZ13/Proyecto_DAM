package com.example.proyecto_dam.controlador

import android.content.ContentValues
import com.example.proyecto_dam.base.BurgerBD
import com.example.proyecto_dam.entidad.Usuario
import com.example.proyecto_dam.utils.appConfig

class ArregloUsuario {

    fun Registrar(bean:Usuario):Int{
        var salida=-1
        //abrir acceso a la base de datos en modo escritura
        var cn= appConfig.BD.writableDatabase
        //crear objeto de la clase ContentValues
        var row= ContentValues()
        //claves
        row.put("nom_usu",bean.nombre)
        row.put("ape_usu",bean.apellido)
        row.put("cod_gen",bean.genero)
        row.put("usu_log",bean.usuario)
        row.put("con_log",bean.contrasena)
        //invocar al método insert
        salida=cn.insert("tb_usuario","cod_usu",row).toInt()
        return salida
    }
    fun existeUsuario(nombreUsuario: String): Boolean {
        val db = BurgerBD(appConfig.CONTEXT).readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM tb_usuario WHERE usu_log = ?",
            arrayOf(nombreUsuario)
        )

        val existe = cursor.count > 0

        cursor.close()
        db.close()

        return existe
    }


}
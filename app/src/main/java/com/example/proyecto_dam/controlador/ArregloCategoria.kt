package com.example.proyecto_dam.controlador

import android.database.sqlite.SQLiteDatabase
import com.example.proyecto_dam.utils.appConfig

class ArregloCategoria {
    fun listadoCategoria():ArrayList<String>{
        var data=ArrayList<String>()
        var cn : SQLiteDatabase = appConfig.BD.readableDatabase
        var SQL = "select * from tb_categoria"
        var rs = cn.rawQuery(SQL,null)
        while (rs.moveToNext()){

            var bean =rs.getString(1)
            data.add(bean)
        }
        return data
    }
    fun buscarNombreCategoria(codCat:Int):String{
        var data=""
        var cn: SQLiteDatabase = appConfig.BD.readableDatabase
        var SQL="select nom_Cat from tb_categoria where cod_cat=?"
        var rs=cn.rawQuery(SQL, arrayOf(codCat.toString()))
        while (rs.moveToNext()){
            data =rs.getString(0)
        }
        return data
    }

}
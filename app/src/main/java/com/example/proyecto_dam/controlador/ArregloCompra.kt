package com.example.proyecto_dam.controlador

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.proyecto_dam.entidad.Compra
import com.example.proyecto_dam.utils.appConfig

class ArregloCompra {

    fun Comprar(bean: Compra):Int{
        var salida = -1

        var cn = appConfig.BD.writableDatabase

        var row = ContentValues()

        row.put("cantidad", bean.cantidad)
        row.put("precio", bean.precio)

        salida = cn.insert("tb_compra","cod_compra",row ).toInt()

        return salida
    }
    fun listado():ArrayList<Compra>{
        var data = ArrayList<Compra>()
        var cn: SQLiteDatabase =appConfig.BD.readableDatabase

        var SQL="select * from tb_compra"
        var rs = cn.rawQuery(SQL, null)

        while (rs.moveToNext()){
            var bean = Compra(
                rs.getInt(0),
                rs.getInt(1),
                rs.getDouble(2))
            data.add(bean)
        }
        return data
}}
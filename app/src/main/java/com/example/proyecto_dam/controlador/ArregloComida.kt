package com.example.proyecto_dam.controlador

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.proyecto_dam.entidad.Comida
import com.example.proyecto_dam.utils.appConfig

class ArregloComida {

    fun listado():ArrayList<Comida>{
        var data = ArrayList<Comida>()
        var cn:SQLiteDatabase=appConfig.BD.readableDatabase

        var SQL="SELECT c.cod_com, c.nom_com, c.pre_com, c.foto, c.cod_Cat, cat.nom_Cat " +
                "FROM tb_comida c " +
                "INNER JOIN tb_categoria cat ON c.cod_Cat = cat.cod_cat"
        var rs = cn.rawQuery(SQL, null)

        while (rs.moveToNext()){
            var bean = Comida(
                rs.getInt(0),
                rs.getString(1),
                rs.getDouble(2),
                rs.getString(3),
                rs.getString(4))

            data.add(bean)
        }
        return data

    }fun adicionar(bean:Comida):Int{
        var salida=-1
        //abrir acceso a la base de datos en modo escritura
        var cn=appConfig.BD.writableDatabase
        //crear objeto de la clase contentValues
        var row= ContentValues()
        //claves
        row.put("nom_com",bean.nombre)
        row.put("pre_com",bean.precio)
        row.put("foto",bean.foto)
        row.put("cod_Cat",bean.codigoCategoria)

        //invocar metodo insert
        salida=cn.insert("tb_comida","cod_com",row).toInt()
        return salida
    }

    fun actualizar(bean:Comida):Int{
        var salida=-1
        //abrir acceso a la base de datos en modo escritura
        var cn=appConfig.BD.writableDatabase
        //crear objeto de la clase contentValues
        var row= ContentValues()
        //claves
        row.put("cod_com",bean.codigo)
        row.put("nom_com",bean.nombre)
        row.put("pre_com",bean.precio)
        row.put("foto",bean.foto)
        row.put("cod_Cat",bean.codigoCategoria)

        //invocar metodo update
        salida=cn.update("tb_comida",row,"cod_com=?", arrayOf(bean.codigo.toString()))
        return salida
    }

    fun eliminar(cod:Int):Int{
        var salida=-1
        //abrir acceso a la base de datos en modo escritura
        var cn=appConfig.BD.writableDatabase
        //invocar metodo update
        salida=cn.delete("tb_comida","cod_com=?", arrayOf(cod.toString()))
        return salida
    }



}
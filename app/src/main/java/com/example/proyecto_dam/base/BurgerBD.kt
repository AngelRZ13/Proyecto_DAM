package com.example.proyecto_dam.base

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.proyecto_dam.entidad.Usuario
import com.example.proyecto_dam.utils.appConfig

class BurgerBD(context: Context) :SQLiteOpenHelper(appConfig.CONTEXT, appConfig.BDNAME,null , appConfig.VERSION)

{
    override fun onCreate(bd: SQLiteDatabase) {

        bd.execSQL("create table tb_categoria" +
                "(" +
                "cod_cat integer primary key autoincrement," +
                "nom_Cat varchar(30))")

        bd.execSQL("create table tb_comida" +
                "(" +
                "cod_com integer primary key autoincrement," +
                "nom_com varchar(30)," +
                "pre_com double," +
                "foto varchar(3)," +
                "cod_Cat int references tb_categoria)")

        bd.execSQL("create table tb_usuario" +
                "(" +
                "cod_usu integer primary key autoincrement," +
                "nom_usu varchar(30)," +
                "ape_usu varchar(30)," +
                "cod_gen int references tb_genero," +
                "usu_log varchar(30)," +
                "con_log varchar(30)," +
                "es_admin integer DEFAULT 0)")

        bd.execSQL("create table tb_genero" +
                "(" +
                "cod_gen integer primary key autoincrement," +
                "nom_gen varchar(30))")

        bd.execSQL("create table tb_compra" +
                "(" +
                "cod_compra  integer primary key autoincrement," +
                "cantidad int," +
                "precio double)")

        //



        bd.execSQL("insert into tb_categoria values(null,'Hamburguesa')")
        bd.execSQL("insert into tb_categoria values(null,'Pollo')")
        bd.execSQL("insert into tb_categoria values(null,'Bebidas')")

        bd.execSQL("insert into tb_comida values(null,'Hamburguesa de carne','20','burger_2','1')")
        bd.execSQL("insert into tb_comida values(null,'Hamburguesa de Pollo','20','burger_2','2')")

        bd.execSQL("insert into tb_genero values(null,'Masculino')")
        bd.execSQL("insert into tb_genero values(null,'Femenino')")

        bd.execSQL("insert into tb_usuario values(null,'raul','jonas','1','ramirez','123',1)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addToCart(cod_com: Int, cantidad: Int) {
        val db = writableDatabase
        val contentValues = ContentValues()

        // Verificar si el artículo ya está en el carrito
        val cursor = db.rawQuery("SELECT * FROM tb_carrito WHERE cod_com = ?", arrayOf(cod_com.toString()))
        val cantidadColumnIndex = cursor.getColumnIndex("cantidad")

        if (cursor.moveToFirst()) {
            if (cantidadColumnIndex != -1 && cursor.moveToFirst()) {
            // El artículo ya está en el carrito, actualizar la cantidad
            val nuevaCantidad = cursor.getInt(cantidadColumnIndex) + cantidad
            contentValues.put("cantidad", nuevaCantidad)
            db.update("tb_carrito", contentValues, "cod_com = ?", arrayOf(cod_com.toString()))
        } else {
            // El artículo no está en el carrito, agregarlo
            contentValues.put("cod_com", cod_com)
            contentValues.put("cantidad", cantidad)
            db.insert("tb_carrito", null, contentValues)
        }
        }
        cursor.close()
        db.close()
    }






}
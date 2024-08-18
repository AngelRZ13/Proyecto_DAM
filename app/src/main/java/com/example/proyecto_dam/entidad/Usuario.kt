package com.example.proyecto_dam.entidad

import android.database.Cursor
import java.io.Serializable

class Usuario(
    var codigo: String?,
    var nombre: String?,
    var apellido: String?,
    var genero: String?,
    var usuario: String?,
    var contrasena: String?,
    var esAdmin: Int = 0
) : Serializable {
    constructor(cursor: Cursor) : this(
        getStringFromCursor(cursor, "cod_usu"),
        getStringFromCursor(cursor, "nom_usu"),
        getStringFromCursor(cursor, "ape_usu"),
        getStringFromCursor(cursor, "cod_gen"),
        getStringFromCursor(cursor, "usu_log"),
        getStringFromCursor(cursor, "con_log"),
        getStringFromCursor(cursor, "es_admin")?.toIntOrNull() ?: 0
    )

    companion object {
        private fun getStringFromCursor(cursor: Cursor, columnName: String): String? {
            val columnIndex = cursor.getColumnIndex(columnName)
            return cursor.getString(columnIndex)
        }

    }
}



package com.example.clientes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ClientesSQLite(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "Clientes.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Crear la tabla clientes
        val createTableQuery = """
            CREATE TABLE clientes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                dni TEXT NOT NULL
            )
        """.trimIndent()
        // Ejecutamos la consulta si db no es null
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Elimina la tabla Clientes y la vuelve a crear si existe
        // Este metodo se llama cuando se actualiza la version de la base de datos
        db?.execSQL("DROP TABLE IF EXISTS clientes")
        // Llamamos al metodo onCreate para crearla de nuevo
        onCreate(db);
    }

    // Implementamos los metodos CRUD
    // Insercion
    fun insertarCliente(cliente: Cliente): Long {
        // Abrimos conexion de escritura con la BD
        val db = writableDatabase

        // Establecemos los valores que vamos a insertar
        val values = ContentValues().apply {
            put("nombre", cliente.nombre)
            put("dni", cliente.dni)
        }

        // Ejecutamos la consulta a la BD y retornamos la insercion
        val newRowId = db.insert("clientes", null, values)
        db.close() // Cerramos conexion a la base de datos
        return newRowId
    }

    // Actualizacion
    fun actualizarCliente(idCliente: Long, cliente: Cliente): Int {
        // Abrimos conexion de escritura con la BD
        val db = writableDatabase

        // Establecemos los valores que vamos a actualizar
        val values = ContentValues().apply {
            put("nombre", cliente.nombre)
            put("dni", cliente.dni)
        }

        // Ejecutamos la consulta a la BD y retornamos la actualizacion
        val affectedRows = db.update("clientes", values, "id=?", arrayOf(idCliente.toString()))
        db.close() // Cerramos conexion a la base de datos
        return affectedRows
    }

    // Borrado
    fun borrarCliente(idCliente: Int): Int {
        // Abrimos conexion de escritura con la BD
        val db = writableDatabase

        // Ejecutamos la consulta a la BD y retornamos la actualizacion
        val affectedRows = db.delete("clientes", "id=?", arrayOf(idCliente.toString()))
        db.close() // Cerramos conexion a la base de datos
        return affectedRows
    }

    // Seleccion
    fun getNumClientes(): Int {
        // Abrimos conexion de lectura con la BD
        val db = readableDatabase

        // Establecemos la consulta a la BD para obtener el total de clientes que hay
        val selectQuery = "SELECT count(*) AS numClientes FROM clientes"
        // Utilizamos un cursor para realizar la consulta a la BD
        val cursor = db.rawQuery(selectQuery, null)
        var numClientes = 0
        // Iteramos el cursor y establecemos el total de clientes obtenidos para retornar dicho valor
        cursor.use {
            if (it.moveToFirst())
                numClientes = it.getInt(it.getColumnIndexOrThrow("numClientes"))
        }
        // cursor.close() // Al usar cursor.use el cursor ya se cierra automaticamente
        db.close() // Cerramos conexion a la base de datos
        return numClientes
    }

    fun getListadoClientes(): List<Cliente> {
        // Abrimos conexion de lectura con la BD
        val db = readableDatabase

        // Establecemos la consulta a la BD para obtener todos los registros de clientes ordenados por su DNI
        val selectQuery = "SELECT * FROM clientes ORDER BY dni DESC"
        // Utilizamos un cursor para realizar la consulta a la BD
        val cursor: Cursor = db.rawQuery(selectQuery, null)
        // Iteramos el cursor y establecemos cada registro obtenido en la listaClientes
        val listaClientes = mutableListOf<Cliente>()
        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val dni = cursor.getString(cursor.getColumnIndexOrThrow("dni"))
                val cliente = Cliente(nombre, dni)
                listaClientes.add(cliente)
            } while (cursor.moveToNext())
        }
        cursor.close() // Cerramos el cursor
        db.close() // Cerramos conexion a la base de datos
        return listaClientes
    }
}
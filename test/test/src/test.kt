fun getListadoClientes(): List<Cliente>{
    val listaClientes = mutableListOf<Cliente>()
    val db = readableDatabase
    val selectQuery = "SELECT * FROM clientes ORDER BY dni DESC"
    val cursor: Cursor = db.rawQuery(selectQuery, null)
// Nos movemos por los resultados de la consulta SQL
    if(cursor.moveToFirst()){
        do{
            val nombre =
                cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
            val dni =
                cursor.getString(cursor.getColumnIndexOrThrow("dni"))
            val cliente = Cliente(nombre, dni)
            listaClientes.add(cliente)
        }while(cursor.moveToNext())
    }
    cursor.close() // Cerramos el cursor
    db.close() // Cerramos la base de datos
    return listaClientes
}
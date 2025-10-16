package com.example.clientes

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var clienteAdapter: ClienteAdapter
    private lateinit var listaClientesBBDD: MutableList<Cliente>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Obtenemos los botones y el recyclerView por su id y los almacenamos en variables
        val btnInsertar = findViewById<Button>(R.id.btnInsertar)
        val btnEliminar = findViewById<Button>(R.id.btnBorrar)
        val recyclerView = findViewById<RecyclerView>(R.id.rcListaClientes)

        // Instanciamos BD
        val dbCliente = ClientesSQLite(this)
        // dbCliente.reiniciarBaseDeDatos()

        // Obtener la lista de clientes de la BD
        listaClientesBBDD = dbCliente.getListadoClientes().toMutableList()

        // Inicializar el Adapter con la lista actual
        clienteAdapter = ClienteAdapter(listaClientesBBDD)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = clienteAdapter

        // Establecemos el listener para el evento del boton Insertar
        btnInsertar.setOnClickListener {
            val numClientes = dbCliente.getNumClientes()
            val listaClientes = obtenerListaClientes()

            // En caso de estar completa la lista de clientes, mostramos mensaje de error en un pop-up
            if (numClientes == listaClientes.size) {
                Toast.makeText(this, "No es posible insertar más clientes", Toast.LENGTH_LONG).show()
            } else {
                // La lista no esta llena, insertamos el cliente
                val cliente = listaClientes[numClientes]
                dbCliente.insertarCliente(cliente)
                // Actualizar la lista y notificar al Adapter
                listaClientesBBDD.add(cliente)
                clienteAdapter.notifyItemInserted(listaClientesBBDD.size - 1)
            }
        }

        // Establecemos el listener para el evento del boton Insertar
        btnEliminar.setOnClickListener {
            // Si esta vacia, mensaje de error y finalizamos solo la ejecucion del listener
            if (listaClientesBBDD.isEmpty()) {
                Toast.makeText(this, "No hay clientes en la lista, no es posible borrar clientes", Toast.LENGTH_LONG).show()
                return@setOnClickListener // finalizamos el metodo (es un return para especificar a que afecta el return)
            }

            // Obtenemos el total de clientes en la BD
            val numClientes: Int = dbCliente.getNumClientes()
            if (numClientes > 0) {
                // Elimina el ultimo cliente en la BD
                dbCliente.borrarCliente(numClientes)

                // Elimina solo si la lista en memoria no esta vacia
                if (listaClientesBBDD.isNotEmpty()) {
                    listaClientesBBDD.removeAt(listaClientesBBDD.lastIndex)
                    clienteAdapter.notifyItemRemoved(listaClientesBBDD.size)
                }
            } else { // Si no hay clientes que poder borrar en la BD, mensaje de error.
                Toast.makeText(this, "No hay clientes en la base de datos que poder borrar.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun obtenerListaClientes(): List<Cliente> {
        return listOf(
            Cliente("Juan Pérez", "12345678A"),
            Cliente("María López", "87654321B"),
            Cliente("Carlos Sánchez", "56781234C"),
            Cliente("Ana Gómez", "43218765D"),
            Cliente("Pedro Ramírez", "34567812E"),
            Cliente("Lucía Fernández", "23456789F"),
            Cliente("Diego Torres", "98765432G"),
            Cliente("Laura Jiménez", "76543210H"),
            Cliente("Sergio Ruiz", "65432109I"),
            Cliente("Marta Castro", "54321098J"),
            Cliente("Andrés Molina", "87654320K"),
            Cliente("Beatriz Navarro", "76543219L"),
            Cliente("José Herrera", "65432187M"),
            Cliente("Rocío Delgado", "54321987N"),
            Cliente("Gabriel Ortega", "43219876O"),
            Cliente("Elena Vargas", "32198765P"),
            Cliente("Francisco León", "21098765Q"),
            Cliente("Patricia Silva", "10987654R"),
            Cliente("Hugo Medina", "09876543S"),
            Cliente("Isabel Rojas", "98765432T")
        )
    }
}
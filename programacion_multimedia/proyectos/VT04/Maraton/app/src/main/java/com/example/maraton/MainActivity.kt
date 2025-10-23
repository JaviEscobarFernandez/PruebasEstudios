package com.example.maraton

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maraton.bbdd.FirebaseManager
import com.example.maraton.bbdd.FirebaseSeeder
import com.example.maraton.ui.TiempoAdapter
import com.example.maraton.ui.TiempoItem

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseSeeder: FirebaseSeeder
    private lateinit var firebaseManager: FirebaseManager
    private lateinit var recyclerTiempos: RecyclerView
    private lateinit var tiempoAdapter: TiempoAdapter
    private var tiempoList = mutableListOf<TiempoItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseSeeder = FirebaseSeeder()
        firebaseManager = FirebaseManager()

        val btnSeedData = findViewById<Button>(R.id.btnSeedData)
        recyclerTiempos = findViewById(R.id.recyclerTiempos)
        recyclerTiempos.layoutManager = LinearLayoutManager(this)

        // Tiempo adapter y Recycler
        tiempoAdapter = TiempoAdapter(mutableListOf())
        recyclerTiempos.adapter = tiempoAdapter
        btnSeedData.setOnClickListener {
            firebaseSeeder.seedData(
                onSuccess = {
                    Toast.makeText(this, "Datos de prueba agregados", Toast.LENGTH_SHORT).show()
                    Log.d("MainActivity", "Datos guardados, ahora cargamos los tiempos")
                    loadTiempos() // Llamar a loadTiempos() SOLO cuando los datos ya estén en Firebase
                },
                onFailure = { exception ->
                    Toast.makeText(this, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
                    Log.e("MainActivity", "Error en seedData: ${exception.message}")
                }
            )
        }
    }
    private fun loadTiempos() {
        tiempoList.clear() // Limpiar lista antes de cargar nuevos datos
        val puntos = listOf("punto1", "punto2", "meta")
        var puntosCargados = 0

        puntos.forEach { punto ->
            firebaseManager.getTiempos(
                punto,
                onDataReceived = { tiempos ->
                    tiempos.forEach { (idCorredor, tiempo) ->
                        tiempoList.add(TiempoItem(idCorredor, punto, tiempo))
                    }

                    puntosCargados++ // Una petición completada

                    if (puntosCargados == puntos.size) {
                        runOnUiThread {
                            // tiempoAdapter.notifyDataSetChanged() // YA NO ES NECESARIO si usaste el CAMBIO #1
                            // O si modificaste el adaptador con updateData:
                            tiempoAdapter.updateData(tiempoList) // Llamas a la función de actualización
                            Log.d("MainActivity", "Todos los ${tiempoList.size} tiempos cargados y RecyclerView actualizado.")
                        }
                    }
                },
                onFailure = { exception ->
                    runOnUiThread {
                        Toast.makeText(this, "Error al cargar tiempos: ${exception.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}


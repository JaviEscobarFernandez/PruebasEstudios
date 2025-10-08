package com.example.primeraaplicacion

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // view -> Seleccion(view) es lo mismo que it, es la seleccion del boton pulsado.
        findViewById<ImageButton>(R.id.playButton).setOnClickListener { view -> Seleccion(view) }
        findViewById<ImageButton>(R.id.pauseButton).setOnClickListener { Seleccion(it) }
        findViewById<ImageButton>(R.id.atrasButton).setOnClickListener { Seleccion(it) }
        findViewById<ImageButton>(R.id.adelanteButton).setOnClickListener { Seleccion(it) }
        findViewById<ImageButton>(R.id.siguienteButton).setOnClickListener { Seleccion(it) }
    }
    fun Seleccion(view: View) {
        when (view.getId()) {
            R.id.playButton -> {
                Toast.makeText(this, "Has pulsado el botón Play", Toast.LENGTH_SHORT).show()
            }
            R.id.pauseButton -> {
                Toast.makeText(this, "Has pulsado el botón Pause", Toast.LENGTH_SHORT).show()
            }
            R.id.atrasButton -> {
                Toast.makeText(this, "Has pulsado el botón Atras", Toast.LENGTH_SHORT).show()
            }
            R.id.adelanteButton -> {
                Toast.makeText(this, "Has pulsado el botón Adelante", Toast.LENGTH_SHORT).show()
            }
            R.id.siguienteButton -> {
                Toast.makeText(this, "Has pulsado el botón Siguiente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
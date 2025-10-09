package com.example.oraculo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
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

        // Cogemos las referencias de la UI
        val btnEnviar: Button = findViewById<Button>(R.id.btnSiguiente)
        val txtNombre: EditText = findViewById<EditText>(R.id.editTextNombre)
        val calendario: DatePicker = findViewById<DatePicker>(R.id.calendar)

        // Programamos el boton siguiente
        btnEnviar.setOnClickListener {
            val nombre = txtNombre.text
            val dia = calendario.dayOfMonth
            val mes = calendario.month + 1 // Empiezan en 0 los meses
            val year = calendario.year

            // Mostramos la fecha escogida
            Toast.makeText(this, "$nombre Fecha seleccionada: $dia/$mes/$year", Toast.LENGTH_SHORT).show()

            // Realizamos el envio de informacion a la ActivityVerFuturo
            val intentFuturo = Intent(this, ActivityVerFuturo::class.java)
            // Añadimos los datos
            intentFuturo.putExtra("nombre", nombre.toString())
            intentFuturo.putExtra("dia", dia)
            intentFuturo.putExtra("mes", mes)
            // Enviamos
            startActivity(intentFuturo)
        }
    }
}
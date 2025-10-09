package com.example.oraculo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityVerFuturo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_futuro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Mapa para las imagenes del Zodiago
        val recursosSigno = mapOf(
            "aries" to R.drawable.aries,
            "tauro" to R.drawable.tauro,
            "geminis" to R.drawable.geminis,
            "cancer" to R.drawable.cancer,
            "leo" to R.drawable.leo,
            "virgo" to R.drawable.virgo,
            "libra" to R.drawable.libra,
            "escorpio" to R.drawable.escorpio,
            "sagitario" to R.drawable.sagitario,
            "capricornio" to R.drawable.capricornio,
            "acuario" to R.drawable.acuario,
            "piscis" to R.drawable.piscis,
        )

        // Obtenemos los elementos graficos
        val imgSigno = findViewById<ImageView>(R.id.imageSigno)
        val txtPrediccion = findViewById<TextView>(R.id.textVerFuturo)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        // Cuando se presiona el boton "Volver", llamamos a finish()
        btnVolver.setOnClickListener { finish() }

        // Obtenemos los datos del Intent recibido
        val nombre = intent.getStringExtra("nombre") ?: "Nombre"
        val diaNacimiento = intent.getIntExtra("dia", -1)
        val mesNacimiento = intent.getIntExtra("mes", -1)

        // Creamos un objeto de la clase Oraculo y su prediccion
        val oraculo = Oraculo(diaNacimiento, mesNacimiento)
        val prediccion = oraculo.obtenerPrediccion(nombre)

        // Mostramos la prediccion obtenida en la UI y cambiamos la imagen por la adecuada
        txtPrediccion.text = prediccion
        val signoId = recursosSigno[oraculo.signo] ?: 0
        val nuevoDrawable = getDrawable(signoId)
        imgSigno.setImageDrawable(nuevoDrawable)
    }
}
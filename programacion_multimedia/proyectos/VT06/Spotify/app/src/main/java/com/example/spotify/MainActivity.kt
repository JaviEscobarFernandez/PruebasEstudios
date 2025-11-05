package com.example.spotify

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var reproducirPausar: Button? = null
    private var imagen: ImageView? = null
    private var posicion: Int = 0
    private var vectorReproduccion: Array<MediaPlayer?> = arrayOfNulls(3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imagen = findViewById(R.id.imagenPrincipal)
        reproducirPausar = findViewById(R.id.botonPlay)
        vectorReproduccion[0] = MediaPlayer.create(this, R.raw.cancion1)
        vectorReproduccion[1] = MediaPlayer.create(this, R.raw.cancion2)
        vectorReproduccion[2] = MediaPlayer.create(this, R.raw.cancion3)
    }

    fun playPause(view: View?) {
        if (vectorReproduccion[posicion]?.isPlaying == true) {
            vectorReproduccion[posicion]?.pause()
            reproducirPausar?.setBackgroundResource(R.drawable.play)
        } else {
            vectorReproduccion[posicion]?.start()
            reproducirPausar?.setBackgroundResource(R.drawable.pause)
        }
    }

    fun stop(view: View?) {
        vectorReproduccion[posicion]?.stop()
        vectorReproduccion[0] = MediaPlayer.create(this, R.raw.cancion1)
        vectorReproduccion[1] = MediaPlayer.create(this, R.raw.cancion2)
        vectorReproduccion[2] = MediaPlayer.create(this, R.raw.cancion3)
        posicion = 0
        reproducirPausar?.setBackgroundResource(R.drawable.play)
        imagen?.setImageResource(R.drawable.foto1)
    }

    fun siguiente(view: View?) {
        if (posicion < vectorReproduccion.size - 1) {
            if (vectorReproduccion[posicion]?.isPlaying == true) {
                vectorReproduccion[posicion]?.stop()
                vectorReproduccion[0] = MediaPlayer.create(this, R.raw.cancion1)
                vectorReproduccion[1] = MediaPlayer.create(this, R.raw.cancion2)
                vectorReproduccion[2] = MediaPlayer.create(this, R.raw.cancion3)
            }
            posicion++
            vectorReproduccion[posicion]?.start()
            reproducirPausar?.setBackgroundResource(R.drawable.pause)

            when (posicion) {
                0 -> imagen?.setImageResource(R.drawable.foto1)
                1 -> imagen?.setImageResource(R.drawable.foto2)
                2 -> imagen?.setImageResource(R.drawable.foto3)
            }
        }
    }

    fun anterior(view: View?) {
        if (posicion > 0) {
            if (vectorReproduccion[posicion]?.isPlaying == true) {
                vectorReproduccion[posicion]?.stop()
                vectorReproduccion[0] = MediaPlayer.create(this, R.raw.cancion1)
                vectorReproduccion[1] = MediaPlayer.create(this, R.raw.cancion2)
                vectorReproduccion[2] = MediaPlayer.create(this, R.raw.cancion3)
            }
            posicion--
            vectorReproduccion[posicion]?.start()
            reproducirPausar?.setBackgroundResource(R.drawable.pause)

            when (posicion) {
                0 -> imagen?.setImageResource(R.drawable.foto1)
                1 -> imagen?.setImageResource(R.drawable.foto2)
                2 -> imagen?.setImageResource(R.drawable.foto3)
            }
        }
    }
}
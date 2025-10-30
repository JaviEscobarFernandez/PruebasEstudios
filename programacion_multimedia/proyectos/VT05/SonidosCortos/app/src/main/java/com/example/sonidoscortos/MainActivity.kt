package com.example.sonidoscortos

import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var sonidoCorto: SoundPool? = null
    var sonidoLargo: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val reproducirCorto = findViewById<Button>(R.id.buttonSonidoCorto)
        sonidoCorto = SoundPool(1, AudioManager.STREAM_MUSIC, 1)
        sonidoCorto?.load(this, R.raw.sonido_boton, 1)
    }

    fun audioCorto(view: View) {
        sonidoCorto?.play(1, 1f,1f,1,0,1f)
    }

    fun audioLargo(view: View) {
        sonidoLargo = MediaPlayer.create(this, R.raw.sonido_cancion)
        sonidoLargo?.start()
    }

    fun audioLargoStop(view: View) {
        sonidoLargo?.stop()
    }
}
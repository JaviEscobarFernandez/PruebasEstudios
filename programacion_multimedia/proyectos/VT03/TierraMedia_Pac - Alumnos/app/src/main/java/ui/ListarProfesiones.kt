package ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TableRow
import android.widget.TextView
import bbdd.HabitantesSQLite
import com.elsda.tierramedia_pac.R

class ListarProfesiones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_profesiones)
        //TODO crear toda la lógica para que se muestre bien la información en el listado de profesiones
    }

    /**
     * Método para insertar texto en la tabla
     * @param texto cadena de texto a añadir en la fila
     * @param fila fila de la tabla donde añadiremos el texto
     */
    private fun insertarTextoEnTabla(texto: String, fila: TableRow) {
        val textView = TextView(this@ListarProfesiones).apply {
            text = texto
            // Ajusta estos layoutParams dependiendo de tu contenedor final
            layoutParams = TableRow.LayoutParams(
                0, // Usar 0 para el ancho en TableRow con layout_weight
                TableRow.LayoutParams.WRAP_CONTENT,
                1f // Peso para distribución equitativa en TableRow
            )
            textSize = 11f
            setBackgroundColor(Color.WHITE)
            setTextColor(Color.BLACK)
        }

        fila.addView(textView)
    }
}
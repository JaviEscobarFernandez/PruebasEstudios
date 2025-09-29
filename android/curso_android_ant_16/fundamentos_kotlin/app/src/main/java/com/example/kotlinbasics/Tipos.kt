package com.example.kotlinbasics

/**
 * 1 bit = la unidad más básica de un sistema informático (0, 1)
 * 1 kb = 1024 bits = 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024
 * 1 Mb = 1024 kb
 * 1 Gb = 1024 Mb...
 * */
fun main() {
    println("Boolean:")
    val soyValenciano: Boolean = true // 1 = true, 0 = false
    print("¿Soy Valenciano? ")
    println (soyValenciano)

    println("Números enteros:") // -2,147,483,648 -> 2,147,483,647
    val paises: Int = 120
    println("Paises: $paises")

    // val milisegundos: int = 2147483648 // fuera de rango
    val milisegundos: Long = 21_474_836_471L // Podemos usar _ para separar como si fuesen comas
    println("Milisegundos: $milisegundos")
    println("Máximo valor Long:" + Long.MAX_VALUE) // -9223372036854775807 -> 9223372036854775807

    println("Números decimales:")
    val euros: Float = 20.50f
    println("Saldo: $euros")

    val diametroNeumatico: Double = 2.56_543_234_567
    println("Diametro: $diametroNeumatico")

    println("Textos:")
    val letra1: Char = 'J'
    val letra2: Char = 'a'
    val letra3: Char = 'v'
    val letra4: Char = 'i'
    println("$letra1$letra2$letra3$letra4")

    val nombreCompleto: String = "Javi"
    println(nombreCompleto)

    var casosEspeciales: String = "La última letra es la 'n'"
    println(casosEspeciales)

    casosEspeciales = "La última letra es la \'n', gracias a la \\ y no a \$letra1"
    println(casosEspeciales)

    println("Concatenación:")
    val nombre = readln() // entrada de datos
    print("Knock Knock ")
    println(nombre)
    println("Knock Knock " + nombre)
    println("Knock Knock $nombre")

    println("Nulos:")
    var sobreNombre: String? = null
    sobreNombre = "Javi"
    println("Longitud de sobrenombre ${sobreNombre!!.length}")
    sobreNombre = ""
    println("Longitud de sobrenombre ${sobreNombre?.length}")
    sobreNombre = null
    println("Longitud de sobrenombre ${sobreNombre?.length}")
}
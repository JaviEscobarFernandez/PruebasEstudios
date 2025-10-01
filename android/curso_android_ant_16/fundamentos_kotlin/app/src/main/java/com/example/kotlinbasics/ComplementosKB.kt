package com.example.kotlinbasics

val global = 8
lateinit var texto: String
val lazyTime: Long by lazy { time() }

fun time() = System.currentTimeMillis()

fun main() {
    println("Tiempo inicial: ${time()}")

    tema("Variables locales vs globales")
    val local = 5
    // val global = 6
    println("Local: $local")
    println("Global: $global")
    // println("local(): ${local()}")

    tema("Constantes")
    println(Constantes.fechaNacimiento)
    val x = readln().toInt()
    println(x * 2)

    tema("Lateinit")
    println("Introduce el texto:")
    texto = readln()
    println("local(): ${local()}")

    tema("Lazy")
    println("Tiempo perezoso: $lazyTime")
}

fun local() {
    val local = 4
    // println(local)
    // println(global)
    texto = "- $texto -"
    println(texto)
}

fun tema(texto: String) {
    println("\n${Constantes.SEPARADOR} $texto ${Constantes.SEPARADOR}")
}

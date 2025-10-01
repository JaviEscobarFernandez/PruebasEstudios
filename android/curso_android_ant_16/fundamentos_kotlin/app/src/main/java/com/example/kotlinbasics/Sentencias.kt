package com.example.kotlinbasics

fun main() {
    println("Sentencias:")
    print("Introduce un numero: ")
    var x = readln().toInt()
    print("Introduce otro numero: ")
    var y = readln().toInt()

    println("Sentencia if else")
    if (false)
        println("es true")
    if (x == y)
        println("X es igual a Y")
    else
        println("X no es igual a Y")

    if (x > y)
        println("X > Y")
    else if (x >= y) {
        print("X > Y")
        println(" o X = Y")
    }
    else
        println("No es mayor ni igual.")

    println("Sentencia when:") // El es switch de toda la vida
    print("Introduce tu nombre para consultar tu sueldo: ")
    val nombre = readln()
    when (nombre) {
        "Juan" -> println("100.0 €")
        "María" -> println("130.0 €")
        "Alberto" -> println("200.0 €")
        "Pedro",
        "Saray" -> println("240.0 €")
        "Alex" -> {
            println("210 €")
            println("110.0 €")
        }
        else -> println("50.0 €")
    }
}
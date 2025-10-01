package com.example.kotlinbasics

fun main() {
    println("Throw:")
    val ex = "Laura"
    val nombre = readln()
    try {
        if (nombre == ex) {
            throw Exception("La que no debe ser nombrada ;(")
        } else {
            println("Claro que me acuerdo de $nombre :)")
        }
    } catch (e: Exception) {
        println(e)
    } finally {
        println("Ya se ha ido el pesao.")
    }
    println("try, catch y finally:")
    println("El programa continua ejecutandose...")
}
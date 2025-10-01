package com.example.kotlinbasics

fun main() {
    println("Bucles")
    println("For:")
    for (i in 1..3) {
        println(i)
    }
    val nombre = "Javi"
    for (i in 0..nombre.length - 1)
        println("Indice $i = ${nombre[i]}")

    for (letra in nombre) {
        println(letra)
    }

    nombre.forEach {
        print(it)
    }

    println("While y Do-While:")
    var indice = 0
    while (indice < nombre.length) {
        println("indice: $indice = ${nombre[indice]}")
        indice++
    }

    do {
        indice--
        println("indice: $indice = ${nombre[indice]}")
    } while (indice > 0)

    println("return, break y continue:")
    for (i in 0..4) {
        if (i == 2)
            break
        println("indice: $i")
    }
    for (i in 0..4) {
        if (i == 2)
            continue
        println("indice: $i")
    }
    for (i in 0..4) {
        if (i == 2)
            return
        println("indice: $i")
    }
    println("Ya no continua por el return")
}
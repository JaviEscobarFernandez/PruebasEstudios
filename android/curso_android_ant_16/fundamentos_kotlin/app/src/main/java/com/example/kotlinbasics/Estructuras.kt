package com.example.kotlinbasics

fun main() {
    println("Estructuras de datos:")
    println("Listas inmutables:")
    val listaDiasHabiles: List<String>
    listaDiasHabiles = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
    println("Lista de solo lectura:\n$listaDiasHabiles")
    println("Primer día: ${listaDiasHabiles.get(0)}")

    val listaAmigos: MutableList<String>
    listaAmigos = mutableListOf("Jose", "Alex", "Aitor", "Adrian", "Jorge")
    println("Mis amigos son: $listaAmigos")
    listaAmigos.add("Vero")
    println("Mis amigos son: $listaAmigos")
    listaAmigos.remove("Jose")
    println("Mis amigos son: $listaAmigos")
    listaAmigos.removeAt(0)
    println("Mis amigos son: $listaAmigos")
    // listaAmigos[2] ="Roberto"
    listaAmigos.set(2, "Roberto")
    println("Mis amigos son: $listaAmigos")

    val mapInventario = mutableMapOf<String, Int>()
    mapInventario["T1"] = 12 // Tuercas
    mapInventario["M2"] = 4  // Martillos
    mapInventario["T2"] = 54 // Tablas
    println("Inventario: $mapInventario")
    mapInventario.remove("T2")
    println("Inventario: $mapInventario")
    println(mapInventario.keys)
    println(mapInventario.values)

    println("Transformaciones:")
    val precios = listOf(10, 20, 5)
    println("IVA: ${precios.map { it * 0.16 }}")

    val bebidas = listOf("Cerveza", "Coca-cola", "Agua")
    println("Menú: ${bebidas zip precios}")

    val numeros = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
    println(numeros)
    println(numeros.flatten())

    println("Filtros:")
    val herramientas = listOf("Tuercas", "Destornillador", "Martillo", "Llave Inglesa", "Sierra")
    println(herramientas.filter { it.length <= 8})
    println(herramientas.filter { it.contains('s')})
    println("Indice de Martillo = ${herramientas.indexOf("Martillo")}")

    println("Organización:")
    println(listaDiasHabiles)
    println("Reverso: ${listaDiasHabiles.reversed()}")
    println("Ordenado alfabeticamente: ${listaDiasHabiles.sorted()}")
    println("Ordenado por tamaño letras (Menor - Mayor): ${listaDiasHabiles.sortedBy { it.length }}")
    println("Ordenado por tamaño letras (Mayor - Menor): ${listaDiasHabiles.sortedBy { it.length }.reversed()}")
}

package com.example.kotlinbasics

fun main() {
    println("Operador Elvis:")
    var version: Int? = 3
    println("La versión actual es: $version")
    version = null
    println("La versión actual es: ${version ?: 5}")

    println("Operadores matematicos:")
    print("Introduce un numero: ")
    var x = readln()
    print("Introduce otro numero: ")
    var y = readln()
    println("$x, $y")
    println("x + y = ${x.toInt() + y.toInt()}")
    println("x - y = ${x.toInt() - y.toInt()}")
    println("x / y = ${x.toInt() / y.toInt()}")
    println("x * y = ${x.toInt() * y.toInt()}")
    println("x % y = ${x.toInt() % y.toInt()}")

    var numX = x.toInt()
    var numY = y.toInt()
    // numX = numX + 1
    numX++
    println("(x++) x + 1 = $numX")
    // numY = numY - 1
    numY--
    println("(y--) y - 1 = $numY")

    //numX = numX + 11
    numX += 11
    println("(x+=) x + 11 = $numX")
    numX /= 2
    println("(x/=) x / 2 = $numX")

    println("Operadores de igualdad:")
    val esigual: Boolean = 2 == 4
    println("2 es igual a 4? $esigual")
    val noesigual = 2 != 4
    println("2 no es igual a 4? $noesigual")

    println("Operadores lógicos")
    val or = (1 == 1 || 1 == 5) // true
    /** OR
     * true o true = true
     * true o false = true
     * false o true = true
     * false o false = false
     */
    println("Or: $or")

    val and = (1 == 1 && 1 == 5) // false
    /** AND
     * true y true = true
     * true y false = false
     * false y true = false
     * false y false = false
     */
    println("And: $and")

    println("Operadores comparativos:")
    val mayorque = (7 > 3) // true
    val menorque = (1 < 3) // true
    println("Mayor que: $mayorque")
    println("Menor que: $menorque")

    val menorOIgualQue = (7 >= 7) // true
    val mayorOIgualQue = (3 <= 3) // true
    println("Mayor o igual que: $menorOIgualQue")
    println("Menor o igual que: $mayorOIgualQue")
}

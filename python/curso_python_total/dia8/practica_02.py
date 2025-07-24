# Ejercicio 1
def gen():
    num = 0
    while True:
        num += 1
        yield num
generador = gen()

# Ejercicio 2
def gen2():
    mult = 0
    while True:
        mult += 1
        num = 7 * mult
        yield num
generador = gen2()

# Ejercicio 3
def gen3():
    vidas = 4
    while vidas > 1:
        vidas -= 1
        if (vidas > 1):
            yield f"Te quedan {vidas} vidas"
        else:
            yield f"Te queda {vidas} vida"
    yield "Game Over"
perder_vida = gen3()

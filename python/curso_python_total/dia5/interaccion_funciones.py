from random import *

# Lista inicial
palitos = ["-", "--", "---", "----"]

# Mezcla de lista
def mezclar(lista):
    shuffle(lista)
    return lista

# Solicitar intento
def probar_suerte():
    intento = ""
    while intento not in ["1", "2", "3", "4"]:
        intento = input("Elige un número del 1 al 4: ")
    return int(intento)

# Comprobar intento
def validar_intento(lista, intento):
    print(f"Te ha tocado: {lista[intento - 1]}")
    if lista[intento - 1] == "-":
        print("Has perdido, mala suerte")
    else:
        print("Te has librao por ahora")

palitos_mezclados = mezclar(palitos)
seleccion = probar_suerte()
validar_intento(palitos_mezclados, seleccion)

from random import *

# Ejercicio 1
def lanzar_dados():
    dado1 = randint(1, 6)
    dado2 = randint(1, 6)
    evaluar_jugada(dado1, dado2)
    return [dado1, dado2]

def evaluar_jugada(dado1, dado2):
    suma_dados = dado1 + dado2
    evaluacion = f"La suma de tus dados es {suma_dados}."
    if suma_dados <= 6:
        evaluacion += " Lamentable"
    elif suma_dados > 6 and suma_dados < 10:
        evaluacion += " Tienes buenas chances"
    else:
        evaluacion += " Parece una jugada ganadora"
    return evaluacion

lanzar_dados()

# Ejercicio 2
lista_numeros = [1,2,15,7,2]

def reducir_lista(lista):
    numeros_sin_duplicados = list(set(lista))
    max = 0
    indice = 0
    indice_max = 0
    for n in numeros_sin_duplicados:
        if max < n:
            max = n
            indice_max = indice
        indice += 1
    numeros_sin_duplicados.pop(indice_max)
    return numeros_sin_duplicados

def promedio(lista):
    result = 0
    cont = 0
    for n in lista:
        result += n
        cont += 1
    return result / cont

nueva_lista = reducir_lista(lista_numeros)
print(nueva_lista)
print(promedio(nueva_lista))

# Ejercicio 3
def lanzar_moneda():
    moneda = randint(0,1)
    return "Cara" if moneda else "Cruz"

def probar_suerte(moneda, lista):
    if moneda == "Cara":
        print("La lista se autodestruirá")
        lista.clear()
    else:
        print("La lista fue salvada")
    return lista

lista_numeros = [1,2,15,7,2]
print(probar_suerte(lanzar_moneda(), lista_numeros))

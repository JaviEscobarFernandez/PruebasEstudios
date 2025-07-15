# Ejercicio 1
def todos_positivos(lista):
    for n in lista:
        if n < 0:
            return False
    return True
lista_numeros = [-1, 10, 23, 213, -93]

# Ejercicio 2
def suma_menores(lista):
    result = 0
    for n in lista:
        if n in range(1, 1000):
            result += n
    return result
lista_numeros = [-1, 10, 23, 213, -93]

# Ejercicio 3
def cantidad_pares(lista):
    result = 0
    for n in lista:
        if n % 2 == 0:
            result += 1
    return result
lista_numeros = [-1, 10, 23, 213, -93]

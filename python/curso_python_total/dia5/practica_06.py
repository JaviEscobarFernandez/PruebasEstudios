# Ejercicio 1
def suma_cuadrados(*args):
    resultado = 0
    for n in args:
        resultado += n * n
    return resultado
print(suma_cuadrados(1, 2, 3))

# Ejercicio 2
def suma_absolutos(*args):
    resultado = 0
    for n in args:
        resultado += abs(n)
    return resultado

# Ejercicio 3
def numeros_persona(nombre, *args):
    suma_numeros = sum(args)
    return f"{nombre}, la suma de tus números es {suma_numeros}"

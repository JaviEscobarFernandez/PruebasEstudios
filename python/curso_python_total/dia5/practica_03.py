# Ejercicio 1
def potencia(num1, num2):
    result = 1
    for i in range(num2):
        result *= num1
    return result

print(potencia(3, 4))

# Ejercicio 2
def usd_a_eur(dolares):
    return dolares * 0.9
dolares = 120
print(usd_a_eur(dolares))

# Ejercicio 3
def invertir_palabra(palabra):
    return palabra[::-1].upper()
palabra = "Python"
print(invertir_palabra(palabra))

# Ejercicio 1
fichero = open("texto.txt")
print(fichero.read())
fichero.close()

# Ejercicio 2
fichero = open("texto.txt")
print(fichero.readline())
fichero.close()

# Ejercicio 3
fichero = open("texto.txt")
cont = 1
for linea in fichero:
    if cont == 2:
        print(linea)
    cont += 1
fichero.close()

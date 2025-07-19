fichero = open("prueba.txt")
print(fichero)
print(type(fichero))

print(fichero.read())
fichero.close()

fichero = open("prueba.txt")
print(fichero.readline().rstrip())
print(fichero.readline().upper())
print(fichero.readline())

fichero.close()

fichero = open("prueba.txt")
cont = 0
for l in fichero:
    cont += 1
    print(f"Linea {cont}: {l}")

fichero.close()

fichero = open("prueba.txt")
todas_lineas = fichero.readlines()
print(todas_lineas)
ultima_linea = todas_lineas.pop()
print(ultima_linea)
fichero.close()

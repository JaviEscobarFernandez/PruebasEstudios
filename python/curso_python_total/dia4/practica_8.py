# Ejercicio 1
lista_nombres = ["Marcos", "Laura", "Mónica", "Javier", "Celina", "Marta", "Darío", "Emiliano", "Melisa"]
for indice, nombre in enumerate(lista_nombres):
    print(f'{nombre} se encuentra en el índice {indice}')

# Ejercicio 2
palabra = "Python"
lista_indices = list(enumerate(palabra))
print(lista_indices)

# Ejercicio 3
lista_nombres = ["Marcos", "Laura", "Mónica", "Javier", "Celina", "Marta", "Darío", "Emiliano", "Melisa"]
for indice, nombre in enumerate(lista_nombres):
    if nombre[0] == "M":
        print(indice)

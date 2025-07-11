nombres = ["Ana", "Hugo", "Valeria"]
edades = [65, 29, 42]

combinados = zip(nombres, edades)
print(combinados)
print(type(combinados))

combinados = list(combinados)
print(combinados)

ciudades = ["Valencia", "Barcelona", "Murcia"]
combinados = list(zip(nombres, edades, ciudades))
print(combinados)

for nombre, edad, ciudad in combinados:
    print(f"{nombre} tiene {edad} años y reside en {ciudad}")

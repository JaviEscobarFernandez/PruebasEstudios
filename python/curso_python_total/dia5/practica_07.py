# Ejercicio 1
def cantidad_atributos(**kwargs):
    cont = 0
    for clave in kwargs.items():
        cont += 1
    return cont

# Ejercicio 2
def lista_atributos(**kwargs):
    lista = []
    for clave, valor in kwargs.items():
        lista.append(valor)
    return lista

# Ejercicio 3
def describir_persona(nombre, **kwargs):
    print(f"Características de {nombre}:")
    for clave, valor in kwargs.items():
        print(f"{clave}: {valor}")

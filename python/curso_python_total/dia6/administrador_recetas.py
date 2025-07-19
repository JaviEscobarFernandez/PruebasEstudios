import os
from pathlib import Path
from os import system

print("Bienvenido al administrador de recetas.")
ruta = Path(os.getcwd(), "Recetas")
print(f"La ruta de acceso al directorio donde se encuentran las recetas es: {ruta}")

def contar_recetas():
    cantidad_recetas = 0
    for txt in Path(ruta).glob("**/*.txt"):
        cantidad_recetas += 1
    return cantidad_recetas

def mostrar_menu():
    print("\t[1] - Leer receta")
    print("\t[2] - Añadir receta")
    print("\t[3] - Añadir sección de recetas")
    print("\t[4] - Eliminar receta")
    print("\t[5] - Eliminar sección de recetas")
    print("\t[6] - Salir del administrador de recetas")
    print(f"\tHay un total de {contar_recetas()} ficheros de recetas")

def seleccionar_categoria():
    categorias = []
    for r in Path(ruta).glob("*"):
        print(r.stem)
        categorias.append(r.stem)

    categoria = input("Elige una categoria: ").lower()
    for c in categorias:
        if c.lower() == categoria:
            return c

    print("ERROR: Categoria no existente")
    return ""

def seleccionar_receta(categoria):
    ruta_elegida = Path(ruta, categoria)
    recetas = []
    for r in Path(ruta_elegida).glob("*.txt"):
        print(r.stem)
        recetas.append(r.stem)

    receta = input("Elige una receta: ").lower()
    for r in recetas:
        if r.lower() == receta:
            return r

    print("ERROR: Receta no existente")
    return ""

def leer_receta():
    categoria = seleccionar_categoria()
    if categoria == "":
        return

    receta = seleccionar_receta(categoria)
    if receta == "":
        return

    receta = receta + ".txt"
    fichero = open(Path(ruta, categoria, receta), "r")
    print(f"Leyendo el contenido de {receta}")
    print(fichero.readline())
    fichero.close()


def add_receta():
    categoria = seleccionar_categoria()
    if categoria == "":
        return

    nueva_receta = input("Introduce el nombre de la receta: ")
    if nueva_receta == "":
        print("ERROR: no has introducido un nombre de receta válido")
        return

    nueva_receta = nueva_receta + ".txt"
    contenido_receta = input("Introduce el contenido de la receta: ")
    fichero = open(Path(ruta, categoria, nueva_receta), "w")
    print(f"Creando la receta {nueva_receta}")
    fichero.writelines(contenido_receta)
    fichero.close()


def add_seccion():
    nueva_seccion = input("Introduce el nombre de la sección: ")
    if nueva_seccion == "":
        print("ERROR: nombre de sección no válido")
        return
    for s in Path(ruta).glob("*"):
        if s.stem.lower() == nueva_seccion.lower():
            print("ERROR: El nombre de la sección ya existe")
            return
    print(f"Creando la seccion: {nueva_seccion}")
    os.makedirs(Path(ruta, nueva_seccion))

def eliminar_receta():
    categoria = seleccionar_categoria()
    if categoria == "":
        return

    receta_delete = seleccionar_receta(categoria)
    if receta_delete == "":
        return

    receta_delete = receta_delete + ".txt"
    print(f"Borrando la receta {receta_delete}")
    Path(ruta, categoria, receta_delete).unlink()

def eliminar_seccion():
    categoria = seleccionar_categoria()
    if categoria == "":
        return

    print(f"Eliminando la seccion: {categoria}")
    os.rmdir(Path(ruta, categoria))

opcion = "0"
while opcion != "6":
    mostrar_menu()
    opcion = input("Elige una opción: ")
    match opcion:
        case "1":
            leer_receta()
        case "2":
            add_receta()
        case "3":
            add_seccion()
        case "4":
            eliminar_receta()
        case "5":
            eliminar_seccion()
        case "6":
            print("¡Adios!")
            break
        case _:
            print("ERROR: Dato introducido no válido.")

    input("presiona una tecla para continuar")
    system("cls")

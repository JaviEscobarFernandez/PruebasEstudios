# Ejercicio 1
def abrir_leer(nombre_fichero):
    fichero = open(nombre_fichero, "r")
    contenido = fichero.read()
    fichero.close()
    return contenido

# Ejercicio 2
def sobrescribir(nombre_fichero):
    fichero = open(nombre_fichero, "w")
    fichero.write("contenido eliminado")
    fichero.close()

# Ejericicio 3
def registro_error(nombre_fichero):
    fichero = open(nombre_fichero, "a")
    fichero.write("se ha registrado un error de ejecución")
    fichero.close()

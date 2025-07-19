# Ejercicio 1
fichero = open("mi_archivo.txt", "w")
fichero.write("Nuevo texto")
fichero.close()

fichero = open("mi_archivo.txt", "r")
print(fichero.read())
fichero.close()

# Ejercicio 2
fichero = open("mi_archivo.txt", "a")
fichero.write("\nNuevo inicio de sesión")
fichero.close()

fichero = open("mi_archivo.txt", "r")
print(fichero.read())
fichero.close()

# Ejercicio 3
registro_ultima_sesion = ["Federico", "20/12/2021", "08:17:32 hs", "Sin errores de carga"]
registros = []
for r in registro_ultima_sesion:
    registros.append(r + "\t")
fichero = open("registro.txt", "a")
fichero.writelines(registros)
fichero.close()

fichero = open("registro.txt", "r")
print(fichero.read())
fichero.close()

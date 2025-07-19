import os
from pathlib import Path

ruta = os.getcwd()
print(ruta)
print(type(ruta))

os.chdir(os.getcwd() + "\\alternativo")
ruta = os.getcwd()
print(ruta)
print(type(ruta))

fichero = open("otro_archivo.txt", "r")
print(fichero.read())
fichero.close()


ruta = os.getcwd() + "\\otro_directorio"
os.rmdir(ruta)
os.makedirs(ruta)
elemento = os.path.basename(ruta)
print(elemento)
elemento = os.path.split(ruta)
print(elemento)


carpeta = Path("C:/Users/javie/OneDrive/Escritorio/Git/PruebasEstudios/python/curso_python_total/dia6/alternativo/otro_directorio")
archivo = carpeta / "otro_archivo.txt"
mi_archivo = open(archivo, "w")
mi_archivo.write("hola que tal?")
mi_archivo.close()

mi_archivo = open(archivo, "r")
print(mi_archivo.read())
mi_archivo.close()
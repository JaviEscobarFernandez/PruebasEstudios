import os
import shutil
from send2trash import send2trash

print(os.getcwd())

archivo = open("Curso.txt", "w")
archivo.write("Texto de prueba")
archivo.close()

print(os.listdir())

shutil.move("Curso.txt", "..\\")

send2trash("..\\Curso.txt")

print(os.walk(os.getcwd()))
ruta = os.getcwd()
ruta = "..\\"
for carpeta, subcarpeta, archivo in os.walk(ruta):
    print(f"En el directorio: {carpeta}")
    print(f"Los subdirectorios son:")
    for sub in subcarpeta:
        print(f"\t{sub}")
    print("Los ficheros que contiene son:")
    for a in archivo:
        print(f"\t{a}")
    print("\n")
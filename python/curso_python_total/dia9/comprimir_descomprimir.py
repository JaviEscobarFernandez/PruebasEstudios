import zipfile
import shutil
import os

archivo1 = open("archivo_01.txt", "w")
archivo1.write("Prueba1")
archivo1.close()

archivo2 = open("archivo_02.txt", "w")
archivo2.write("Prueba2")
archivo2.close()

mi_zip = zipfile.ZipFile("archivo_comprimido.zip", "w")
mi_zip.write("archivo_01.txt")
mi_zip.write("archivo_02.txt")

mi_zip.close()

zip_abierto = zipfile.ZipFile("archivo_comprimido.zip", "r")
zip_abierto.extractall()
zip_abierto.close()

carpeta_origen = "origen"
archivo_destino = "todo_comprimido"
shutil.make_archive(archivo_destino, "zip", carpeta_origen)

shutil.unpack_archive("todo_comprimido.zip", "Extraccion completada")

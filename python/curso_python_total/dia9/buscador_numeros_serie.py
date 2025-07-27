import os
import datetime
import time
import math
from pathlib import Path
import re

ruta = "Mi_Gran_Directorio"
fecha_actual = datetime.datetime.today().ctime()

def mostrar_busqueda(ficheros, cantidad_ficheros, duracion):
    print("----------------------------------------------------")
    print(f"Fecha de búsqueda: [{fecha_actual}]")
    print("\nARCHIVO\t\tNRO. SERIE")
    print("-------\t\t----------")
    for nombre, contenido in ficheros.items():
        print(f"{nombre} {contenido}")
    print(f"\nNúmeros encontrados: {cantidad_ficheros}")
    print(f"Duración de la búsqueda: {duracion} segundos")
    print("----------------------------------------------------")

def localizar_contenido(contenido):
    patron = r"N\w{3}-\d{5}"
    for c in contenido:
        busqueda = re.findall(patron, c)
        if len(busqueda) > 0:
            return busqueda
    return []

def leer_fichero(ruta_fichero, nombre_fichero):
    archivo = open(Path(ruta_fichero, nombre_fichero), "r")
    contenido = archivo.readlines()
    archivo.close()

    texto = ""
    busqueda = localizar_contenido(contenido)
    for b in busqueda:
        texto += b
    return texto

def listar_ficheros():
    time_inicial = time.time()
    cantidad_ficheros = 0
    informacion_localizada = {}
    for carpeta, subcarpeta, archivo in os.walk(ruta):
        for a in archivo:
            ruta_concreta = Path(carpeta)
            informacion = leer_fichero(ruta_concreta, a)
            if informacion != "":
                cantidad_ficheros += 1
                informacion_localizada[a] = informacion

    time_final = time.time()
    duracion = math.ceil(time_final - time_inicial)
    mostrar_busqueda(informacion_localizada, cantidad_ficheros, duracion)

listar_ficheros()

from pathlib import Path, PureWindowsPath

carpeta = Path("C:/Users/javie/OneDrive/Escritorio/Git/PruebasEstudios/python/curso_python_total/dia6/alternativo/otro_directorio/otro_archivo.txt")
print(carpeta.read_text())
print(carpeta.name)
print(carpeta.suffix)
print(carpeta.stem)

if not carpeta.exists():
    print("Este archivo no existe")
else:
    print("Genial, existe")

fichero = Path("C:/Users/javie/OneDrive/Escritorio/Git/PruebasEstudios/python/curso_python_total/dia6/alternativo/otro_directorio/otro_archivo2.txt")

if not fichero.exists():
    print("No existe el archivo")

ruta_windows = PureWindowsPath(carpeta)
print(ruta_windows)

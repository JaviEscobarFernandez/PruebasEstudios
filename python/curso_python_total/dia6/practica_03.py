from pathlib import Path

# Ejercicio 1
ruta_base = Path.home()
print(ruta_base)

# Ejercicio 2
ruta = Path("Curso Python", "Día 6", "practicas_path.py")
print(ruta)

# Ejercicio 3
ruta_base = Path.home()
ruta = Path(ruta_base, "Curso Python", "Día 6", "practicas_path.py")
print(ruta)

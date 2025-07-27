from collections import Counter
from collections import defaultdict
from collections import deque

# Ejercicio 1
lista = [1, 2, 3, 6, 7, 1, 2, 4, 5, 5, 5, 5, 3, 2, 6, 7]

contador = Counter(lista)

# Ejercicio 2
mi_diccionario = defaultdict(lambda: "Valor no hallado")
mi_diccionario["edad"] = 44

# Ejercicio 3
lista_ciudades = deque(["Londres", "Berlin", "París", "Madrid", "Roma", "Moscú"])
# lista_ciudades.appendleft("Barcelona")
print(lista_ciudades)

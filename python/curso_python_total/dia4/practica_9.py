# Ejercicio 1
capitales = ["Berlín", "Tokio", "París", "Helsinki", "Ottawa", "Canberra"]
paises = ["Alemania", "Japón", "Francia", "Finlandia", "Canadá", "Australia"]
combo = list(zip(capitales, paises))
for capital, pais in combo:
    print(f"La capital de {pais} es {capital}")

# Ejercicio 2
marcas = ["Coca-cola", "Nike", "Ferrari"]
productos = ["Refresco", "Zapatillas", "Deportivo"]
mi_zip = zip(marcas, productos)

# Ejercicio 3
num_esp = ["uno", "dos", "tres", "cuatro", "cinco"]
num_por = ["um", "dois", "três", "quatro", "cinco"]
num_ing = ["one", "two", "three", "four", "five"]
numeros = list(zip(num_esp, num_por, num_ing))
print(numeros)

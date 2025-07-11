lista = ["a", "b", "c", "d"]
for letra in lista:
    print(letra)

for l in lista:
    print("Letra: " + l)

for letra in lista:
    numero_letra = lista.index(letra) + 1
    print(f"Letra {numero_letra}: {letra}")

lista = ["pablo", "laura", "fede", "luis", "julia"]
for nombre in lista:
    if nombre.startswith("l"):
        print("Nombre que empieza por 'l': " + nombre)

numeros = [1, 2, 3, 4, 5]
mi_valor = 0
print("sumando: ")
for numero in numeros:
    mi_valor += numero
    print(numero)
print(f"resultado: {mi_valor}")

palabra = "python"
for letra in palabra:
    print(letra)

for letra in "python":
    print(letra)

for a, b in [[1, 2], [3, 4], [5, 6]]:
    print(a)
    print(b)

dic = { "clave1":"a", "clave2":"b", "clave3":"c" }
for clave, valor in dic.items():
    print(f"clave: '{clave}' - valor: '{valor}'")
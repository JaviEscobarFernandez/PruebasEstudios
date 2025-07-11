monedas = 5
while monedas > 0:
    print(f"Tengo {monedas} monedas")
    monedas -= 1
else:
    print("No quedan monedas")

respuesta = "s"
while respuesta == "s":
    respuesta = input("¿Deseas continuar? (s/n) ")
else:
    print("Adios!")

while respuesta == "s":
    pass

print("Hola")

nombre = input("Introduce tu nombre: ")
for letra in nombre:
    if letra == "J":
        continue
    if letra == "v":
        break
    print(letra)
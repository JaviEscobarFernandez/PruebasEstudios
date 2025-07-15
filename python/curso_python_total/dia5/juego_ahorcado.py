from random import choice

lista_palabras = ["Zapatilla", "Tortilla", "Pelota", "Porteria", "Perro", "Tornillo", "Salvavidas"]
vidas = 6

def validar_letra(letra):
    if letra.isalpha() and len(letra) == 1:
        return True
    return False

def elegir_palabra(lista):
    return choice(lista)

def inicializar_palabra(palabra):
    result = ""
    for n in range(0, len(palabra)):
        result += "_"
    return result

def localizar_letra(letra, palabra_secreta, palabra_formada):
    print(palabra_formada.find(letra), palabra_secreta.find(letra))
    if palabra_secreta.find(letra) == -1:
        return False
    if palabra_formada.find(letra) >= 0:
        return False
    return True

def establecer_letra(letra, palabra_secreta, palabra_formada):
    indice = 0
    palabra = ""
    for l in palabra_secreta:
        if l == letra:
            palabra += l
        else:
            palabra += palabra_formada[indice]
        indice += 1
    return palabra

palabra_secreta = elegir_palabra(lista_palabras).upper()
palabra_formada = inicializar_palabra(palabra_secreta)

while vidas > 0:
    letra = input("Introduce una leta: ").upper()

    if not validar_letra(letra):
        vidas -= 1
        print("ERROR: caracter introducido no válido.")
        print(f"Vidas restantes: {vidas}")
        continue

    if not localizar_letra(letra, palabra_secreta, palabra_formada):
        vidas -= 1
        print("ERROR: la letra indicada no está o ya las has indicado anteriormente.")
        print(f"Vidas restantes: {vidas}")
        continue

    palabra_formada = establecer_letra(letra, palabra_secreta, palabra_formada)
    print(f"Estableciendo letra '{letra}' en la palabra a adivinar")
    print(palabra_formada)

    if palabra_formada == palabra_secreta:
        print(f"¡Lo has adivinado! La palabra era: {palabra_formada}, te han quedado {vidas} restantes")
        break

    palabra_elegida = input("Introduce la palabra que crees que es: ").upper()
    if palabra_elegida == palabra_secreta:
        print(f"¡Lo has adivinado! La palabra era: {palabra_secreta}, te han quedado {vidas} restantes")
        break

    vidas -= 1
    print(f"No has adivinado la palabra, vidas restantes: {vidas}, palabra actual: {palabra_formada}")
from random import *
nombre = input("Introduce tu nombre: ")
print(f"Bueno, {nombre}, he pensado un número entre 1 y 100,"
      f"\ny tienes solo ocho intentos para adivinar cuál crees que es el número")

intentos = 0
max_intentos = 8
numero_aleatorio = randint(1,100)
while intentos < max_intentos:
    intentos += 1
    numero = int(input("Introduce un número del 1 al 100: "))
    if numero < 1 or numero > 100:
        print("Número introducido no válido, debe ser un valor entero de 1 a 100.")
    elif numero < numero_aleatorio:
        print("No has acertado el número, has elegido un número menor al secreto.")
    elif numero > numero_aleatorio:
        print("No has acertado el número, has elegido un número mayor al secreto.")
    else:
        print(f"Muy bien has acertado!!!, el número secreto es {numero_aleatorio}")
        print(f"Lo has acertado en {intentos}/{max_intentos} intentos.")
        break
    print(f"intentos realizados: {intentos}, intentos restantes: {max_intentos - intentos}")
    if intentos >= 8:
        print("Has agotado todos los intentos, hemos finalizado.")

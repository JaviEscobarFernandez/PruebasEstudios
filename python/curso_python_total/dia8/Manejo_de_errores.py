def suma():
    n1 = int(input("Número 1: "))
    n2 = int(input("Número 2: "))
    print(n1 + n2)
    print("Gracias por sumar")

try:
    suma()
except TypeError:
    print("ERROR: Estas intentando concatenar erroneamente")
except ValueError:
    print("ERROR: dato introducido no válido, debes introducir un número")
else:
    print("Codigo adicional si no ha fallado")
finally:
    print("finalizando prueba")

def solicitar_numero():
    while True:
        try:
            numero = int(input("Introduce un número: "))
        except:
            print("ERROR: Dato introducido no válido")
        else:
            print(f"El número introducido es {numero}")
            break
    print("Gracias")

solicitar_numero()

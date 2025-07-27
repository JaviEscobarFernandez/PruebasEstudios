import re

# Ejercicio 1
def verificar_email(email):
    patron1 = re.search(r"\w+@\w+\.com", email)
    patron2 = re.search(r"\w+@\w+\.com..", email)
    if patron1 or patron2:
        print("Ok")
        return True
    print("La dirección de email es incorrecta")
    return False

# Ejercicio 2
def verificar_saludo(frase):
    if len(frase) > 0:
        patron = r"Hola.*"
        busqueda = re.search(patron, frase)
        if busqueda:
            print("Ok")
            return True
    print("No has saludado")
    return False

print(verificar_saludo(input("Introduce la frase: ")))

# Ejercicio 3
def verificar_cp(cp):
    patron = r"\w{2}\d{4}"
    if re.search(patron, cp):
        print("Ok")
        return True
    print("El código postal ingresado no es correcto")
    return False

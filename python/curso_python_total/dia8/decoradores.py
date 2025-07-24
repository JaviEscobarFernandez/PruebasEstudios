def mayuscula(texto):
    print(texto.upper())

def minuscula(texto):
    print(texto.lower())

print("Hola")
mayuscula("Hoy es lunes")
print("Adios")

mi_funcion = mayuscula
mi_funcion("Python")

def una_funcion(funcion):
    return funcion

una_funcion(mayuscula("Prueba"))

def cambiar_letras(tipo):
    def mayuscula(texto):
        print(texto.upper())

    def minuscula(texto):
        print(texto.lower())

    if tipo == "may":
        return mayuscula
    if tipo == "min":
        return minuscula

operacion = cambiar_letras("may")
operacion("Palabra")

def decorar_saludo(funcion):
    def otra_funcion(palabra):
        print("Hola")
        funcion(palabra)
        print("Adios")
    return otra_funcion

def mayusculas(texto):
    print(texto.upper())

@decorar_saludo
def minusculas(texto):
    print(texto.lower())

minusculas("Python")
mayusculas("Python")

mayuscula_decorada = decorar_saludo(mayusculas)
mayuscula_decorada("Fede")
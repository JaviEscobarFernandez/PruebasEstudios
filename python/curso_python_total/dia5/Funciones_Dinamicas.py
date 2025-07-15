def validar_cifras(numero):
    return numero in range(100, 1000)
resultado = validar_cifras(658)
print(resultado)
resultado = validar_cifras(23)
print(resultado)

def validar_cifras(lista):
    for n in lista:
        if n in range(100, 1000):
            return True
    return False
resultado = validar_cifras([1, 2, 3, 49, 500])
print(resultado)
resultado = validar_cifras([1, 10000, 2, 3983821, 21])
print(resultado)

def validar_cifras(lista):
    lista_valida = []
    for n in lista:
        if n in range(100, 1000):
            lista_valida.append(n)
    return lista_valida
resultado = validar_cifras([1, 2, 3, 49, 500, 1, 10000, 2, 3983821, 21, 234, 123, 453])
print(resultado)

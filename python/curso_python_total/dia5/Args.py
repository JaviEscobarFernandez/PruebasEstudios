def suma(a, b):
    return a + b

print(suma(10, 15))

def suma(*args):
    resultado = 0
    for n in args:
        resultado += n
    return resultado

print(suma(10, 20, 30, 40, 50))

def suma2(*args):
    return sum(args)
print(suma2(10, 20, 30, 40, 50))

def mi_funcion():
    lista = []
    for n in range(1, 5):
        lista.append(n * 10)
    return lista

def mi_generador():
    for n in range(1, 5):
        yield n * 10

print(mi_funcion())
print(mi_generador())

g = mi_generador()
print(next(g))
print(next(g))
print(next(g))
print(next(g))

def mi_generador():
    x = 1
    yield x
    x += 1
    yield x
    x += 1
    yield x

g = mi_generador()
print(next(g))
print(next(g))

print("Hola mundo")

print(next(g))

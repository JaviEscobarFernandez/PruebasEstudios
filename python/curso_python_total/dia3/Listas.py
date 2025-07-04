mi_lista = ["a", "b", "c"]
print(type(mi_lista))

otra_lista = ["hola", 55, 6.1]
print(type(otra_lista))

resultado = len(mi_lista)
print(resultado)

resultado = mi_lista[0]
print(resultado)

resultado = mi_lista[0:1]
print(resultado)

resultado = mi_lista[0:2]
print(resultado)

resultado = mi_lista[0:]
print(resultado)

mi_lista2 = ["d", "e", "f"]
mi_lista3 = mi_lista + mi_lista2
print(mi_lista3)

mi_lista3[0] = "alfa"
mi_lista3[1] = "beta"
print(mi_lista3)

mi_lista3.append("g")
print(mi_lista3)

mi_lista3.pop()
print(mi_lista3)

mi_lista3.pop(0)
print(mi_lista3)

eliminado = mi_lista3.pop(0)
print(eliminado)
print(mi_lista3)

lista = ["g", "o", "b", "m", "c"]
print(lista)
lista.sort()
print(lista)

lista.reverse()
print(lista)


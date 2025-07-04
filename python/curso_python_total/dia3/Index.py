mi_texto = "Esta es una prueba"
resultado = mi_texto[0]
print(resultado)

resultado = mi_texto[9]
print(resultado)

print(mi_texto[-4])

resultado = mi_texto.index("a")
print(resultado)

resultado = mi_texto.index("prueba")
print(resultado)

resultado = mi_texto.index("a", mi_texto.index("a") + 1)
print(resultado)

resultado = mi_texto.rindex("a")
print(resultado)
texto = "Este es el texto de Federico"
resultado = texto
print(resultado)

resultado = texto.upper()
print(resultado)

resultado = texto[2].upper()
print(resultado)

resultado = texto.lower()
print(resultado)

resultado = texto.split()
print(resultado)
print(type(resultado))

resultado = texto.split("t")
print(resultado)

a = "Aprender"
b = "Python"
c = "es"
d = "genial"
e = " ".join([a, b, c, d])
print(e)

e = "-".join([a, b, c, d])
print(e)

resultado = texto.find("F")
print(resultado)

resultado = texto.find("w")
print(resultado)

resultado = texto.replace("Federico", "Javi")
print(resultado)

resultado = texto.replace("e", "x")
print(resultado)
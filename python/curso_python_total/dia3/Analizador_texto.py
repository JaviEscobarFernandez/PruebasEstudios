texto = input("Introduce un texto: ")
letra1 = input("Introduce la primera letra: ")
letra2 = input("Introduce la segunda letra: ")
letra3 = input("Introduce la tercera letra: ")
lista_letras = [letra1, letra2, letra3]

texto_minus = texto.lower()
letra1_count = texto_minus.count(lista_letras[0].lower())
letra2_count = texto_minus.count(lista_letras[1].lower())
letra3_count = texto_minus.count(lista_letras[2].lower())

texto_lista = texto.split()
texto_palabras_count = len(texto_lista)

texto_primera_letra = texto[0]
texto_ultima_letra = texto[-1]

texto_palabras_invertidas_lista = texto_lista
texto_palabras_invertidas_lista.reverse()
texto_palabras_invertidas = " ".join(texto_palabras_invertidas_lista)
print(texto_palabras_invertidas)
print(type(texto_palabras_invertidas))

resultado = texto_palabras_invertidas.find("Python")
esta_python = "python" in texto_minus
diccionario = { True:"Sí está", False:"No está" }

print(f"Las veces que aparece la letra '{letra1}' es: {letra1_count}")
print(f"Las veces que aparece la letra '{letra2}' es: {letra2_count}")
print(f"Las veces que aparece la letra '{letra3}' es: {letra3_count}")
print(f"Hay {texto_palabras_count} palabras en el texto")
print(f"La primera letra del texto es: {texto_primera_letra}")
print(f"La última letra del texto es: {texto_ultima_letra}")
print(f"El texto en orden invertido de palabras es:\n{texto_palabras_invertidas}")
print(f"¿La palabra 'Python' está en el texto? {diccionario[esta_python]}")

if 10 > 9:
    print("Correcto")

x = True
if x:
    print("Es Correcto")

if 5 == 2:
    print("Es correcto??")
else:
    print("No es correcto!")

mascota = "perro"
if mascota == "gato":
    print("Tienes un gato")
elif mascota == "perro":
    print("Tienes un perro")
elif mascota == "pez":
    print("Tienes un pez")
else:
    print("Ni idea, cual quieres?")

edad = 16
calificacion = 9
if edad < 18:
    print("Eres menor de edad")
    if calificacion >= 7:
        print("Has aprobado")
    else:
        print("Has suspendido")
else:
    print("Eres adulto")

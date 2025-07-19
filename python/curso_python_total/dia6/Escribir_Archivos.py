fichero = open("archivo.txt", "w")
fichero.write("Nuevo texto introducido")
fichero.write("\nHola ")
fichero.write("Mundo")
fichero.close()

fichero = open("archivo.txt", "w")
fichero.writelines(["hola", "mundo", "aqui", "estoy"])
fichero.close()

fichero = open("archivo.txt", "w")
lista = ["hola", "mundo", "aqui", "estoy"]
for p in lista:
    fichero.write(p + "\n")
fichero.close()

fichero = open("archivo.txt", "a")
fichero.write("Añadiendo una línea al final sin reemplazar el contenido")
fichero.close()
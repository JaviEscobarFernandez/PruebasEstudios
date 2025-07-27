import re

texto = "Si necesitas ayuda llama al (658)-598-9977 las 24 horas al servicio de ayuda online"

palabra = "ayuda" in texto
print(palabra)

patron = "nada"
busqueda = re.search(patron, texto)
print(busqueda)

patron = "ayuda"
busqueda = re.search(patron, texto)
print(busqueda)
print(busqueda.span())
print(busqueda.start())
print(busqueda.end())

busqueda = re.findall(patron, texto)
print(len(busqueda))

for find in re.finditer(patron, texto):
    print(find.span())

texto = "llama al 564-525-6588 ya mismo"
patron = r'\d\d\d-\d\d\d-\d\d\d\d'
resultado = re.search(patron, texto)
print(resultado)
print(resultado.group())

patron = r'\d{3}-\d{3}-\d{4}'
resultado = re.search(patron, texto)
print(resultado)

patron = re.compile(r'\d{3}-\d{3}-\d{4}')
resultado = re.search(patron, texto)
print(resultado)
print(resultado.group(0))

clave = input("Clave: ")
patron = r'\D{1}\w{7}'
validar = re.search(patron, clave)
print(validar)

texto = "No atendemos los lunes por la tarde"
buscar = re.search(r'lunes|martes', texto)
print(buscar)

buscar = re.search(r'....demos...', texto)
print(buscar)

buscar = re.search(r'^\D', texto)
print(buscar)

buscar = re.search(r'\D$', texto)
print(buscar)

buscar = re.findall(r'[^\s]', texto)
print(buscar)

buscar = re.findall(r'[^\s]+', texto)
print(buscar)
print(''.join(buscar))
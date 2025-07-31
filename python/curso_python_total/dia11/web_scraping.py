import bs4
import requests

resultado = requests.get("https://es.wikipedia.org/wiki/Chirivella")
# print(type(resultado))
# print(resultado.text)

sopa = bs4.BeautifulSoup(resultado.text, "lxml")
# print(sopa)
print(type(sopa))
print(sopa.select("title"))
print(sopa.select("p"))
print(sopa.select("h1"))
print(sopa.select("title")[0].get_text())

parrafo_especial = sopa.select("p")
print(parrafo_especial)

parrafo_especial = sopa.select("p")[2]
print(parrafo_especial)

parrafo_especial = sopa.select("p")[2].get_text()
print(parrafo_especial)


columna_lateral = sopa.select(".infobox.geography.vcard tr")
print(columna_lateral)

columna_lateral = sopa.select(".infobox.geography.vcard tr")
for p in columna_lateral:
    print(p.get_text())

imagenes = sopa.select(".mw-file-element")

for i in imagenes:
    print(i)

imagenes = "https:" + sopa.select(".mw-file-element")[0]["src"]
print(imagenes)
print(type(imagenes))
imagen_curso_1 = requests.get(imagenes)
print(imagen_curso_1.content)

f = open("imagenes/imagen_obtenida.jpg", "wb")
f.write(imagen_curso_1.content)
f.close()

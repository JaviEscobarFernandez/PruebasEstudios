import bs4
import requests

# crear url sin numero de pagina
url_base ="https://books.toscrape.com/catalogue/page-{}.html"
"""
# for n in range(1, 11):
#    print(url_base.format(n))

resultado = requests.get(url_base.format("1"))
sopa = bs4.BeautifulSoup(resultado.text, "lxml")
# print(sopa.select(".product_pod"))

libros = sopa.select(".product_pod")
ejemplo = libros[0]
print(ejemplo)

ejemplo = libros[0].select(".star-rating.three")
print(ejemplo)

ejemplo = libros[0].select("a")[1]["title"]
print(ejemplo)
"""

# lista de titulos con 4 o 5 estrellas
titulos_rating_alto = []

# iterar paginas
for pagina in range(1, 51):
    # crear sopa en cada pagina
    url_pagina = url_base.format(pagina)
    resultado = requests.get(url_pagina)
    sopa = bs4.BeautifulSoup(resultado.text, "lxml")

    # seleccionar datos de los libros
    libros = sopa.select(".product_pod")

    # iterar libros
    for libro in libros:
        # comprobar que tengan 4 o 5 estresllas
        if len(libro.select(".star-rating.Four")) != 0 or len(libro.select(".star-rating.Five")) != 0:
            # almacenar titulo
            titulo_libro = libro.select("a")[1]["title"]
            # agregar titulo a la lista
            titulos_rating_alto.append(titulo_libro)

# ver libros con 4 o 5 estresllas
for t in titulos_rating_alto:
    print(t)

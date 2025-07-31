import bs4
import requests

# crear url sin numero de pagina
url_base ="https://books.toscrape.com/catalogue/page-{}.html"
# for n in range(1, 11):
#    print(url_base.format(n))

resultado = requests.get(url_base.format("1"))
sopa = bs4.BeautifulSoup(resultado.text, "lxml")
# print(sopa.select(".product_pod"))

libros = sopa.select(".product_pod")
ejemplo = libros[0]
print(ejemplo)

ejemplo = libros[0].select(".star-rating.Three")
print(ejemplo)

ejemplo = libros[0].select("a")[1]["title"]
print(ejemplo)

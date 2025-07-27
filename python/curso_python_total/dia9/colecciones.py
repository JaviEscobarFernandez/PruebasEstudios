from collections import Counter
from collections import defaultdict
from collections import namedtuple

numeros = [8, 6, 9, 5, 4, 5, 5, 5, 8, 7, 4, 5, 4, 4]
print(Counter(numeros))
print(type(Counter(numeros)))

print(Counter("mississippi"))

frase = "al pan pan y al vino vino"
print(Counter(frase.split()))

serie = Counter([1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,5])
print(serie.most_common())
print(serie.most_common(1))
print(serie.most_common(2))

print(list(serie))

mi_dic = { "uno":"verde", "dos":"azul", "tres":"rojo" }
print(mi_dic["dos"])

mi_dic = defaultdict(lambda: "Nada")
mi_dic["uno"] = "verde"
print(mi_dic["Dod"])
print(mi_dic)

mi_tupla = (500, 18, 65)
print(mi_tupla[1])

Persona = namedtuple("Persona", ["Nombre", "Altura", "Peso"])
ariel = Persona("Ariel", 1.76, 79)
print(ariel.Altura)
print(ariel.Peso)
print(ariel.Nombre)
print(ariel[2])
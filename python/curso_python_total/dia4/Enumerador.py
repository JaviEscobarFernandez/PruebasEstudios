lista = ["a", "b", "c"]
indice = 0
for item in lista:
    print(indice, item)
    indice += 1

lista = ["a", "b", "c"]
for item in enumerate(lista):
    print(item)

lista = ["a", "b", "c", "d"]
for indice, item in enumerate(lista):
    print(f"{indice} - {item}")

for indice, item in enumerate(range(50, 55)):
    print(indice, item)

lista = ["a", "b", "c"]
mis_tuples = list(enumerate(lista))
print(mis_tuples)
print(mis_tuples[1][0])

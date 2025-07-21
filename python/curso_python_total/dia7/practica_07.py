# Ejercicio 1
palabra = "polimorfismo"
lista = ["Clases", "POO", "Polimorfismo"]
tupla = (1, 2, 3, 80)

for s in palabra, lista, tupla:
    print(len(s))

# Ejercicio 2
class Mago:
    def atacar(self):
        print("Ataque mágico")

class Arquero:
    def atacar(self):
        print("Lanzamiento de flecha")

class Samurai:
    def atacar(self):
        print("Ataque con katana")

gandalf = Mago()
legolas = Arquero()
aragorn = Samurai()
personajes = [legolas, gandalf, aragorn]
for p in personajes:
    p.atacar()

# Ejercicio 3
class Mago:
    def defender(self):
        print("Escudo mágico")

class Arquero:
    def defender(self):
        print("Esconderse")

class Samurai:
    def defender(self):
        print("Bloqueo")

def personaje_defender(personaje):
    personaje.defender()

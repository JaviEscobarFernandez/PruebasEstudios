class Vaca:

    def __init__(self, nombre:str):
        self.nombre = nombre

    def hablar(self):
        print(self.nombre + " dice muuu")

class Oveja:

    def __init__(self, nombre:str):
        self.nombre = nombre

    def hablar(self):
        print(self.nombre + " dice beee")

vaca1 = Vaca("Aurora")
oveja1 = Oveja("Nube")

vaca1.hablar()
oveja1.hablar()

animales = [vaca1, oveja1]
for a in animales:
    a.hablar()

def animal_habla(animal):
    animal.hablar()

animal_habla(vaca1)
animal_habla(oveja1)

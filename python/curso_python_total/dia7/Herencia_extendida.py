class Animal:

    def __init__(self, edad:int, color:str):
        self.edad = edad
        self.color = color

    def nacer(self):
        print("Este animal ha nacido")

    def hablar(self):
        print("Este animal emite un sonido")

class Pajaro(Animal):

    def __init__(self, edad:int, color:str, altura_vuelo:int):
        super().__init__(edad, color)
        self.altura_vuelo = altura_vuelo

    def hablar(self):
        print("Pio")

    def volar(self, metros:int):
        print(f"El pájaro vuela {metros} metros")

piolin = Pajaro(3, "Amarillo", 60)
piolin.volar(100)
mi_animal = Animal(5, "Negro")

class Padre:
    def hablar(self):
        print("Hola")

class Madre:
    def reir(self):
        print("Ja ja")

    def hablar(self):
        print("¿Que tal?")

class Hijo(Madre, Padre):
    pass

class Nieto(Hijo):
    pass

mi_nieto = Nieto()
mi_nieto.hablar()
mi_nieto.reir()

print(Nieto.__mro__)

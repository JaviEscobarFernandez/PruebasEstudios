class Animal:

    def __init__(self, edad:int, color:str):
        self.edad = edad
        self.color = color

    def nacer(self):
        print("Este animal ha nacido")

class Pajaro(Animal):
    pass

print(Pajaro.__bases__)
print(Animal.__bases__)
print(Animal.__subclasses__())
print(Pajaro.__subclasses__())

piolin = Pajaro(2, "Amarillo")
piolin.nacer()
print(piolin.color)
print(piolin.edad)
class Pajaro:
    alas = True
    def __init__(self, color:str, especie:str):
        self.color = color
        self.especie = especie

pajaro1 = Pajaro("Azul", "Periquito")
#pajaro2 = Pajaro(123)
pajaro2 = Pajaro("Blanco", "Loro")

print(f"Color del pajaro1: {pajaro1.color} y es un: {pajaro1.especie}")
print(f"Color del pajaro2: {pajaro2.color} y es un: {pajaro2.especie}")
print(Pajaro.alas)
print(pajaro1.alas)
pajaro1.alas = False
print(Pajaro.alas)
print(pajaro1.alas)

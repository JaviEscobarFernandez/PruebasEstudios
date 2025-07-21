class Pajaro:
    alas = True

    def __init__(self, color: str, especie: str):
        self.color = color
        self.especie = especie

    def piar(self):
        print(f"pio, soy de color {self.color}")

    def volar(self, metros: int):
        print(f"El pájaro ha volado {metros} metros.")
        self.piar()

    def pintar_negro(self):
        self.color = "negro"
        print(f"Ahora el pájaro es {self.color}")

    @classmethod
    def poner_huevos(cls, cantidad):
        print(f"Ha puesto {cantidad} huevos")
        cls.alas = True
        print(cls.alas)

    @staticmethod
    def mirar():
        print("El pájaro mira")

piolin = Pajaro("Amarillo", "Canario")
piolin.volar(50)
piolin.piar()
piolin.alas = False
print(piolin.alas)
print(piolin.pintar_negro())
piolin.piar()

Pajaro.poner_huevos(3)
Pajaro.mirar()
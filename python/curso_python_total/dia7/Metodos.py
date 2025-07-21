class Pajaro():
    alas = True

    def __init__(self, color:str, especie:str):
        self.color = color
        self.especie = especie

    def piar(self):
        print(f"pio, soy de color {self.color}")

    def volar(self, metros:int):
        print(f"El pájaro ha volado {metros} metros.")

piolin = Pajaro("Amarillo", "Canario")
piolin.volar(50)
piolin.piar()

# Ejercicio 1
class Mascota:

    @staticmethod
    def respirar():
        print("Inhalar... Exhalar")

Mascota.respirar()

# Ejercicio 2
class Jugador:
    vivo = False

    @classmethod
    def revivir(cls):
        cls.vivo = True

# Ejercicio 3
class Personaje:

    def __init__(self, cantidad_flechas:int):
        self.cantidad_flechas = cantidad_flechas

    def lanzar_flecha(self):
        self.cantidad_flechas -= 1

pj1 = Personaje(100)
pj1.lanzar_flecha()

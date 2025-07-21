# Ejercicio 1
class Perro():
    def ladrar(self):
        print("Guau!")

perro_flauta = Perro()
perro_flauta.ladrar()

# Ejercicio 2
class Mago():
    def lanzar_hechizo(self):
        print("¡Abracadabra!")

merlin = Mago()
merlin.lanzar_hechizo()

# Ejercicio 3
class Alarma():
    def postergar(self, cantidad_minutos:int):
        print(f"La alarma ha sido pospuesta {cantidad_minutos} minutos")

alarma = Alarma()
alarma.postergar(15)

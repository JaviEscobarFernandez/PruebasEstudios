# Ejercicio 1
class Persona:

    def __init__(self, nombre:str, edad:int):
        self.nombre = nombre
        self.edad = edad

class Alumno(Persona):
    pass

# Ejercicio 2
class Mascota:

    def __init__(self, edad:str, nombre:str, cantidad_patas:int):
        self.edad = edad
        self.nombre = nombre
        self.cantidad_patas = cantidad_patas

class Perro(Mascota):
    pass

# Ejercicio 3
class Vehiculo:

    def acelerar(self):
        pass

    def frenar(self):
        pass

class Automovil(Vehiculo):
    pass

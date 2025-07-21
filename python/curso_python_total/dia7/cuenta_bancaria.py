from contextlib import nullcontext
import os

class Persona:
    def __init__(self, nombre:str, apellidos:str):
        self.nombre = nombre
        self.apellidos = apellidos

class Cliente(Persona):
    def __init__(self, nombre:str, apellidos:str, numero_cuenta:str):
        super().__init__(nombre, apellidos)
        self.numero_cuenta = numero_cuenta
        self.balance = 0

    def __str__(self):
        datos = f"Nombre: {self.nombre}"
        datos += f"\nApellidos: {self.apellidos}"
        datos += f"\nNúmero de cuenta: {self.numero_cuenta}"
        datos += f"\nBalance: {self.balance}"
        return datos

    def depositar(self, cantidad:int):
        self.balance += cantidad
        print("Saldo ingresado correctamente")

    def retirar(self, cantidad:int):
        cantidad_retirada = cantidad
        if cantidad > self.balance:
            print("No tienes suficiente saldo en la cuenta")
            return
        self.balance -= cantidad_retirada
        print(f"Fondos retirados correctamente, cantidad: {cantidad_retirada}")

lista_clientes = []

def registrar_cliente():
    print("Iniciado proceso de registro de cliente")
    nombre = input("Introduce el nombre del cliente: ")
    apellidos = input("Introduce los apellidos del cliente: ")
    num_cuenta = input("Introduce el número de cuenta del cliente: ")
    cliente = Cliente(nombre, apellidos, num_cuenta)
    print("Cliente registrado correctamente")
    return cliente

def seleccionar_cliente():
    cliente_ids = []
    cont = 1
    for cliente in lista_clientes:
        cliente_ids.append(cont)
        cont += 1

    if len(cliente_ids) == 0:
        print("No hay clientes registrados")
        return nullcontext

    clientes = list(zip(cliente_ids, lista_clientes))
    for id_cli, cliente in clientes:
        print(f"{id_cli} - {cliente.nombre} {cliente.apellidos}")

    id_cliente = input("Selecciona un id de cliente: ")
    for id_cli, cliente in clientes:
        if id_cliente == str(id_cli):
            return cliente
    print("ERROR: no has seleccionado un cliente válido")
    return nullcontext

def depositar_dinero(cliente):
    cantidad = int(input("Introduce la cantidad a depositar: "))
    cliente.depositar(cantidad)

def retirar_dinero(cliente):
    cantidad = int(input("Introduce la cantidad a retirar: "))
    cliente.retirar(cantidad)

def consultar_saldo(cliente):
    return cliente.balance

def limpiar_consola():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')

opcion = 0
cliente_seleccionado = nullcontext
while opcion != "6":
    print("Gestor de cuenta bancaria")
    print("[1] - Registrar Cliente")
    print("[2] - Seleccionar Cliente")
    print("[3] - Realizar deposito")
    print("[4] - Retirar saldo")
    print("[5] - Consultar saldo")
    print("[6] - Salir")
    if cliente_seleccionado != nullcontext:
        print("Cliente seleccionado actualmente:")
        print(cliente_seleccionado)

    opcion = input("Selecciona una opcion: ")

    match opcion:
        case "1":
            lista_clientes.append(registrar_cliente())
        case "2":
            cliente_seleccionado = seleccionar_cliente()
        case "3":
            if cliente_seleccionado != nullcontext:
                depositar_dinero(cliente_seleccionado)
            else:
                print("ERROR: No tienes seleccionado ningún cliente, no puedes realizar la operación")
        case "4":
            if cliente_seleccionado != nullcontext:
                retirar_dinero(cliente_seleccionado)
            else:
                print("ERROR: No tienes seleccionado ningún cliente, no puedes realizar la operación")
        case "5":
            if cliente_seleccionado != nullcontext:
                print(f"El saldo es de: {consultar_saldo(cliente_seleccionado)}€")
            else:
                print("ERROR: No tienes seleccionado ningún cliente, no puedes realizar la operación")
        case "6":
            print("¡Adios!")
        case __:
            print("ERROR: dato introducido no válido")

    input("Presione una tecla para continuar")
    limpiar_consola()

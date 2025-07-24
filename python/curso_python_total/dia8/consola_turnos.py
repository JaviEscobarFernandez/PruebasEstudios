import turnos

opcion = "0"
while opcion != "2":
    print("Bievenido a la consola para obtener su turno")
    print("[1] - Solicitar turno")
    print("[2] - Salir")
    opcion = input("Elija una opcion: ")
    match opcion:
        case "1":
            turnos.solicitar_turno()
        case "2":
            print("Adios")
        case __:
            print("ERROR - Dato introducido no válido")

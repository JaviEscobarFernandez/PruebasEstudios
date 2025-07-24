def generar_turno(seccion):
    turno_cosmetica = 0
    turno_farmacia = 0
    turno_perfumeria = 0
    while True:
        match seccion:
            case "1":
                turno_cosmetica += 1
                yield turno_cosmetica
            case "2":
                turno_farmacia += 1
                yield turno_farmacia
            case "3":
                turno_perfumeria += 1
                yield turno_perfumeria
            case __:
                yield -1

turno_cosmetica = generar_turno("1")
turno_farmacia = generar_turno("2")
turno_perfumeria = generar_turno("3")

def validar_seccion(seccion):
    match seccion:
        case "1":
            return True
        case "2":
            return True
        case "3":
            return True
        case __:
            return False

def generar_letra_seccion(seccion):
    match seccion:
        case "1":
            return "C"
        case "2":
            return "F"
        case "3":
            return "P"
        case __:
            return "-ERROR-"

def decorar_mensaje(funcion):
    def otra_funcion():
        print(f"Su turno es: {funcion()}")
        print("Aguarde y será atendido")
    return otra_funcion

@decorar_mensaje
def solicitar_turno():
    while True:
        print("[1] - Cosmetica")
        print("[2] - Farmacia")
        print("[3] - Perfumeria")
        seccion = input("Selecciona una secccion: ")
        if validar_seccion(seccion):
            numero_turno = 0
            match seccion:
                case "1":
                    numero_turno = next(turno_cosmetica)
                case "2":
                    numero_turno = next(turno_farmacia)
                case "3":
                    numero_turno = next(turno_perfumeria)
            return f"{generar_letra_seccion(seccion)}-{numero_turno}"

        print("ERROR: debes seleccionar una seccion existente")


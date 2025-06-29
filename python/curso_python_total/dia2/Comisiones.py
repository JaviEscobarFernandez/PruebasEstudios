nombre = input("Introduce tu nombre: ")
total_ventas = int(input("Introduce el total de ventas del mes: "))

valor_comision = 13
comision = round(total_ventas * valor_comision / 100, 2)
print(f"{nombre} ha vendido un total de {total_ventas}"
      f"\nAplicando la comisión del {valor_comision} % obtenemos: {comision}€")

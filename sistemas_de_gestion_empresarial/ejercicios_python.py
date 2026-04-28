'''
CASO Práctico
• Una empresa introduce productos en su ERP. Antes de guardar un producto, el sistema debe comprobar que el precio
sea correcto. Pide al usuario el precio de un producto y muestra si el precio es válido o inválido.
• Este ejemplo sirve para explicar validación de datos. En un ERP no se deberían guardar precios negativos o iguales a
cero.
Conceptos trabajados:
• input() para pedir datos.
• float() para convertir a número decimal.
• if / else para tomar decisiones.
• print() para mostrar el resultado
'''

def validarDatos(valor):
    if valor > 0:
        return True
    return False

valor = float(input("Introduce el precio del producto: "))
if (not validarDatos(valor)):
    print("El precio no es válido.")
else:
    print("Precio validado con éxito.")

'''
Una tienda usa un ERP para registrar ventas. El programa debe pedir el precio de un producto y la cantidad vendida.
Después debe calcular el total de la venta.
• Este ejemplo representa una operación muy habitual en un ERP: calcular importes.
Conceptos trabajados:
• Variables.
• Tipos numéricos: float e int.
• Operador de multiplicación *.
• Salida con print().
'''

def calcularTotalVenta(precio, cantidad):
    if precio <= 0 or cantidad <= 0:
        return 0
    return precio * cantidad
precio = float(input("Introduce el precio del producto: "))
cantidad = int(input("Introduce la cantidad vendida: "))
print(f"El total es: {calcularTotalVenta(precio, cantidad)}€")


'''
Mostrar una tabla de multiplicar. Una empresa quiere generar cálculos automáticos. El programa debe pedir un número y
mostrar su tabla de multiplicar del 1 al 10.
• Este ejemplo permite explicar el bucle for, que se utiliza cuando sabemos cuántas veces queremos repetir una acción.
Conceptos trabajados:
• for.
• range(1, 11).
• Multiplicación.
• Repetición controlada.
'''
def tablaMultiplicar(numero):
    print("La tabla de multiplicar de {numero} es: ")
    for i in range(1, 11):
        print(f"{numero} x {i} = {numero * i}")

numero = int(input("Introduce un número para obtener su tabla de multiplicar del 1 al 10: "))
tablaMultiplicar(numero)


'''
 Una empresa quiere saber cuántos productos tiene y verlos ordenados.
Conceptos trabajados:
• sort() → ordena la lista
• len() → cuenta elementos 
'''

productos = ["Pelota", "Raqueta", "Zapatillas", "Camiseta", "Pantalones"]
print("Imprimiendo lista de productos inicial:")
print(productos)
print("La cantidad de productos son: " + str(len(productos)))
productos.sort()
print("Imprimiendo lista de productos ordenada alfabeticamente")
print(productos)
print("Imprimiendo productos uno por uno:")
cont = 0
for p in productos:
    cont += 1
    print(f"{cont} - {p}")

from tkinter import *
import random
import datetime
from tkinter import filedialog, messagebox


# funcionalidad calculadora
operador = ""
precios_comida = [1.32, 1.65, 2.31, 3.22, 1.22, 1.99, 2.05, 2.65]
precios_bebidas = [0.25, 0.99, 1.21, 1.54, 1.08, 1.10, 2.00, 1.58]
precios_postres = [1.54, 1.68, 1.32, 1.97, 2.55, 2.14, 1.94, 1.74]


def click_boton(numero):
    global operador
    operador = operador + numero
    visor_calculadora.delete(0, END)
    visor_calculadora.insert(END, operador)

def borrar():
    global operador
    operador = ""
    visor_calculadora.delete(0, END)

def obtener_resultado():
    global operador
    resultado = str(eval(operador))
    visor_calculadora.delete(0, END)
    visor_calculadora.insert(0, resultado)
    operador = ""

# funcionalidad botones
def revisar_check():
    # comida
    x = 0
    for c in cuadros_comida:
        if variables_comida[x].get() == 1:
            cuadros_comida[x].config(state = NORMAL)
            if cuadros_comida[x].get() == "0":
                cuadros_comida[x].delete(0, END)
            cuadros_comida[x].focus()
        else:
            cuadros_comida[x].config(state = DISABLED)
            texto_comida[x].set("0")
        x += 1
    # bebida
    x = 0
    for c in cuadros_bebidas:
        if variables_bebidas[x].get() == 1:
            cuadros_bebidas[x].config(state = NORMAL)
            if cuadros_bebidas[x].get() == "0":
                cuadros_bebidas[x].delete(0, END)
            cuadros_bebidas[x].focus()
        else:
            cuadros_bebidas[x].config(state = DISABLED)
            texto_bebidas[x].set("0")
        x += 1
    # postres
    x = 0
    for c in cuadros_postres:
        if variables_postres[x].get() == 1:
            cuadros_postres[x].config(state = NORMAL)
            if cuadros_postres[x].get() == "0":
                cuadros_postres[x].delete(0, END)
            cuadros_postres[x].focus()
        else:
            cuadros_postres[x].config(state = DISABLED)
            texto_postres[x].set("0")
        x += 1

def total():
    # comida
    subtotal_comida = 0
    p = 0
    for cantidad in texto_comida:
        subtotal_comida = subtotal_comida + (float(cantidad.get()) * precios_comida[p])
        p += 1

    # bebidas
    subtotal_bebidas = 0
    p = 0
    for cantidad in texto_bebidas:
        subtotal_bebidas = subtotal_bebidas + (float(cantidad.get()) * precios_bebidas[p])
        p += 1

    # postres
    subtotal_postres = 0
    p = 0
    for cantidad in texto_postres:
        subtotal_postres = subtotal_postres + (float(cantidad.get()) * precios_postres[p])
        p += 1

    subtotal = subtotal_comida + subtotal_bebidas + subtotal_postres
    impuestos = subtotal * 0.07
    resultado_total = subtotal + impuestos

    var_factura_comida.set(f"€ {round(subtotal_comida, 2)}")
    var_factura_bebidas.set(f"€ {round(subtotal_bebidas, 2)}")
    var_factura_postres.set(f"€ {round(subtotal_postres, 2)}")
    var_factura_subtotal.set(f"€ {round(subtotal, 2)}")
    var_factura_impuestos.set(f"€ {round(impuestos, 2)}")
    var_factura_total.set(f"€ {round(resultado_total, 2)}")

# funcionalidad factura
def factura():
    texto_factura.delete(1.0, END)
    num_factura = f"N# - {random.randint(1000, 9999)}"
    fecha = datetime.datetime.now()
    fecha_factura = f"{fecha.day} / {fecha.month} / {fecha.year} - {fecha.hour} : {fecha.minute}"
    texto_factura.insert(END, f"Datos:\t{num_factura}\t\t{fecha_factura}\n")
    texto_factura.insert(END, f"*" * 63 + "\n")
    texto_factura.insert(END, f"Items\t\tCant.\tFactura Items\n")
    texto_factura.insert(END, f"-" * 75 + "\t")

    x = 0
    for c in texto_comida:
        if c.get() != "0" and c.get() != "":
            texto_factura.insert(END, f"{lista_comida[x]}\t\t{c.get()}\t"
                                      f"€ {int(c.get()) * precios_comida[x]}\n")
        x += 1

    x = 0
    for b in texto_bebidas:
        if b.get() != "0" and b.get() != "":
            texto_factura.insert(END, f"{lista_bebidas[x]}\t\t{b.get()}\t"
                                      f"€ {int(b.get()) * precios_bebidas[x]}\n")
        x += 1

    x = 0
    for p in texto_postres:
        if p.get() != "0" and p.get() != "":
            texto_factura.insert(END, f"{lista_postres[x]}\t\t{p.get()}\t"
                                      f"€ {int(p.get()) * precios_postres[x]}\n")
        x += 1

    texto_factura.insert(END, f"-" * 75 + "\n")
    texto_factura.insert(END, f"Factura de la comida: \t\t\t{var_factura_comida.get()}\n")
    texto_factura.insert(END, f"Factura de la bebida: \t\t\t{var_factura_bebidas.get()}\n")
    texto_factura.insert(END, f"Factura de los postres: \t\t\t{var_factura_bebidas.get()}\n")
    texto_factura.insert(END, f"-" * 75 + "\n")
    texto_factura.insert(END, f"Subtotal: \t\t\t{var_factura_subtotal.get()}\n")
    texto_factura.insert(END, f"Impuestos: \t\t\t{var_factura_impuestos.get()}\n")
    texto_factura.insert(END, f"Total: \t\t\t{var_factura_total.get()}\n")
    texto_factura.insert(END, f"-" * 75 + "\n")
    texto_factura.insert(END, "Lo esperamos pronto")

# generar fichero factura
def guardar():
    info_factura = texto_factura.get(1.0, END)
    archivo = filedialog.asksaveasfile(mode="w", defaultextension=".txt")
    archivo.write(info_factura)
    archivo.close()
    messagebox.showinfo("Información", "Su factura ha sido almacenada")

# reiniciar datos
def resetear():
    texto_factura.delete(0.1, END)
    for texto in texto_comida:
        texto.set("0")
    for texto in texto_bebidas:
        texto.set("0")
    for texto in texto_postres:
        texto.set("0")

    for cuadro in cuadros_comida:
        cuadro.config(state=DISABLED)
    for cuadro in cuadros_bebidas:
        cuadro.config(state=DISABLED)
    for cuadro in cuadros_postres:
        cuadro.config(state=DISABLED)

    for v in variables_comida:
        v.set(0)
    for v in variables_bebidas:
        v.set(0)
    for v in variables_postres:
        v.set(0)

    var_factura_comida.set("")
    var_factura_bebidas.set("")
    var_factura_postres.set("")
    var_factura_subtotal.set("")
    var_factura_impuestos.set("")
    var_factura_total.set("")


# iniciar tkinter
aplicacion = Tk()

# tamaño ventana
aplicacion.geometry("1020x630+0+0")

# impedir maximizar ventana
aplicacion.resizable(False, False)

# titulo ventana
aplicacion.title("Restaurante - Sistema de Facturación")

# color fondo ventana
aplicacion.config(bg="burlywood")

# panel superior
panel_superior = Frame(aplicacion, bd=1, relief="flat")
panel_superior.pack(side="top")

# etiqueta titulo
etiqueta_titulo = Label(panel_superior, text="Sistema de Facturación", fg="azure4",
                        font=("Dosis", 40), bg="burlywood", width=34)
etiqueta_titulo.grid(row=0, column=0)

# panel izquierdo
panel_izquierdo = Frame(aplicacion, bd=1, relief="flat")
panel_izquierdo.pack(side="left")

# panel factura
panel_factura = Frame(panel_izquierdo, bd=1, relief="flat", bg="azure4", padx=40)
panel_factura.pack(side="bottom")

# panel comida
panel_comida = LabelFrame(panel_izquierdo, text="Comida", font=("Dosis", 19, "bold"),
                            bd=1, relief="flat", fg="azure4")
panel_comida.pack(side="left")

# panel bebidas
panel_bebidas = LabelFrame(panel_izquierdo, text="Bebidas", font=("Dosis", 19, "bold"),
                            bd=1, relief="flat", fg="azure4")
panel_bebidas.pack(side="left")

# panel postres
panel_postres = LabelFrame(panel_izquierdo, text="Postres", font=("Dosis", 19, "bold"),
                            bd=1, relief="flat", fg="azure4")
panel_postres.pack(side="left")

# panel derecha
panel_derecha = Frame(aplicacion, bd=1, relief="flat")
panel_derecha.pack(side="right")

# panel calculadora
panel_calculadora = Frame(panel_derecha, bd=1, relief="flat", bg="burlywood")
panel_calculadora.pack()

# panel recibo
panel_recibo = Frame(panel_derecha, bd=1, relief="flat", bg="burlywood")
panel_recibo.pack()

# panel botones
panel_botones = Frame(panel_derecha, bd=1, relief="flat", bg="burlywood")
panel_botones.pack()

# lista de productos
lista_comida = ["pollo", "cordero", "salmon", "merluza", "kebab", "pizza1", "pizza2", "paella"]
lista_bebidas = ["agua", "coca-cola", "fanta-n", "fanta-l", "vino", "cerveza", "cerveza2", "cerveza3"]
lista_postres = ["flan", "helado", "manzana", "platano", "melón", "sandía", "tarta", "pastel"]

# generar items comida
variables_comida = []
cuadros_comida = []
texto_comida = []
contador = 0
for c in lista_comida:
    # crear checkbutton
    variables_comida.append("")
    variables_comida[contador] = IntVar()
    comida = Checkbutton(panel_comida,
                         text=c.title(),
                         font=("Dosis", 14, "bold"),
                         onvalue=1,
                         offvalue=0,
                         variable=variables_comida[contador],
                         command = revisar_check)
    comida.grid(row = contador, column = 0, sticky = W)

    # crear los cuadros de entrada
    cuadros_comida.append("")
    texto_comida.append("")
    texto_comida[contador] = StringVar()
    texto_comida[contador].set("0")
    cuadros_comida[contador] = Entry(panel_comida,
                                     font=("Dosis", 14, "bold"),
                                     bd = 1,
                                     width = 6,
                                     state = "disabled",
                                     textvariable = texto_comida[contador])
    cuadros_comida[contador].grid(row = contador, column = 1)

    contador += 1

# generar items bebidas
variables_bebidas = []
cuadros_bebidas = []
texto_bebidas = []
contador = 0
for c in lista_bebidas:
    # crear checkbutton
    variables_bebidas.append("")
    variables_bebidas[contador] = IntVar()
    bebidas = Checkbutton(panel_bebidas,
                          text=c.title(),
                          font=("Dosis", 14, "bold"),
                          onvalue=1,
                          offvalue=0,
                          variable=variables_bebidas[contador],
                          command = revisar_check)
    bebidas.grid(row = contador, column = 0, sticky = W)

    # crear los cuadros de entrada
    cuadros_bebidas.append("")
    texto_bebidas.append("")
    texto_bebidas[contador] = StringVar()
    texto_bebidas[contador].set("0")
    cuadros_bebidas[contador] = Entry(panel_bebidas,
                                     font=("Dosis", 14, "bold"),
                                     bd = 1,
                                     width = 6,
                                     state = "disabled",
                                     textvariable = texto_bebidas[contador])
    cuadros_bebidas[contador].grid(row = contador, column = 1)
    contador += 1

# generar items postres
variables_postres = []
cuadros_postres = []
texto_postres = []
contador = 0
for c in lista_postres:
    # crear checkbutton
    variables_postres.append("")
    variables_postres[contador] = IntVar()
    postres = Checkbutton(panel_postres,
                          text=c.title(),
                          font=("Dosis", 14, "bold"),
                          onvalue=1,
                          offvalue=0,
                          variable=variables_postres[contador],
                          command = revisar_check)
    postres.grid(row = contador, column = 0, sticky = W)

    # crear los cuadros de entrada
    cuadros_postres.append("")
    texto_postres.append("")
    texto_postres[contador] = StringVar()
    texto_postres[contador].set("0")
    cuadros_postres[contador] = Entry(panel_postres,
                                     font=("Dosis", 14, "bold"),
                                     bd = 1,
                                     width = 6,
                                     state = "disabled",
                                     textvariable = texto_postres[contador])
    cuadros_postres[contador].grid(row = contador, column = 1)
    contador += 1

# variables
var_factura_comida = StringVar()
var_factura_bebidas = StringVar()
var_factura_postres = StringVar()
var_factura_subtotal = StringVar()
var_factura_impuestos = StringVar()
var_factura_total = StringVar()

# etiquetas de factura y campos de entrada
etiqueta_factura_comida = Label(panel_factura,
                                text="Factura Comida",
                                font=("Dosis", 10, "bold"),
                                bg="azure4",
                                fg="white")
etiqueta_factura_comida.grid(row = 0, column = 0)

texto_factura_comida = Entry(panel_factura,
                             font=("Dosis", 10, "bold"),
                             bd=1,
                             width=10,
                             state="readonly",
                             textvariable=var_factura_comida)
texto_factura_comida.grid(row = 0, column = 1, padx=41)

etiqueta_factura_bebidas = Label(panel_factura,
                                text="Factura Bebida",
                                font=("Dosis", 10, "bold"),
                                bg="azure4",
                                fg="white")
etiqueta_factura_bebidas.grid(row = 1, column = 0)

texto_factura_bebidas = Entry(panel_factura,
                             font=("Dosis", 10, "bold"),
                             bd=1,
                             width=10,
                             state="readonly",
                             textvariable=var_factura_bebidas)
texto_factura_bebidas.grid(row = 1, column = 1, padx=41)

etiqueta_factura_postres = Label(panel_factura,
                                text="Factura Postres",
                                font=("Dosis", 10, "bold"),
                                bg="azure4",
                                fg="white")
etiqueta_factura_postres.grid(row = 2, column = 0)

texto_factura_postres = Entry(panel_factura,
                             font=("Dosis", 10, "bold"),
                             bd=1,
                             width=10,
                             state="readonly",
                             textvariable=var_factura_postres)
texto_factura_postres.grid(row = 2, column = 1, padx=41)

etiqueta_factura_subtotal = Label(panel_factura,
                                text="Subtotal",
                                font=("Dosis", 10, "bold"),
                                bg="azure4",
                                fg="white")
etiqueta_factura_subtotal.grid(row = 0, column = 2)

texto_factura_subtotal = Entry(panel_factura,
                             font=("Dosis", 10, "bold"),
                             bd=1,
                             width=10,
                             state="readonly",
                             textvariable=var_factura_subtotal)
texto_factura_subtotal.grid(row = 0, column = 3, padx=41)

etiqueta_factura_impuestos = Label(panel_factura,
                                text="Impuestos",
                                font=("Dosis", 10, "bold"),
                                bg="azure4",
                                fg="white")
etiqueta_factura_impuestos.grid(row = 1, column = 2)

texto_factura_impuestos = Entry(panel_factura,
                             font=("Dosis", 10, "bold"),
                             bd=1,
                             width=10,
                             state="readonly",
                             textvariable=var_factura_impuestos)
texto_factura_impuestos.grid(row = 1, column = 3, padx=41)

etiqueta_factura_total = Label(panel_factura,
                                text="Total",
                                font=("Dosis", 10, "bold"),
                                bg="azure4",
                                fg="white")
etiqueta_factura_total.grid(row = 2, column = 2)

texto_factura_total = Entry(panel_factura,
                             font=("Dosis", 10, "bold"),
                             bd=1,
                             width=10,
                             state="readonly",
                             textvariable=var_factura_total)
texto_factura_total.grid(row = 2, column = 3, padx=41)

# botones
botones = ["total", "recibo", "guardar", "resetear"]
botones_creados = []
columnas = 0
for b in botones:
    boton = Button(panel_botones,
                   text = b.title(),
                   font = ("Dosis", 14, "bold"),
                   fg = "white",
                   bg = "azure4",
                   bd = 1,
                   width = 8)
    botones_creados.append(boton)
    boton.grid(row = 0, column = columnas)
    columnas += 1

botones_creados[0].config(command = total)
botones_creados[1].config(command = factura)
botones_creados[2].config(command = guardar)
botones_creados[3].config(command = resetear)

# area de recibo
texto_factura = Text(panel_recibo,
                     font = ("Dosis", 12, "bold"),
                     bd = 1,
                     width = 42,
                     height = 10)
texto_factura.grid(row = 0, column = 0)

# calculadora
visor_calculadora = Entry(panel_calculadora,
                          font = ("Dosis", 12, "bold"),
                          width = 39,
                          bd = 1)
visor_calculadora.grid(row = 0, column = 0, columnspan = 8)

botones_calculadora = ["7", "8", "9", "+",
                       "4", "5", "6", "-",
                       "1", "2", "3", "x",
                       "=", "B", "0", "/"]
botones_guardados = []
fila = 1
columna = 0
for b in botones_calculadora:
    boton = Button(panel_calculadora,
                   text = b.title(),
                   font = ("Dosis", 12, "bold"),
                   fg = "white",
                   bg = "azure4",
                   bd = 1,
                   width = 8)
    botones_guardados.append(boton)

    boton.grid(row = fila, column = columna)
    if columna == 3:
        fila +=1

    columna += 1
    if columna == 4:
        columna = 0

botones_guardados[0].config(command = lambda : click_boton("7"))
botones_guardados[1].config(command = lambda : click_boton("8"))
botones_guardados[2].config(command = lambda : click_boton("9"))
botones_guardados[3].config(command = lambda : click_boton("+"))
botones_guardados[4].config(command = lambda : click_boton("4"))
botones_guardados[5].config(command = lambda : click_boton("5"))
botones_guardados[6].config(command = lambda : click_boton("6"))
botones_guardados[7].config(command = lambda : click_boton("-"))
botones_guardados[8].config(command = lambda : click_boton("1"))
botones_guardados[9].config(command = lambda : click_boton("2"))
botones_guardados[10].config(command = lambda : click_boton("3"))
botones_guardados[11].config(command = lambda : click_boton("*"))
botones_guardados[12].config(command = obtener_resultado)
botones_guardados[13].config(command = borrar)
botones_guardados[14].config(command = lambda : click_boton("0"))
botones_guardados[15].config(command = lambda : click_boton("/"))

# mantener la ventana abierta
aplicacion.mainloop()

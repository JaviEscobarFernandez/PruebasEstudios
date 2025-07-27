import datetime
mi_hora = datetime.time(17, 35)
print(type(mi_hora))
print(mi_hora)
print(mi_hora.minute)
print(mi_hora.hour)
print(mi_hora.microsecond)

mi_dia = datetime.date(2025, 10, 17)
print(mi_dia)
print(mi_dia.year)
print(mi_dia.ctime())
print(mi_dia.day)
print(mi_dia.today())

from datetime import datetime

mi_fecha = datetime(2025, 5, 15, 22, 10, 15, 2500)
mi_fecha = mi_fecha.replace(month = 11)
print(mi_fecha)

from datetime import date

nacimiento = date(1995, 3, 5)
defuncion = date(2095, 6, 19)
vida = defuncion - nacimiento
print(vida)
print(vida.days)

despierta = datetime(2022, 10, 5, 7, 30)
duerme = datetime(2022, 10, 5, 23, 45)
vigilia = duerme - despierta
print(vigilia.seconds)

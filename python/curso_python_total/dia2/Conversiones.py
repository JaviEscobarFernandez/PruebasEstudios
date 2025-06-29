num1 = 20
num2 = 30.5

print(type(num1))
print(type(num2))

num1 = num1 + num2
print(type(num1))
print(type(num2))

num1 = 5.8
print(num1)
print(type(num1))

num2 = int(num1)
print(num2)
print(type(num2))

edad = input("Dime tu edad: ")
edad = int(edad)
nueva_edad = 1 + edad
print("Cumplirás " + str(nueva_edad) + " años")
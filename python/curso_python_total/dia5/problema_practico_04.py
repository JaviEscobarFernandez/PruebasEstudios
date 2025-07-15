def contar_primos(num):
    if num == 0 or num == 1:
        print("Por convención el 0 y el 1 no se consideran primos.")
        return 0
    print(f"Calculando numeros primos en rango 0 - {num}")
    cont = 0
    for n in range(0, num + 1):
        if not es_primo(n):
            continue
        print(n)
        cont += 1
    return cont

def es_primo(num):
    if num <= 1:
        return False
    for n in range(2, num):
        if num % n == 0:
            return False
    return True

print(f"Total numeros primos: {contar_primos(2)}")
print(f"Total numeros primos: {contar_primos(1)}")
print(f"Total numeros primos: {contar_primos(2)}")
print(f"Total numeros primos: {contar_primos(8)}")
print(f"Total numeros primos: {contar_primos(9)}")
print(f"Total numeros primos: {contar_primos(11)}")
print(f"Total numeros primos: {contar_primos(50)}")

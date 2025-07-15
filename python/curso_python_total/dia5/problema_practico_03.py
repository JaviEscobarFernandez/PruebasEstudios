def buscar_doble_cero(*args):
    ceros = 0
    for n in args:
        if ceros > 1:
            break
        if n == 0:
            ceros += 1
            continue
        ceros = 0
    return True if ceros > 1 else False

print(buscar_doble_cero(1, 40, 3, 0, 2, 1, 0, 3, 4, 50))
print(buscar_doble_cero(1, 2, 3, 0, 0, 4, 5, 1))

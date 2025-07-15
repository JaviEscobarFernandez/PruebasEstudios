def devolver_distintos(num1, num2, num3):
    total = num1 + num2 + num3
    lista = [num1, num2, num3]
    max = num1
    min = num1
    inter = num1
    for n in lista:
        if n > max:
            max = n
        elif n < min:
            min = n
        else:
            inter = n
    if total > 15:
        return max
    elif total < 10:
        return min
    return inter

print(devolver_distintos(10, 2, 3))

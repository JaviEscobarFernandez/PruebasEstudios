mi_tuple = (1, 2, 3, 4)
print(type(mi_tuple))
print(mi_tuple)

mi_tuple = 1, 2, 3, 4
print(type(mi_tuple))
print(mi_tuple)

t = (1, 2, 3, "Hola", "Mundo")
print(t)

print(mi_tuple[-2])

# mi_tuple[0] = 10
# print(mi_tuple)

mi_tuple = (1, 2, (10, 20), 4, (100, 200, 300), 1)
print(mi_tuple)
print(mi_tuple[2][0])
print(mi_tuple[4][2])

t = (1, 2, 3)
x, y, z = t
print(x, y, z)

t = (1, 2, 3, 1)
print(len(t))
print(t.count(1))
print(t.index(2))

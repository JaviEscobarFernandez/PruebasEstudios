mi_set = set([1, 2, 3, 4, 5])
print(type(mi_set))
print(mi_set)

otro_set = { 1, 2, 3, 4, 5, 6 }
print(type(otro_set))
print(otro_set)

mi_set = { 1, "a", (1, 2, 3, 4), 1, 2, 2, 3, 4, 4, 3, 5, 5 }
print(mi_set)

mi_set = { 1, 2, 3, 4, 5 }
print(len(mi_set))
print(2 in mi_set)

s1 = { 1, 2, 3 }
s2 = { 3, 4, 5 }
s3 = s1.union(s2)
print(s3)

s1.add(4)
s1.add(2)
s1.remove(3)
s1.discard(3)
s1.pop()
s1.clear()
print(s1)


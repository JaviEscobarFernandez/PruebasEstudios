# Ejercicio 1
codigo = ",:_#,,,,,,:::____##Pyt%on_ _Total,,,,,,::#"
codigo2 = codigo.lstrip(',:%_# ')
print(codigo2)

# Ejercicio 2
frutas = ["mango", "banana", "cereza", "ciruela", "pomelo"]
frutas.insert(3, "naranja")
print(frutas)

# Ejercicio 3
marcas_smartphones = {"Samsung", "Xiaomi", "Apple", "Huawei", "LG"}
marcas_tv = {"Sony", "Philips", "Samsung", "LG"}
conjuntos_aislados = marcas_smartphones.isdisjoint(marcas_tv)
print(conjuntos_aislados)

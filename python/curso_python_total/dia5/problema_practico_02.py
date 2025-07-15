def orden_unico_alfabetico(palabra):
    palabra_set = set(palabra)
    lista_palabra = list(palabra_set)
    lista_palabra.sort()
    return lista_palabra

print(orden_unico_alfabetico("entretenido"))

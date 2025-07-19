from pathlib import Path

guia = Path("Barcelona", "Sagrada_Familia")
print(guia)

guia = Path("Barcelona", "Sagrada_Familia.txt")
print(guia)

base = Path.home()
guia = Path("Barcelona", "Sagrada_Familia.txt")
print(base)
print(guia)

guia = Path(base, "Barcelona", "Sagrada_Familia.txt")
print(guia)

guia = Path(base, "Europa", "España", Path("Barcelona", "Sagrada_Familia.txt"))
print(guia)

guia2 = guia.with_name("La_Pedrera.txt")
print(guia)
print(guia2)
print(guia.parent)
print(guia.parent.parent)
print(guia.parent.parent.parent)

guia = Path(Path.home(), "Europa")
for txt in Path(guia).glob("*.txt"):
    print(txt)

for txt in Path(guia).glob("**/*.txt"):
    print(txt)

guia = Path("Europa", "España", "Barcelona", "Sagrada_Familia.txt")
en_europa = guia.relative_to(Path("Europa"))
en_esp = guia.relative_to(Path("Europa", "España"))
print(en_europa)
print(en_esp)

import pygame
import random
import math
import io
from pygame import mixer

# Metodo para convertir fuente a bytes
def fuente_to_bytes(f):
    with open(f, "rb") as f:
        ttf_bytes = f.read()
        return io.BytesIO(ttf_bytes)

# Inicializar Pygame
pygame.init()

# Crear la pantalla
pantalla = pygame.display.set_mode((800, 600))

# Titulo, Icono y fondo
pygame.display.set_caption("Invasión Espacial")
icono = pygame.image.load("imagenes/ovni.png")
pygame.display.set_icon(icono)
fondo = pygame.image.load("imagenes/fondo.jpg")

# Musica
mixer.music.load("sonidos/MusicaFondo.mp3")
mixer.music.set_volume(0.3)
mixer.music.play(-1)

# Jugador
img_jugador = pygame.image.load("imagenes/cohete.png")
jugador_posX = 368
jugador_posY = 500
jugador_posX_cambio = 0

# Enemigos
img_enemigo = []
enemigo_posX = []
enemigo_posY = []
enemigo_posX_cambio = []
enemigo_posY_cambio = []
cantidad_enemigos = 8

# Enemigo
for e in range(cantidad_enemigos):
    img_enemigo.append(pygame.image.load("imagenes/enemigo.png"))
    enemigo_posX.append(random.randint(0, 736))
    enemigo_posY.append(random.randint(50, 200))
    enemigo_posX_cambio.append(0.5)
    enemigo_posY_cambio.append(50)

# Proyectiles
img_bala = []
bala_posX = []
bala_posY = []
bala_posX_cambio = []
bala_posY_cambio = []
bala_visible = []
cantidad_municion = 3

# Proyectil
for p in range(cantidad_municion):
    img_bala.append(pygame.image.load("imagenes/bala.png"))
    bala_posX.append(0)
    bala_posY.append(500)
    bala_posX_cambio.append(0)
    bala_posY_cambio.append(3)
    bala_visible.append(False)

# Puntuacion
puntuacion = 0
fuente_en_bytes = fuente_to_bytes("fuentes/FreeSansBold.ttf")
fuente = pygame.font.Font(fuente_en_bytes, 32)
texto_posX = 10
texto_posY = 10

# Texto final del juego
fuente_final = pygame.font.Font(fuente_en_bytes, 42)

def texto_final():
    mi_fuente_final = fuente_final.render("JUEGO TERMINADO", True, (255, 255, 255))
    pantalla.blit(mi_fuente_final, (220, 200))

# Funcion mostrar puntuacion
def mostrar_puntuacion(x:int, y:int):
    texto = fuente.render(f"Puntuación: {puntuacion}", True, (255, 255, 255))
    pantalla.blit(texto, (x, y))

# Funcion jugador
def jugador(pos_x:int, pos_y:int):
    pantalla.blit(img_jugador, (pos_x, pos_y))

# Funcion enemigo
def enemigo(pos_x:int, pos_y:int, en):
    pantalla.blit(img_enemigo[en], (pos_x, pos_y))

# Funcion disparar bala
def disparar_bala(x, y, cont:int):
    bala_visible[cont] = True
    pantalla.blit(img_bala[cont], (x + 16, y + 10))

# Funcion detectar colisiones
def hay_colision(pos_x_1, pos_y_1, pos_x_2, pos_y_2):
    distancia = math.sqrt(math.pow(pos_x_2 - pos_x_1, 2) + math.pow(pos_y_2 - pos_y_1, 2))
    if distancia < 27:
        return True
    return False

# Loop del juego
en_ejecucion = True
while en_ejecucion:

    # Color pantalla
    # pantalla.fill((205, 144, 228))
    # Fondo pantalla
    pantalla.blit(fondo, (0, 0))

    # Manejar eventos
    for evento in pygame.event.get():
        # Salir del juego
        if evento.type == pygame.QUIT:
            en_ejecucion = False

        # Evento presionar teclas
        if evento.type == pygame.KEYDOWN:
            # Movimiento del jugador
            if evento.key == pygame.K_LEFT:
                jugador_posX_cambio = -0.5
            if evento.key == pygame.K_RIGHT:
                jugador_posX_cambio = 0.5
            # Manejo de los proyectiles
            if evento.key == pygame.K_SPACE:
                for bala in range(cantidad_municion):
                    if not bala_visible[bala]:
                        sonido_bala = mixer.Sound("sonidos/disparo.mp3")
                        sonido_bala.play()
                        bala_posX[bala] = jugador_posX
                        disparar_bala(bala_posX[bala], bala_posY[bala], bala)
                        break

        # Evento soltar teclas
        if evento.type == pygame.KEYUP:
            if evento.key == pygame.K_LEFT or evento.key == pygame.K_RIGHT:
                jugador_posX_cambio = 0

    # Actualizar posicion del jugador
    jugador_posX += jugador_posX_cambio

    # Manejar limites pantalla en el movimiento del jugador
    if jugador_posX <= 0:
        jugador_posX = 0
    elif jugador_posX >= 736:
        jugador_posX = 736

    # Movimiento bala
    for bala in range(cantidad_municion):
        if not bala_visible[bala]:
            continue
        if bala_posY[bala] <= -64:
            bala_posY[bala] = 500
            bala_visible[bala] = False
        else:
            disparar_bala(bala_posX[bala], bala_posY[bala], bala)
            bala_posY[bala] -= bala_posY_cambio[bala]

    # Actualizar posicion del enemigo
    for e in range(cantidad_enemigos):
        # Fin del juego
        if enemigo_posY[e] > 500:
            for k in range(cantidad_enemigos):
                enemigo_posY[k] = 1000
            texto_final()
            break
        enemigo_posX[e] += enemigo_posX_cambio[e]

        # Manejar limites pantalla en el movimiento del jugador
        if enemigo_posX[e] <= 0:
            enemigo_posX_cambio[e] = 0.5
            enemigo_posY[e] += enemigo_posY_cambio[e]
        elif enemigo_posX[e] >= 736:
            enemigo_posX_cambio[e] = -0.5
            enemigo_posY[e] += enemigo_posY_cambio[e]

        # Manejar colisiones
        for bala in range(cantidad_municion):
            if hay_colision(enemigo_posX[e], enemigo_posY[e], bala_posX[bala], bala_posY[bala]):
                sonido_colision = mixer.Sound("sonidos/golpe.mp3")
                sonido_colision.play()
                bala_posY[bala] = 500
                bala_visible[bala] = False
                puntuacion += 1
                enemigo_posX[e] = random.randint(0, 736)
                enemigo_posY[e] = random.randint(50, 200)

        # Aplicar nueva posicion
        enemigo(enemigo_posX[e], enemigo_posY[e], e)

    # Aplicar nueva posicion
    jugador(jugador_posX, jugador_posY)

    # Aplicar puntuacion
    mostrar_puntuacion(texto_posX, texto_posY)

    # Actualizar en cada iteracion
    pygame.display.update()

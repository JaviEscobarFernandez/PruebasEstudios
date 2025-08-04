import pyttsx3
import speech_recognition as sr
import pywhatkit
import yfinance as yf
import pyjokes
import webbrowser
import datetime
import wikipedia

# variables para la direccion del audio del asistente
idHelena = r"HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0"
idZira = r"HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_EN-US_ZIRA_11.0"

# escuchar nuestro microfono y devolver el audio como texto
def transformar_audio_en_texto():
    # almacenar el recognizer en una variable
    r = sr.Recognizer()

    # configurar el microfono
    with sr.Microphone() as origen:
        # tiempo de espera
        r.pause_threshold = 1.8

        # informar que la grabacion ha comenzado
        print("Ya puedes hablar")

        # almacenar lo que escuche como audio
        audio = r.listen(origen)

        try:
            pedido = r.recognize_google(audio, language="es-ES")

            # verificar que ha recibido los datos
            print(f"Has dicho: {pedido}")

            # devolver pedido
            return pedido
        # en caso de no comprender el audio
        except sr.UnknownValueError:
            print("No entendí lo que dijiste")
            # devolver error
            return "sigo esperando"
        # en caso de no poder resolver el pedido
        except sr.RequestError:
            print("No entendí lo que dijiste")
            # devolver error
            return "sigo esperando"
        # error inesperado
        except:
            print("Algo va mal")
            # devolver error
            return "sigo esperando"

# funcion para que el asistente pueda ser escuchado
def hablar(mensaje, voz):
    # encender el motor de pyttsx3
    engine = pyttsx3.init()
    engine.setProperty("voice", voz)

    # pronunciar mensaje
    engine.say(mensaje)
    engine.runAndWait()

# informar el dia de la semana
def pedir_dia():
    # crear variable con datos de hoy
    dia = datetime.date.today()

    # crear variable para el dia de la semana
    dia_semana = dia.weekday()

    # diccionario con nombres de dias
    calendario = { 0: "Lunes",
                   1: "Martes",
                   2: "Miércoles",
                   3: "Jueves",
                   4: "Viernes",
                   5: "Sábado",
                   6: "Domingo"}
    # decir el dia de la semana
    hablar(f"hoy es {calendario[dia_semana]}", idHelena)

# informar que hora es
def pedir_hora():
    # crear una variable con datos de la hora
    hora = datetime.datetime.now()
    hora = f"En este momento son las { hora.hour} horas con {hora.minute} minutos y {hora.second} segundos"

    # decir la hora
    hablar(hora, idHelena)

# funcion saludo inicial
def saludo_inicial():
    # crear variable con datos de hora
    hora = datetime.datetime.now()
    if hora.hour < 6 or hora.hour > 20:
        momento = "Buenas noches"
    elif 6 <= hora.hour < 13:
        momento = "Buenos días"
    else:
        momento = "Buenas tardes"

    # decir el saludo
    hablar(f"{momento}, soy Helena, tu asistente personal. Por favor, dime en que puedo ayudarte.", idHelena)

# funcion central del asistente
def pedir_cosas():
    # activar saludo inicial
    saludo_inicial()

    # variable de corte
    comenzar = True

    # loop central
    while comenzar:
        # activar el micro y guardar la solicitud en un string
        pedido = transformar_audio_en_texto().lower()
        if "abrir youtube" in pedido:
            hablar("Ahora mismo, voy a abrir YouTube", idHelena)
            webbrowser.open("https://www.youtube.com")
            continue
        elif "abrir navegador" in pedido:
            hablar("Ahora mismo, voy a abrir el navegador", idHelena)
            webbrowser.open("https://www.google.com")
            continue
        elif "que día es hoy" in pedido:
            pedir_dia()
            continue
        elif "que hora es" in pedido:
            pedir_hora()
            continue
        elif "busca en wikipedia" in pedido:
            hablar("Buscando lo solicitado en wikipedia", idHelena)
            pedido = pedido.replace("busca en wikipedia", "")
            wikipedia.set_lang("es")
            resultado = wikipedia.summary(pedido, sentences = 1)
            hablar("Wikipedia dice lo siguiente:", idHelena)
            hablar(resultado, idHelena)
            continue
        elif "busca en internet" in pedido:
            hablar("Vamos a ello", idHelena)
            pedido = pedido.replace("busca en internet", "")
            pywhatkit.search(pedido)
            hablar("Esto es lo que he encontrado", idHelena)
            continue
        elif "reproducir" in pedido:
            hablar("Buena idea, vamos a reproducirlo", idHelena)
            pywhatkit.playonyt(pedido)
            continue
        elif "broma" in pedido:
            hablar(pyjokes.get_joke("es"), idHelena)
            continue
        elif "precio de las acciones" in pedido:
            accion = pedido.split("de")[-1].strip()
            cartera = { "apple":"APPL",
                        "amazon":"AMZN",
                        "google":"GOOGL" }
            try:
                accion_buscada = cartera[accion]
                accion_buscada = yf.Ticker(accion_buscada)
                precio_actual = accion_buscada.info["regularMarketPrice"]
                hablar(f"Localizada, el precio de {accion} es {precio_actual}", idHelena)
                continue
            except:
                hablar("No he conseguido localizarla", idHelena)
                continue
        elif "adiós" in pedido:
            hablar("Me voy a descansar, cualquier cosa me avisas", idHelena)
            break

pedir_cosas()

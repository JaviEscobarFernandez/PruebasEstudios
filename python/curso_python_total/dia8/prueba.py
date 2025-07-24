import unittest
import cambia_texto

class ProbarCambiaTexto(unittest.TestCase):
    def test_mayusculas(self):
        palabra = "Buenos días"
        resultado = cambia_texto.todo_mayusculas(palabra)
        self.assertEqual(resultado, "BUENOS DÍAS")

if __name__ == "__main__":
    unittest.main()

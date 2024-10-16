using System;

namespace Practicando
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Ejercicio calcular superficie y volumen de una esfera en base a su radio
            Console.WriteLine("Introduce un numero (el radio) para calcular la superficie y el volumen de una esfera:");
            int radio = 0;
            if (!int.TryParse(Console.ReadLine(), out radio))
            {
                Console.WriteLine("Dato introducido no válido.");
                return;
            }
            // Con Math.PI obtenemos el valor de PI.
            // Con Math.Pow elevamos el valor, en este caso al cuadrado(2) y al cubo(3).
            double superficie = 4 * Math.PI * Math.Pow(radio, 2);
            double volumen = 4 / 3 * Math.PI * Math.Pow(radio, 3);
            Console.WriteLine("La superficie de dicha esfera es:" + superficie + " y el volumen es:" + volumen);
            Calculadora();
            Rectangulo();
        }

        static void Calculadora()
        {
            // Introducir 2 numeros y realizar suma / resta / multiplicacion / division / resto y mostrarlos por pantalla los resultados.
            int firstNumber = 0;
            Console.WriteLine("Introduce dos numeros y realizaré con ellos las operaciones básicas de una calculadora.\nIntroduce el primer número:");
            if (!int.TryParse(Console.ReadLine(), out firstNumber))
            {
                Console.WriteLine("Dato introducido no válido.");
                return;
            }
            int secondNumber = 0;
            Console.WriteLine("Muy bien, ahora el segundo:");
            if (!int.TryParse(Console.ReadLine(), out secondNumber))
            {
                Console.WriteLine("Dato introducido no válido.");
                return;
            }
            int suma = firstNumber + secondNumber;
            int resta = firstNumber - secondNumber;
            int multiplicacion = firstNumber * secondNumber;
            int division = (secondNumber > 0) ? firstNumber / secondNumber : 0; // Para evitar dividir entre 0
            int resto = firstNumber % secondNumber;
            Console.WriteLine("Aqui los resultados:\nSuma: " + suma + "\nResta: " + resta + "\nMultiplicación: " + multiplicacion + "\nDivisión: " + division + "\nResto: " + resto);
        }

        static void Rectangulo()
        {
            // Solicitar el ancho (x) y la altura (y) de un rectángulo y calcular el perímetro, el área y la diagonal.
            int altura = 0;
            Console.WriteLine("Hola, vamos a calcular el perimetro, el área y la diagonal de un rectángulo.\nIntroduce su altura:");
            if (!int.TryParse(Console.ReadLine(), out altura))
            {
                Console.WriteLine("Dato introducido no válido.");
                return;
            }
            int baseRectangulo = 0;
            Console.WriteLine("Introduce su base:");
            if (!int.TryParse (Console.ReadLine(), out baseRectangulo))
            {
                Console.WriteLine("Dato introducido no válido.");
                return;
            }
            float area = baseRectangulo * altura;
            float perimetro = (baseRectangulo * 2) + (altura * 2);
            double diagonal = Math.Sqrt(Math.Pow(altura, 2) + Math.Pow(baseRectangulo, 2));
            Console.WriteLine("El área es: " + area + " el perímetro es: " + perimetro + " la diagonal es: " + diagonal);
        }
    }
}

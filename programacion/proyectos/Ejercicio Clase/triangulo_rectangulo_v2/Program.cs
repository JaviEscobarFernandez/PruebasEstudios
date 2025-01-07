using System;

namespace triangulo_rectangulo_v2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
             * Implementa con código sobre el editor una solución que cumpla con las siguientes especificaciones:
             * Se solicita por consola 1 número enteros. Se guardan sobre la variable "cateto".
             * Valida que el número sea mayor que 0.
             * Dibuja en salida un triángulo rectángulo con asteriscos. La longitud de los catetos (lados) deber ser la indicada por entrada
             * El triángulo resultante deberá tener su ángulo recto en la esquina superior izquierda:
            */

            Console.WriteLine("-----------------------------");
            Console.WriteLine("-    Triángulo rectángulo   -");
            Console.WriteLine("-----------------------------");
            int cateto = 0;
            do
            {
                Console.Write("Introduce un número que será la longitud del cateto: ");
                cateto = ValidarNumero(Console.ReadLine());
            }
            while (cateto <= 0);

            // Hago añadido extra de dar la posibilidad de mostrarlo al derecho o invertido.
            bool invertido = false;
            Console.WriteLine("¿Quieres mostrar el triángulo de arriba a abajo o a la inversa?");
            Console.Write("Pulsa N para invertirlo, cualquier otra tecla para mantenerlo normal: ");
            if (Console.ReadLine().ToUpper() == "N")
                invertido = true;
            ImprimirTrianguloRectangulo(cateto, invertido);
        }

        static int ValidarNumero(string datos)
        {
            int num = 0;
            if (!int.TryParse(datos, out num))
            {
                Console.WriteLine("ERROR: Dato introducido no válido.");
                return 0;
            }
            if (num <= 0 || num > 25)
            {
                Console.WriteLine("ERROR: Introduce un número entero entre 1 y 25.");
                num = 0;
            }
            return num;
        }

        static void ImprimirTrianguloRectangulo(int cateto, bool invertido)
        {
            Console.WriteLine();

            for (int i = 0; i < cateto; i++)
            {
                if (invertido)
                {
                    for (int j = cateto; j > i; j--)
                        Console.Write(" *");
                }
                else
                {
                    for (int j = 0; j <= i; j++)
                        Console.Write(" *");
                }
                Console.WriteLine();
            }
        }
    }
}

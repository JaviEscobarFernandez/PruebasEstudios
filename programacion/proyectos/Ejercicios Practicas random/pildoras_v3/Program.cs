using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pildorasv3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // BucleWhilePrueba();
            // BucleDoWhilePrueba();

            // Generar numero aleatorio entre 0 y 100.
            Random numero = new Random();
            int numeroAleatorio = numero.Next(0, 101);
            bool acierto = false;
            Console.WriteLine("Hola, vamos a jugar a ver si aciertas que numero estoy pensando del 0 al 100.");
            do
            {
                // Preguntar que numero es
                Console.WriteLine("Dime, ¿que numero crees que es?");

                // Validar dato introducido.
                int respuesta = 0;
                if (!int.TryParse(Console.ReadLine(), out respuesta))
                    respuesta = -1;

                if (respuesta < 0 || respuesta > 100)
                {
                    Console.WriteLine("Dato indicado no válido, debe ser un numero entero del 0 al 100.");
                    continue;
                }

                // Si acertamos, lo indica, sino, nos idica si es mayor o menor.
                if (respuesta == numeroAleatorio)
                {
                    Console.WriteLine("¡Felicidades! Has acertado, el número era: {0}", numeroAleatorio);
                    acierto = true;
                }
                else if (respuesta < numeroAleatorio)
                    Console.WriteLine("No, el número aleatorio es mayor que {0}.", respuesta);
                else
                    Console.WriteLine("No, el número aleatorio es menor que {0}.", respuesta);
            }
            while (!acierto);
        }

        static void BucleWhilePrueba()
        {
            Console.WriteLine("¿Deseas entrar al bucle while?");
            string respuesta = Console.ReadLine().ToLower();

            while (respuesta != "no")
            {
                Console.WriteLine("Estamos dentro del bucle while.");
                Console.Write("Introduce tu nombre, por favor: ");
                string nombre = Console.ReadLine();
                Console.WriteLine($"{nombre}, puedes salir del bucle cuando respondas no.");
                Console.WriteLine("¿Quieres repetir el bucle de nuevo?");
                respuesta = Console.ReadLine().ToLower();
            }
        }

        static void BucleDoWhilePrueba()
        {
            int z = 10;
            // nunca se ejecutará while, porque no puede entrar.
            while (z < 10)
            {
                Console.WriteLine("Dentro del while. {0}", z);
                z++;
            }
            // Aquí entrará al menos una vez aunque no se cumpla la condicion.
            do
            {
                Console.WriteLine("Dentro del do while. {0}", z);
                z++;
            }
            while (z < 10);
        }
    }
}

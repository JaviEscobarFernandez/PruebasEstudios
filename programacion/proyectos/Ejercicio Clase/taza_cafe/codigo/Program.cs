using System;

namespace taza_cafe
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hola, vamos a servir una taza de café.");

            // Comprobar si hay café hecho, si lo hay lo calentamos, de lo contrario lo preparamos.
            ComprobarCafe();

            Console.WriteLine("\nYa está el café listo, servimos el café en una taza.\n");

            // Vamos a condimentarlo.
            CondimentarCafe();

            Console.WriteLine("\nDisfruta del café ;)");
        }

        static void ComprobarCafe()
        {
            string respuesta = "N";
            do
            {
                Console.Write("¿Hay café hecho? responde (S/N): ");
                respuesta = Console.ReadLine().ToUpper();
                Console.WriteLine();
                switch (respuesta)
                {
                    case "S":
                        Console.WriteLine("Genial, vamos a calentarlo.");
                        break;
                    case "N":
                        Console.WriteLine("Vaya por dios, vamos a prepararlo.");
                        break;
                    default:
                        Console.WriteLine("ERROR: Dato introducido no valido.");
                        break;
                }
            }
            while (respuesta != "S" && respuesta != "N");
        }

        static void CondimentarCafe()
        {
            string respuesta = "1";
            do
            {
                Console.WriteLine("¿Deseas añadir algo al café?");
                Console.WriteLine("1 - Añadir leche.");
                Console.WriteLine("2 - Añadir azúcar.");
                Console.WriteLine("3 - Así esta bien, gracias.");
                Console.WriteLine();
                respuesta = Console.ReadLine().ToUpper();
                switch (respuesta)
                {
                    case "1":
                        Console.WriteLine("Genial, añadimos leche.");
                        break;
                    case "2":
                        Console.WriteLine("Vamos con un poco de azúcar, no seas golosón.");
                        break;
                    case "3":
                        Console.WriteLine("Excelente.");
                        break;
                    default:
                        Console.WriteLine("ERROR: Dato introducido no valido.");
                        break;
                }
            }
            while (respuesta != "3");
        }
    }
}

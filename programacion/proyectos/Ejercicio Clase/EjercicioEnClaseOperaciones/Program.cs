using System;

namespace EjercicioEnClase
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Ejercicio Saludo nombre
            // Console.WriteLine("Hola, ¿Como te llamas?");
            // string name = Console.ReadLine();
            // Console.WriteLine("Hola " + name);
            // Console.ReadKey();

            // Ejercicio operaciones con dos numeros:
            //int a = 4; int b = 2;
            //int resultado = a + b;
            //// Suma
            //Console.WriteLine("Resultado: " + resultado);
            //Console.WriteLine("Resultado: " + a + b); // Al estar sin parentesis concatena los valores, no los suma
            //Console.WriteLine("Suma: " + (a + b)); // Si estuviese sin parentesis generaria concatenacion de strings
            //// Resta
            //Console.WriteLine("Resta: " + (a - b)); // Si estuviese sin parentesis generaria concatenacion de strings
            //// Multiplicacion
            //Console.WriteLine("Multiplicacion: " + (a * b)); // Si estuviese sin parentesis generaria concatenacion de strings
            //// Division
            //Console.WriteLine("Division: " + (a / b)); // Si estuviese sin parentesis generaria concatenacion de strings
            //// Resto o modulo
            //Console.WriteLine("Resto o modulo: " + (a % b)); // Si estuviese sin parentesis generaria concatenacion de strings

            // Ejercicio operaciones con dos numeros v2:
            //Console.Write("Escribe el operando 1: ");
            //int a = int.Parse(Console.ReadLine());
            //Console.Write("Escribe el operando 2: ");
            //int b = int.Parse(Console.ReadLine());

            //int resultado = a + b;
            //// Suma
            //Console.WriteLine("Resultado: " + resultado);
            //Console.WriteLine("Resultado: " + a + b);
            //Console.WriteLine("Suma: " + (a + b));
            //// Resta
            //Console.WriteLine("Resta: " + (a - b));
            //// Multiplicacion
            //Console.WriteLine("Multiplicacion: " + (a * b));
            //// Division
            //Console.WriteLine("Division: " + (a / b));
            //// Resto o modulo
            //Console.WriteLine("Resto o modulo: " + (a % b));

            // Ejercicio operaciones con dos numeros v3:
            //Console.Write("Escribe el operando 1: ");
            //int a = int.Parse(Console.ReadLine());
            //Console.Write("Escribe el operando 2: ");
            //int b = int.Parse(Console.ReadLine());

            //Console.Write("Elige una opcion:");
            //string opcion = Console.ReadLine();
            //opcion = opcion.ToLower();
            //int resultado = a + b;
            //switch (opcion)
            //{
            //    case "suma":
            //        Console.WriteLine("Suma: " + (a + b));
            //        break;
            //    case "resta":
            //        Console.WriteLine("Resta: " + (a - b));
            //        break;
            //    case "multiplicacion":
            //        Console.WriteLine("Multiplicacion: " + (a * b));
            //        break;
            //    case "division":
            //        Console.WriteLine("Division: " + (a / b));
            //        break;
            //    case "resto":
            //        Console.WriteLine("Resto: " + (a % b));
            //        break;
            //    default:
            //        Console.WriteLine("Error" );
            //        break;
            //}

            // Ejercicio operaciones con dos numeros v4:
            string opcion;
            Console.WriteLine("Hola, introduce dos numeros enteros y una opcion para calcularlos.");
            do
            {
                Console.Write("Escribe el operando 1: ");
                int a = int.Parse(Console.ReadLine());
                Console.Write("Escribe el operando 2: ");
                int b = int.Parse(Console.ReadLine());

                Console.WriteLine("Opciones disponibles:\nSuma\nResta\nMultiplicacion\nDivision\nResto");
                Console.Write("Elige una opcion, si quieres salir escribe finalizar: ");
                opcion = Console.ReadLine();
                opcion = opcion.ToLower();
                int resultado = a + b;
                switch (opcion)
                {
                    case "suma":
                        Console.WriteLine("Suma: " + (a + b));
                        break;
                    case "resta":
                        Console.WriteLine("Resta: " + (a - b));
                        break;
                    case "multiplicacion":
                        Console.WriteLine("Multiplicacion: " + (a * b));
                        break;
                    case "division":
                        Console.WriteLine("Division: " + (a / b));
                        break;
                    case "resto":
                        Console.WriteLine("Resto: " + (a % b));
                        break;
                    case "finalizar":
                        Console.WriteLine("¡Nos vemos!");
                        break;
                    default:
                        Console.WriteLine("Error");
                        break;
                }
            } while (opcion != "finalizar");
        }
    }
}

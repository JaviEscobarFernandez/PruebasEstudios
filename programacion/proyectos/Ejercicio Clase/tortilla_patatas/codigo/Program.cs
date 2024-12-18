using System;

namespace tortilla_patatas
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hola, vamos a cocinar una tortilla de patatas.");
            Console.WriteLine("\n1 - Lo primero que debemos hacer es pelar las patatas.");
            Console.WriteLine("\n2 - Una vez hemos terminado, calentamos el aceite en una sartén.");

            // Comprobamos si el aceite está caliente
            RealizarAccion("¿Está caliente el aceite?");

            Console.WriteLine("\n3 - Vamos a cocinar las patatas en el aceite.");

            // Comprobamos si las patatas están cocinadas
            RealizarAccion("¿Están tiernas las patatas?");

            Console.WriteLine("\n4 - Ahora escurrimos las patatas para quitar el exceso de aceite.");
            Console.WriteLine("\n5 - Seguimos batiendo los huevos.");
            Console.WriteLine("\n6 - Mezclamos los huevos batidos con las patatas.");
            Console.WriteLine("\n7 - Vertemos la mezcla en la sartén con un chorrito de aceite.");

            // Comprobamos si está hecha por un lado
            RealizarAccion("¿Está hecha por ese lado?");

            Console.WriteLine("\n8 - Damos la vuelta a la tortilla, si no eres un experto, utiliza un plato como toda la vida.\nSi quieres jugartela, dale impulso a la sartén y dale la vuelta.");

            // Comprobamos si está cocinada por ambos lados
            RealizarAccion("¿Está hecha por el otro lado también?");

            Console.WriteLine("\n9 - Hemos terminado nuestra tortilla de patatas, emplatemos y sirvamos.");
            Console.WriteLine("Ha sido un éxito.");
        }

        static void RealizarAccion(string pregunta)
        {
            string respuesta = "N";
            do
            {
                Console.WriteLine(pregunta + " respone con (S/N)");
                respuesta = Console.ReadLine().ToUpper();
                ValidarRespuesta(respuesta);
            }
            while (respuesta != "S");
        }

        static void ValidarRespuesta(string respuesta)
        {
            switch (respuesta)
            {
                case "S":
                    Console.WriteLine("Genial, sigamos con el siguiente paso");
                    break;
                case "N":
                    Console.WriteLine("Vaya, esperamos un poco más y comprobemos de nuevo");
                    break;
                default:
                    Console.WriteLine("ERROR: dato introducido no válido");
                    break;
            }
        }
    }
}

using System;

namespace calcular_dias
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // introducir cantidad de dias
            Console.Write("Hola, vamos a calcular el número de días, por favor introduce una cantidad de días: ");

            // almacenar resultado y validarlo
            int dias = 0;
            if (!Int32.TryParse(Console.ReadLine(), out dias))
            {
                Console.WriteLine("El dato introducido no es válido.");
                return;
            }

            if (dias <= 0)
            {
                Console.WriteLine("Debes introducir un numero entero mayor a 0.");
                return;
            }

            // Calcular años:
            int years = dias / 365;
            int restoDias = dias % 365;

            // Calcular meses:
            int meses = restoDias / 30;
            restoDias = restoDias % 30;

            // Calcular semanas:
            int semanas = restoDias / 7;
            restoDias = restoDias % 30;

            // Calcular dias: (no es necesario, es el sobrante)

            // mostrar resultado
            Console.WriteLine($"El resultado es: años: {years},  meses: {meses}, semanas: {semanas}, días: {restoDias}");
        }
    }
}

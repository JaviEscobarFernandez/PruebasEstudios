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

            // calcular dias, semanas, meses y años
            int semanas = dias / 7;
            int meses = dias / 30;
            int años = dias / 365;

            // mostrar resultado
            Console.WriteLine($"El resultado es: días: {dias}, semanas: {semanas}, meses: {meses}, años: {años}");
        }
    }
}

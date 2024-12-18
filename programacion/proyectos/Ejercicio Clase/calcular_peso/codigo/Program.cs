using System;

namespace calcular_peso
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hola, vamos a calcular el peso de un objeto.");

            // Obtenemos los datos para calcular el peso (Peso = Gravedad x masa)
            int gravedad = ObtenerDato("Introduce el valor para la gravedad: ");
            int masa = ObtenerDato("Introduce el valor para la masa: ");

            // Calculamos el resultado y lo mostramos
            Console.WriteLine($"El peso del objeto es: {CalcularPeso(gravedad, masa)}");
        }

        static int ObtenerDato(string dato)
        {
            int resultado = 0;
            do
            {
                Console.Write("\n" + dato);
                resultado = ValidarDato(Console.ReadLine());
            }
            while (resultado <= 0);

            return resultado;
        }

        static int ValidarDato(string dato)
        {
            int resultado = 0;
            if (!int.TryParse(dato, out resultado) || resultado > 1000)
            {
                resultado = 0;
                Console.WriteLine("ERROR: Debes introducir un número mayor a 0 y que no sea superior a 1000.");
            }

            return resultado;
        }

        static int CalcularPeso(int gravedad, int masa) { return gravedad * masa; }
    }
}

using System;

namespace calculadora_simple
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
             * Programa que solicita dos números y realiza una operación aritmética simple simulando una calculadora.
             * Muestra la operación y vuelve a mostrar el menú para solicitar una nueva operación.
             * Da la posibilidad de salir pulsando s.
             * Cada opcion se maneja de forma modular en un procedimiento aparte.
             * Valida los datos introducidos para evitar fallos.
            */

            string opcion = "";
            do
            {
                Console.WriteLine("---------------------------------------------------------");
                Console.WriteLine("-                    Calculadora                        -");
                Console.WriteLine("---------------------------------------------------------");
                Console.WriteLine("Pulsa 1 para realizar una suma.");
                Console.WriteLine("Pulsa 2 para realizar una resta.");
                Console.WriteLine("Pulsa 3 para realizar una multiplicación.");
                Console.WriteLine("Pulsa 4 para realizar una división.");
                Console.WriteLine("Pulsa 5 para realizar una división y obtener su resto.");
                Console.WriteLine("Pulsa S para salir.");
                Console.WriteLine("---------------------------------------------------------");
                opcion = Console.ReadLine().ToUpper();
                switch (opcion)
                {
                    case "1":
                        Sumar();
                        break;
                    case "2":
                        Restar();
                        break;
                    case "3":
                        Multiplicar();
                        break;
                    case "4":
                        Dividir(false);
                        break;
                    case "5":
                        Dividir(true);
                        break;
                    case "S":
                        Console.WriteLine("Finalizando calculadora");
                        break;
                    default:
                        Console.WriteLine("ERROR: Dato introducido no válido.");
                        break;
                }
            }
            while (opcion != "S");
        }

        static void Sumar()
        {
            float a = SolicitarNumero(true);
            float b = SolicitarNumero(false);
            Console.WriteLine($"El resultado de sumar {a} con {b} es: {a + b}");
        }

        static void Restar()
        {
            float a = SolicitarNumero(true);
            float b = SolicitarNumero(false);
            Console.WriteLine($"El resultado de restar {a} con {b} es: {a - b}");
        }
        static void Multiplicar()
        {
            float a = SolicitarNumero(true);
            float b = SolicitarNumero(false);
            Console.WriteLine($"El resultado de multiplicar {a} con {b} es: {a * b}");
        }
        static void Dividir(bool resto)
        {
            float a = SolicitarNumero(true);
            float b = SolicitarNumero(false);
            // Para evitar dividir entre 0
            if (b == 0)
            {
                Console.WriteLine("ERROR: No es posible dividir entre 0.");
                return;
            }
            Console.Write($"El resultado de dividir {a} con {b} es: {a / b}");
            if (resto)
                Console.Write($" con un resto de: {a % b}");
            Console.WriteLine();
        }

        static float SolicitarNumero(bool first)
        {
            float num = 0f;
            string posicion = first ? "primer" : "segundo";
            bool valido = false;
            do
            {
                Console.Write($"Introduce el {posicion} número: ");
                num = ValidarNumero(Console.ReadLine(), ref valido);
                Console.WriteLine();
            }
            while (!valido);
            return num;
        }

        static float ValidarNumero(string datos, ref bool valido)
        {
            float num = 0f;
            if (!float.TryParse(datos, out num))
            {
                Console.WriteLine("ERROR: Valor introducido no válido.");
                return 0f;
            }

            valido = true;
            return num;
        }
    }
}

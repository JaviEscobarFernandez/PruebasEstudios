using System;

namespace maximoNnumeros
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int count = 0; // Esta variable se encarga de ejecutar el bucle hasta obtener un valor menor a 0.
            int maxNumber = 0; // Esta variable almacenará el número máximo introducido por el usuario.
            Console.WriteLine("Hola, vamos a calcular el maximo de N numeros.");
            while (count >= 0)
            {
                Console.WriteLine("Introduce un número entero para calcular el máximo, para finalizar intruduce un número negativo:");

                // Comprobamos si el valor introducido por el usuario es válido, de lo contrario mostramos mensaje de error y volvemos a preguntar.
                int value = 0; // Utilizamos value para obtener el dato introducido por el usuario.
                if (!int.TryParse(Console.ReadLine(), out value))
                {
                    Console.WriteLine("Dato introducido no válido, debe ser un número entero que no exceda los 32 bits.");
                    continue;
                }
                count = value;// Establecemos count al valor de value para actualizar en caso de tener que finalizar el bucle.

                // Valor menor a 0, salimos
                if (value < 0)
                {
                    Console.WriteLine("Has introducido un valor negativo, finalizamos, el máximo es: " + maxNumber);
                    break;
                }
                // Comprobamos si maxNumber es menor al valor introducido por el usuario, actualizamos su valor.
                if (maxNumber < value)
                    maxNumber = value;
            }
        }
    }
}

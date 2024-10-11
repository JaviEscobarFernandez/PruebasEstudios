using System.Numerics;

namespace Proyecto_prueba_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Ejercicio: Hacer un programa que calcule el Factorial de un número N obtenido por consola (N! = 1*2*3....*N)

            Console.WriteLine("Indica un numero para obtener el Factorial: "); // Pedimos por pantalla que introduzcan un valor
            UInt32 variableN = 0; // Declaramos esta variable estableciandola en 0, para almacenar el valor analizado

            // Comprobamos si el valor introducido por el usuario es válido, de lo contrario mostramos mensaje de error y finalizamos.
            if (!UInt32.TryParse(Console.ReadLine(), out variableN))
            {
                Console.Write("Dato introducido no valido, debe ser un número positivo.");
                return;
            }

            if (variableN > 100)
            {
                Console.Write("Dato introducido no valido, debe ser un número entre 0 y 100.");
                return;
            }

            // El dato es válido, continuamos
            UInt32 i = 1;          // Declaramos i y le asignamos valor 1
            BigInteger Result = i; // Declaramos Result y le asignamos valor de i (utilizamos BigInteger porque el resultado puede ser muy grande)

            // Cuando i sea menor o igual al valor introducido por el usuario, ejecutamos el bucle.
            // Multiplicara Result por i para obtener el calculo factorial (N! = 1*2*3....*N)
            // Incrementará i en 1 para evitar el bucle infinito y continuar con el calculo factorial
            // Cuando i sea mayor al numero indicado, mostramos el resultado y finalizamos.
            Console.WriteLine("Calculando Factorial de {0}", variableN);
            while (i <= variableN)
            {
                Result *= i;
                i++;
            }
            Console.WriteLine("El resultado es: {0}", Result);
        }
    }
}

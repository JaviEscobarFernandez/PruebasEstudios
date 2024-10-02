using System.ComponentModel.DataAnnotations;

namespace Proyecto_prueba_2
{
    internal class Program
    {
        // Declaramos las opciones en un enum
        enum ProgramOptions: UInt32
        {
            pares = 1,
            impares
        }

        static void Main(string[] args)
        {
            // Pedimos por pantalla que elija una opción introduciendo un valor.
            Console.WriteLine("Opcion 1: Comprobar numeros pares\nOpcion 2: Comprobar la cantidad de numeros impares");
            UInt32 option = 0; // Declaramos esta variable estableciandola en 0, para almacenar el valor analizado

            // Comprobamos si el valor introducido por el usuario es válido, de lo contrario mostramos mensaje de error y finalizamos.
            if (!UInt32.TryParse(Console.ReadLine(), out option))
            {
                Console.Write("Dato introducido no válido, debe ser un número positivo.");
                Environment.Exit(0);
            }

            // Dependiendo de la opcion elegida, hacemos una u otra opción
            switch ((ProgramOptions)option)
            {
                case ProgramOptions.pares:
                    NumerosPares();
                    break;
                case ProgramOptions.impares:
                    NumerosImpares();
                    break;
                default:
                    Console.Write("Opción introducida no válida, debe ser un valor de 1 a 2.");
                    break;
            }

            // Cerramos con error code 0.
            Environment.Exit(0);
        }

        static void NumerosPares()
        {
            // Comprobar los N numeros pares en base al valor establecido hasta 100:
            Console.WriteLine("Introduce un número del 1 al 98 y te mostraré los números pares empezando por ese valor hasta el 100: ");
            UInt32 variableN = 0; // Declaramos esta variable estableciandola en 0, para almacenar el valor analizado

            // Comprobamos si el valor introducido por el usuario es válido, de lo contrario mostramos mensaje de error y finalizamos.
            if (!UInt32.TryParse(Console.ReadLine(), out variableN))
            {
                Console.Write("Dato introducido no valido, debe ser un número positivo.");
                return;
            }

            if (variableN > 98)
            {
                Console.Write("Dato introducido no valido, debe ser un número entre 0 y 98.");
                return;
            }

            // El dato es válido, continuamos
            Console.WriteLine("Empezando a generar los numeros pares...");
            while (variableN < 100)
            {
                Console.WriteLine(variableN);
                variableN += 2;
            }
        }

        static void NumerosImpares()
        {
            // Comprobar los N primeros numeros impares en base al valor establecido:
            Console.WriteLine("Escribe un numero del 1 al 100 y te indicaré la cantidad de números impares en base al valor, empezando por el 1: "); // Pedimos por pantalla que introduzcan un valor
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
            UInt32 i = 1;      // Declaramos i y le asignamos valor 1
            UInt32 Result = 0; // Declaramos Result y le asignamos valor 0

            // Cuando i sea menor o igual al valor introducido por el usuario, ejecutamos el bucle.
            // Multiplicara Result para sacar el primer numero impar en base al valor de i
            // Incrementará i en 1 para evitar el bucle infinito y continuar con la búsqueda del siguiente numero impar
            // Mostramos en pantalla Result cada vez que se ejecuta el bucle con el calculo realizado, mostrando el siguiente numero impar.
            Console.WriteLine("Empezando a generar los numeros impares...");
            while (i <= variableN)
            {
                Result = 2 * i - 1;
                i++;
                Console.WriteLine(Result);
            }
        }
    }
}

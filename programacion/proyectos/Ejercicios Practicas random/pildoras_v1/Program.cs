using System;

namespace pildoras_v1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // ejercicioEdad();
            // mensajeEnPantalla();
            Console.WriteLine($"La suma de los números es: {sumar(5, 10)}");
            Console.WriteLine($"La suma de los números es: {sumar(5, 10, 10)}");
            Console.WriteLine($"La división de los números es: {dividir(10, 3)}");
            Console.WriteLine($"La división de los números es: {dividir(10.1, 3)}");
        }

        static void mensajeEnPantalla()
        {
            Console.WriteLine("Mensaje desde el metodo MensajeEnPantalla()");
        }

        static void ejercicioEdad()
        {
            int edad = 0;
            Console.WriteLine("Hola, introduce tu edad:");
            int.TryParse(Console.ReadLine(), out edad);
            if (edad == 0)
            {
                Console.WriteLine("Valor introducido inválido.");
                return;
            }
            Console.WriteLine($"Tienes una edad de {edad} años.");
            Console.WriteLine("Tienes una edad de " + edad + " años.");
            Console.WriteLine("Tienes una edad de {0} años y el año pasado {1} años.", edad, --edad);

            double test = Math.Pow(3, edad);
            double pi = Math.PI;
            Console.WriteLine(test + " " + pi);
        }

        static double sumar(double x, double y)
        {
            // Console.WriteLine($"La suma de los números es: {x + y}");
            return x + y;
        }
        // Aqui hemos creado una sobrecarga de suma, añadiendo un parametro opcional, que se puede introducir o no, sino se introduce queda el valor 0 por defecto.
        static double sumar(double x, double y, double z = 0)
        {
            // Console.WriteLine($"La suma de los números es: {x + y}");
            return x + y + z;
        }
        // Hemos sustituido las llaves y el return por flecha, el resultado es el mismo. ¡¡SOLO ES VALIDO SI SOLO ES UNA LINEA DE CODIGO!!
        // static int dividir(int x, int y)
        // {
        //     return x / y;
        // }
        static int dividir(int x, int y) => x / y;
        // Aqui hemos creado una sobrecarga, dependiendo de los parametros elegirá uno u otro
        static double dividir(double x, double y) => x / y;
    }

    class FuncionA
    {
        static void FuncionA1()
        {
            Console.WriteLine("FuncionA");
        }
    }

    class FuncionB
    {
        static void FuncionA1()
        {
            Console.WriteLine("FuncionA");
        }
    }
}

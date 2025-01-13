using System;

namespace control_excepciones
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
             * Un ejemplo de como controlar de forma sencilla una excepcion
             * Utilizamos try catch y manejamos errores especificos y al final uno genérico.
             */

            int num1 = 0;
            do
            {
                Console.Write("Introduce un número mayor a 0: ");
                num1 = ValidarNumero(Console.ReadLine());
            }
            while (num1 <= 0);

            Console.WriteLine("Todo en orden.");
        }

        static int ValidarNumero(string datos)
        {
            int num1 = 0;
            try
            {
                num1 = int.Parse(datos);
                if (num1 <= 0)
                    Console.WriteLine("ERROR: Debes introducir un numero mayor a 0.");
            }
            catch (FormatException ex)
            {
                // Manejamos la excepcion en caso de no introducir un formato valido (numerico en este caso)
                Console.WriteLine("ERROR: Dato introducido no válido.");
                num1 = 0;
            }
            catch (OverflowException ex)
            {
                // Manejamos la excepcion en caso de sobrepasar el limite máximo numerico.
                Console.WriteLine("ERROR: Número introducido demasiado grande.");
                num1 = 0;
            }
            catch (Exception ex)
            {
                // Manejamos el resto de excepciones de forma genérica.
                Console.WriteLine("ERROR: Error inesperado.");
                Console.WriteLine($"{ex.Message}");
                num1 = 0;
            }

            return num1;
        }
    }
}

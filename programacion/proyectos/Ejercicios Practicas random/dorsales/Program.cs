using System;

namespace dorsales
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hola, vamos a almacenar dorsales:");
            string opcion = "";
            // Utilizamos un string para almacenar los dorsales, separando cada numero de dorsal con ; al inicio y fin (;num_dorsal1;num_dorsal2;)
            string dorsales = ";";
            do
            {
                Console.WriteLine("------------------------------");
                Console.WriteLine("1 - Añadir un nuevo dorsal");
                Console.WriteLine("2 - Ver dorsales");
                Console.WriteLine("S - Salir");
                Console.WriteLine("------------------------------");
                opcion = Console.ReadLine().ToUpper();
                switch (opcion)
                {
                    case "1":
                        AddDorsal(ref dorsales);
                        break;
                    case "2":
                        ListarDorsales(dorsales);
                        break;
                    case "S":
                        Console.WriteLine("Adios");
                        break;
                    default:
                        Console.WriteLine("ERROR: Dato introducido no válido.");
                        break;
                }
            }
            while (opcion != "S");
        }

        static void AddDorsal(ref string dorsales)
        {
            // variable para almacenar el dorsal indicado
            int dorsal = 0;
            do
            {
                Console.Write("\nIntroduce el número del dorsal: ");
                // Comprobamos si el dato introducido es un número válido y lo almacenamos en dorsal.
                dorsal = ValidarDorsal(Console.ReadLine());
            }
            while (dorsal <= 0); // Repetimos el bucle hasta que introduzca un dato valido.

            // Comprobamos si el dorsal ya existe (retorna true si existe)
            if (ComprobarDorsal(dorsal, dorsales))
            {
                Console.WriteLine("ERROR: El dorsal ya existe.");
                return;
            }
            dorsales += dorsal + ";";
        }

        static int ValidarDorsal(string dato)
        {
            int dorsal = 0;
            if (!int.TryParse(dato, out dorsal))
            {
                Console.WriteLine("ERROR: Dato introducido no válido.");
                dorsal = 0;
                return dorsal;
            }
            if (dorsal <= 0 || dorsal > 200)
            {
                Console.WriteLine("ERROR: El dorsal debe ser un número entre 1 y 200.");
                dorsal = 0;
            }
            return dorsal;
        }

        static bool ComprobarDorsal(int dorsal, string dorsales)
        {
            // establecemos el dorsal entre los separadores ;
            string busquedaDorsal = ";" + dorsal + ";";
            // buscamos esa cadena en el string dorsales, si lo encuentra, retornamos true (dorsal en uso)
            if (dorsales.Contains(busquedaDorsal))
                return true;
            return false;
        }

        static void ListarDorsales(string dorsales)
        {
            // Vamos a listar los dorsales
            string dorsal = ""; // Para almacenar cada caracter numerico e imprimirlo
            int indice = 0; // Simplemente por mostrar un indice
            Console.WriteLine("Indice - Dorsales");
            Console.WriteLine("------------------");
            // Recorremos el string dorsales, donde estan almacenados los dorsales separados por ;
            for (int i = 0; i < dorsales.Length; i++)
            {
                // Comprobamos caracter a caracter
                char c = dorsales[i];
                // Si el caracter es un ; vemos si hay que imprimir el resultado
                if (c == ';')
                {
                    // Si la longitud del dorsal es mayor a 0, significa que es el separador que indica el fin del dorsal
                    if (dorsal.Length > 0)
                    {
                        // Incrementamos el indice y mostramos el resultado.
                        indice++;
                        Console.WriteLine($"{indice}    |    {dorsal}");
                    }
                    // Vaciamos el dorsal para seguir con el siguiente.
                    dorsal = "";
                    continue;
                }
                // El caracter no es ; asi que concatenamos el caracter en dorsal
                dorsal += c;
            }
        }
    }
}

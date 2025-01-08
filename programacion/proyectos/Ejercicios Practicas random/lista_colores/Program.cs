using System;
using System.Collections.Generic;

namespace lista_colores
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
             * Programa con un menu para añadir a una lista de colores previamente declarada determinados colores
             * El menu da la posibilidad de añadir, eliminar y listar colores
             * Adicionalmente tiene opciones de limpiar pantalla y salir del programa
             * Se realiza de forma modular y se añaden validaciones para comprobar las acciones de los colores y la lista.
            */

            List<string> listaColores = new List<string>();
            string opcion = "";
            do
            {
                Console.WriteLine("--------------------------------------");
                Console.WriteLine("-  Programa para introducir colores  -");
                Console.WriteLine("--------------------------------------");
                Console.WriteLine(" Pulsa 1 para añadir un color");
                Console.WriteLine(" Pulsa 2 para eliminar un color");
                Console.WriteLine(" Pulsa 3 para listar los colores añadidos");
                Console.WriteLine(" Pulsa 4 para limpiar pantalla");
                Console.WriteLine(" Pulsa S para salir");
                Console.WriteLine("--------------------------------------");
                Console.WriteLine();
                opcion = Console.ReadLine().ToUpper();
                switch (opcion)
                {
                    case "1":
                        AñadirColor(ref listaColores);
                        break;
                    case "2":
                        EliminarColor(ref listaColores);
                        break;
                    case "3":
                        ListarColores(listaColores);
                        break;
                    case "4":
                        Console.Clear();
                        break;
                    case "S":
                        Console.WriteLine("Saliendo del programa...");
                        break;
                    default:
                        Console.WriteLine("ERROR: dato introducido no válido.");
                        break;
                }
            }
            while (opcion != "S");
        }

        static void AñadirColor(ref List<string> listaColores)
        {
            Console.Write("Introduce el nombre de un color que desees añadir a la lista: ");
            string color = Console.ReadLine().ToLower();
            if (ValidarColor(listaColores, color, false))
            {
                listaColores.Add(color);
                Console.WriteLine($"Se ha añadido correctamente el color {color} a la lista.");
            }
        }

        static void EliminarColor(ref List<string> listaColores)
        {
            // Comprobamos primero si la lista esta vacia o no
            if (ListaVacia(listaColores))
            {
                Console.WriteLine("ERROR: La lista está vacia.");
                return;
            }

            Console.Write("Introduce el nombre del color que deseas eliminar: ");
            string color = Console.ReadLine().ToLower();
            if (ValidarColor(listaColores, color, true))
            {
                listaColores.Remove(color);
                Console.WriteLine($"Se ha borrado correctamente el color {color} de la lista.");
            }
        }

        static void ListarColores(List<string> listaColores)
        {
            // Comprobamos primero si la lista esta vacia o no
            if (ListaVacia(listaColores))
            {
                Console.WriteLine("ERROR: La lista está vacia.");
                return;
            }

            int cont = 1;
            // Recorremos la lista e imprimimos los colores.
            foreach (string color in listaColores)
            {
                Console.WriteLine($"{cont} - {color}");
                cont++;
            }
        }

        static bool ValidarColor(List<string> lista, string color, bool inverse)
        {
            // Comprobaciones para en caso de ser comprobacion de que esta o de forma inversa de que no está.
            if ((!inverse && lista.Contains(color)) || (inverse && !lista.Contains(color)))
            {
                if (!inverse)
                    Console.WriteLine("ERROR: el color indicado ya existe en la lista.");
                else
                    Console.WriteLine("ERROR: el color indicado no existe en la lista.");
                return false;
            }

            return true;
        }

        static bool ListaVacia(List<string> listaColores)
        {
            if (listaColores.Count <= 0)
                return true;
            return false;
        }
    }
}

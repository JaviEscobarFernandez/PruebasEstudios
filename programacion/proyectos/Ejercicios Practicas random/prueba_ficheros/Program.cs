using System;
using System.IO;

namespace prueba_ficheros
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string ruta_archivo = @"C:\Users\javie\Desktop\Ilerna\Programación\Ficheros\prueba_01.txt";

            string opcion = "";
            do
            {
                Console.WriteLine("1 - Ver contenido del fichero");
                Console.WriteLine("2 - Añadir nuevo contenido al fichero");
                Console.WriteLine("3 - Vaciar fichero");
                Console.WriteLine("4 - Salir");
                opcion = Console.ReadLine();
                switch (opcion)
                {
                    case "1":
                        VerContenido(ruta_archivo);
                        break;
                    case "2":
                        Console.Write("Escribe el contenido que deseas añadir: ");
                        IntroducirContenido(ruta_archivo, Console.ReadLine());
                        break;
                    case "3":
                        VaciarContenido(ruta_archivo);
                        break;
                    case "4":
                        Console.WriteLine("¡Adios!");
                        break;
                    default:
                        Console.WriteLine("ERROR: Dato introducido no válido.");
                        break;
                }
            }
            while (opcion != "4");
        }

        static void VerContenido(string ruta)
        {
            // Establecer conexion
            FileStream file = new FileStream(ruta, FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader sr = new StreamReader(file);

            // Realizar operaciones
            string contenido = "";
            while((contenido = sr.ReadLine()) != null)
            {
                Console.WriteLine(contenido);
            }

            // Cerrar conexion
            sr.Close();
            file.Close();
        }

        static void IntroducirContenido(string ruta, string contenido)
        {
            // Establecer conexion
            FileStream stream = new FileStream(ruta, FileMode.Append, FileAccess.Write);
            StreamWriter sw = new StreamWriter(stream);

            // Realizar operaciones
            sw.WriteLine(contenido);
            Console.WriteLine("Contenido introducido correctamente.");

            // Cerrar conexion
            sw.Close();
            stream.Close();
        }

        static void VaciarContenido(string ruta)
        {
            // Establecer conexion
            FileStream stream = new FileStream(ruta, FileMode.Truncate, FileAccess.Write);
            StreamWriter sw = new StreamWriter(stream);

            // Realizar operaciones
            sw.WriteLine();

            // Cerrar conexion
            sw.Close();
            stream.Close();
        }
    }
}

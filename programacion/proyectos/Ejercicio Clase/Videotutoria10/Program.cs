using System;
using System.IO;

namespace Videotutoria_10
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Establecer ruta/nombre fichero
            // @ sirve para evitar los caracteres como \n etc.
            // Las rutas pueden ser relativas o absolutas.
            string rutaArchivo = @"C:\Users\javie\Desktop\Ilerna\Programación\Ficheros\videotutoria10.txt";
            Console.WriteLine("Hola, vamos a manejar el fichero para leer y almacenar alumnos.");

            string respuesta = "";
            do
            {
                Console.WriteLine("1 - Leer fichero:\n2 - Escribir en el fichero:\n3 - Salir");
                respuesta = Console.ReadLine().ToUpper();
                switch (respuesta)
                {
                    case "1":
                        LeerFichero(rutaArchivo);
                        break;
                    case "2":
                        Console.Write("Escribe el nombre del Alumno: ");
                        EscribirFichero(rutaArchivo, Console.ReadLine());
                        break;
                    case "3":
                        Console.WriteLine("Adios!");
                        break;
                    default:
                        Console.WriteLine("Error: Dato no válido.");
                        break;
                }
            }
            while (respuesta != "3");
        }

        static void LeerFichero(string ruta)
        {
            // 1 - Establecer la comunicacion
            FileStream F1 = new FileStream(ruta, FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader F1_SR = new StreamReader(F1);

            // 2 - Realizar las operaciones (leer)
            string registro = "";
            // Para leer los registros debemos utilizar un bucle while, ya que la lectura es secuencial.
            // Leemos linea, si no es nula, el bucle continua, si fuese nula, significa que hemos llegado al EOF (end of file).
            Console.WriteLine("Mostrando el contenido:");
            while ((registro = F1_SR.ReadLine()) != null)
            {
                // Imprimimos por pantalla la linea leida
                Console.WriteLine(registro);
            }
            Console.WriteLine("");

            // 3 - Cerrar la comunicacion
            // Importante, primero cerrar el StreamReader y luego el FileStream (al reves que cuando establecemos comunicacion)
            F1_SR.Close();
            F1.Close();
        }

        static void EscribirFichero(string ruta, string registro)
        {
            // 1 - Establecer la comunicacion
            // Utilizamos Append porque queremos escribir al final
            FileStream F1 = new FileStream(ruta, FileMode.Append, FileAccess.Write);
            StreamWriter F1_SW = new StreamWriter(F1);

            // 2 - Realizar las operaciones (leer)
            F1_SW.WriteLine(registro);
            Console.WriteLine("Registro almacenado correctamente.\n");

            // 3 - Cerrar la comunicacion
            F1_SW.Close();
            F1.Close();
        }
    }
}

using System;
using System.IO;

namespace ejercicio_ficheros_directorios_02
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Crear menu que solicite introducir una ruta y a partir de ahi, generar un archivo, leerlo, borrarlo, sobreescribirlo, vaciarlo y crear directorio

            // Realizar menu
            string opcion = "";
            string ruta = "";
            do
            {
                Console.WriteLine("Elige una opcion:");
                Console.WriteLine("1 - Establecer ruta.");
                Console.WriteLine("2 - Generar un archivo.");
                Console.WriteLine("3 - Leer archivo.");
                Console.WriteLine("4 - Introducir datos en el archivo.");
                Console.WriteLine("5 - Borrar archivo.");
                Console.WriteLine("6 - Sobreescribir archivo.");
                Console.WriteLine("7 - Vaciar archivo.");
                Console.WriteLine("8 - Crear directorio.");
                Console.WriteLine("S - Salir.");
                opcion = Console.ReadLine().ToUpper();
                switch (opcion)
                {
                    case "1":
                        // Solicitar ruta y establecerla
                        ruta = SolicitarRuta();
                        break;
                    case "2":
                        // Generar un archivo (comprobar si hay ruta establecida)
                        CrearArchivo(ruta);
                        break;
                    case "3":
                        // Leer archivo (comprobar si hay ruta establecida)
                        LeerArchivo(ruta);
                        break;
                    case "4":
                        // Introducir datos en un archivo (comprobar si hay ruta establecida)
                        IntroducirDatos(ruta);
                        break;
                    case "5":
                        // Borrar archivo (comprobar si hay ruta establecida)
                        BorrarArchivo(ruta);
                        break;
                    case "6":
                        // Sobreescribir archivo (comprobar si hay ruta establecida)
                        SobreescribirArchivo(ruta);
                        break;
                    case "7":
                        // Vaciar archivo (comprobar si hay ruta establecida)
                        VaciarArchivo(ruta);
                        break;
                    case "8":
                        // Crear directorio (Solicitar una ruta)
                        CrearDirectorio();
                        break;
                    case "S":
                        Console.WriteLine("Adios!");
                        break;
                    default:
                        Console.WriteLine("ERROR: dato no válido.");
                        break;
                }
                Console.WriteLine();
            }
            while (opcion != "S");
        }

        static string SolicitarRuta()
        {
            Console.Write("Introduce la ruta: ");
            string ruta = @Console.ReadLine();
            if (RutaVacia(ruta))
            {
                Console.WriteLine("¿Quieres que se establezca una ruta por defecto automaticamente? - pulsa S para confirmar.");
                if (Console.ReadLine().ToUpper() == "S")
                    ruta = @"C:\Users\javie\Desktop\Ilerna\Programación\ficheros\archivo_prueba01.txt";
            }

            if (!RutaVacia(ruta, false))
                Console.WriteLine($"Ruta establecida correctamente: {ruta}");
            return ruta;
        }

        static void CrearArchivo(string ruta)
        {
            if (RutaVacia(ruta))
                return;

            FileMode fm = FileMode.CreateNew;
            FileAccess fa = FileAccess.Write;
            RealizarOperaciones(ruta, fm, fa);
        }

        static void LeerArchivo(string ruta)
        {
            if (RutaVacia(ruta))
                return;

            Console.WriteLine("El contenido del archivo es:");
            FileMode fm = FileMode.Open;
            FileAccess fa = FileAccess.Read;
            RealizarOperaciones(ruta, fm, fa);
        }

        static void IntroducirDatos(string ruta)
        {
            if (RutaVacia(ruta))
                return;

            Console.WriteLine("Introduce el texto a añadir en el archivo: ");
            FileMode fm = FileMode.Append;
            FileAccess fa = FileAccess.Write;
            RealizarOperaciones(ruta, fm, fa, Console.ReadLine());
        }

        static void SobreescribirArchivo(string ruta)
        {
            if (RutaVacia(ruta))
                return;

            Console.WriteLine("Introduce el texto a añadir en el archivo: ");
            FileMode fm = FileMode.Create;
            FileAccess fa = FileAccess.Write;
            RealizarOperaciones(ruta, fm, fa, Console.ReadLine());
        }

        static void VaciarArchivo(string ruta)
        {
            if (RutaVacia(ruta))
                return;

            FileMode fm = FileMode.Truncate;
            FileAccess fa = FileAccess.Write;
            RealizarOperaciones(ruta, fm, fa);
        }

        static void BorrarArchivo(string ruta)
        {
            if (RutaVacia(ruta))
                return;

            // FileStream creo que no tiene opcion de borrado, asi que utilizamos File.Delete(ruta);
            File.Delete(ruta);
            Console.WriteLine("Archivo borrado correctamente");
        }

        static void CrearDirectorio()
        {
            Console.WriteLine("Introduce una ruta: ");
            string ruta = @Console.ReadLine();
            if (RutaVacia(ruta))
            {
                Console.WriteLine("¿Quieres establecer automaticamente una ruta por defecto? - pulsa S para confirmar");
                if (Console.ReadLine().ToUpper() == "S")
                    ruta = @"C:\Users\javie\Desktop\Ilerna\Programación\Ficheros\";
            }

            if (RutaVacia(ruta, false))
                return;

            Console.WriteLine($"Ruta establecida correctamente: {ruta}");
            Console.Write("Introduce el nombre del directorio a crear: ");
            string folder = Console.ReadLine();
            if (folder != "")
            {
                Directory.CreateDirectory(ruta + folder);
                Console.WriteLine($"Directorio {folder} creado correctamente en la ruta: {ruta}");
                return;
            }
            Console.WriteLine("ERROR: nombre de directorio no valido.");
        }

        static bool RutaVacia(string ruta, bool mostrarMensaje = true)
        {
            if (ruta == "")
            {
                Console.WriteLine("ERROR: hay que establecer una ruta previamente.");
                return true;
            }
            return false;
        }

        static void RealizarOperaciones(string ruta, FileMode fm, FileAccess fa, string datos = "")
        {
            // Establecer conexion
            FileStream f1 = new FileStream(ruta, fm, fa);

            // Realizar operaciones
            if (fa != FileAccess.Read)
            {
                StreamWriter sw = new StreamWriter(f1);

                sw.WriteLine(datos);
                Console.WriteLine("Operacion realizada correctamente.");

                // Cerrar conexion
                sw.Close();
            }
            else
            {
                StreamReader sr = new StreamReader(f1);

                string contenido = "";
                while ((contenido = sr.ReadLine()) != null)
                {
                    Console.WriteLine(contenido);
                }

                // Cerrar conexion
                sr.Close();
            }

            // Cerrar conexion
            f1.Close();
        }
    }
}

using System;
using System.IO;

namespace buffer_binaryreader_binarywritter
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
             * Prueba con flujos para leer y escribir en un archivo png (una imagen de prueba)
             * Prueba con BinaryReader y BinaryWriter para leer y escribir en un archivo binario (.bin)
             */

            const string rutaImg = @"c:\users\javie\desktop\ilerna\programación\ficheros\test_prueba.png";
            const string rutaBin = @"c:\users\javie\desktop\ilerna\programación\ficheros\test_prueba.bin";
            LeerBuffer(rutaImg);
            EscribirBuffer(rutaImg);
            CrearEscribirBinario(rutaBin);
            LeerBinario(rutaBin);
        }
        static void LeerBuffer(string ruta)
        {
            // Abrimos el flujo hacia el fichero para leerlo
            FileStream fs = new FileStream(ruta, FileMode.Open, FileAccess.Read);

            // Cargamos el contenido en el buffer
            byte[] buffer = new byte[fs.Length];
            fs.Read(buffer, 0, buffer.Length);

            // Recorremos el buffer y lo vamos imprimiendo
            for (int i = 0; i < buffer.Length; i++)
            {
                Console.WriteLine(buffer[i]);
                // Finalizamos el bucle si es muy largo, con un ejemplo nos sirve
                if (i > 1000)
                    break;
            }

            // Cerramos el flujo
            fs.Close();
        }

        static void EscribirBuffer(string ruta)
        {
            // Abrimos el flujo hacia el fichero para leerlo y escribirlo
            FileStream fs = new FileStream(ruta, FileMode.Open, FileAccess.ReadWrite);

            // Cargamos el contenido en el buffer
            byte[] buffer = new byte[fs.Length];
            fs.Read(buffer, 0, buffer.Length);

            // Creamos un random para modificar el contenido del buffer con numeros aleatorios
            Random random = new Random();
            for (int i = 1000; i < buffer.Length; i++)
            {
                buffer[i] = (byte)random.Next(0, 256); // maximo 255 (1 byte)
            }
            // Nos posicionamos con el puntero
            fs.Seek(0, SeekOrigin.Begin);
            // Escribimos en el archivo el contenido del buffer modificado
            fs.Write(buffer, 0, buffer.Length);

            // Cerramos el flujo
            fs.Close();
        }
        static void CrearEscribirBinario(string ruta)
        {
            // En caso de exister lo borramos primero
            if (File.Exists(ruta))
                File.Delete(ruta);

            // Abrimos el flujo hacia el fichero para crearlo y escribir
            FileStream fs = new FileStream(ruta, FileMode.Create, FileAccess.Write);
            // Escribimos en el archivo binario
            BinaryWriter writer = new BinaryWriter(fs);
            writer.Write(1234);             // Escribir un entero
            writer.Write("Hola que tal");   // Escribir una cadena
            writer.Write(3.1416);           // Escribir un double

            // Cerramos el flujo
            writer.Close();
            fs.Close();

            Console.WriteLine("Datos escritos en el archivo binario.");
        }

        static void LeerBinario(string ruta)
        {
            // Abrimos el flujo hacia el fichero para leerlo
            FileStream fs = new FileStream(ruta, FileMode.Open, FileAccess.Read);
            // Leemos el archivo binario
            BinaryReader reader = new BinaryReader(fs);
            int entero = reader.ReadInt32();
            string cadena = reader.ReadString();
            double numero = reader.ReadDouble();

            // Cerramos el flujo
            reader.Close();
            fs.Close();

            Console.WriteLine("Entero: " + entero);
            Console.WriteLine("Cadena: " + cadena);
            Console.WriteLine("Double: " + numero);
        }
    }
}


using System;
using System.IO;

namespace videotutoria_12
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Validar fichero
            string ruta = @"C:\Users\javie\Desktop\Ilerna\Programación\Ficheros\ciclismo\prueba_ciclismo_v12.txt";
            if (File.Exists(ruta))
            {
                Console.WriteLine("ERROR: el archivo ya existe.");
                return;
            }

            // Crear flujo del programa
            FileStream fs = new FileStream(ruta, FileMode.OpenOrCreate, FileAccess.Write);
            StreamWriter writer = new StreamWriter(fs);

            // Escribir cabecera fichero
            writer.WriteLine("Nombre;Modelo Bicicleta;Dorsal");

            // Ingresar Ciclistas
            bool continuar = true;
            int dorsal = 0;
            do
            {
                Console.Write("Introduce el nombre del ciclista: ");
                string ciclista = Console.ReadLine();
                Console.Write("Introduce el modelo de la bicicleta: ");
                string modelo = Console.ReadLine();
                dorsal++;
                writer.WriteLine(ciclista + ";" + modelo + ";" + dorsal);
                bool opcion = true;
                do
                {
                    Console.WriteLine("¿Deseas añadir más participantes? (S/N)");
                    string respuesta = Console.ReadLine().ToUpper();
                    switch (respuesta)
                    {
                        case "S":
                            opcion = true;
                            break;
                        case "N":
                            opcion = true;
                            continuar = false;
                            break;
                        default:
                            opcion = false;
                            Console.WriteLine("ERROR: Dato introducido no valido, introduce: (S/N)");
                            break;
                    }
                }
                while (!opcion);
            }
            while (continuar);

            // Finalizar programa
            writer.Close();
            fs.Close();
        }
    }
}

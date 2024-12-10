using System;
using System.IO;

namespace prueba_ciclismo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Establecemos la ruta donde se almacenan los ficheros
            string rutaPorDefecto = @"C:\Users\javie\Desktop\Ilerna\Programación\Ficheros\ciclismo\";

            // Solicitamos que indique el nombre del fichero
            Console.Write("Hola, por favor indica el nombre del archivo: ");

            // Añadimos al nombre del fichero la extension .txt
            string nombreFichero = Console.ReadLine();

            // Añadimos el nombre del fichero a la ruta
            string rutaIngresos = rutaPorDefecto + nombreFichero + ".txt";

            // Comprobamos si existe el fichero, en ese caso, mostramos mensaje de error y finalizamos
            if (ValidarFichero(rutaIngresos) == false)
                return;

            // Creamos el fichero
            CrearFichero(rutaIngresos);

            // Solicitamos los datos que desea introducir en el fichero y los introducimos
            string[] datosParticipante = new string[3];
            SolicitarDatos(rutaIngresos, datosParticipante);

            // Finalizamos importando el fichero a excel
            ImportarFichero(rutaIngresos, rutaPorDefecto, nombreFichero);
        }

        static bool ValidarFichero(string ruta)
        {
            Console.WriteLine();
            if (File.Exists(ruta))
            {
                Console.WriteLine("ERROR: El archivo ya existe, no puede sobreescribirse");
                return false;
            }
            return true;
        }

        static void CrearFichero(string ruta)
        {
            // Establecemos conexion
            FileStream fs = new FileStream(ruta, FileMode.Create, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);

            // Realizamos las operaciones
            string cabecera = "Nombre;Modelo de bicicleta;Dorsal;";
            sw.WriteLine(cabecera);

            // Cerramos conexion
            sw.Close();
            fs.Close();

            Console.WriteLine($"El archivo ha sido creado correctamente en: {ruta}");
        }

        static void SolicitarDatos(string ruta, string[] datos)
        {
            string[] dorsales = new string[100];
            InicializarDorsal(dorsales);

            Console.WriteLine("Vamos a introducir los datos de los participantes:");
            string ingreso = "S";
            do
            {
                // Solo mostramos opcion de ingresar participantes cuando la opcion sea S (por defecto es S)
                if (ingreso == "S")
                {
                    IngresarParticipante(ruta, datos, dorsales);
                    Console.WriteLine("¿Deseas seguir introduciendo más participantes?");
                }
                Console.WriteLine("Introduce 'S' para seguir introduciendo participantes.");
                Console.WriteLine("Introduce 'N' para salir del programa.");
                ingreso = Console.ReadLine().ToUpper();
                switch (ingreso)
                {
                    case "S":
                        Console.WriteLine("Continuemos con el siguiente.\n");
                        break;
                    case "N":
                        break;
                    default:
                        Console.WriteLine("ERROR: Valor introducido no válido.\n");
                        break;
                }
            }
            while (ingreso != "N");
        }

        static void IngresarParticipante(string ruta, string[] datos, string[] dorsales)
        {
            // Solicitamos el nombre del participante y lo almacenamos en la primera posicion del vector.
            Console.Write("\nIntroduce el nombre del participante: ");
            datos[0] = Console.ReadLine();

            // Solicitamos el nombre de la bicicleta y lo almacenamos en la segunda posicion del vector.
            Console.Write("\nIntroduce el modelo de la bicicleta: ");
            datos[1] = Console.ReadLine();

            // Solicitamos el dorsal del participante y lo almacenamos en la tercera posicion del vector.
            bool dorsalValido = false;
            do
            {
                Console.Write("\nIntroduce el dorsal: ");
                string dorsal = Console.ReadLine();
                // Debemos validar el dorsal
                if (ValidarDorsal(dorsal, dorsales))
                {
                    datos[2] = dorsal;
                    dorsalValido = true; // Para finalizar el bucle
                }
            }
            while (!dorsalValido);

            RegistrarParticipante(ruta, datos);
        }

        static void InicializarDorsal(string[] dorsales)
        {
            for (int i = 0; i < dorsales.Length; i++)
            {
                dorsales[i] = "*";
            }
        }

        static bool ValidarDorsal(string dorsal, string[] dorsales)
        {
            int dorsalNumber = 0;

            // Comprobamos que el dorsal sea un valor numerico.
            if (!int.TryParse(dorsal, out dorsalNumber))
            {
                Console.WriteLine("ERROR: debes introducir un numero para el dorsal.");
                return false;
            }

            // Comprobamos que el dorsal sea un valor entre 1 y 100
            if (dorsalNumber <= 0 || dorsalNumber > 100)
            {
                Console.WriteLine("ERROR: el dorsal debe comprender un valor entre 1 y 100.");
                return false;
            }

            if (DorsalEnUso(dorsal, dorsales))
            {
                Console.WriteLine("ERROR: el dorsal ya esta siendo utilizado por otro participante.");
                return false;
            }

            return true;
        }

        static bool DorsalEnUso(string dorsal, string[] dorsales)
        {
            // Comprobamos si el dorsal esta en uso.
            foreach (string d in dorsales)
            {
                if (dorsal == d)
                    return true;
            }
            // No esta en uso, almacenamos el dorsal en el vector.
            return !AddDorsal(dorsal, dorsales);
        }

        static bool AddDorsal(string dorsal, string[] dorsales)
        {
            // Iteramos el vector de dorsales y buscamos el primer hueco libre y agregamos el dorsal
            for (int i = 0; i < dorsales.Length; i++)
            {
                if (dorsales[i] == "*")
                {
                    // Hueco encontrado, dorsal agregado al vector, retornamos true para validar
                    dorsales[i] = dorsal;
                    return true;
                }
            }
            // No hay hueco, lanzamos error.
            Console.WriteLine("ERROR: Límite de dorsales alcanzado.");
            return false;
        }

        static void RegistrarParticipante(string ruta, string[] datos)
        {
            // Establcemos conexion
            FileStream fs = new FileStream(ruta, FileMode.Append, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);

            // Realizamos las operaciones
            string datosEscritura = GenerarDatosEscritura(datos);
            sw.WriteLine(datosEscritura);
            Console.WriteLine("Participante registrado correctamente.");

            // Cerramos la conexion
            sw.Close();
            fs.Close();
        }

        static void ImportarFichero(string rutaFicheroTxt, string ruta, string nombre)
        {
            string rutaFicheroExcel = ruta + nombre + ".csv";

            // Establcemos conexion (lectura)
            FileStream fs = new FileStream(rutaFicheroTxt, FileMode.Open, FileAccess.Read);
            StreamReader sr = new StreamReader(fs);

            // Establecemos conexion (escritura)
            FileStream fs2 = new FileStream(rutaFicheroExcel, FileMode.Append, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs2);

            // Realizamos las operaciones
            string datos = "";
            while ((datos = sr.ReadLine()) != null)
            {
                sw.WriteLine(datos);
            }
            Console.WriteLine("Archivo importado a excel correctamente.");

            // Cerramos la conexion (escritura)
            sw.Close();
            fs.Close();

            // Cerramos la conexion (lectura)
            sr.Close();
            fs.Close();
        }

        static string GenerarDatosEscritura(string[] datos)
        {
            string datosEscritura = "";
            // Iteramos el vector de los datos obtenidos y lo añadimos a un string separando por ";"
            foreach (string s in datos)
            {
                datosEscritura += s + ";";
            }
            // Retornamos el string generado
            return datosEscritura;
        }
    }
}

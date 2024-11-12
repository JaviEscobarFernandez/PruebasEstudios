using System;

namespace pildoras_v5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // NumeroAleatorioValidado();

            // Con esto obtenemos el valor maximo de int32
            int numero = int.MaxValue;
            Console.WriteLine($"El valor maximo de int32 es: {numero}");
            // Ahora incrementamos el valor maximo y hay un desbordamiento y pasa al valor negativo maximo, no crashea
            numero++;
            Console.WriteLine($"El valor maximo de int32 es: {numero}");
            // Asi podemos comprobar el overflow y crashea
            checked
            {
                // NumeroAleatorioValidado();
                // Con esto obtenemos el valor maximo de int32
                int numero2 = int.MaxValue;
                Console.WriteLine($"El valor maximo de int32 es: {numero2}");
                // Ahora incrementamos el valor maximo y hay un desbordamiento y pasa al valor negativo maximo, no crashea
                numero2++;
                Console.WriteLine($"El valor maximo de int32 es: {numero2}");
            }
        }

        static void NumeroAleatorioValidado()
        {
            // Generar numero aleatorio entre 0 y 100.
            Random numero = new Random();
            int numeroAleatorio = numero.Next(0, 101);
            bool acierto = false;
            Console.WriteLine("Hola, vamos a jugar a ver si aciertas que numero estoy pensando del 0 al 100.");
            do
            {
                // Preguntar que numero es
                Console.WriteLine("Dime, ¿que numero crees que es?");

                int respuesta = -1;
                // respuesta = int.Parse(Console.ReadLine()); // <-- Error en tiempo de ejecucion al no indicar un dato adecuado (una letra o numero demasiado alto)

                // Validar dato introducido.
                // Validar con try... catch especifico, se recomienda especifico para afinar
                // utilizamos ref para devolver el valor de respuesta por si se actualiza dentro de la funcion (como & en c++)
                // if (!ValidarConTryCatchEspecifico(ref respuesta))
                //     continue;

                // Validar con try... catch generico, por si hay muchas excepciones, este las abarca todas.
                // if (!ValidarConTryCatchGenerico(ref respuesta))
                //     continue;

                // Validar con TryParse (evitaria overflow y formato invalido)
                // if (!ValidarConTryParse(ref respuesta))
                //     respuesta = -1;

                // Validar con try... catch especifico + generico, afinamos los especificos y aseguramos el generico al final
                // if (!ValidarConTryCatchEspecificoGenerico(ref respuesta))
                //     continue;

                // Validar con try... catch generico filtrado + especifico despues, igual que el anterior, pero en otro orden.
                if (!ValidarConTryCatchGenericoFiltrado(ref respuesta))
                    continue;

                if (respuesta < 0 || respuesta > 100)
                {
                    Console.WriteLine("Dato indicado no válido, debe ser un numero entero del 0 al 100.");
                    continue;
                }

                // Si acertamos, lo indica, sino, nos idica si es mayor o menor.
                if (respuesta == numeroAleatorio)
                {
                    Console.WriteLine("¡Felicidades! Has acertado, el número era: {0}", numeroAleatorio);
                    acierto = true;
                }
                else if (respuesta < numeroAleatorio)
                    Console.WriteLine("No, el número aleatorio es mayor que {0}.", respuesta);
                else
                    Console.WriteLine("No, el número aleatorio es menor que {0}.", respuesta);
            }
            while (!acierto);
        }

        static bool ValidarConTryParse(ref int respuesta)
        {
            if (!int.TryParse(Console.ReadLine(), out respuesta))
                return false;
            return true;
        }

        static bool ValidarConTryCatchEspecifico(ref int respuesta)
        {
            try
            {
                respuesta = int.Parse(Console.ReadLine());
            }
            // Evitamos que al poner texto no crashee, pero si se pone un numero altisimo crashea
            catch (FormatException ex)
            {
                Console.WriteLine("Dato indicado no válido, has introducido texto.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            // Evitamos overflow (numero mayor al maximo del int)
            catch (OverflowException ex)
            {
                Console.WriteLine("Dato indicado no válido, el numero excede el limite.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            return true;
        }

        static bool ValidarConTryCatchGenerico(ref int respuesta)
        {
            try
            {
                respuesta = int.Parse(Console.ReadLine());
            }
            // Con Exception evitamos cualquier excepcion en lugar de una especifica
            // evita overflow, texto, etc. seria una forma generica de evitarlo.
            catch (Exception ex)
            {
                Console.WriteLine("Dato indicado no válido, error generico.");
                // si quisiesemos imprimir el error
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            return true;
        }
        static bool ValidarConTryCatchEspecificoGenerico(ref int respuesta)
        {
            try
            {
                respuesta = int.Parse(Console.ReadLine());
            }
            // Evitamos que al poner texto no crashee, pero si se pone un numero altisimo crashea
            catch (FormatException ex)
            {
                Console.WriteLine("Dato indicado no válido, has introducido texto.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            // Evitamos overflow (numero mayor al maximo del int)
            catch (OverflowException ex)
            {
                Console.WriteLine("Dato indicado no válido, el numero excede el limite.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            // Por si hubiese algun error mas, aseguramos
            catch (Exception ex)
            {
                Console.WriteLine("Dato indicado no válido, ha habido un error inespecifico.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            return true;
        }

        static bool ValidarConTryCatchGenericoFiltrado(ref int respuesta)
        {
            try
            {
                respuesta = int.Parse(Console.ReadLine());
            }
            // Por si hubiese algun error mas, aseguramos
            catch (Exception ex) when (ex.GetType() != typeof(FormatException) && ex.GetType() != typeof(OverflowException))
            {
                Console.WriteLine("Dato indicado no válido, ha habido un error inespecifico.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            // Evitamos que al poner texto no crashee, pero si se pone un numero altisimo crashea
            catch (FormatException ex)
            {
                Console.WriteLine("Dato indicado no válido, has introducido texto.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            // Evitamos overflow (numero mayor al maximo del int)
            catch (OverflowException ex)
            {
                Console.WriteLine("Dato indicado no válido, el numero excede el limite.");
                // si quisiesemos imprimir el error para debugear
                // Console.WriteLine($"Exception: {ex}");
                return false;
            }
            return true;
        }
    }
}

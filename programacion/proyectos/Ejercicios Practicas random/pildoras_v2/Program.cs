using System;

namespace pildoras_v2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // haceFrio();
            // circulacion();
            // parciales();
            transportes();
        }

        static void haceFrio()
        {
            bool haceFrio = true;
            Console.WriteLine(!haceFrio);
        }

        static void circulacion()
        {
            int edad = 0;
            Console.Write("Hola, vamos a comprobar si eres mayor de edad, introduce tu edad: ");
            if (!int.TryParse(Console.ReadLine(), out edad))
                Console.WriteLine("Dato introducido no válido");

            if (mayorEdad(edad))
            {
                Console.Write("Indica si tiene el carnet de conducir, con si o no: ");
                string carnet = Console.ReadLine().ToLower();
                puedesCircular(tieneCarnet(carnet));
            }
        }

        static bool mayorEdad(int edad)
        {
            if (edad >= 18)
            {
                Console.WriteLine("Eres mayor de edad, puedes pasar.");
                return true;
            }
            Console.WriteLine("No eres mayor de edad, largo!");
            return false;
        }

        static bool tieneCarnet(string carnet)
        {
            if (carnet == "si" || carnet == "sí")
                return true;
            return false;
        }

        static void puedesCircular(bool todoEnRegla)
        {
            if (todoEnRegla)
                Console.WriteLine("Tienes todo en regla, puedes circular.");
            else
                Console.WriteLine("Bajese del vehiculo, no tiene el permiso de circulacion");
        }

        static void parciales()
        {
            Console.WriteLine("Hola, vamos a comprobar si estas aprobado");
            int parcial1 = validarNota("Introduce la nota del primer parcial: ");
            int parcial2 = validarNota("Introduce la nota del segundo parcial: ");
            int parcial3 = validarNota("Introduce la nota del tercer parcial: ");
            if (parcial1 >= 5 && parcial2 >= 5 && parcial3 >= 5)
                Console.WriteLine($"Ha aprobado, su media es: {(parcial1 + parcial2 + parcial3) / 3}");
            else
                Console.WriteLine("Esta suspendido");
        }

        static int validarNota(string mensaje)
        {
            Console.Write(mensaje);
            int nota = 0;
            if (!int.TryParse(Console.ReadLine(), out nota))
                Console.WriteLine("Dato introducido no válido, lo dejamos en 0");
            return nota;
        }

        static void transportes()
        {
            Console.Write("Elige el medio de transporte (coche, tren o avión): ");
            string transporte = Console.ReadLine().ToLower();
            switch (transporte)
            {
                case "coche":
                    Console.WriteLine("Velocidad media: 100 km/h");
                    break;
                case "tren":
                    Console.WriteLine("Velocidad media: 250 km/h");
                    break;
                case "avión":
                case "avion":
                    Console.WriteLine("Velocidad media: 800 km/h");
                    break;
                default:
                    Console.WriteLine("Dato introducido no válido.");
                    break;
            }
        }
    }
}

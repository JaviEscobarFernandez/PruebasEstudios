using System;

namespace prueba_enums_dias_semana
{
    internal class Program
    {
        enum diasSemana
        {
            lunes, martes, miercoles, jueves, viernes, sabado, domingo
        };

        static void Main(string[] args)
        {
            ContarDiasSemana();
            VerDiaSemana();
            DiaSemanaAleatorio();
        }

        static void ContarDiasSemana()
        {
            int count = 0;
            for (diasSemana i = diasSemana.lunes; i <= diasSemana.domingo; i++)
            {
                count++;
            }
            Console.WriteLine($"La semana tiene {count} días.");
        }

        static void VerDiaSemana()
        {
            int dia = -1;
            do
            {
                Console.Write("\nIntroduce un número del 0 al 6 para ver que dia de la semana es: ");
                dia = ValidarNumero(Console.ReadLine());
            }
            while (dia < 0);

            Console.WriteLine($"El día elegido es: {MostrarDiaSemana(dia)}");

        }

        static string MostrarDiaSemana(int dia)
        {
            string diaElegido = "";
            diasSemana diaSemana = (diasSemana)dia;
            switch (diaSemana)
            {
                case diasSemana.lunes:
                    diaElegido = "Lunes";
                    break;
                case diasSemana.martes:
                    diaElegido = "Martes";
                    break;
                case diasSemana.miercoles:
                    diaElegido = "Miércoles";
                    break;
                case diasSemana.jueves:
                    diaElegido = "Jueves";
                    break;
                case diasSemana.viernes:
                    diaElegido = "Viernes";
                    break;
                case diasSemana.sabado:
                    diaElegido = "Sábado";
                    break;
                case diasSemana.domingo:
                    diaElegido = "Domingo";
                    break;
                default:
                    diaElegido = "Desconocido";
                    break;
            }
            return diaElegido;
        }

        static int ValidarNumero(string dato)
        {
            int numero = -1;
            if (!int.TryParse(dato, out numero))
            {
                Console.WriteLine("ERROR: dato introducido no válido.");
                numero = -1;
            }
            else if (numero < 0 || numero > 6)
            {
                Console.WriteLine("ERROR: debe ser un valor de 0 a 6.");
                numero = -1;
            }
            return numero;
        }

        static void DiaSemanaAleatorio()
        {
            Console.WriteLine("\nVamos a generar un dia de la semana de forma aleatoria");
            Random random = new Random();
            int numeroAleatorio = random.Next(0, 7);
            Console.WriteLine($"El día de la semana elegido es: {MostrarDiaSemana(numeroAleatorio)}");
        }
    }
}

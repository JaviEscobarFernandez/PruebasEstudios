using System;

namespace videotutoria7
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // pruebaRefVal();
            // vectorInformarYVisualizar10numerosAleatorios();

            // dada una cantidad de tiempo dar horas minutos y segundos
            // dada la cantidad de horas minutos y segundos dar la cantidad de segundos
            // menu principal para converir en segundos horas, minutos y segundos
            string opcion = "";
            do
            {
                Console.WriteLine("1: Convertir segundos a horas, minutos y segundos.");
                Console.WriteLine("2: Convertir horas, minutos y segundos a segundos.");
                Console.WriteLine("S: Salir.");
                opcion = Console.ReadLine().ToUpper();

                switch (opcion)
                {
                    case "1":
                        opcion1();
                        break;
                    case "2":
                        opcion2();
                        break;
                    case "S":
                        break;
                    default:
                        Console.WriteLine("Dato introducido no válido, introduce 1, 2 o S dependiendo de la opcion que prefiera.");
                        break;
                }
            }
            while (opcion != "S");
        }

        public static void opcion1()
        {
            // Paso 1: Obtener segundos del usuario:
            Console.Write("Introduce el número en segundos a transformar: ");
            int segundos = int.Parse(Console.ReadLine());

            // Paso 2: Obtener calculo de horas.
            int horas = segundos / 3600;
            int auxSegundos = segundos % 3600;

            // Paso 3: Obtener calculo de minutos.
            int minutos = auxSegundos / 60;
            auxSegundos = auxSegundos % 60;

            // Paso 4: Obtener calculo de segundos (sobrante).

            Console.WriteLine($"\n La cantidad de {segundos} segundos es: {horas} horas, {minutos} minutos, {auxSegundos} segundos.");
            Console.WriteLine();
        }
        public static void opcion2()
        {
            // Paso 1: Obtener segundos del usuario:
            Console.Write("Introduce el número en Horas a transformar: ");
            int horas = int.Parse(Console.ReadLine());

            Console.Write("\nIntroduce el número en Minutos a transformar: ");
            int minutos = int.Parse(Console.ReadLine());

            Console.Write("\nIntroduce el número en Segundos a transformar: ");
            int segundos = int.Parse(Console.ReadLine());

            int horas_segundos = horas * 3600;

            int minutos_segundos = minutos * 60;

            Console.WriteLine($"\nLa cantidad de {horas} horas, {minutos} minutos, {segundos} segundos es: {horas_segundos + minutos_segundos + segundos} segundos.\n");
        }

        static void vectorInformarYVisualizar10numerosAleatorios()
        {
            // Definir Array
            int[] array = new int[10];

            // informar array
            informarArray(array);

            // visualizar el array
            visualizarArray(array);
        }

        static void informarArray(params int[] array)
        {
            Random random = new Random();
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = random.Next(0, 51);
            }
        }

        static void visualizarArray(params int[] array)
        {
            foreach (int i in array)
            {
                Console.WriteLine(i);
            }
        }

        static void pruebaRefVal()
        {
            int num1 = 5;
            int num2 = 4;
            int num3 = 0;
            num3 = prueba_valor(num1, num2);
            num3 = prueba_referencia(num1, ref num2);
            int[] array = new int[] { 1, 2, 3, 4 };
            int retornoParams = prueba_params(1, 2, 3, 4);
        }

        static int prueba_valor(int num1, int num2)
        {
            num1 = 10;
            num2 = 20;
            return num1 + num2;
        }
        static int prueba_referencia(int num1, ref int num2)
        {
            num1 = 10;
            num2 = 20;
            return num1 + num2;
        }

        static int prueba_params(params int[] numeros)
        {
            return numeros.Length;
        }
    }
}

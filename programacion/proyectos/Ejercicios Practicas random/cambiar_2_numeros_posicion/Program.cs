using System;

namespace cambiar_2_numeros_posicion
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Realice un programa modular donde el usuario introduzca dos números enteros y se intercambien de posición.
            int[] numeros = new int[2];

            // Solicitar numeros
            SolicitarNumeros(numeros);

            // Intercambiar posiciones
            IntercambiarPosiciones(numeros);

            // Imprimir resultado
            Console.WriteLine($"Los números {numeros[1]} y {numeros[0]} han cambiado de posición: {numeros[0]} y {numeros[1]}");
        }

        static void SolicitarNumeros(int[] numeros)
        {
            Console.WriteLine("Hola, vamos a intercambiar dos numeros de posiciones.");
            for (int i = 0; i < numeros.Length; i++)
            {
                do
                {
                    Console.Write($"\nIntroduce el numero {i + 1}: ");
                    numeros[i] = ValidarDatos(Console.ReadLine());
                }
                while (numeros[i] <= 0);
            }
        }

        static int ValidarDatos(string datos)
        {
            int num = -1;

            if (!int.TryParse(datos, out num))
                num = -1;

            if (num <= 0)
                Console.WriteLine("ERROR: Debes introducir un número válido mayor a 0.");

            return num;
        }

        static void IntercambiarPosiciones(int[] numeros)
        {
            int tempNum = numeros[0];
            numeros[0] = numeros[1];
            numeros[1] = tempNum;
        }
    }
}

using System;

namespace suma_digitos_numero
{
    class Program
    {
        static void Main(string[] args)
        {
            // Realice un programa modular donde se calcule la suma de los dígitos de un número que el usuario introduzca por pantalla.
            // Por ejemplo, si el usuario introduce el número 369, el resultado sería: 3 + 6 + 9 = 18

            // Primero obtenermos el numero
            int numero = obtenerNumero();

            // Imprimimos el resultado calculando la suma
            Console.WriteLine($"\nLa suma del número {numero} es: {calcularSuma(numero)}");
        }

        static int obtenerNumero()
        {
            // Pedimos el numero y lo validamos.
            Console.WriteLine("Hola, vamos a calcular la suma de todos los digitos de un número.");
            int result = 0;
            do
            {
                Console.Write("Introduce un número de 1 a 10000: ");
                result = validarDato(Console.ReadLine());
            }
            while (result <= 0);

            return result;
        }

        static int validarDato(string dato)
        {
            int datoValidado = 0;
            int.TryParse(dato, out datoValidado);
            // Solo es valido si es un numero entero entre 1 y 10000
            if (datoValidado <= 0 || datoValidado > 10000)
                invalidarDato(ref datoValidado);

            return datoValidado;
        }

        static void invalidarDato(ref int dato)
        {
            dato = -1;
            Console.WriteLine("Dato introducido no váido, por favor, introduce un número entero de 1 a 10000.");
        }

        static int calcularSuma(int x)
        {
            // Convertimos el numero a string
            string numero = x.ToString();
            int sumaTotal = 0;
            // Recorremos el string
            foreach (char s in numero)
            {
                // Convertimos cada char del string a string para poder convertirlo a int de forma adecuada (ASCII).
                string valorTemp = s.ToString();
                int numTemp = Convert.ToInt32(valorTemp);

                // Sumamos el numero al total.
                sumaTotal += numTemp;
            }

            return sumaTotal;
        }
    }
}

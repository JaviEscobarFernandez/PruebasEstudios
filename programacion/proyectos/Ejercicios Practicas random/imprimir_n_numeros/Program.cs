using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace imprimir_n_numeros
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
            A continuación, analizaremos otro ejemplo recursivo.En este caso, vamos a imprimir por pantalla n números naturales.
            Será el usuario quién decida qué números naturales querrá imprimir.Por ejemplo, si el usuario introduce el número 6,
            se imprimirá por pantalla la siguiente secuencia: 1 2 3 4 5 6
            */

            // Solicitar numero
            int numero = SolicitarNumero();

            // Generar secuencia
            string secuencia = GenerarSecuencia(numero);

            // Imprimir resultado
            Console.Write("La secuencia es:" + secuencia);
        }

        static int SolicitarNumero()
        {
            Console.WriteLine("Hola, vamos a generar una secuencia de números naturales del 1 al que indiques.");
            int num = 0;
            do
            {
                Console.Write("Introduce el número: ");
                num = ValidarNumero(Console.ReadLine());
            }
            while (num <= 0);

            return num;
        }

        static int ValidarNumero(string datos)
        {
            int num = 0;
            if (!int.TryParse(datos, out num))
                num = -1;

            if (num <= 0 || num > 20)
            {
                Console.WriteLine("ERROR: dato introducido ni válido, debe ser un número entre 1 y 20.");
                num = -1;
            }

            return num;
        }

        static string GenerarSecuencia(int numero)
        {
            int maxNum = numero;
            string secuencia = "";
            Secuenciar(1, maxNum, ref secuencia);
            return secuencia;
        }
        static void Secuenciar(int numero, int maxNum, ref string secuencia)
        {
            if (numero > maxNum)
                return;
            secuencia = secuencia + " " + Convert.ToString(numero);
            Secuenciar(++numero, maxNum, ref secuencia);
        }
    }
}

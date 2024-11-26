using System;

namespace libreria_vt08
{
    public class Operaciones
    {
        public static int Sumar(int num1, int num2) {  return num1 + num2; }
        public static int Restar(int num1, int num2) { return num1 - num2; }
        public static int Multiplicar(int num1, int num2) { return num1 * num2; }
        public static int Dividir(int num1, int num2)
        {
            if (num2 == 0)
            {
                Console.WriteLine("ERROR: no es posible dividir entre 0");
                return 0;
            }
            return num1 / num2;
        }
    }
}

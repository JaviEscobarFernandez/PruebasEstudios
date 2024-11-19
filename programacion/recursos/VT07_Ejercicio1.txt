using System;

namespace M03_VT08_Práctica
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numero1 = 5;
            int numero2 = 4;
            int numero3 = 0;
            //----------------------------------------------------------------- Paso por valor
            //numero3 = prueba_valor(numero1, numero2);

            //----------------------------------------------------------------- Paso por referencia
            //numero3 = prueba_referencia(numero1, ref numero2);
            //prueba_referencia2(numero1, numero2, ref numero3);


            //----------------------------------------------------------------- Tipos parámetros de referencia
            //----------------------------------------------------- params
            int[] array = new int[] { 1, 2, 3, 4 };

            //numero3 = prueba_params(array);
            //numero3 = prueba_params(1,2,3,4);
            //numero3 = prueba_params(1, 4);
            //numero3 = prueba_params();

            //----------------------------------------------------- in
            //numero3 = prueba_in(numero1, numero2);


            //----------------------------------------------------- out
            prueba_out(out numero1);

        }
        public static int prueba_params(params int[] numeros)
        {
            int suma = 0;
            foreach (int num in numeros)
            {
                suma += num;
            }
            return suma;
        }

        public static int prueba_in(in int num1, int num2)
        {
            // num1 = 100; ------ Esto da error de compilación
            return num1 + num2;
        }

        public static void prueba_out(out int num1)
        {
            num1 = 100;
        }

        public static void prueba_referencia2(int num1, int num2, ref int resultado)
        {
            resultado =  num1 + num2;
        }

        public static int prueba_referencia(int num1, ref int num2)
        {
            num1 = 10;
            num2 = 20;

            return num1 + num2;
        }
        public static int prueba_valor(int num1, int num2)
        {
            num1 = 10;
            num2 = 20;

            return num1 + num2;
        }
    }
}
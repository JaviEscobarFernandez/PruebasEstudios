using System;

namespace prueba_tipo_datos_y_conversiones
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // tipo datos simples:
            // enteros sin signo
            byte num1 = 1;
            ushort num2 = 2;
            uint num3 = 3;
            ulong num4 = 4;
            // enteros con signo
            sbyte num5 = 5;
            short num6 = -6;
            int num7 = 7;
            long num8 = -8;
            // con precision
            float num9 = 9.01f;
            double num10 = 10.10;
            decimal num11 = 11.11M;
            // booleanos
            bool esTrue = true;
            bool esFalse = false;
            // caracteres
            char letra = 'J';
            string nombre = "Javi";

            // conversiones implicitas:
            // num1 = num2; // Esto no se puede realizar porque byte es menor tamaño maximo que ushort
            num2 = num1;
            num3 = num2;
            num4 = num3;
            // num5 = num1; // Esto tampoco se puede realizar, un byte no puede convertirse a sbyte de forma implicita (y viceversa)
            num6 += num1;
            num8 = num7 + num6 + num5;
            // num8 = num9; // Esto tampoco se puede realizar, no se puede convertir un entero (con o sin signo) a un float
            num9 = num8;
            num10 += num9;
            // num10 = num11; // Esto tampoco se puede realizar, no se puede convertir un float o double a decimal (y viceversa)
            num11 = 40.7M + 10.2M;
            Console.WriteLine($"Test {num4} {num10} {num11}"); // 1 17,1 50,9

            // conversiones explicitas:
            num5 = Convert.ToSByte(num1); // Convertimos byte a sbyte
            // num4 = Convert.ToUInt64(num6); // Lo podemos convertir, pero cuidado, num6 es negativo, por lo que se va a salir de rango
            num11 = (decimal)num10;
            num3 = (uint)num11; // Aqui convertimos decimal a uint, por lo que truncaremos, se quedará sin decimales
            Console.WriteLine($"Test 2 {num11} {num3}"); // 17,1 17

            // Prueba booleanos
            Console.WriteLine($"Test: {esTrue} {esFalse} {esTrue == esFalse} {esFalse != esTrue}"); // true false false true

            // Prueba Char
            char[] nombreVector = nombre.ToCharArray();
            foreach (char c in nombreVector)
            {
                // Si la letra localizada es la misma que teniamos almacenada, la convertimos a string y la pasamos a minuscula
                if (c == letra)
                {
                    string letraEncontrada = Convert.ToString(c).ToLower();
                    Console.Write($"\t{letraEncontrada}");
                }
                // Sino, imprimimos normal
                else
                    Console.Write($"\t{c}");
            }
            Console.WriteLine();

            // Prueba strings
            nombre = "    " + nombre + "              "; // Concatenar
            Console.WriteLine("|" + nombre + "|"); // |    Javi              |

            // Le quitamos los espacios del principio y final a nombre
            nombre = nombre.Trim();
            Console.WriteLine("|" + nombre + "|"); // |Javi|

            // Contamos el numero de caracteres de nombre:
            int numCaracteres = nombre.Length;
            Console.WriteLine($"{nombre} contiene {numCaracteres} caracteres.");
            string trozoNombre = nombre.Substring(1, nombre.Length - 1);
            Console.WriteLine($"El nombre sin la primera letra es: {trozoNombre}");
            if (nombre.Contains("av"))
                Console.WriteLine("El nombre contiene el conjunto de caracteres 'av'");
            nombre = nombre.ToUpper();
            Console.WriteLine($"El nombre en mayúsculas es: {nombre} y en minúsculas es: {nombre.ToLower()}");
        }
    }
}

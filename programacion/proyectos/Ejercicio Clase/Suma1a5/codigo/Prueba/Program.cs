using System;

namespace Prueba
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int i = 1;
            int result = 0;
            while (i <= 5)
            {
                result += i;
                i++;
            }
            Console.WriteLine(result);
        }
    }
}

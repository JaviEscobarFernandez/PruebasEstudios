namespace Impar1a10
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Funcion para mostrar los numeros impares del 1 al 10.
            UInt32 x = 1;
            UInt32 resultado = x;
            while (resultado < 10)
            {
                Console.WriteLine(resultado);
                x++;
                resultado = x * 2 - 1;
            }
        }
    }
}

using System;

namespace cuenta_regresiva_10_1_recursivo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Implementa un programa que realice una cuenta regresiva desde 10 hasta 1, simulando una cuenta atrás
            // para el despegue de un cohete. Al llegar a 1, el programa debe mostrar un mensaje indicando que el cohete ha despegado
            // La cuenta atrás debe implementarse mediante una función recursiva.
            const int tiempo_despegue = 10;
            cuenta_atras(tiempo_despegue);
        }

        static void cuenta_atras(int contador)
        {

            if (contador > 0)
            {
                Console.WriteLine(contador);
                cuenta_atras(contador - 1);
            }
            else
                Console.WriteLine("¡Despegue!");
        }
    }
}

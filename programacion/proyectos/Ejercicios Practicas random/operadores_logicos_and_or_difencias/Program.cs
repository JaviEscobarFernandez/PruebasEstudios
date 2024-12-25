using System;

namespace operadores_logicos_and_or_difencias
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // & y | se deben utilizar para operaciones bit a bit
            int a = 0x00000001; // valor 1
            int b = 0x00000002; // valor 2
            int c = 0x00000010; // valor 16
            int d = a | b; // valor 1 | 2 = 3
            Console.WriteLine($"a: {a}, b: {b}, c: {c}, d: {d}");
            int x = a & c; // valor 0 porque no coinciden
            int y = b & d; // valor 2 porque coinciden en dicho bit
            Console.WriteLine($"x: {x}, y: {y}");
            d |= c; // d ahora es 3 | 16 = 19
            int z = (a | b | c) & d; // valor 1 | 2 | 16 & 19 = 19
            Console.WriteLine($"a: {a}, b: {b}, c: {c}, d: {d}, x: {x}, y: {y}, z: {z}");

            // && y || se deben utilizar para comprobaciones lógicas, ya que son más eficientes (no comprueban el segundo operando si no es requerido)
            int num1 = 0;
            int num2 = 10;
            // Aquí, al no cumplirse la primera condición, ya no comprueba la segunda.
            if (num1 > 0 && num2 < 10)
                Console.WriteLine("test"); // No se imprimirá
            // Aquí se comprueba el segundo operando aunque es innecesario con &
            if (num1 > 0 & num2 < 10)
                Console.WriteLine("test"); // No se imprimirá
            // Aquí, al cumplirse la primera condición, ya no comprueba la segunda.
            if (num1 == 0 || num2 < 10)
                Console.WriteLine("test"); // Se imprimirá
            // Aquí se comprueba el segundo operando aunque es innecesario con |
            if (num1 == 0 | num2 < 10)
                Console.WriteLine("test"); // Se imprimirá

            // XOR             V          F          V          V      = (V^F = V^V = F^V =) V
            bool xorTest = (1 == 1) ^ (1 == 2) ^ (1 == 1) ^ (1 == 1);
            // Paso 1: True y False pasa a True
            // Paso 2: True True pasa a False
            // Paso 3: False y True pasa a True
            Console.WriteLine(xorTest);
        }
    }
}

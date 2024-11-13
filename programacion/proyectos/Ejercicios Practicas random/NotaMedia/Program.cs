using System;

namespace NotaMedia
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Pedimos que nos vaya indicando las notas de los 7 temas.
            const int totalNotas = 7;
            float[] notas = new float[totalNotas];
            SolicitarNotas(ref notas);

            // Sacamos la media e indicamos el resultado
            Console.WriteLine($"\nEl resultado de tu nota media es: {ObtenerNotaMedia(notas)}");
        }

        static void SolicitarNotas(ref float[] notas)
        {
            Console.WriteLine("Hola, vamos a comprobar tu nota media.");
            for (int i = 0; i < notas.Length; i++)
            {
                // Almacenamos las notas (validandolas primero)
                do
                {
                    float nota = 0;
                    Console.Write($"\nIndica el valor de la nota del exámen Nº{i + 1}: ");
                    if (!ValidarNota(Console.ReadLine(), ref nota))
                    {
                        notas[i] = -1;
                        Console.WriteLine("Dato introducido no válido, debe ser un valor de 0 a 10 (se pueden indicar decimales).");
                    }
                    else
                        notas[i] = nota;
                }
                while (notas[i] < 0);
            }
        }

        static bool ValidarNota(string str, ref float nota)
        {
            float result = nota;
            str = str.Replace(".", ","); // Reemplazamos el punto a una coma para que los decimales (en caso de haberlos) los asigne adecuadamente.

            // Validamos el resultado
            if (!float.TryParse(str, out result))
                return false; // No es adecuado, retornamos false.

            // Si el resultado es menor a 0 o mayor a 10, no es adecuado tampoco.
            if (result < 0 || result > 10.0f)
                return false;

            // Resultado adecuado, retornamos true y asignamos a nota su valor.
            nota = result;
            return true;
        }

        static float ObtenerNotaMedia(float[] notas)
        {
            float notaMedia = 0;
            // Recorremos notas y sumamos todas las notas
            foreach (float i in notas)
            {
                notaMedia += i;
            }
            // Si la suma total de notas es mayor a 0, sacamos la media dividiendola entre el total.
            if (notaMedia > 0)
                notaMedia /= notas.Length;
            // Devolvemos la nota media
            return notaMedia;
        }
    }
}

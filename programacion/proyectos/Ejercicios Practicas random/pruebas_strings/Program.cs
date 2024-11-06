using System;

namespace pruebas_strings
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // PruebaStrings();
            string cadenaTest = "Prueba";
            // Lenght Devuelve el número de caracteres:
            Console.WriteLine($"\nProbando Lenght: \"{cadenaTest}\" tiene {cadenaTest.Length} caracteres.");

            // ToCharArray() convierte un string en un array de caracteres:
            Console.WriteLine("\nProbando ToCharArray()");
            char[] charVector = cadenaTest.ToCharArray();
            // Imprimiendo de diferentes formas charVector
            Console.WriteLine(charVector);
            foreach (char c in charVector)
                Console.Write($"{c}\t");
            Console.WriteLine();

            // Substring() extrae parte de una cadena, se debe indicar el inicio (SubString(X)) o puede ser sobrecargado si se indica inicio y fin (SubString(X, Y))
            Console.WriteLine("\nProbando Substring()");
            Console.WriteLine($"Si le quitamos el primer caracter quedaría: {cadenaTest.Substring(1)}");
            Console.WriteLine($"Si le quitamos los primeros dos caracteres y dejamos los dos siguientes tan solo quedaría: {cadenaTest.Substring(2, 2)}");

            // CopyTo() Copia un numero de caracteres especificados a una determinada posicion del string
            Console.WriteLine("\nProbando CopyTo()");
            // Reemplazamos el caracter en posicion 1 de charVectorTest ('A') por el caracter en posicion 2 de cadenaTest
            char[] charVectorTest = { 'J', 'A', 'V', 'I' };
            cadenaTest.CopyTo(2, charVectorTest, 1, 1);
            foreach (char c in charVectorTest)
                Console.Write($"{c}\t"); // Mostrará "J  u   V   I"

            // Copia tres carácter desde la posición 3 (cuarto carácter) de cadenaTest al array charVector en la posición 1
            cadenaTest.CopyTo(3, charVector, 1, 3);
            Console.WriteLine(charVector); // Mostrará "JuVI"

            // CompareTo() Compara la cadena que tiene el string por otra pasada por parametro
            // devuelve un entero que indica si la posicion es anterior (-1), igual (0) o posterior(1) (orden alfabetico) empieza a comparar desde el primer al ultimo caracter
            Console.WriteLine("\nProbando CompareTo()");
            Console.WriteLine("Melon".CompareTo("Sandia")); // -1 porque "Melon" precede a "Sandia"
            Console.WriteLine("Melon".CompareTo("Melon"));  // 0 porque "Melon" es igual a "Melon"
            Console.WriteLine("Melon".CompareTo("Malon"));  // 1 porque "Melon" sigue a "Malon"

            // Contains() devuelve true o false dependiendo de si el string contiene el string indicado
            Console.WriteLine("\nProbando Contains()");
            string nombreA = "Antonio";
            string nombreB = "Ana";
            Console.WriteLine($"¿{nombreA} contiene la palabra {nombreB}?: {nombreA.Contains(nombreB)}");
            Console.WriteLine($"¿{nombreA} contiene la primera letra de {nombreB} ({nombreB[0]}): {nombreA.Contains(nombreB[0].ToString())}");

            // IndexOf() Busca un caracter especifico en un string, si existe indica su posicion, sino devuelve -1
            Console.WriteLine("\nProbando IndexOf()");
            string nameA = "Juan";
            char a = 'a';
            string cutNameA = nameA.Substring(2);
            Console.WriteLine($"{nameA} tiene la letra \"{a}\" en la posición: {nameA.IndexOf(a)}");
            Console.WriteLine($"{nameA} tiene la palabra \"{cutNameA}\" en la posición: {nameA.IndexOf(cutNameA)}");

            // Insert() inserta una cadena de caracteres en una posicion especifica del string
            Console.WriteLine("\nProbando Insert()");
            string testCadenaDos = "Hola Mundo";
            string resultInsert = testCadenaDos.Insert(3, cadenaTest);
            Console.WriteLine($"Insertando \"{cadenaTest}\" a partir de la tercera posicion de \"{testCadenaDos}\": { resultInsert}");

            // Trim() elimina los espacios en blanco del principio y del final de un string
            Console.WriteLine("\nProbando Trim()");
            string stringTest = "       Hola     Mundo          ";
            string resultTrim = stringTest.Trim();
            Console.WriteLine($"Eliminando los espacios del principio y final de \"{stringTest}\": \"{resultTrim}\"");

            // Replace() devuelve un string donde se ha sustituido un caracter por otro
            Console.WriteLine("\nProbando Replace()");
            string cocheA = "Deportivo";
            string cocheB = cocheA.Replace('o', 'a');
            Console.WriteLine($"Reemplazando los caracteres \"o\" de \"{cocheA}\" por caracteres \"a\": \"{cocheB}\"");

            // Remove() devuelve un string al cual se le han eliminado un número especificado de caracteres desde una posición específica
            Console.WriteLine("\nProbando Remove()");
            string motoA = "motoloco";
            string motoB = motoA.Remove(2, 2);
            Console.WriteLine($"Eliminando 2 caracteres de \"{motoA}\" a partir de la posición 2: \"{motoB}\"");

            // Split() divide un string en un array de strings (string[]) utilizando un delimitador específico
            Console.WriteLine("\nProbando Split()");
            string compra = "Cereales, Peras, Platanos, Sandia, Naranjas";
            string[] productos = compra.Split(',');
            Console.WriteLine($"Lista de la compra completa: {compra}");
            int contadorCompra = 1;
            Console.WriteLine("Lista de la compra separada:");
            foreach (string p in productos)
            {
                Console.WriteLine($"{contadorCompra} - {p.Trim()}");
                ++contadorCompra;
            }
            string[] productosInvertidos = new string[productos.Length];
            Console.WriteLine("\nLista de la compra separada invertida:");
            for (int i = 0; i < productos.Length; i++)
            {
                productosInvertidos[i] = productos[productos.Length - 1 - i];
            }
            int contadorCompraInvertido = 1;
            foreach (string p in productosInvertidos)
            {
                Console.WriteLine($"{contadorCompraInvertido} - {p.Trim()}");
                ++contadorCompraInvertido;
            }
            Console.WriteLine("Lista de la compra completa invertida:");
            foreach (string p in productosInvertidos)
            {
                Console.Write($"{p.Trim()}, ");
            }
            Console.WriteLine("");

            // ToLower() y ToUpper() convierte un string a minusculas o a mayusculas todas las letras
            Console.WriteLine("\nProbando ToLower() y ToUpper()");
            string nombreCompleto = "Javi Escobar Fernandez";
            Console.WriteLine($"Tu nombre: \"{nombreCompleto}\"\nen minusculas seria: \"{nombreCompleto.ToLower()}\"\ny en mayusculas seria: \"{nombreCompleto.ToUpper()}\"");
        }

        static void PruebaStrings()
        { 
            string nombre = "";
            do
            {
                Console.Write("Hola, introduce tu nombre: ");
                nombre = Console.ReadLine();
            }
            while (nombre.Length <= 0);
            
            Console.WriteLine($"El primer caracter del nombre es: {nombre[0]}");

            char[] nombreVector = new char[nombre.Length];
            for (int i = 0; i < nombre.Length; i++)
            {
                nombreVector[i] = nombre[i];
            }

            Console.Write("El nombre es: ");
            foreach (char c in nombreVector)
                Console.Write($"{c}");

            Console.Write("\nInvertido seria: ");
            for (int j = nombreVector.Length - 1; j >= 0; j--)
                Console.Write($"{nombreVector[j]}");

            Console.WriteLine("");
        }
    }
}

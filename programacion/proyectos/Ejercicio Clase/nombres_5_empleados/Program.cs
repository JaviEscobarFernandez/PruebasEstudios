using System;

namespace nombres_5_empleados
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // ejercicioPlanteado(); // Lo he planteado con una matriz en lugar de dos vectores
            ejercicioResueltoEnClase(); // Aqui se ha planteado con dos vectores
        }

        public static void ejercicioResueltoEnClase()
        {
            int numeroEmpleados = 5;
            string[] nombreEmpleado = new string[numeroEmpleados];
            double[] salarioEmpleado = new double[numeroEmpleados];

            // Paso 01: Pedir los datos:
            for (int i = 0; i < nombreEmpleado.Length; i++)
            {
                Console.Write($"Por favor, introduce el nombre del empleado {i + 1}: ");
                nombreEmpleado[i] = Console.ReadLine();
                double salario = 0;
                do
                {
                    Console.Write("Ahora introduce su salario: ");
                    salario = double.Parse(Console.ReadLine());
                }
                while (salario <= 0);
                salarioEmpleado[i] = salario;
            }

            // Paso 02: Comprobar el empleado con el mayor salario:
            int posicionSueldoMayor = 0;
            for (int j = 0; j < nombreEmpleado.Length; j++)
            {
                if (salarioEmpleado[j] > salarioEmpleado[posicionSueldoMayor])
                    posicionSueldoMayor = j;
            }

            // Paso 03: Mostrar empleado y sueldo correspondiente
            Console.WriteLine($"El empleado con mayor sueldo es: {nombreEmpleado[posicionSueldoMayor]} con un sueldo de: {salarioEmpleado[posicionSueldoMayor]}");
        }

        public static void ejercicioPlanteado()
        {
            // Programa que permita ingresar los nombres de 5 empleados y sus respectivos sueldos.
            // El programa debe mostrar el sueldo mayor y el nombre del empleado al que pertenece.
            // Los sueldos son tipo double
            // Los nombres deben ser strings
            // No pueden tener 0 de sueldo

            // Declarar variables
            string[,] empleados = new string[5, 2];

            // Pedir datos iterando
            for (int i = 0; i < 5; i++)
            {
                Console.Write($"Por favor, introduce el nombre del empleado {i+1}: ");
                string nombreEmpleado = Console.ReadLine();

                // Validar datos
                double sueldo = 0;
                do
                {
                    Console.Write("Ahora introduce su sueldo: ");
                    double.TryParse(Console.ReadLine(), out sueldo);
                    if (sueldo <= 0)
                        Console.WriteLine("Sueldo introducido no válido, debe ser un valor mayor a 0.");
                }
                while (sueldo <= 0);

                // Almacenamos en la matriz el nombre del empleado y su sueldo correspondiente
                empleados[i,0] = nombreEmpleado;
                empleados[i,1] = sueldo.ToString();
            }

            // Comprobar el sueldo mas alto, almacenamos la posicion de la matriz para luego buscar e imprimir su nombre y sueldo.
            int posicionSueldoMayor = 0;
            double mayorSueldo = 0;
            for (int j = 0; j < 5; j++)
            {
                double sueldoEmpleado = Convert.ToDouble(empleados[j, 1]);
                if (sueldoEmpleado > mayorSueldo)
                {
                    posicionSueldoMayor = j;
                    mayorSueldo = sueldoEmpleado;
                }
            }

            // Mostrar empleado y sueldo correspondiente
            Console.WriteLine($"El empleado con mayor sueldo es: {empleados[posicionSueldoMayor, 0]} con un sueldo de: {empleados[posicionSueldoMayor, 1]}");
        }
    }
}

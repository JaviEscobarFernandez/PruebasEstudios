SET SERVEROUTPUT ON;

DROP PROCEDURE saludar;

DROP PROCEDURE calcular_diferencia_fechas;

DROP FUNCTION sumar_numeros;

DROP FUNCTION es_par;


-- Ejercicio 1)  Procedimiento:

-- Creaci�n de un procedimiento PL/SQL simple
CREATE OR REPLACE PROCEDURE saludar IS
BEGIN
    dbms_output.put_line('�Hola, mundo!');
END saludar;
/

-- Bloque An�nimo 1 para Probar el Procedimiento:
-- Bloque an�nimo para probar el procedimiento "saludar"
DECLARE BEGIN
    saludar; -- Llama al procedimiento "saludar" para mostrar un saludo
END;
/

-- Ejercicio 2) Funci�n:
-- Creaci�n de una funci�n PL/SQL simple que suma dos n�meros
CREATE OR REPLACE FUNCTION sumar_numeros (
    a NUMBER,
    b NUMBER
) RETURN NUMBER IS
    resultado NUMBER;
BEGIN
    resultado := a + b;
    RETURN resultado;
END sumar_numeros;
/

-- Bloque An�nimo 2 para Probar la Funci�n:
-- Bloque an�nimo para probar la funci�n "sumar_numeros"
DECLARE
    a         NUMBER := 5; -- Cambia el valor de "a" seg�n tus necesidades
    b         NUMBER := 3; -- Cambia el valor de "b" seg�n tus necesidades
    resultado NUMBER;
BEGIN
    resultado := sumar_numeros(a, b); -- Llama a la funci�n para sumar dos n�meros
    dbms_output.put_line('Resultado de la suma '
                         || a
                         || ' + '
                         || b
                         || '  = '
                         || resultado); -- Muestra el resultado
END;
/

-- -- Ejercicio 3) Procedimiento con Fechas:
-- Creaci�n de un procedimiento PL/SQL que muestra la diferencia de d�as entre dos fechas
CREATE OR REPLACE PROCEDURE calcular_diferencia_fechas (
    fecha1 DATE,
    fecha2 DATE
) IS
    diferencia NUMBER;
BEGIN
    diferencia := fecha2 - fecha1;
    dbms_output.put_line('Diferencia de d�as entre '
                         || fecha1
                         || ' y '
                         || fecha2
                         || ' -->  '
                         || diferencia 
                         || ' d�as');

END calcular_diferencia_fechas;
/
-- Bloque An�nimo 3 para Probar el Procedimiento con Fechas:
-- Bloque an�nimo para probar el procedimiento "calcular_diferencia_fechas"
DECLARE
    fecha_inicio DATE :=  '15/11/2024';
    fecha_fin    DATE :=  '20/12/2024';
BEGIN
    calcular_diferencia_fechas(fecha_inicio, fecha_fin);
END;
/

-- Ejercicio 4) Funci�n con Booleanos:
-- Creaci�n de una funci�n PL/SQL que verifica si un n�mero es par
CREATE OR REPLACE FUNCTION es_par (
    numero NUMBER
) RETURN BOOLEAN IS
BEGIN
    IF MOD(numero, 2) = 0 THEN
        RETURN true;
    ELSE
        RETURN false;
    END IF;
END es_par;
/
-- Bloque An�nimo para Probar la Funci�n con Booleanos:
-- Bloque an�nimo para probar la funci�n "es_par"
DECLARE
    numero        NUMBER := 9;  -- Cambia el n�mero a verificar
    es_par_result BOOLEAN;
BEGIN
    es_par_result := es_par(numero);
    IF es_par_result THEN
        dbms_output.put_line(numero || ' es un n�mero PAR');
    ELSE
        dbms_output.put_line(numero || '  es un n�mero IMPAR');
    END IF;
END;
/
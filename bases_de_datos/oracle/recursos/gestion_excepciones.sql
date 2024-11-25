SET SERVEROUTPUT ON
-- 1. Excepciones Oracle predefinidas:
-- La excepción ZERO_DIVIDE es una excepción predefinida que se produce cuando intentas dividir un número entre cero.

DECLARE
    num1 NUMBER := 10;
    num2 NUMBER := 0;
    resultado NUMBER;
BEGIN
    resultado := num1 / num2;
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('Error: División por cero no permitida.');
END;
/

-- 2. Excepciones Oracle NO-predefinidas:
--Una excepción no-predefinida común es ORA-01722 que se produce cuando se intenta convertir una cadena a un número y la cadena no es numéricamente válida.
-- En este ejemplo, si la tabla tabla_no_existente no existe, al intentar eliminarla se generará el error ORA-00942. 
-- Gracias al PRAGMA EXCEPTION_INIT, podemos capturar este error específico y manejarlo con una excepción personalizada ExcepcionTablaNoExiste.
DECLARE
    -- Definimos una excepción
    ExcepcionTablaNoExiste EXCEPTION;

    -- Asociamos la excepción con el error ORA-00942
    PRAGMA EXCEPTION_INIT(ExcepcionTablaNoExiste, -942);
BEGIN
    -- Intentamos eliminar una tabla que no existe
    EXECUTE IMMEDIATE 'DROP TABLE tabla_no_existente';
EXCEPTION
    WHEN ExcepcionTablaNoExiste THEN
        DBMS_OUTPUT.PUT_LINE('Error: La tabla que intentas eliminar no existe.');
END;
/


-- 3. Errores definidos por el usuario:
-- Puedes definir tus propias excepciones para manejar condiciones específicas en tu código.

DECLARE
    num NUMBER := -5;
    ExcepcionNumeroNegativo EXCEPTION;
BEGIN
    IF num < 0 THEN
        RAISE ExcepcionNumeroNegativo;
    ELSE
        DBMS_OUTPUT.PUT_LINE('El número es positivo o cero.');
    END IF;
EXCEPTION
    WHEN ExcepcionNumeroNegativo THEN
        DBMS_OUTPUT.PUT_LINE('Error: El número es negativo.');
END;
/

-- 4. Ejemplo sencillo que utiliza WHEN OTHERS:
-- Vamos a intentar actualizar una nota

BEGIN
    UPDATE notas SET nota = 'A' WHERE id_alumno = 1;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Se ha producido un error al intentar actualizar la NOTA: ' || SQLERRM);
END;
/
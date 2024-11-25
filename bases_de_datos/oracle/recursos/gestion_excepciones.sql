SET SERVEROUTPUT ON
-- 1. Excepciones Oracle predefinidas:
-- La excepci�n ZERO_DIVIDE es una excepci�n predefinida que se produce cuando intentas dividir un n�mero entre cero.

DECLARE
    num1 NUMBER := 10;
    num2 NUMBER := 0;
    resultado NUMBER;
BEGIN
    resultado := num1 / num2;
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('Error: Divisi�n por cero no permitida.');
END;
/

-- 2. Excepciones Oracle NO-predefinidas:
--Una excepci�n no-predefinida com�n es ORA-01722 que se produce cuando se intenta convertir una cadena a un n�mero y la cadena no es num�ricamente v�lida.
-- En este ejemplo, si la tabla tabla_no_existente no existe, al intentar eliminarla se generar� el error ORA-00942. 
-- Gracias al PRAGMA EXCEPTION_INIT, podemos capturar este error espec�fico y manejarlo con una excepci�n personalizada ExcepcionTablaNoExiste.
DECLARE
    -- Definimos una excepci�n
    ExcepcionTablaNoExiste EXCEPTION;

    -- Asociamos la excepci�n con el error ORA-00942
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
-- Puedes definir tus propias excepciones para manejar condiciones espec�ficas en tu c�digo.

DECLARE
    num NUMBER := -5;
    ExcepcionNumeroNegativo EXCEPTION;
BEGIN
    IF num < 0 THEN
        RAISE ExcepcionNumeroNegativo;
    ELSE
        DBMS_OUTPUT.PUT_LINE('El n�mero es positivo o cero.');
    END IF;
EXCEPTION
    WHEN ExcepcionNumeroNegativo THEN
        DBMS_OUTPUT.PUT_LINE('Error: El n�mero es negativo.');
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
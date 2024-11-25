-- Si ya los tenemos creados los podemos elimina
DROP PROCEDURE saludar;
DROP FUNCTION calcular_cuadrado;

-- Ejemplo Bloques Anónimos:
DECLARE
    v_nombre VARCHAR2(50) := 'Tamara';
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hola, ' || v_nombre || '!');
END;
/
-- Ejemplo de un procedimiento:
CREATE OR REPLACE PROCEDURE saludar (p_nombre VARCHAR2) AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('¡Hola, ' || p_nombre || '!');
END saludar;
/
 --llamar a un procedimiento
CALL saludar('Tamara');
EXECUTE saludar('Tamara');
/
-- Ejemplo de un función:
CREATE OR REPLACE FUNCTION calcular_cuadrado (p_numero NUMBER) RETURN NUMBER IS
    v_cuadrado NUMBER;
BEGIN
    v_cuadrado := p_numero * p_numero;
    RETURN v_cuadrado;
END calcular_cuadrado;
/
-- llamar a una función
SELECT calcular_cuadrado(4) FROM dual;
--si necesitamos  almacenar el resultado de la función en una variable PL/SQL dentro de un bloque de código
-- Ejemplo Bloques Anónimos:
DECLARE
    v_number NUMBER := 4;
    v_cuadrado NUMBER;
BEGIN
    v_cuadrado := calcular_cuadrado(v_number);
    DBMS_OUTPUT.PUT_LINE('Cuadrado de ' || v_number || ' = ' || v_cuadrado );
END;


-- 2. Procedimiento
-- Ejercicio: Crear un procedimiento que acepte un número y muestre su tabla de multiplicar.

CREATE OR REPLACE PROCEDURE TablaMultiplicar(p_numero NUMBER) AS
BEGIN
    FOR i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(p_numero || ' x ' || i || ' = ' || (p_numero * i));
    END LOOP;
END TablaMultiplicar;
/
-- Invocación:

BEGIN
    TablaMultiplicar(7);  -- Mostrará la tabla de multiplicar del 7.
END;
/




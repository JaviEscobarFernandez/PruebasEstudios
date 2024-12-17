-- Ejercicio: Crear un procedimiento que acepte un número y muestre su tabla de multiplicar.
CREATE OR REPLACE PROCEDURE tabla_multiplicar(p_numero IN NUMBER) IS
    v_result NUMBER := 0;
BEGIN
    FOR mult IN 1..10 LOOP
        v_result := p_numero * mult;
        DBMS_OUTPUT.PUT_LINE(p_numero ||' x ' || mult || ' = ' || v_result);
    END LOOP;
END;
/

DECLARE
    v_numero NUMBER := &numero;
BEGIN
    tabla_multiplicar(v_numero);
END;
/
-- Ejercicio: Excepción evitar dividir por 0 (excepcion predefinida)
DECLARE
    v_num1 NUMBER(3) := &numero1;
    v_num2 NUMBER(3) := &numero2;
    v_result NUMBER(5);
BEGIN
    v_result := v_num1 / v_num2;
    DBMS_OUTPUT.PUT_LINE(v_num1 || ' entre ' || v_num2 || ' es: ' || v_result);
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: no se puede dividir entre 0');
END;
/
-- Excepción no predefinida
DECLARE
    v_pass NUMBER(30) := &password;
    no_string_exception EXCEPTION;
    PRAGMA EXCEPTION_INIT(no_string_exception, -06502);
BEGIN
    v_pass := 'aasd';
    DBMS_OUTPUT.PUT_LINE('La contraseña es: ' || v_pass);
EXCEPTION
    WHEN no_string_exception THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: No puedes introducir caracteres en un campo numérico');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || sqlcode);
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || sqlerrm);
END;
/
-- Excepcion definida por el usuario
DECLARE
    numero_negativo EXCEPTION;
    v_num1 NUMBER := &numero;
BEGIN
    IF v_num1 < 0 THEN
        RAISE numero_negativo;
    END IF;
        DBMS_OUTPUT.PUT_LINE('El número es: ' || v_num1);
EXCEPTION
    WHEN numero_negativo THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: No se admiten números menores a 0');
END;
/
-- Mas ejercicios
SET SERVEROUTPUT ON;
-- Excepción predefinida por Oracle
DECLARE
    v_num1 NUMBER(5) := &numero1;
    v_num2 NUMBER(5) := &numero2;
    v_resultado INTEGER(8,2) := 0;
BEGIN
    v_resultado := v_num1 / v_num2;
    DBMS_OUTPUT.PUT_LINE('El resultado de dividir ' || v_num1 || ' entre ' || v_num2 || ' es: ' || v_resultado);
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: no se puede dividir entre 0');
END;
/
-- Excepción NO predefinida por Oracle
DECLARE
    tablaNoExistente EXCEPTION;
    PRAGMA EXCEPTION_INIT(tablaNoExistente, -00942);
BEGIN
    EXECUTE IMMEDIATE'DROP TABLE tablanoexistente1';
EXCEPTION
    WHEN tablaNoExistente THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: la tabla que intentas borrar no existe.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
-- Excepción definida por el usuario
DECLARE
    valorNegativo EXCEPTION;
    v_num1 NUMBER(5) := &numero;
BEGIN
    IF v_num1 < 0 THEN
        RAISE valorNegativo;
    END IF;
    CASE v_num1
        WHEN 1 THEN DBMS_OUTPUT.PUT_LINE('Es válido');
        WHEN 2 THEN DBMS_OUTPUT.PUT_LINE('Es válido');
        WHEN 3 THEN DBMS_OUTPUT.PUT_LINE('Es válido');
        ELSE DBMS_OUTPUT.PUT_LINE('No es válido');
    END CASE;
EXCEPTION
    WHEN valorNegativo THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: No se admiten valores negativos.');
END;
/
-- Ejemplo para utilizar WHEN OTHERS y SQLERRM para obtener el codigo del error
BEGIN
    EXECUTE IMMEDIATE 'UPDATE tablanoexistente SET columna1=0 WHERE columna0=1';
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: el mensaje/código es: ' ||SQLERRM);
END;
/

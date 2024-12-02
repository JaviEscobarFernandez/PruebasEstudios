-- Procedimiento saludo:
DROP PROCEDURE saludar;
CREATE OR REPLACE PROCEDURE saludar(p_nombre IN VARCHAR2) IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hola ' || p_nombre);
END saludar;
/
DECLARE
    v_nombre VARCHAR2(10) := '&nombre';
BEGIN
    saludar(v_nombre);
END;
/

-- Funcion sumar dos numeros:
CREATE OR REPLACE FUNCTION sumar_numeros(p_num1 IN NUMBER, p_num2 IN NUMBER) RETURN NUMBER AS
    resultado NUMBER := 0;
BEGIN
    resultado := p_num1 + p_num2;
    RETURN resultado;
END sumar_numeros;
/
DECLARE
    v_num1 NUMBER(10) := &numero1;
    v_num2 NUMBER(10) := &numero2;
BEGIN
    DBMS_OUTPUT.PUT_LINE('La suma de ' || v_num1 || ' + ' ||v_num2 || ' es: ' || sumar_numeros(v_num1, v_num2));
END;
/

-- Procedimiento calcular diferencia de dos fechas
CREATE OR REPLACE PROCEDURE calcular_diferencia_fechas (p_fecha1 DATE, p_fecha2 DATE) IS
    v_diferencia NUMBER := 0;
BEGIN
    v_diferencia := p_fecha2 - p_fecha1;
    DBMS_OUTPUT.PUT_LINE('La diferencia de ' || p_fecha1 || ' y ' ||p_fecha2 || ' es: ' || v_diferencia);
END calcular_diferencia_fechas;
/
DECLARE
    v_fecha1 DATE := '15/11/2024';
    v_fecha2 DATE := '26/11/2024';
BEGIN
    calcular_diferencia_fechas(v_fecha1,v_fecha2);
END;
/

-- Crear funcion bool para verificar si un numero dado es Par.
CREATE OR REPLACE FUNCTION es_par(p_num IN NUMBER) RETURN BOOLEAN AS
    v_is_par BOOLEAN := FALSE;
BEGIN
    -- MOD es modulo igual que en C# %
    -- Dividimos entre 2, si el resto es 0, es par (p_num % 2 == 0)
    IF MOD(p_num, 2) = 0 THEN
        v_is_par := TRUE;
    END IF;
    RETURN v_is_par;
END es_par;
/
DECLARE
    v_num NUMBER := &numero;
BEGIN
    IF es_par(v_num) = TRUE THEN
        DBMS_OUTPUT.PUT_LINE(v_num || ' es par.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_num || ' es impar.');
    END IF;
END;
/

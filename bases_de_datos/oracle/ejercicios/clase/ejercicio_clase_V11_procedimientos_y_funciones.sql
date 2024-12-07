-- Ejemplos de Procedimientos y Funciones sencillas en PL/SQL
-- Ejercicio 1) Un procedimiento llamado "saludar" que muestra un saludo simple
-- Bloque anónimo 1 llamando al procedimiento "saludar"
CREATE OR REPLACE PROCEDURE saludar(p_nombre IN VARCHAR2) IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('¡Hola ' || p_nombre || '!');
END;
/
DECLARE
    v_nombre VARCHAR2(50) := '&nombre';
BEGIN
    saludar(v_nombre);
END;
/

-- Ejercicio 2) Una función llamada "sumar_numeros" que suma dos números y devuelve el resultado.
-- Bloque anónimo 2 utilizando la función "sumar_numeros" para realizar una suma y mostrar el resultado.
CREATE OR REPLACE FUNCTION sumar_numeros(p_num1 IN NUMBER, p_num2 IN NUMBER) RETURN NUMBER IS
    v_result NUMBER(5) := 0;
BEGIN
    v_result := p_num1 + p_num2;
    RETURN v_result;
END;
/
DECLARE
    v_num1 NUMBER(5) := &numero1;
    v_num2 NUMBER(5) := &numero2;
BEGIN
    DBMS_OUTPUT.PUT_LINE('El resultado de sumar ' || v_num1 || ' + ' || v_num2 || ' es: ' || sumar_numeros(v_num1, v_num2));
END;
/

-- Ejercicio 3) Un procedimiento llamado "calcular_diferencia_fechas" que muestra la diferencia de días entre dos fechas
-- Bloque anónimo 3 llamando al procedimiento "calcular_diferencia_fechas"
CREATE OR REPLACE PROCEDURE calcular_diferencia_fechas(p_fecha1 IN DATE, p_fecha2 IN DATE) IS
    v_diferencia_fechas NUMBER;
BEGIN
    v_diferencia_fechas := p_fecha2 - p_fecha1;
    DBMS_OUTPUT.PUT_LINE('La diferencia es: ' || v_diferencia_fechas || ' días');
END;
/
DECLARE
    v_fecha1 DATE := TO_DATE('&fecha1', 'yyyy/mm/dd');
    v_fecha2 DATE := TO_DATE('&fecha2', 'yyyy/mm/dd');
BEGIN
    calcular_diferencia_fechas(v_fecha1, v_fecha2);
END;
/

-- Ejercicio 4) Una función llamada “es_par" queue verifica si un número es par o no (True / False).
-- Bloque anónimo 4 para probar la función "es_par"
CREATE OR REPLACE FUNCTION es_par(p_numero IN NUMBER) RETURN BOOLEAN IS
    v_par BOOLEAN := FALSE;
BEGIN
    IF MOD(p_numero, 2) = 0 THEN
        v_par := TRUE;
    END IF;
    RETURN v_par;
END;
/
DECLARE
    v_numero NUMBER := &numero;
BEGIN
    IF es_par(v_numero) THEN
        DBMS_OUTPUT.PUT_LINE('El numero: ' || v_numero || ' es par.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('El numero: ' || v_numero || ' es impar.');
    END IF;
END;
/

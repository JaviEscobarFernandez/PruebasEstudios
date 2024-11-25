SET SERVEROUTPUT ON

-- Uso de IF:
-- En este bloque, estamos declarando una variable llamada edad. 
-- Luego, mediante una estructura IF-ELSE, verificamos si la persona es mayor de edad (es decir, si tiene 18 años o más). 
-- Dependiendo del resultado, se imprime un mensaje adecuado.

DECLARE
    v_edad NUMBER; -- Declaración de una variable 'edad' 
BEGIN

    v_edad := &edad; -- entrada por pantalla y asignación del valor
    -- Comprueba si la 'edad' es mayor o igual a 18
    IF v_edad >= 18 THEN
        dbms_output.put_line('Mayor de edad.'); -- Si es verdadero, imprime 'Mayor de edad.'
    ELSE
        dbms_output.put_line('Menor de edad.'); -- Si es falso, imprime 'Menor de edad.'
    END IF;
END;
/

-- Uso de CASE:
-- En este bloque, se declara una variable día con por entrada y otra variable nombre_del_día para almacenar el nombre del día correspondiente. 
-- Luego, utilizando la estructura CASE, se verifica el valor de día para asignar el nombre del día adecuado a nombre_del_día. 
-- Finalmente, se imprime el resultado.

DECLARE
    v_dia            NUMBER; --Declaración de una variable 'dia'
    v_nombre_del_dia VARCHAR2(20); -- Declaración de la variable 'nombre_del_día' para almacenar el nombre del día
BEGIN
    v_dia  := &dia;
    -- Se evalúa el valor de 'día' para determinar el nombre del día correspondiente
    CASE v_dia
        WHEN 1 THEN
            v_nombre_del_dia := 'Lunes';
        WHEN 2 THEN
            v_nombre_del_dia := 'Martes';
        WHEN 3 THEN
            v_nombre_del_dia := 'Miércoles';
        WHEN 4 THEN
            v_nombre_del_dia := 'Jueves';
        WHEN 5 THEN
            v_nombre_del_dia := 'Viernes';
        WHEN 6 THEN
            v_nombre_del_dia := 'Sábado';
        WHEN 7 THEN
            v_nombre_del_dia := 'Domingo';
        ELSE
            v_nombre_del_dia := 'Día inválido'; -- Si 'dia' no está entre 1 y 7, se considera inválido
    END CASE;

    dbms_output.put_line(v_nombre_del_dia); -- Imprime el 'nombre_del_día' determinado
END;
/

-- Uso de WHILE:
-- Escriba un bloque que imprima los números del 1 al 5 usando un bucle WHILE.
DECLARE
    v_cont NUMBER := 1; -- Inicializa contador
BEGIN
    WHILE v_cont <= 5 LOOP
        dbms_output.put_line(v_cont); -- Imprime el valor del contador
        v_cont := v_cont + 1; -- Incrementa el contador
    END LOOP;
END;
/


-- Uso de FOR en orden inverso:
-- Imprimir los números del 5 al 1 en orden decreciente usando un bucle FOR.
BEGIN
    FOR contador IN REVERSE 1..5 LOOP
        dbms_output.put_line(contador); -- Imprime el valor del contador
    END LOOP;
END;
/

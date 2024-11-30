-- set serveroutput on se utiliza para mostrar en la salida de script los mensajes
-- Pero es mas organizado si los mostramos de forma especifica en la salida DBMS
-- Asi que no es necesario (por defecto esta en off)
-- SET SERVEROUTPUT ON;

SET SERVEROUTPUT OFF;

-- Probando bloques anonimos
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hola');
END;
/
DECLARE
    v_var1 NUMBER := 0;
    v_cad1 VARCHAR2(10) := 'prueba';
    v_fecha DATE := SYSDATE; -- sysdate es la fecha actual
BEGIN
    DBMS_OUTPUT.PUT_LINE('El valor de v_var1 es: ' || v_var1);
    DBMS_OUTPUT.PUT_LINE('El valor de v_cad1 es: ' || v_cad1);
    DBMS_OUTPUT.PUT_LINE('El valor de v_fecha es: ' || v_fecha);
    v_var1 := 14;
    DBMS_OUTPUT.PUT_LINE('El valor de v_var1 es: ' || v_var1);

END;
/

-- Pedir datos y realizar suma
DECLARE
    v_op1 NUMBER(3) := &operando1; -- con &xnombre se pide que se introduzca un valor al usuario
    v_op2 NUMBER(3) := &operando2;
    v_sum NUMBER(3);
BEGIN
    v_sum := v_op1 + v_op2;
    DBMS_OUTPUT.PUT_LINE(v_op1 || ' + ' || v_op2 || ' = ' || v_sum);
END;
/

-- Operadores aritmeticos
DECLARE
    v_n1 NUMBER(2) := &operando1;
    v_n2 NUMBER(2) := &operando2;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Suma: '|| (v_n1 + v_n2));
    DBMS_OUTPUT.PUT_LINE('Resta: '|| (v_n1 - v_n2));
    DBMS_OUTPUT.PUT_LINE('Multiplicacion: '|| (v_n1 * v_n2));
    DBMS_OUTPUT.PUT_LINE('Division: '|| (v_n1 / v_n2));
    DBMS_OUTPUT.PUT_LINE('Potencia: '|| (v_n1 ** v_n2));
END;
/

-- Bloque if elsif else
DECLARE
    v_n1 NUMBER(2) := &numero1;
    v_n2 NUMBER(2) := &numero1;
    v_n3 NUMBER(2) := &numero1;
BEGIN
    IF v_n1 >= v_n2 AND v_n1 >= v_n3 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es el mayor');
    ELSIF v_n2 >= v_n3 THEN
        DBMS_OUTPUT.PUT_LINE(v_n2 || ' es el mayor');
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_n3 || ' es el mayor');

    END IF;
END;
/

-- Operadores logicos y relacionales
DECLARE
    v_n1 NUMBER(2) := &numero1;
    v_n2 NUMBER(2) := &numero1;
    v_n3 NUMBER(2) := &numero1;
BEGIN
    IF v_n1 < v_n2 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es menor que ' || v_n2);
    END IF;

    IF v_n1 > v_n2 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es mayor que ' || v_n2);
    END IF;

    IF v_n1 >= v_n2 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es mayor o igual que ' || v_n2);
    END IF;

    IF v_n1 <= v_n2 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es menor o igual que ' || v_n2);
    END IF;

    IF v_n1 = v_n2 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es igual que ' || v_n2);
    END IF;

    IF v_n1 != v_n2 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es distinto que ' || v_n2);
    END IF;

    IF v_n1 > v_n2 AND v_n1 > v_n3 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es mayor que ' || v_n2 ||
        ' y mayor que ' || v_n3);
    END IF;

    IF v_n1 = v_n2 OR v_n2 > v_n3 THEN
        DBMS_OUTPUT.PUT_LINE(v_n1 || ' es igual que ' || v_n2 ||
        ' o que ' || v_n2 || ' es mayor que ' || v_n3);
    END IF;
END;
/

-- Estructura case:
DECLARE
    v_dia NUMBER(1) := &dia;
BEGIN
    CASE v_dia
        WHEN 1 THEN DBMS_OUTPUT.PUT_LINE('Lunes');
        WHEN 2 THEN DBMS_OUTPUT.PUT_LINE('Martes');
        WHEN 3 THEN DBMS_OUTPUT.PUT_LINE('Miercoles');
        WHEN 4 THEN DBMS_OUTPUT.PUT_LINE('Jueves');
        WHEN 5 THEN DBMS_OUTPUT.PUT_LINE('Viernes');
        WHEN 6 THEN DBMS_OUTPUT.PUT_LINE('Sabado');
        WHEN 7 THEN DBMS_OUTPUT.PUT_LINE('Domingo');
        ELSE DBMS_OUTPUT.PUT_LINE('ERROR: debes introducir un valor entre 1 y 7');
    END CASE;
END;
/

-- Bucles While, For y Loop
-- Bucle While
DECLARE
    v_i NUMBER(2) := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Bucle While');
    WHILE (v_i <= 10)
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_i);
        v_i := v_i + 1;
    END LOOP;
END;
/
-- Bucle For
DECLARE
    -- v_i NUMBER(2) := 1;
    -- En el bucle for no hace falta crear una variable
    -- Porque se puede declarar en el propio bucle for
BEGIN
    -- Bucle normal (empieza en el primer valor y crece hasta el segundo)
    DBMS_OUTPUT.PUT_LINE('Bucle For');
    FOR v_i IN 1..10
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_i);
    END LOOP;
    -- Bucle reverse (empieza del segundo valor y decrece hasta el primero)
    DBMS_OUTPUT.PUT_LINE('Bucle For Reverse');
    FOR v_i IN REVERSE 1..10
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_i);
    END LOOP;
END;
/
-- Bucle Loop
DECLARE
    v_i NUMBER(2) := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Bucle Loop');
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_i);
        -- Exit When se utiliza para finalizar el bucle cuando se cumpla la condicion
        -- Como un break en c# cuando queremos finalizar el bucle
        EXIT WHEN v_i = 10;
        v_i := v_i + 1;
    END LOOP;
END;
/

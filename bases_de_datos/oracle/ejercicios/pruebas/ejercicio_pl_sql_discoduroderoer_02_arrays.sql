-- Arrays
DECLARE
    -- Para declarar arrays debemos utilizar TYPE nombre IS VARRAY(longitud) OF tipo_de_dato;
    -- Y luego crear una variable de ese array creado nombre_variable nombre_array := nombre_array(aqui ya los valores);
    TYPE alumnosArray IS VARRAY(3) OF VARCHAR2(20);
    v_alumnos alumnosArray := alumnosArray('Jose', 'Juan', 'Manuel');

    TYPE notasArray IS VARRAY(3) OF NUMBER(2);
    v_notas notasArray := notasArray(10, 7, 9);
BEGIN
    -- Aqui recorremos con un for todas las posiciones del array indicando nombre_array.COUNT (que seria como en c# array.Length)
    FOR v_i IN 1..v_alumnos.COUNT
    LOOP
        DBMS_OUTPUT.PUT_LINE('Alumno: ' || v_alumnos(v_i) ||
        ', nota: ' || v_notas(v_i));
    END LOOP;
END;
/

DROP TABLE asignaturas;
DROP TABLE alumnos;
DROP TABLE notas;
DROP PROCEDURE aumentarnotasasignatura;

CREATE TABLE asignaturas (
    codigo_asig VARCHAR2(10) PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
);

CREATE TABLE alumnos (
    id_alumno NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
);


CREATE TABLE notas (
    id_nota NUMBER PRIMARY KEY,
    id_alumno NUMBER REFERENCES alumnos(id_alumno),
    codigo_asig VARCHAR2(10) REFERENCES asignaturas(codigo_asig),
    nota FLOAT NOT NULL
);


INSERT INTO asignaturas (codigo_asig, nombre) VALUES ('DAX_M02B', 'Matemáticas');
INSERT INTO asignaturas (codigo_asig, nombre) VALUES ('DAX_M03C', 'Física');

INSERT INTO alumnos (id_alumno, nombre) VALUES (1, 'Juan Pérez');
INSERT INTO alumnos (id_alumno, nombre) VALUES (2, 'María López');
INSERT INTO alumnos (id_alumno, nombre) VALUES (3, 'Carlos Gómez');

INSERT INTO notas (id_nota, id_alumno, codigo_asig, nota) VALUES (1, 1, 'DAX_M02B', 2.5);
INSERT INTO notas (id_nota, id_alumno, codigo_asig, nota) VALUES (2, 2, 'DAX_M02B', 3.2);
INSERT INTO notas (id_nota, id_alumno, codigo_asig, nota) VALUES (3, 3, 'DAX_M02B', 4.1);
INSERT INTO notas (id_nota, id_alumno, codigo_asig, nota) VALUES (4, 1, 'DAX_M03C', 3.5);
INSERT INTO notas (id_nota, id_alumno, codigo_asig, nota) VALUES (5, 2, 'DAX_M03C', 4.0);
INSERT INTO notas (id_nota, id_alumno, codigo_asig, nota) VALUES (6, 3, 'DAX_M03C', 4.8);



-- Crea un procedimiento que aumente un número de % como parámetro de entrada las notas de los alumnos 
-- de una asignatura que le pasamos por parámetro. Nos devolverá el número total de alumnos actualizados 
-- y la nueva nota media. No muestra nada por pantalla.
CREATE OR REPLACE PROCEDURE aumentarnotasasignatura (
    p_codigo_asig IN VARCHAR2,
    p_aumento     IN INTEGER,
    p_num_alumnos OUT NUMBER,
    p_nota_media  OUT FLOAT
) AS
    -- Definición de las variables para total de notas y nota actualizada
    v_total_nota       FLOAT := 0;
    v_nota_actualizada notas.nota%TYPE;

    -- Definición del cursor explícito para seleccionar todas las notas de una asignatura dada
    CURSOR c_notas IS
        SELECT * FROM notas
        WHERE codigo_asig = p_codigo_asig
        FOR UPDATE;

    -- Definición de una variable basada en el tipo de dato del cursor
    vc_notas           c_notas%rowtype;

    -- Excepción personalizada para manejar el caso en el que no hay notas
    e_sin_datos EXCEPTION;
BEGIN
    p_num_alumnos := 0;

    -- Abrimos el cursor para trabajar con las notas
    OPEN c_notas;
    LOOP
        -- Tomamos una fila del cursor
        FETCH c_notas INTO vc_notas;
        -- Salimos del loop si no hay más registros en el cursor
        EXIT WHEN c_notas%notfound;

        -- Calculamos la nota actualizada con el porcentaje dado
        v_nota_actualizada := vc_notas.nota * ( 1 + ( p_aumento / 100 ) );

        -- Actualizamos la nota en la base de datos
        UPDATE notas
        SET
            nota = v_nota_actualizada
        WHERE
            CURRENT OF c_notas;

        -- Sumamos al total de notas y contamos un alumno más
        v_total_nota := v_total_nota + v_nota_actualizada;
        p_num_alumnos := p_num_alumnos + 1;
    END LOOP;

    -- Cerramos el cursor una vez que hemos terminado con él
    CLOSE c_notas;

    -- Si no se han actualizado notas, lanzamos una excepción
    IF p_num_alumnos = 0 THEN
        RAISE e_sin_datos;
    END IF;

    -- Calculamos la nota media
    p_nota_media := v_total_nota / p_num_alumnos;
EXCEPTION
    -- Si se lanza la excepción personalizada, mostramos un mensaje correspondiente
    WHEN e_sin_datos THEN
        raise_application_error(-20001, 'No se encontraron datos para la asignatura con código ' || p_codigo_asig);
    -- Si se produce cualquier otro error, mostramos un mensaje general
    WHEN OTHERS THEN
        raise_application_error(-20002, 'Se produjo un error inesperado: ' || sqlerrm);
END aumentarnotasasignatura;
/

-- Bloque que pasa una asignatura para usar el procedimiento y muestra error si la nueva nota media es menor a 3.
DECLARE
    v_codigo_asig        VARCHAR2(10);
    v_aumento            INTEGER(2);
    v_num_alumnos        NUMBER;
    v_nota_media_antigua DECIMAL(4, 2);
    v_nota_media_nueva   DECIMAL(4, 2);
    v_total_notas        DECIMAL(4, 2);
    v_contador           NUMBER;

    -- Excepciones personalizadas
    e_sin_datos EXCEPTION;
    e_notas_bajas EXCEPTION;
BEGIN
    -- Definimos los valores de las variables
    v_codigo_asig := 'DAX_M02B';
    v_aumento := 5;

    -- Calculamos la nota media anterior
    SELECT
        AVG(nota),
        COUNT(*)
    INTO
        v_nota_media_antigua,
        v_contador
    FROM
        notas
    WHERE
        codigo_asig = v_codigo_asig;

    -- Si hay notas en la asignatura, procedemos
    IF v_contador = 0 THEN
        RAISE e_sin_datos;
    ELSE
        -- Llamamos al procedimiento para aumentar las notas
        aumentarnotasasignatura(v_codigo_asig, v_aumento, v_num_alumnos, v_nota_media_nueva);
        -- Si la nota media anterior es inferior a 3, lanzamos una excepción
        IF v_nota_media_antigua < 3 THEN
            RAISE e_notas_bajas;
        END IF;
        -- Mostramos los resultados
        dbms_output.put_line('Asignatura: ' || v_codigo_asig);
        dbms_output.put_line('Nota media anterior: ' || v_nota_media_antigua);
        dbms_output.put_line('Nota media actualizada: ' || v_nota_media_nueva);
    END IF;
EXCEPTION
    -- Manejamos las excepciones personalizadas y otros errores
    WHEN e_sin_datos THEN
        dbms_output.put_line('PROCEDIMIENTO - No hay notas registradas para la asignatura con código ' || v_codigo_asig);
    WHEN e_notas_bajas THEN
        raise_application_error(-20003, 'Las notas deberían ser más altas, ahora la media es de: ' || v_nota_media_nueva);
    WHEN OTHERS THEN
        dbms_output.put_line('Error: ' || sqlerrm);
END;
/

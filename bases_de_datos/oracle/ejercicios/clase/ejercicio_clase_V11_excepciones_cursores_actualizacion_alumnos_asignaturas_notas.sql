-- Ejemplos Excepciones en Procedimientos y funciones
DROP TABLE notas_v11;
DROP TABLE alumnos_v11;
DROP TABLE asignaturas_v11;

CREATE TABLE asignaturas_v11 (
    codigo_asig VARCHAR2(10) PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
);

CREATE TABLE alumnos_v11 (
    id_alumno NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
);


CREATE TABLE notas_v11 (
    id_nota NUMBER PRIMARY KEY,
    id_alumno NUMBER REFERENCES alumnos_v11(id_alumno),
    codigo_asig VARCHAR2(10) REFERENCES asignaturas_v11(codigo_asig),
    nota FLOAT NOT NULL
);


INSERT INTO asignaturas_v11 (codigo_asig, nombre) VALUES ('DAX_M02B', 'Matemáticas');
INSERT INTO asignaturas_v11 (codigo_asig, nombre) VALUES ('DAX_M03C', 'Física');

INSERT INTO alumnos_v11 (id_alumno, nombre) VALUES (1, 'Juan Pérez');
INSERT INTO alumnos_v11 (id_alumno, nombre) VALUES (2, 'María López');
INSERT INTO alumnos_v11 (id_alumno, nombre) VALUES (3, 'Carlos Gómez');

INSERT INTO notas_v11 (id_nota, id_alumno, codigo_asig, nota) VALUES (1, 1, 'DAX_M02B', 2.5);
INSERT INTO notas_v11 (id_nota, id_alumno, codigo_asig, nota) VALUES (2, 2, 'DAX_M02B', 3.2);
INSERT INTO notas_v11 (id_nota, id_alumno, codigo_asig, nota) VALUES (3, 3, 'DAX_M02B', 4.1);
INSERT INTO notas_v11 (id_nota, id_alumno, codigo_asig, nota) VALUES (4, 1, 'DAX_M03C', 3.5);
INSERT INTO notas_v11 (id_nota, id_alumno, codigo_asig, nota) VALUES (5, 2, 'DAX_M03C', 4.0);
INSERT INTO notas_v11 (id_nota, id_alumno, codigo_asig, nota) VALUES (6, 3, 'DAX_M03C', 4.8);

-- Función notamediaasignatura:
-- Esta función simplemente devuelve la nota media de una asignatura específica.
CREATE OR REPLACE FUNCTION nota_media_asignatura(p_id_asignatura notas_v11.codigo_asig%TYPE) RETURN FLOAT AS
    v_count_notas FLOAT := 0;
    v_media_notas FLOAT := 0;
    sin_datos EXCEPTION;
BEGIN
    SELECT AVG(nota), COUNT(nota) INTO v_media_notas, v_count_notas
    FROM notas_v11 WHERE codigo_asig = p_id_asignatura;

    IF v_count_notas <= 0 THEN
        RAISE sin_datos;
    END IF;

    RETURN v_media_notas;
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: No se puede dividir entre 0 el total de notas para sacar la media');
        RETURN NULL;
    WHEN sin_datos THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: No hay datos en la asignatura indicada.');
        RETURN NULL;
END;
/
-- Bloque anónimo:
-- Bloque anónimo en PL/SQL que utiliza la función notamediaasignatura definida previamente.
DECLARE
    v_id_asignatura notas_v11.codigo_asig%TYPE := '&codigo_asignatura';
BEGIN
    DBMS_OUTPUT.PUT_LINE('La nota media de la asignatura: ' || v_id_asignatura || ' es: ' || nota_media_asignatura(v_id_asignatura));
END;
/

-- Procedimiento aumentarnotasasignatura:
-- Aumenta las notas de los alumnos en un porcentaje determinado para una asignatura específica. Después de hacer esto, devuelve el número de alumnos actualizados y la nueva nota media.
CREATE OR REPLACE PROCEDURE aumentar_notas_asignatura(
    p_id_asignatura asignaturas_v11.codigo_asig%TYPE,
    p_pct NUMBER,
    p_num_alumnos OUT NUMBER,
    p_nota_media OUT FLOAT) IS
-- Declaraciones
    -- Declaramos el cursor con el resultado de la tabla notas de la asignatura especificada
    -- Añadimos el FOR UPDATE porque necesitamos actualizarla.
    CURSOR c_notas IS SELECT * FROM notas_v11 WHERE codigo_asig = p_id_asignatura FOR UPDATE;
    -- Creamos la variable para almacenar cada fila del cursor previamente definido
    registro_notas c_notas%ROWTYPE;
    -- Variables faltantes
    v_suma_notas FLOAT;
    v_nueva_nota notas_v11.nota%TYPE;
BEGIN
    -- Inicializamos a 0 el parametro para realizar la cuenta
    p_num_alumnos := 0;
    p_nota_media := 0;
    v_suma_notas := 0;
    -- Abrimos el cursor y lo iteramos
    OPEN c_notas;
    LOOP
        -- Vamos almacenando en registro_notas cada fila iterada
        FETCH c_notas INTO registro_notas;
        -- Cuando no queden registros finalizamos el bucle
        EXIT WHEN c_notas%NOTFOUND;
        -- Actualizamos la variable de la nota con el incremento del pct del parametro
        v_nueva_nota := registro_notas.nota;
        v_nueva_nota := v_nueva_nota + (v_nueva_nota * p_pct / 100);
        -- Ejecutamos consulta para actualizar el resultado de la nueva nota
        -- Se utiliza una consulta UPDATE clasica, simplemente se utiliza el CURRENT OF para especificar el cursor
        UPDATE notas_v11 SET nota = v_nueva_nota WHERE CURRENT OF c_notas;
        -- Vamos incrementando el total de notas con la nueva nota obtenida.
        v_suma_notas := v_suma_notas + v_nueva_nota;
        -- Actualizamos el contador de alumnos
        p_num_alumnos := p_num_alumnos + 1;
    END LOOP;
    -- Cerranis cursor
    CLOSE c_notas;

    -- Sacamos la nueva media con la suma total de las nuevas notas y el total de alumnos.
    p_nota_media := v_suma_notas / p_num_alumnos;
END;
/

-- Bloque anónimo:
-- En este bloque, se define una asignatura, se calcula la nota media anterior y luego se llama al
-- procedimiento anterior para aumentar las notas. También tiene un control de errores en caso de que la nota media anterior sea menor que 3.
DECLARE
    v_id_asignatura notas_v11.codigo_asig%TYPE := '&codigo_asignatura';
    v_pct NUMBER := &porcentaje;
    v_num_alumnos NUMBER;
    v_nota_media FLOAT;
    nota_baja EXCEPTION;
BEGIN
    v_nota_media := nota_media_asignatura(v_id_asignatura);
    IF v_nota_media < 3 THEN
        RAISE nota_baja;
    END IF;
    DBMS_OUTPUT.PUT_LINE('La nota media de la asignatura: ' || v_id_asignatura || ' es: ' || v_nota_media);
    aumentar_notas_asignatura(v_id_asignatura, v_pct, v_num_alumnos, v_nota_media);
    DBMS_OUTPUT.PUT_LINE('La nota media de la asignatura: ' || v_id_asignatura || ' ha sido actualizada, ahora es: ' || v_nota_media);
EXCEPTION
    WHEN nota_baja THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: La nota media es menor a 3.');
END;
/

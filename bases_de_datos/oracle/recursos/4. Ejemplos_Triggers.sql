
DROP TRIGGER alumnos_before_insert;

DROP TRIGGER alumnos_before_update;

DROP TABLE alumnos CASCADE CONSTRAINTS;
DROP TABLE alumnos_historico CASCADE CONSTRAINTS;

CREATE TABLE alumnos (
    dni            VARCHAR2(11) PRIMARY KEY, -- DNI como clave primaria
    nombre         VARCHAR2(50) NOT NULL,   -- Nombre del alumno
    apellido       VARCHAR2(50) NOT NULL,   -- Apellido del alumno
    palabra_clave  VARCHAR2(20),            -- Contraseña o clave
    edad           NUMBER(3) CHECK (edad >= 0), -- Edad con restricción de ser positiva
    crea_username  VARCHAR2(10),            -- Usuario que crea
    crea_date      DATE,                    -- Fecha de creación
    mod_username   VARCHAR2(10),            -- Usuario que modifica
    mod_date       DATE                     -- Fecha de modificación
);



-- BEFORE INSERT Trigger. crear un disparador ANTES DE INSERTAR en Oracle 

CREATE OR REPLACE TRIGGER alumnos_before_insert BEFORE
    INSERT ON alumnos
    FOR EACH ROW
DECLARE
    v_username VARCHAR2(10);
BEGIN

-- Buscar el nombre de usuario que realiza la acción
    SELECT
        user
    INTO v_username
    FROM
        dual;

   -- Se actualizara de forma interna el campo crea_date con la fecha actual

    :new.crea_date := sysdate;

   -- Se actualizara de forma interna el campo crea_username con el usuario
    :new.crea_username := v_username;
END;
/

-- Pruebas: Insertar un Registro en alumnos

INSERT INTO alumnos (dni, nombre, apellido, palabra_clave, edad) 
VALUES ('12345678A', 'Juan', 'Pérez', 'ClaveSegura', 25);

SELECT dni, nombre, apellido, palabra_clave, edad, crea_date, crea_username
FROM alumnos;



-- BEFORE UPDATE Trigger. crear un disparador ANTES DE ACTUALIZAR en Oracle 

CREATE OR REPLACE TRIGGER alumnos_before_update BEFORE
    UPDATE ON alumnos
    FOR EACH ROW
DECLARE
    v_username VARCHAR2(10);
BEGIN

-- Buscar el nombre de usuario que realiza la acción
    SELECT
        user
    INTO v_username
    FROM
        dual;

   -- Se actualizara de forma interna el campo crea_date con la fecha actual

    :new.mod_date := sysdate;

   -- Se actualizara de forma interna el campo crea_username con el usuario
    :new.mod_username := v_username;
END;
/


-- Pruebas: modificar  un Registro en alumnos

UPDATE alumnos
SET palabra_clave = 'ClaveActualizada', edad = 26
WHERE dni = '12345678A';

SELECT dni, nombre, apellido, palabra_clave, edad, mod_date, mod_username
FROM alumnos;




-- AFTER INSERT, UPTADE, DELETE significa que Oracle activará este activador después de que se ejecute alguna acción

-- CREAR NUEVA TABLA PARA HISTORICOS

DROP TABLE alumnos_historico;

CREATE TABLE alumnos_historico (
    fecha     DATE,
    hora      VARCHAR2(10),
    usuario   VARCHAR2(25),
    evento    VARCHAR2(10),
    dni       VARCHAR2(11),
    old_pas   VARCHAR2(20),
    new_pas   VARCHAR2(20)
);


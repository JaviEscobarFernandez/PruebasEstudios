-- Crear tabla alumnos (DNI (PK), nombre, apellidos, telefono, email)
CREATE TABLE alumnos (
    DNI CHAR(9) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    apellidos VARCHAR2(60) NOT NULL,
    telefono NUMBER(9) NOT NULL,
    email VARCHAR2(60) UNIQUE
);

-- Insertar varios alumnos
INSERT INTO alumnos (DNI, nombre, apellidos, telefono, email) VALUES ('12345678A', 'Juan', 'Lopez Fernandez', 123456789, 'juan_lopez_fernandez@gmail.com');
INSERT INTO alumnos (DNI, nombre, apellidos, telefono, email) VALUES ('22345678A', 'Ana', 'Milan Fernandez', 223456789, 'ana_milan_fernandez@gmail.com');
INSERT INTO alumnos (DNI, nombre, apellidos, telefono, email) VALUES ('32345678A', 'Pedro', 'Lopez Toledo', 323456789, 'pedro_lopez_toledo@gmail.com');
INSERT INTO alumnos (DNI, nombre, apellidos, telefono, email) VALUES ('42345678A', 'Maria', 'Carretero Mora', 423456789, 'Maria_carretero_mora@gmail.com');
INSERT INTO alumnos (DNI, nombre, apellidos, telefono, email) VALUES ('52345678A', 'Sara', 'Guerrero Hernandez', 523456789, 'sara_guerrero_hernandez@gmail.com');
INSERT INTO alumnos (DNI, nombre, apellidos, telefono, email) VALUES ('62345678A', 'Javi', 'Escobar Fernandez', 623456789, 'javi_escobar_fernandez@gmail.com');

-- Actualizar algun dato de alumnos
UPDATE alumnos SET DNI='63345678B' WHERE DNI='62345678A';

-- Crear tabla asignaturas (IdAsignatura (PK), nombre)
CREATE TABLE asignaturas (
    IdAsignatura NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL
);

-- Insertar varios datos de asignaturas
INSERT INTO asignaturas (IdAsignatura, nombre) VALUES (1,'Sistemas Informáticos');
INSERT INTO asignaturas (IdAsignatura, nombre) VALUES (2,'Programación');
INSERT INTO asignaturas (IdAsignatura, nombre) VALUES (3,'Bases de datos');
INSERT INTO asignaturas (IdAsignatura, nombre) VALUES (4,'Inglés');
INSERT INTO asignaturas (IdAsignatura, nombre) VALUES (5,'Lenguajes de marcas');
INSERT INTO asignaturas (IdAsignatura, nombre) VALUES (6,'Entornos de desarrollo');

-- Crear tabla asignaturas_alumnos (IdAsignatura (PK)(FK), DNI_Alumno(PK)(FK))
CREATE TABLE asignaturas_alumnos (
    IdAsignatura NUMBER(5),
    DNI_Alumno CHAR(9),
    CONSTRAINT pk_asignaturas_alumnos PRIMARY KEY (IdAsignatura, DNI_Alumno),
    CONSTRAINT fk_asignatura FOREIGN KEY (IdAsignatura) REFERENCES asignaturas(IdAsignatura),
    CONSTRAINT fk_dni_alumno FOREIGN KEY (DNI_alumno) REFERENCES alumnos(DNI)
);

-- Insertar alumnos y asignaturas
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (1, '12345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (2, '12345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (3, '12345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (1, '22345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (3, '22345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (4, '22345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (4, '32345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (5, '32345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (6, '32345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (3, '42345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (2, '42345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (1, '42345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (2, '52345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (5, '52345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (3, '52345678A');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (2, '63345678B');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (1, '63345678B');
INSERT INTO asignaturas_alumnos (IdAsignatura, DNI_Alumno) VALUES (4, '63345678B');

-- Crear vista que muestre el nombre del alumno y el nombre de sus asignaturas ordenada por nombre de alumno alfabeticamente.
CREATE VIEW nombre_asignaturas_alumnos AS
    SELECT alu.nombre AS nombre_alumno, asig.nombre AS nombre_asignatura FROM asignaturas_alumnos asigAlu
    INNER JOIN alumnos alu ON alu.DNI = asigAlu.DNI_Alumno
    INNER JOIN asignaturas asig ON asig.IdAsignatura=asigAlu.IdAsignatura
    ORDER BY alu.nombre ASC;

-- Consultar vista anterior
SELECT * FROM nombre_asignaturas_alumnos;
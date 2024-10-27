CREATE TABLE Estudiantes (
    estudiante_id NUMBER(6) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    apellidos VARCHAR2(60) NOT NULL,
    fecha_nacimiento DATE
);

CREATE TABLE Cursos (
    curso_id NUMBER(2) PRIMARY KEY,
    nombre_curso VARCHAR2(10) NOT NULL,
    descripcion VARCHAR2(60)
);

CREATE TABLE Matriculas (
    matricula_id NUMBER(6) PRIMARY KEY,
    estudiante_id NUMBER(6),
    curso_id NUMBER(2),
    fecha_matricula DATE,
    CONSTRAINT fk_matriculas_estudiante FOREIGN KEY (estudiante_id) REFERENCES Estudiantes(estudiante_id),
    CONSTRAINT fk_matriculas_curso FOREIGN KEY (curso_id) REFERENCES Cursos(curso_id)
);

CREATE TABLE Profesores (
    profesor_id NUMBER(6) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    apellidos VARCHAR2(60) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Curso_Profesor (
    curso_id NUMBER(2),
    profesor_id NUMBER(6),
    PRIMARY KEY (curso_id, profesor_id),
    CONSTRAINT fk_curso_profesor_curso FOREIGN KEY (curso_id) REFERENCES Cursos(curso_id),
    CONSTRAINT fk_curso_profesor_profesor FOREIGN KEY (profesor_id) REFERENCES Profesores(profesor_id)
);

-- Modificaciones
-- Modificar el tipo de dato de una columna: Cambiar el tipo de dato de la columna precio en la tabla Libros de NUMBER(6) a NUMBER(8, 2) para permitir decimales.
ALTER TABLE LIBROS MODIFY precio NUMBER(8, 2);
-- Eliminar una columna: Eliminar la columna nacionalidad de la tabla Autores.
ALTER TABLE Autores DROP COLUMN nacionalidad;

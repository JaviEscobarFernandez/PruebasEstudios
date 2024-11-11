/*
CICLO (cod_ciclo (PK), nom_ciclo)
DIPLOMA (cod_dip (PK), nom_dip, id_tutor (FK))
MODULO (cod_mod (PK), nom_mod, cod_dip (FK))
TUTOR (id_tutor (PK), nom_tut, telefono)
CICLO_DIPLOMA (cod_ciclo (PK) (FK), cod_dip (PK) (FK))
*/
DROP TABLE ciclo_diploma;
DROP TABLE modulo;
DROP TABLE diploma;
DROP TABLE tutor;
DROP TABLE ciclo;

CREATE TABLE ciclo (
    cod_ciclo NUMBER(5) PRIMARY KEY,
    nom_ciclo VARCHAR2(100) NOT NULL
);

CREATE TABLE tutor (
    id_tutor NUMBER(5) PRIMARY KEY,
    nom_tut VARCHAR2(60) NOT NULL,
    telefono NUMBER(9)
);

CREATE TABLE diploma (
    cod_dip NUMBER(5) PRIMARY KEY,
    nom_dip VARCHAR2(100) NOT NULL,
    id_tutor NUMBER(5),
    CONSTRAINT FK_diploma_tutor FOREIGN KEY (id_tutor) REFERENCES tutor(id_tutor)
);

CREATE TABLE modulo (
    cod_mod NUMBER(5) PRIMARY KEY,
    nom_mod VARCHAR2(100) NOT NULL,
    cod_dip NUMBER(5),
    CONSTRAINT fk_modulo_diploma FOREIGN KEY (cod_dip) REFERENCES diploma(cod_dip)
);

CREATE TABLE ciclo_diploma (
    cod_ciclo NUMBER(5),
    cod_dip NUMBER(5),
    CONSTRAINT pk_ciclo_diploma_ciclo PRIMARY KEY (cod_ciclo, cod_dip),
    CONSTRAINT fk_ciclo_diploma_ciclo FOREIGN KEY (cod_ciclo) REFERENCES ciclo(cod_ciclo),
    CONSTRAINT fk_ciclo_diploma_diploma FOREIGN KEY (cod_dip) REFERENCES diploma(cod_dip)
);

-- Rellenar tablas
INSERT INTO ciclo (cod_ciclo, nom_ciclo) VALUES (1, 'Desarrollo de Aplicaciones Web');
INSERT INTO ciclo (cod_ciclo, nom_ciclo) VALUES (2, 'Administración de Sistemas Informáticos');
INSERT INTO ciclo (cod_ciclo, nom_ciclo) VALUES (3, 'Redes y Seguridad Informática');
INSERT INTO tutor (id_tutor, nom_tut, telefono) VALUES (1, 'Juan Pérez', '123456789');
INSERT INTO tutor (id_tutor, nom_tut, telefono) VALUES (2, 'María García', '987654321');
INSERT INTO tutor (id_tutor, nom_tut, telefono) VALUES (3, 'Carlos Rodríguez', '456789123');
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (101, 'Diploma en Desarrollo Web', 1);
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (102, 'Diploma en Administración de Redes', 2);
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (103, 'Diploma en Seguridad Informática', 3);
INSERT INTO modulo (cod_mod, nom_mod, cod_dip) VALUES (201, 'Fundamentos de HTML y CSS', 101);
INSERT INTO modulo (cod_mod, nom_mod, cod_dip) VALUES (202, 'JavaScript y Frameworks', 101);
INSERT INTO modulo (cod_mod, nom_mod, cod_dip) VALUES (203, 'Redes de Computadores', 102);
INSERT INTO modulo (cod_mod, nom_mod, cod_dip) VALUES (204, 'Seguridad en la Red', 103);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (1, 101);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (2, 102);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (3, 103);

-- Ejercicios seleccion:
-- 1. Seleccionar los nombres de los ciclos
SELECT nom_ciclo FROM ciclo;

-- 2. Seleccionar el nombre y el teléfono de todos los tutores
SELECT nom_tut, telefono FROM tutor;

-- 3. Seleccionar todos los módulos que pertenecen al diploma con cod_dip = 101
SELECT * FROM modulo WHERE cod_dip = 101;

-- 4. Seleccionar todos los diplomas para aquellos diplomas que no tienen tutor asignado
SELECT * FROM diploma WHERE id_tutor IS NULL;

-- 5. Seleccionar los diplomas y los módulos correspondientes a cada diploma
SELECT d.nom_dip AS nombre_diploma, m.nom_mod AS nombre_modulo FROM diploma d
INNER JOIN modulo m ON m.cod_dip = d.cod_dip;

-- 6. Seleccionar todos los módulos cuyo nombre contiene la palabra "Redes":
SELECT * FROM modulo WHERE nom_mod LIKE '%Redes%';

-- 1. Seleccionar los módulos que pertenecen a los diplomas cuyo tutor tiene el teléfono "123456789"
SELECT m.nom_mod AS nombre_modulo FROM diploma d
INNER JOIN modulo m ON d.cod_dip = m.cod_dip
INNER JOIN tutor t ON d.id_tutor = t.id_tutor
WHERE t.telefono = 123456789;

-- 2. Seleccionar los nombres de los ciclos y los módulos asociados a cada ciclo, ordenados por el nombre del ciclo
SELECT c.nom_ciclo, m.nom_mod FROM ciclo c
INNER JOIN ciclo_diploma cd ON c.cod_ciclo = cd.cod_ciclo
INNER JOIN modulo m ON cd.cod_dip = m.cod_dip
ORDER BY c.nom_ciclo;

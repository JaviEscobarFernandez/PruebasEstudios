-- Tabla CICLO
CREATE TABLE ciclo (
    cod_ciclo NUMBER PRIMARY KEY, -- Clave primaria: cod_ciclo
    nom_ciclo VARCHAR2(100) NOT NULL -- Nombre del ciclo
);

-- Tabla TUTOR
CREATE TABLE tutor (
    id_tutor NUMBER PRIMARY KEY, -- Clave primaria: id_tutor
    nom_tut VARCHAR2(100) NOT NULL, -- Nombre del tutor
    telefono VARCHAR2(20) -- Teléfono del tutor
);

-- Tabla DIPLOMA
CREATE TABLE diploma (
    cod_dip NUMBER PRIMARY KEY, -- Clave primaria: cod_dip
    nom_dip VARCHAR2(100) NOT NULL, -- Nombre del diploma
    id_tutor NUMBER, -- Clave foránea: id_tutor
    FOREIGN KEY (id_tutor) REFERENCES tutor(id_tutor)
);

-- Tabla CICLO_DIPLOMA (relación muchos a muchos entre CICLO y DIPLOMA)
CREATE TABLE ciclo_diploma (
    cod_ciclo NUMBER, -- Clave foránea: cod_ciclo
    cod_dip NUMBER, -- Clave foránea: cod_dip
    PRIMARY KEY (cod_ciclo, cod_dip), -- Combinación de claves primarias
    CONSTRAINT fk_ciclo_diploma_cod_ciclo FOREIGN KEY (cod_ciclo) REFERENCES ciclo(cod_ciclo),
    -- Si se elimina un ciclo, se elimina en la relación con diploma
    CONSTRAINT fk_ciclo_diploma_cod_dip FOREIGN KEY (cod_dip) REFERENCES diploma(cod_dip) -- Relación con la tabla DIPLOMA
);

-- Vaciamos y rellenamos tablas
TRUNCATE TABLE ciclo_diploma;
TRUNCATE TABLE ciclo;
TRUNCATE TABLE tutor;
TRUNCATE TABLE diploma;

INSERT INTO ciclo (cod_ciclo, nom_ciclo) VALUES (1, 'Ingeniería Informática');
INSERT INTO ciclo (cod_ciclo, nom_ciclo) VALUES (2, 'Medicina');
INSERT INTO ciclo (cod_ciclo, nom_ciclo) VALUES (3, 'Derecho');
INSERT INTO tutor (id_tutor, nom_tut, telefono) VALUES (1, 'Juan Pérez', '123456789');
INSERT INTO tutor (id_tutor, nom_tut, telefono) VALUES (2, 'María Gómez', '987654321');
INSERT INTO tutor (id_tutor, nom_tut, telefono) VALUES (3, 'Carlos López', '456123789');
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (1, 'Diploma en Programación', 1);
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (2, 'Diploma en Bioquímica', 2);
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (3, 'Diploma en Derecho Internacional', 3);
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (4, 'Diploma en Redes', 1);
INSERT INTO diploma (cod_dip, nom_dip, id_tutor) VALUES (5, 'Diploma en Anatomía', 2);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (1, 1);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (1, 4);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (2, 2);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (2, 5);
INSERT INTO ciclo_diploma (cod_ciclo, cod_dip) VALUES (3, 3);

-- comprobamos los datos
SELECT * FROM ciclo;
SELECT * FROM diploma;
SELECT * FROM ciclo_diploma;

-- Intentamos borrar un ciclo y nos da error, porque ciclo_diploma tiene FK de cod_ciclo
DELETE FROM ciclo WHERE cod_ciclo = 1;

-- Eliminamos la FK de ciclo_diploma - cod_ciclo
ALTER TABLE ciclo_diploma DROP CONSTRAINT fk_ciclo_diploma_cod_ciclo;
-- Volvemos a añadir la FK de ciclo_diploma - cod_ciclo con regla de integridad ON DELETE CASCADE, para asi, en caso de eliminar un ciclo, se elimina las filas donde coincida dicho FK
ALTER TABLE ciclo_diploma ADD CONSTRAINT fk_ciclo_diploma_cod_ciclo FOREIGN KEY (cod_ciclo) REFERENCES ciclo(cod_ciclo) ON DELETE CASCADE;

-- Probamos que se ha borrado correctamente
DELETE FROM ciclo WHERE cod_ciclo = 1;

-- comprobamos los datos
SELECT * FROM ciclo;
SELECT * FROM diploma;
SELECT * FROM ciclo_diploma;

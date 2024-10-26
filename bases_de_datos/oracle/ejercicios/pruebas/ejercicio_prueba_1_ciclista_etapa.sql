-- Modelo relacional:
-- CICLISTA (DNI(PK), nom_ci, telefono)
-- ETAPA (codigoEtapa(PK), fecha_ini, ciudades)
-- CICLISTA_ETAPA (DNI_ciclista(PK)(FK), codigoEtapa(PK)(FK))

-- Creamos la tabla ciclista y le asignamos PK a DNI
CREATE TABLE ciclista (
    DNI CHAR(9) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    telefono NUMBER(9)
);

-- Creamos la tabla etapa y le asignamos PK a codigoEtapa
CREATE TABLE etapa (
    codigoEtapa NUMBER(5) PRIMARY KEY,
    fechaInicio DATE,
    ciudades VARCHAR(20) NOT NULL
);

-- Creamos la tabla ciclista_etapa y cremos clave primaria compuesta con DNI_ciclista y codigo_etapa
-- Tambien añadimos FK a las dos tablas anteriores relacionadas.
CREATE TABLE ciclista_etapa (
    DNI_ciclista CHAR(9),
    codigo_etapa NUMBER(5),
    CONSTRAINT pk_ciclista_etapa PRIMARY KEY (DNI_ciclista, codigo_etapa),
    CONSTRAINT dni_cic FOREIGN KEY (DNI_ciclista) REFERENCES ciclista(DNI),
    CONSTRAINT cod_etp FOREIGN KEY (codigo_etapa) REFERENCES etapa(codigoEtapa)
);

-- Añadimos 2 ciclistas a la tabla ciclista
INSERT INTO ciclista (DNI, nombre, telefono) VALUES ('01478523A','Pepe',658741236);
INSERT INTO ciclista (DNI, nombre, telefono) VALUES ('45682379H','Alfonso',689523147);
-- Creamos 3 etapas en la tabla etapa
INSERT INTO etapa (codigoEtapa, fechaInicio, ciudades) VALUES (00001,'20/10/24','Valencia');
INSERT INTO etapa (codigoEtapa, fechaInicio, ciudades) VALUES (00002,'21/10/24','Alicante');
INSERT INTO etapa (codigoEtapa, fechaInicio, ciudades) VALUES (00003,'23/10/24','Murcia');
-- Enlazamos en la tabla ciclista_etapa las claves primarias
INSERT INTO ciclista_etapa (DNI_ciclista, codigo_etapa) VALUES ('01478523A',00001);
INSERT INTO ciclista_etapa (DNI_ciclista, codigo_etapa) VALUES ('45682379H',00002);

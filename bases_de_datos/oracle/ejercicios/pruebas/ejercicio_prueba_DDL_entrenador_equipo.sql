CREATE TABLE entrenador (
    DNI CHAR(9) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL
);

CREATE TABLE telefonos_entrenador (
    DNI_entrenador CHAR(9),
    telefono NUMBER(9),
    CONSTRAINT pk_telefonos_entrenador PRIMARY KEY (DNI_entrenador, telefono),
    CONSTRAINT fk_entrenador_DNI FOREIGN KEY(DNI_entrenador) REFERENCES entrenador(DNI)
);

CREATE TABLE equipo (
    CIF NUMBER(20) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    DNI_entrenador CHAR(9),
    CONSTRAINT fk_equipo_entrenador_DNI FOREIGN KEY(DNI_entrenador) REFERENCES entrenador(DNI)
);

CREATE TABLE email_equipo (
    CIF_equipo NUMBER(20),
    email VARCHAR2(50),
    CONSTRAINT pk_email_equipo PRIMARY KEY (CIF_equipo, email),
    CONSTRAINT fk_equipo_CIF FOREIGN KEY (CIF_equipo) REFERENCES equipo(CIF)
);

-- Renombrar email_equipo a emails_equipo
ALTER TABLE email_equipo RENAME TO emails_equipo;

-- Equipo siempre debe tener un entrenador
ALTER TABLE equipo MODIFY DNI_entrenador NOT NULL;

-- Añadimos una columna a entrenador
ALTER TABLE entrenador ADD apellidos VARCHAR2(60);

-- Añadimos una columna a equipo
ALTER TABLE equipo ADD ciudad VARCHAR2(50);

-- Modificamos equipo la columna ciudad para que no admita nulos
ALTER TABLE equipo MODIFY ciudad NOT NULL;

-- Renombramos columna de tabla equipo llamada ciudad a ciudades
ALTER TABLE equipo RENAME COLUMN ciudad TO ciudades;

-- Eliminamos ciudades de equipo
ALTER TABLE equipo DROP COLUMN ciudades;

-- Eliminamos tablas:
DROP TABLE emails_equipo;
DROP TABLE equipo;
DROP TABLE telefonos_entrenador;
DROP TABLE entrenador;

-- Creacion de tablas
CREATE TABLE entrenador (
    DNI CHAR(9) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    telefono NUMBER(9)
);

CREATE TABLE equipo (
    CIF CHAR(9) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    DNI_entrenador CHAR(9),
    FOREIGN KEY (DNI_entrenador) REFERENCES entrenador(DNI)
);

CREATE TABLE partido (
    CIF_equipo1 CHAR(9),
    CIF_equipo2 CHAR(9),
    fecha DATE NOT NULL,
    hora TIMESTAMP NOT NULL,
    resultado NUMBER(2) NOT NULL,
    CIF_gana CHAR(9),
    PRIMARY KEY (CIF_equipo1, CIF_equipo2),
    FOREIGN KEY (CIF_equipo1) REFERENCES equipo(CIF),
    FOREIGN KEY (CIF_equipo2) REFERENCES equipo(CIF),
    FOREIGN KEY (CIF_gana) REFERENCES equipo(CIF)
);

CREATE TABLE jugador (
    DNI CHAR(9) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    altura NUMBER(3) NOT NULL,
    peso NUMBER(3) NOT NULL,
    IMC NUMBER(3) DEFAULT 0 -- De momento no hemos visto como generar los derivados, parece que es con triggers
);

CREATE TABLE estadistica (
    DNI_jugador CHAR(9),
    temporada NUMBER(4) NOT NULL,
    minutos NUMBER(20) DEFAULT 0,
    puntos NUMBER(20) DEFAULT 0,
    PRIMARY KEY (DNI_jugador, temporada),
    FOREIGN KEY (DNI_jugador) REFERENCES jugador(DNI)
);

CREATE TABLE jugador_equipo (
    CIF_equipo CHAR(9),
    DNI_jugador CHAR(9) PRIMARY KEY,
    dorsal NUMBER(2) NOT NULL,
    FOREIGN KEY (CIF_equipo) REFERENCES equipo(CIF),
    FOREIGN KEY (DNI_jugador) REFERENCES jugador(DNI)
);

-- Correcciones
ALTER TABLE partido MODIFY resultado CHAR(7) DEFAULT '0-0';

-- Inserciones
-- Entrenador
INSERT INTO entrenador (DNI, nombre, telefono) VALUES ('98345197C', 'Juan', 698320123);
INSERT INTO entrenador (DNI, nombre, telefono) VALUES ('35345697G', 'Pedro', 621782469);
-- Equipo
INSERT INTO equipo (CIF, nombre, email) VALUES ('12345678A', 'EquipoA', 'equipoa@gmail.com');
INSERT INTO equipo (CIF, nombre, email) VALUES ('12345679B', 'EquipoB', 'equipob@gmail.com');
-- Partido
INSERT INTO partido (CIF_equipo1, CIF_equipo2, fecha, hora, resultado, CIF_gana) VALUES ('12345678A', '12345679B', sysdate, CURRENT_TIMESTAMP, '2-5', '12345678A');
-- Jugador
INSERT INTO jugador (DNI, nombre, altura, peso, IMC) VALUES ('93874392F', 'Antonio', 180, 82, 100);
INSERT INTO jugador (DNI, nombre, altura, peso, IMC) VALUES ('21474392S', 'Roberto', 170, 68, 90);
INSERT INTO jugador (DNI, nombre, altura, peso, IMC) VALUES ('93874392D', 'Jose', 200, 94, 103);
INSERT INTO jugador (DNI, nombre, altura, peso, IMC) VALUES ('64654392V', 'Fran', 183, 82, 99);
-- Estadistica
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('93874392F', 2020, 1000, 400);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('93874392F', 2021, 500, 100);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('93874392F', 2022, 1200, 600);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('21474392S', 2020, 200, 30);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('21474392S', 2021, 400, 35);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('21474392S', 2022, 1000, 60);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('93874392D', 2020, 234, 12);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('93874392D', 2021, 564, 53);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('93874392D', 2022, 1237, 574);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('64654392V', 2020, 366, 32);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('64654392V', 2021, 567, 23);
INSERT INTO estadistica (DNI_jugador, temporada, minutos, puntos) VALUES ('64654392V', 2022, 3456, 2345);
-- Jugador Equipo
INSERT INTO jugador_equipo (CIF_equipo, DNI_jugador, dorsal) VALUES ('12345678A', '93874392F', 10);
INSERT INTO jugador_equipo (CIF_equipo, DNI_jugador, dorsal) VALUES ('12345679B', '21474392S', 11);
INSERT INTO jugador_equipo (CIF_equipo, DNI_jugador, dorsal) VALUES ('12345679B', '93874392D', 10);
INSERT INTO jugador_equipo (CIF_equipo, DNI_jugador, dorsal) VALUES ('12345678A', '64654392V', 11);

-- Alguna consulta
SELECT * FROM jugador_equipo;
SELECT * FROM estadistica;

-- Creacion de views
CREATE OR REPLACE VIEW estadistica_equipo_A AS
    SELECT equip.nombre AS nombre_equipo, est.DNI_jugador AS dni_jugador, jug.nombre AS nombre_jugador, je.dorsal, est.temporada, est.minutos, est.puntos
    FROM jugador_equipo je
    INNER JOIN estadistica est ON est.DNI_jugador = je.DNI_jugador
    INNER JOIN equipo equip ON equip.CIF = je.CIF_equipo
    INNER JOIN jugador jug ON jug.DNI = je.DNI_jugador
    WHERE equip.CIF = '12345678A';

CREATE OR REPLACE VIEW estadistica_equipo_B AS
    SELECT equip.nombre AS nombre_equipo, est.DNI_jugador AS dni_jugador, jug.nombre AS nombre_jugador, je.dorsal, est.temporada, est.minutos, est.puntos
    FROM jugador_equipo je
    INNER JOIN estadistica est ON est.DNI_jugador = je.DNI_jugador
    INNER JOIN equipo equip ON equip.CIF = je.CIF_equipo
    INNER JOIN jugador jug ON jug.DNI = je.DNI_jugador
    WHERE equip.CIF = '12345679B';

-- Consulta de views
SELECT * FROM estadistica_equipo_A;
SELECT * FROM estadistica_equipo_B;

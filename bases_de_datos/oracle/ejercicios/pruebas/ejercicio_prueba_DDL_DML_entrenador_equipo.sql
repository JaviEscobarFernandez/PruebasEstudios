-- Ejercicios DDL
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

-- Añadimos comprobacion a telefonos para que sea mayor a 0
ALTER TABLE telefonos_entrenador ADD CONSTRAINT telefonos_mayor_0
CHECK (telefono > 0);

-- Ejercicios DML
-- Añadir entrenadores
INSERT INTO entrenador (DNI, nombre, apellidos) VALUES ('12345678D', 'Juan', 'Mora Perez');
INSERT INTO entrenador (DNI, nombre, apellidos) VALUES ('87654321F', 'Ana', 'Gómez López');
INSERT INTO entrenador (DNI, nombre, apellidos) VALUES ('65432187B', 'Pedro', 'López Martínez');
INSERT INTO entrenador (DNI, nombre, apellidos) VALUES ('98765432H', 'María', 'García Fernández');

-- Añadir teléfonos de entrenadores
INSERT INTO telefonos_entrenador (DNI_entrenador, telefono) VALUES ('12345678D', 651214781);
INSERT INTO telefonos_entrenador (DNI_entrenador, telefono) VALUES ('87654321F', 699876543);
INSERT INTO telefonos_entrenador (DNI_entrenador, telefono) VALUES ('87654321F', 612345678);
INSERT INTO telefonos_entrenador (DNI_entrenador, telefono) VALUES ('65432187B', 690123456);
INSERT INTO telefonos_entrenador (DNI_entrenador, telefono) VALUES ('98765432H', 678901234);

-- Añadir equipos
INSERT INTO equipo (CIF, nombre, DNI_entrenador) VALUES (1120, 'Barcelona', '12345678D');
INSERT INTO equipo (CIF, nombre, DNI_entrenador) VALUES (2230, 'Real Madrid', '87654321F');
INSERT INTO equipo (CIF, nombre, DNI_entrenador) VALUES (3340, 'Valencia CF', '65432187B');
INSERT INTO equipo (CIF, nombre, DNI_entrenador) VALUES (4450, 'Sevilla FC', '98765432H');

-- Añadir correos electrónicos de equipos
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (1120, 'barcelona@email.com');
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (2230, 'real-madrid@email.com');
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (3340, 'valencia-cf@email.com');
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (4450, 'sevilla-fc@email.com');

-- Añadir datos adicionales para los mismos equipos
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (1120, 'info@barcelona.com');
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (2230, 'contact@real-madrid.com');
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (3340, 'support@valencia-cf.com');
INSERT INTO emails_equipo (CIF_equipo, email) VALUES (4450, 'admin@sevilla-fc.com');

-- 1 - Selecciona todos los entrenadores y muestra su DNI, nombre y apellidos.
SELECT DNI, nombre, apellidos FROM entrenador;

-- 2 - Selecciona los entrenadores cuyo nombre sea 'Juan'.
SELECT * FROM entrenador WHERE nombre='Juan';

-- 3 - Selecciona los equipos y el nombre del entrenador correspondiente.
SELECT e.CIF AS CIF_equipo, e.nombre AS nombre_equipo, ent.nombre AS nombre_entrenador
FROM equipo e, entrenador ent WHERE e.DNI_entrenador = ent.DNI;

-- 4 - Cuenta cuántos teléfonos tiene cada entrenador.
SELECT tlf.DNI_entrenador, ent.nombre AS nombre_entrenador, COUNT(tlf.telefono) AS total_telefonos
FROM telefonos_entrenador tlf, entrenador ent WHERE tlf.DNI_entrenador = ent.DNI GROUP BY tlf.DNI_entrenador, ent.nombre;

-- 5 - Selecciona todos los correos electrónicos de los equipos y muestra el nombre del equipo y su email.
SELECT equipo.nombre, emails.email FROM emails_equipo emails, equipo
WHERE equipo.CIF = emails.CIF_equipo;

-- 6 - Encuentra todos los equipos que no tienen ningún correo electrónico asociado.
-- Primero añado un nuevo entrenador y equipo sin email, para poder obtener resultado
INSERT INTO entrenador (DNI, nombre, apellidos) VALUES ('23465432H', 'Alberto', 'García Fernández');
INSERT INTO equipo (CIF, nombre, DNI_entrenador) VALUES (5560, 'Albacete CF', '23465432H');
SELECT * FROM equipo WHERE CIF NOT IN (SELECT CIF_equipo from emails_equipo);

-- 7 - Actualiza el nombre del equipo con CIF 3340 a 'Valencia Club de Fútbol'.
UPDATE equipo SET nombre='Valencia Club de Fútbol' WHERE CIF=3340;

-- 8 - Borra el equipo cuyo CIF sea 1120.
-- Primero debo borrar sus datos referenciados
DELETE FROM emails_equipo WHERE CIF_equipo=1120;
DELETE FROM equipo WHERE CIF=1120;

-- 9 - Selecciona todos los datos de la tabla emails_equipo donde el email contiene 'gmail'.
-- Actualizo algun email a gmail para poder obtener resultados
UPDATE emails_equipo SET email='sevilla-fc@gmail.com' WHERE CIF_equipo=4450 AND email='sevilla-fc@email.com';
SELECT * FROM emails_equipo WHERE email LIKE '%gmail%';

-- 10 Listar entrenadores con más de un teléfono:
SELECT e.DNI AS DNI_entrenador, e.nombre AS nombre_entrenador, e.apellidos AS apellidos_entrenador, COUNT(telef.DNI_entrenador) AS total_telefonos
FROM entrenador e LEFT JOIN telefonos_entrenador telef ON e.DNI = telef.DNI_entrenador
GROUP BY telef.DNI_entrenador,e.DNI,e.nombre,e.apellidos
HAVING COUNT(telef.DNI_entrenador) > 1;

-- 11 Encontrar equipos y sus correos electrónicos ordenados:
SELECT equipo.CIF, equipo.nombre, equipo.DNI_entrenador, emails_equipo.email
FROM equipo, emails_equipo WHERE equipo.CIF = emails_equipo.CIF_equipo
ORDER BY equipo.CIF;

-- 12 Total de equipos por cada entrenador:
SELECT ent.nombre AS nombre_entrenador, ent.apellidos AS apellidos_entrenador, COUNT(e.DNI_entrenador) AS total_equipos
FROM entrenador ent INNER JOIN equipo e ON ent.DNI = e.DNI_entrenador
GROUP BY ent.nombre,ent.apellidos,e.DNI_entrenador;

-- 13 Selecciona los equipos cuyo nombre contenga la palabra 'CF'.
SELECT * FROM equipo WHERE nombre LIKE '%CF%';

-- 14 Obtener el correo principal de cada equipo (el primer correo ingresado):
-- Los primeros emails añadidos acaban en gmail y email, no tenemos identificador para ver cual ha sido insertado primero
SELECT * FROM emails_equipo WHERE email LIKE '%gmail%' OR email LIKE '%email';

-- 15 Actualizar el teléfono de un entrenador:
-- Actualiza el número de teléfono de 'Juan Mora Perez' a '675123456'.
UPDATE telefonos_entrenador SET telefono='675123456' WHERE DNI_entrenador =
(SELECT DNI FROM entrenador WHERE nombre='Juan' AND apellidos='Mora Perez');

-- 16 Eliminar entrenadores sin equipos:
-- Primero hay que borrar los datos referenciados
DELETE FROM telefonos_entrenador WHERE DNI_entrenador IN (SELECT DNI FROM entrenador WHERE DNI NOT IN (SELECT DNI_entrenador FROM equipo));
DELETE FROM entrenador WHERE DNI NOT IN (SELECT DNI_entrenador FROM equipo);

-- 17 Promediar la cantidad de teléfonos por entrenador:
-- No se como promediar esto, saco el total de telefonos por entrenador
SELECT tlf.DNI_entrenador, COUNT(tlf.telefono) FROM telefonos_entrenador tlf
GROUP BY tlf.DNI_entrenador

-- 18 Correos electrónicos y equipos filtrados por dominio:
-- Selecciona los correos electrónicos de equipos que tengan el dominio 'email.com'.
SELECT e.nombre, em.email FROM equipo e, emails_equipo em
WHERE e.CIF = em.CIF_equipo AND em.email LIKE '%email.com%';

-- 19 Detalles completos de equipos y entrenadores:
SELECT e.CIF, e.nombre, e.DNI_entrenador, ent.nombre AS nombre_entrenador, ent.apellidos FROM equipo e
LEFT JOIN entrenador ent ON ent.DNI = e.DNI_entrenador;

-- 20 Entrenadores y equipos en una ciudad específica:
-- Encuentra todos los entrenadores y sus equipos asociados en la ciudad de 'Madrid'.
-- No existe el campo o tabla ciudad, asi que me guio por el nombre del equipo.
SELECT e.CIF, e.nombre, e.DNI_entrenador, ent.nombre AS nombre_entrenador, ent.apellidos FROM equipo e
LEFT JOIN entrenador ent ON ent.DNI = e.DNI_entrenador
WHERE e.nombre LIKE '%Madrid%' OR e.nombre LIKE '%madrid%';

-- Ejercicios DDL vistas
-- 1 Crear una vista para mostrar equipos y sus entrenadores:
--   Crea una vista llamada vista_equipos_entrenadores que muestre el nombre del equipo y el nombre del entrenador correspondiente.
CREATE OR REPLACE VIEW vista_equipos_entrenadores AS SELECT e.nombre AS nombre_equipo, ent.nombre AS nombre_entrenador
FROM equipo e LEFT JOIN entrenador ent ON ent.DNI = e.DNI_entrenador;

-- 2 Crear una vista para mostrar entrenadores y sus teléfonos:
--   Crea una vista llamada vista_entrenadores_telefonos que muestre el nombre del entrenador, sus apellidos y sus números de teléfono.
CREATE OR REPLACE VIEW vista_entrenadores_telefonos AS SELECT ent.nombre, ent.apellidos, tlf.telefono
FROM entrenador ent LEFT JOIN telefonos_entrenador tlf ON tlf.DNI_entrenador = ent.DNI;

-- 3 Crear una vista para mostrar equipos con sus correos electrónicos:
--   Crea una vista llamada vista_equipos_emails que muestre el nombre del equipo y sus correos electrónicos asociados.
CREATE OR REPLACE VIEW vista_equipos_emails AS SELECT e.nombre, em.email
FROM equipo e LEFT JOIN emails_equipo em ON e.CIF = em.CIF_equipo;

-- 4 Crear una vista para mostrar entrenadores con más de un equipo:
--   Crea una vista llamada vista_entrenadores_varios_equipos que muestre los entrenadores que están a cargo de más de un equipo. Incluye el nombre del entrenador y el número de equipos que entrena.
CREATE OR REPLACE VIEW vista_entrenadores_varios_equipos AS SELECT ent.nombre AS nombre_entrenador, COUNT(e.DNI_entrenador) AS total_equipos
FROM entrenador ent, equipo e WHERE ent.DNI = e.DNI_entrenador
GROUP BY ent.nombre,e.DNI_entrenador HAVING COUNT(e.DNI_entrenador) > 1;

-- 5 Crear una vista para mostrar equipos y correos electrónicos filtrados:
--   Crea una vista llamada vista_equipos_gmail que muestre los equipos cuyos correos electrónicos contengan 'gmail'.
CREATE OR REPLACE VIEW vista_equipos_gmail AS SELECT e.nombre AS nombre_equipo, em.email
FROM equipo e LEFT JOIN emails_equipo em ON em.CIF_equipo = e.CIF
WHERE em.email LIKE '%gmail%';

-- 6 Utilizar una vista para contar equipos por entrenador:
--   Crea una vista llamada vista_total_equipos_por_entrenador que muestre el nombre del entrenador y el total de equipos que entrena. Luego, realiza una consulta sobre esta vista para obtener los entrenadores con más de un equipo.
CREATE OR REPLACE VIEW vista_total_equipos_por_entrenador AS SELECT ent.nombre AS nombre_entrenador, COUNT(e.DNI_entrenador) AS total_equipos
FROM entrenador ent LEFT JOIN equipo e ON e.DNI_entrenador = ent.DNI
GROUP BY ent.nombre, e.DNI_entrenador;

-- 7 Crear una vista con una combinación de datos:
--   Crea una vista llamada vista_detalles_completos que combine datos de equipo, entrenador y emails_equipo para mostrar el nombre del equipo, el nombre del entrenador y sus correos electrónicos.
CREATE OR REPLACE VIEW vista_detalles_completos AS SELECT e.nombre AS nombre_equipo, ent.nombre AS nombre_entrenador, em.email FROM equipo e
LEFT JOIN entrenador ent ON ent.DNI = e.DNI_entrenador
LEFT JOIN emails_equipo em ON em.CIF_equipo = e.CIF;

-- Eliminamos vistas:
DROP VIEW vista_equipos_entrenadores;
DROP VIEW vista_entrenadores_telefonos;
DROP VIEW vista_equipos_emails;
DROP VIEW vista_entrenadores_varios_equipos;
DROP VIEW vista_equipos_gmail;
DROP VIEW vista_total_equipos_por_entrenador;
DROP VIEW vista_detalles_completos;

-- Eliminamos tablas:
DROP TABLE emails_equipo;
DROP TABLE equipo;
DROP TABLE telefonos_entrenador;
DROP TABLE entrenador;

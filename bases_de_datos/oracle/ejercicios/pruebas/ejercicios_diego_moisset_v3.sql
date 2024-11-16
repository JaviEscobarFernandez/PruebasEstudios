-- Primer problema:
-- Trabaje con la tabla llamada "medicamentos" de una farmacia.

-- 1- Elimine la tabla:
DROP TABLE medicamentos;

-- 2- Cree la tabla con la siguiente estructura:

CREATE TABLE medicamentos (
    codigo NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(20),
    laboratorio VARCHAR2(20),
    precio NUMBER(6,2),
    cantidad NUMBER(3),
    fecha_vencimiento DATE NOT NULL,
    numero_lote NUMBER(6) DEFAULT NULL
);
-- 3- Ingrese algunos registros:

INSERT INTO medicamentos (codigo, nombre, laboratorio, precio, cantidad, fecha_vencimiento, numero_lote) VALUES (120,'Sertal','Roche',5.2,1,'01/02/2015',123456);
INSERT INTO medicamentos (codigo, nombre, laboratorio, precio, cantidad, fecha_vencimiento, numero_lote) VALUES (220,'Buscapina','Roche',4.10,3,'01/02/2016',null);
INSERT INTO medicamentos (codigo, nombre, laboratorio, precio, cantidad, fecha_vencimiento, numero_lote) VALUES (228,'Amoxidal 500','Bayer',15.60,100,'01/05/2017',null);
INSERT INTO medicamentos (codigo, nombre, laboratorio, precio, cantidad, fecha_vencimiento, numero_lote) VALUES (324,'Paracetamol 500','Bago',1.90,20,'01/02/2018',null);
INSERT INTO medicamentos (codigo, nombre, laboratorio, precio, cantidad, fecha_vencimiento, numero_lote) VALUES (587,'Bayaspirina',null,2.10,null,'01/12/2019',null);
INSERT INTO medicamentos (codigo, nombre, laboratorio, precio, cantidad, fecha_vencimiento, numero_lote) VALUES (789,'Amoxidal jarabe','Bayer',null,null,'15/12/2019',null);

-- 4- Muestre la cantidad de registros empleando la función "count(*)" (6 registros)
SELECT COUNT(*) AS total_medicamentos FROM medicamentos;

-- 5- Cuente la cantidad de medicamentos que tienen laboratorio conocido (5 registros)
SELECT COUNT(laboratorio) AS medicamentos_con_laboratorio FROM medicamentos;

-- 6- Cuente la cantidad de medicamentos que tienen precio y cantidad, con alias (5 y 4 respectivamente)
SELECT COUNT(precio) AS medicamentos_con_precio, COUNT(cantidad) AS medicamentos_con_cantidad FROM medicamentos;

-- 7- Cuente la cantidad de remedios con precio conocido, cuyo laboratorio comience con "B" (2 registros)
SELECT COUNT(precio) AS remedios_con_precio_conocido FROM medicamentos WHERE laboratorio LIKE 'B%';

-- 8- Cuente la cantidad de medicamentos con número de lote distinto de "null" (1 registro)
SELECT COUNT(numero_lote) AS medicamentos_con_lote FROM medicamentos;

-- 9- Cuente la cantidad de medicamentos con fecha de vencimiento conocida (6 registros)
SELECT COUNT(fecha_vencimiento) AS medicamentos_con_fecha FROM medicamentos;

-- Primer problema:
-- Una empresa almacena los datos de sus empleados en una tabla "empleados".

-- 1- Elimine la tabla y créela con la siguiente estructura:
DROP TABLE empleados;
CREATE TABLE empleados(
	nombre VARCHAR2(30),
	documento CHAR(8) PRIMARY KEY,
	domicilio VARCHAR2(30),
	seccion VARCHAR2(20),
	sueldo NUMBER(6,2),
	cantidad_hijos NUMBER(2),
	fecha_ingreso DATE
);

-- 3- Ingrese algunos registros:
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Juan Perez','22333444','Colon 123','Gerencia',5000,2,'10/10/1980');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Ana Acosta','23444555','Caseros 987','Secretaria',2000,0,'15/08/1998');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Lucas Duarte','25666777','Sucre 235','Sistemas',4000,1,null);
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Pamela Gonzalez','26777888','Sarmiento 873','Secretaria',2200,3,null);
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Marcos Juarez','30000111','Rivadavia 801','Contaduria',3000,0,'26/08/2000');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Yolanda Perez','35111222','Colon 180','Administracion',3200,1,'25/09/2001');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Rodolfo Perez','35555888','Coronel Olmedo 588','Sistemas',4000,3,null);
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Martina Rodriguez','30141414','Sarmiento 1234','Administracion',3800,4,'14/12/2000');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES('Andres Costa','28444555',default,'Secretaria',null,null,'08/08/1990');

-- 4- Muestre la cantidad de empleados usando "count" (9 empleados)
SELECT COUNT(*) AS total_empleados FROM empleados;

-- 5- Muestre la cantidad de empleados con fecha de ingreso conocida (6 empleados)
SELECT COUNT(fecha_ingreso) FROM empleados;

-- 6- Muestre la cantidad de empleados con sueldo (8 empleados)
SELECT COUNT(sueldo) FROM empleados;

-- 7- Muestre la cantidad de empleados con sueldo de la sección "Secretaria" (2 empleados)
SELECT COUNT(sueldo) AS empleados_con_sueldo_secretaria FROM empleados WHERE seccion='Secretaria';

-- 8- Muestre el sueldo más alto y el más bajo colocando un alias (5000 y 2000 respectivamente)
SELECT MAX(sueldo) AS sueldo_maximo, MIN(sueldo) AS sueldo_minimo FROM empleados;

-- 9- Muestre el valor mayor de "cantidadhijos" de los empleados "Perez" (3 hijos)
SELECT MAX(cantidad_hijos) AS cantidad_hijos_perez FROM empleados WHERE nombre LIKE '%Perez%';

-- 10- Muestre la fecha de ingreso más reciente (max) y la más lejana (min) (25/09/01 y 10/10/80 respectivamente)
SELECT MAX(fecha_ingreso) AS ultima_fecha_ingreso, MIN(fecha_ingreso) AS primera_fecha_ingreso FROM empleados;

-- 11- Muestre el documento menor (22333444)
SELECT MIN(documento) AS documento_menor FROM empleados;

-- 12- Muestre el promedio de sueldos de todo los empleados (3400. Note que hay un sueldo nulo y no es tenido en cuenta)
SELECT AVG(sueldo) AS promedio_sueldos FROM empleados WHERE sueldo IS NOT NULL;

-- 13- Muestre el promedio de sueldos de los empleados de la sección "Secretaría" (2100. Note que hay 3 registros de la sección solicitada, pero como uno de ellos tiene sueldo nulo, no es tenido en cuenta)
SELECT AVG(sueldo) AS promedio_sueldos_secretaria FROM empleados WHERE seccion='Secretaria';

-- 14- Muestre el promedio de hijos de todos los empleados de "Sistemas" (retorna 2)
SELECT AVG(cantidad_hijos) AS promedio_hijos_sistemas FROM empleados WHERE seccion='Sistemas';

-- 15- Muestre la cantidad de empleados, la cantidad de empleados con domicilio conocido, la suma de los hijos, el promedio de los sueldos y los valores mínimo y máximo del campo "fechaingreso" de todos los empleados. Empleamos todas las funciones de grupo en una sola consulta y nos retorna 9, 8, 14, 3400, 10/10/80 y 25/09/01.
SELECT COUNT(*) AS total_empleados, COUNT(domicilio) AS empleados_con_domicilio, SUM(cantidad_hijos) AS hijos_totales, AVG(sueldo) AS promedio_sueldos, MIN(fecha_ingreso) AS primera_fecha_ingreso, MAX(fecha_ingreso) AS ultima_fecha_ingreso FROM empleados;

-- 16- Realice la misma consulta anterior pero ahora de los empleados de la sección "Recursos". Al no existir tal sección, "count(*)" y "count(domicilio)" retornan 0 (cero) y las demás funciones de grupo retornan "null".
SELECT COUNT(*) AS total_empleados, COUNT(domicilio) AS empleados_con_domicilio, SUM(cantidad_hijos) AS hijos_totales, AVG(sueldo) AS promedio_sueldos, MIN(fecha_ingreso) AS primera_fecha_ingreso, MAX(fecha_ingreso) AS ultima_fecha_ingreso FROM empleados WHERE seccion='Recursos';

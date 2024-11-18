-- Primer problema:
-- Un comercio que tiene un stand en una feria registra en una tabla llamada "visitantes" algunos datos de las personas que visitan o compran en su stand para luego enviarle publicidad de sus productos.

-- 1- Elimine la tabla "visitantes" y créela con la siguiente estructura:
DROP TABLE visitantes;
CREATE TABLE visitantes (
	nombre VARCHAR2(30),
	edad NUMBER(2),
	sexo CHAR(1) default 'f',
	domicilio VARCHAR2(30),
	ciudad VARCHAR2(20) default 'Cordoba',
	telefono VARCHAR2(11),
	mail VARCHAR2(30) default 'no tiene',
	cantidad_compra NUMBER(6,2)
);

-- 3- Ingrese algunos registros:
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, mail, cantidad_compra) VALUES ('Susana Molina',35,default,'Colon 123',default,null,null,59.80);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, mail, cantidad_compra) VALUES ('Marcos Torres',29,'m',default,'Carlos Paz',default,'marcostorres@hotmail.com',150.50);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, mail, cantidad_compra) VALUES ('Mariana Juarez',45,default,default,'Carlos Paz',null,default,23.90);
INSERT INTO visitantes (nombre, edad, sexo, telefono, mail) VALUES ('Fabian Perez',36,'m','4556677','fabianperez@xaxamail.com');
INSERT INTO visitantes (nombre, ciudad, cantidad_compra) VALUES ('Alejandra Gonzalez','La Falda',280.50);
INSERT INTO visitantes (nombre, edad, sexo, ciudad, mail, cantidad_compra) VALUES ('Gaston Perez',29,'m','Carlos Paz','gastonperez1@gmail.com',95.40);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, mail, cantidad_compra) VALUES ('Liliana Torres',40,default,'Sarmiento 876',default,default,default,85);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, mail, cantidad_compra) VALUES ('Gabriela Duarte',21,null,null,'Rio Tercero',default,'gabrielaltorres@hotmail.com',321.50);

-- 4- Queremos saber la cantidad de visitantes de cada ciudad utilizando la cláusula "group by" (4 filas devueltas)
SELECT ciudad, COUNT(*) AS total_visitantes FROM visitantes GROUP BY ciudad;

-- 5- Queremos la cantidad visitantes con teléfono no nulo, de cada ciudad (4 filas devueltas)
SELECT ciudad, COUNT(telefono) AS total_visitantes FROM visitantes GROUP BY ciudad;

-- 6- Necesitamos el total del monto de las compras agrupadas por sexo (3 filas)
-- Note que los registros con valor nulo en el campo "sexo" se procesan como un grupo diferente.
SELECT sexo, SUM(cantidad_compra) AS total_compras FROM visitantes GROUP BY sexo;

-- 7- Se necesita saber el máximo y mínimo valor de compra agrupados por sexo y ciudad (6 filas)
SELECT sexo, ciudad, MAX(cantidad_compra) AS maximo_compras, MIN(cantidad_compra) AS minimo_compras FROM visitantes GROUP BY sexo, ciudad;

-- 8- Calcule el promedio del valor de compra agrupados por ciudad (4 filas)
SELECT ciudad, AVG(cantidad_compra) AS promedio_compras FROM visitantes GROUP BY ciudad;

-- 9- Cuente y agrupe por ciudad sin tener en cuenta los visitantes que no tienen mail (3 filas)
SELECT ciudad, COUNT(mail) AS total_visitantes_con_mail FROM visitantes WHERE mail != 'no tiene' GROUP BY ciudad;


-- Segundo problema:
-- Una empresa almacena los datos de sus empleados en una tabla "empleados".

-- 1- Elimine la tabla y luego créela con la estructura definida a continuación:
DROP TABLE empleados;
CREATE TABLE empleados (
	nombre VARCHAR2(30),
	documento CHAR(8),
	domicilio VARCHAR2(30),
	seccion VARCHAR2(20),
	sueldo NUMBER(6,2),
	cantidad_hijos NUMBER(2),
	fecha_ingreso DATE,
	PRIMARY KEY(documento)
);

-- 3- Ingrese algunos registros:
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Juan Perez','22333444','Colon 123','Gerencia',5000,2,'10/05/1980');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Ana Acosta','23444555','Caseros 987','Secretaria',2000,0,'12/10/1980');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Lucas Duarte','25666777','Sucre 235','Sistemas',4000,1,'25/05/1985');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Pamela Gonzalez','26777888','Sarmiento 873','Secretaria',2200,3,'25/06/1990');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Marcos Juarez','30000111','Rivadavia 801','Contaduria',3000,0,'01/05/1996');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Yolanda Perez','35111222','Colon 180','Administracion',3200,1,'01/05/1996');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Rodolfo Perez','35555888','Coronel Olmedo 588','Sistemas',4000,3,'01/05/1996');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Martina Rodriguez','30141414','Sarmiento 1234','Administracion',3800,4,'01/09/2000');
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, cantidad_hijos, fecha_ingreso) VALUES ('Andres Costa','28444555',default,'Secretaria',null,null,null);

-- 4- Cuente la cantidad de empleados agrupados por sección (5 filas)
SELECT seccion, COUNT(*) AS total_empleados FROM empleados GROUP BY seccion;

-- 5- Calcule el promedio de hijos por sección (5 filas)
SELECT seccion, AVG(cantidad_hijos) AS promedio_hijos FROM empleados GROUP BY seccion;

-- 6- Cuente la cantidad de empleados agrupados por año de ingreso (6 filas)
SELECT EXTRACT(year FROM fecha_ingreso) AS Año, COUNT(*) AS empleados_por_año FROM empleados GROUP BY EXTRACT(year FROM fecha_ingreso);

-- 7- Calcule el promedio de sueldo por sección de los empleados con hijos (4 filas)
SELECT seccion, AVG(sueldo) AS sueldo_promedio FROM empleados WHERE cantidad_hijos > 0 GROUP BY seccion;

-- Primer problema:
-- Una empresa tiene registrados sus clientes en una tabla llamada "clientes".

-- 1- Elimine la tabla "clientes" y créela con la siguiente estructura:
DROP TABLE clientes2;
CREATE TABLE clientes2 (
	nombre VARCHAR2(30) NOT NULL,
	domicilio VARCHAR2(30),
	ciudad VARCHAR2(20),
	provincia VARCHAR2(20)
);

-- 2- Ingrese algunos registros:
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Lopez Marcos','Colon 111','Cordoba','Cordoba');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Perez Ana','San Martin 222','Cruz del Eje','Cordoba');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Garcia Juan','Rivadavia 333','Villa del Rosario','Cordoba');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Perez Luis','Sarmiento 444','Rosario','Santa Fe');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Pereyra Lucas','San Martin 555','Cruz del Eje','Cordoba');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Gomez Ines','San Martin 666','Santa Fe','Santa Fe');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Torres Fabiola','Alem 777','Villa del Rosario','Cordoba');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Lopez Carlos',null,'Cruz del Eje','Cordoba');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Ramos Betina','San Martin 999','Cordoba','Cordoba');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia) VALUES ('Lopez Lucas','San Martin 1010','Posadas','Misiones');

-- 3- Obtenga las provincias sin repetir (3 registros)
SELECT DISTINCT provincia FROM clientes2;

-- 4- Cuente las distintas provincias (retorna 3)
SELECT COUNT(DISTINCT provincia) AS total_provincias FROM clientes2;

-- 5- Se necesitan los nombres de las ciudades sin repetir (6 registros)
SELECT DISTINCT ciudad FROM clientes2;

-- 6- Obtenga la cantidad de ciudades distintas (devuelve 6)
SELECT COUNT(DISTINCT ciudad) AS total_ciudad FROM clientes2;

-- 7- Combine con "where" para obtener las distintas ciudades de la provincia de Cordoba (3 registros)
SELECT DISTINCT ciudad AS ciudades_de_cordoba FROM clientes2 WHERE provincia='Cordoba';

-- 8- Contamos las distintas ciudades de cada provincia empleando "group by" (3 filas)
SELECT provincia, COUNT(DISTINCT ciudad) AS total_ciudades_por_provincia FROM clientes2 GROUP BY provincia;

-- Segundo problema:
-- La provincia almacena en una tabla llamada "inmuebles" los siguientes datos de los inmuebles y sus propietarios para cobrar impuestos:

-- 1- Elimine la tabla:
DROP TABLE inmuebles;

-- 2- Créela con la siguiente estructura:
CREATE TABLE inmuebles (
	documento VARCHAR2(8) not null,
	apellido VARCHAR2(30),
	nombre VARCHAR2(30),
	domicilio VARCHAR2(20),
	barrio VARCHAR2(20),
	ciudad VARCHAR2(20),
	tipo CHAR(1),--b=baldio, e: edificado
	superficie NUMBER(8,2)
);

-- 3- Ingrese algunos registros:
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('11000000','Perez','Alberto','San Martin 800','Centro','Cordoba','e',100);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('11000000','Perez','Alberto','Sarmiento 245','Gral. Paz','Cordoba','e',200);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('12222222','Lopez','Maria','San Martin 202','Centro','Cordoba','e',250);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('13333333','Garcia','Carlos','Paso 1234','Alberdi','Cordoba','b',200);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('13333333','Garcia','Carlos','Guemes 876','Alberdi','Cordoba','b',300);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('14444444','Perez','Mariana','Caseros 456','Flores','Cordoba','b',200);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('15555555','Lopez','Luis','San Martin 321','Centro','Carlos Paz','e',500);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('15555555','Lopez','Luis','Lopez y Planes 853','Flores','Carlos Paz','e',350);
INSERT INTO inmuebles (documento, apellido, nombre, domicilio, barrio, ciudad, tipo, superficie) VALUES ('16666666','Perez','Alberto','Sucre 1877','Flores','Cordoba','e',150);

-- 4- Muestre los distintos apellidos de los propietarios, sin repetir (3 registros)
SELECT DISTINCT apellido AS diferentes_apellidos_propietarios FROM inmuebles;

-- 5- Recupere los distintos documentos de los propietarios y luego muestre los distintos documentos de los propietarios, sin repetir y vea la diferencia (9 y 6 registros respectivamente)
SELECT documento FROM inmuebles;
SELECT DISTINCT documento FROM inmuebles;

-- 6- Cuente, sin repetir, la cantidad de propietarios de inmuebles de la ciudad de Cordoba (5)
SELECT COUNT(DISTINCT documento) AS total_propietarios_cordoba FROM inmuebles WHERE ciudad='Cordoba';

-- 7- Cuente la cantidad de inmuebles con domicilio en 'San Martin' (3)
SELECT COUNT(ciudad) AS total_inmuebles_san_martin FROM inmuebles WHERE domicilio LIKE '%San Martin%';

-- 8- Cuente la cantidad de inmuebles con domicilio en 'San Martin', sin repetir la ciudad (2 registros). Compare con la sentencia anterior.
SELECT COUNT(DISTINCT ciudad) AS total_inmuebles_san_martin FROM inmuebles WHERE domicilio LIKE '%San Martin%';

-- 9- Muestre los apellidos y nombres de todos los registros(9 registros)
SELECT apellido, nombre FROM inmuebles;

-- 10- Muestre los apellidos y nombres, sin repetir (5 registros)
SELECt DISTINCT apellido, nombre FROM inmuebles;
-- Note que si hay 2 personas con igual nombre y apellido aparece una sola vez.

-- 11- Muestre la cantidad de inmuebles que tiene cada propietario en barrios conocidos, agrupando por documento (6 registros)
SELECT documento, COUNT(barrio) AS cantidad_inmuebles FROM inmuebles WHERE barrio IS NOT NULL GROUP BY documento ;

-- 12- Realice la misma consulta anterior pero en esta oportunidad, sin repetir barrio (6 registros)
SELECT documento, COUNT(DISTINCT barrio) AS cantidad_inmuebles FROM inmuebles WHERE barrio IS NOT NULL GROUP BY documento ;
-- Compare los valores con los obtenidos en el punto 11.

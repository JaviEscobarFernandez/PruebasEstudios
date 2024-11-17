-- Primer problema:
-- Una empresa tiene registrados sus clientes en una tabla llamada "clientes".

-- 1- Elimine la tabla "clientes":
DROP TABLE clientes2;

-- 2- Créela con la siguiente estructura:
CREATE TABLE clientes2 (
    nombre VARCHAR2(30) NOT NULL,
    domicilio VARCHAR2(30),
    ciudad VARCHAR2(20),
    provincia VARCHAR2(20),
    telefono NUMBER(11)
);

-- 3- Ingrese algunos registros:
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Lopez Marcos','Colon 111','Cordoba','Cordoba','null');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Perez Ana','San Martin 222','Cruz del Eje','Cordoba','4578585');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Garcia Juan','Rivadavia 333','Villa del Rosario','Cordoba','4578445');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Perez Luis','Sarmiento 444','Rosario','Santa Fe',null);
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Pereyra Lucas','San Martin 555','Cruz del Eje','Cordoba','4253685');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Gomez Ines','San Martin 666','Santa Fe','Santa Fe','0345252525');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Torres Fabiola','Alem 777','Villa del Rosario','Cordoba','4554455');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Lopez Carlos',null,'Cruz del Eje','Cordoba',null);
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Ramos Betina','San Martin 999','Cordoba','Cordoba','4223366');
INSERT INTO clientes2 (nombre, domicilio, ciudad, provincia, telefono) VALUES ('Lopez Lucas','San Martin 1010','Posadas','Misiones','0457858745');

-- 4- Obtenga el total de los registros agrupados por ciudad y provincia (6 filas)
SELECT ciudad, provincia, COUNT(*) AS total FROM clientes2 GROUP BY ciudad, provincia;

-- 5- Obtenga el total de los registros agrupados por ciudad y provincia sin considerar los que tienen menos de 2 clientes (3 filas)
SELECT ciudad, provincia, COUNT(*) AS total_clientes FROM clientes2 GROUP BY ciudad, provincia HAVING COUNT(*) >= 2;

-- 6- Obtenga el total de los clientes que viven en calle "San Martin" (where), agrupados por provincia (group by), de aquellas ciudades que tengan menos de 2 clientes (having) y omitiendo la fila correspondiente a la ciudad de "Cordoba" (having) (2 filas devueltas)
SELECT provincia, COUNT(*) AS total_clientes FROM clientes2 WHERE domicilio LIKE 'San Martin%' GROUP BY provincia HAVING COUNT(*) < 2 AND provincia != 'Cordoba';

-- Segundo problema:
-- Un comercio que tiene un stand en una feria registra en una tabla llamada "visitantes" algunos datos de las personas que visitan o compran en su stand para luego enviarle publicidad de sus productos.

-- 1- Elimine la tabla "visitantes":
DROP TABLE visitantes;

-- 2- Créela con la siguiente estructura:
CREATE TABLE visitantes (
    nombre VARCHAR2(30),
    edad NUMBER(2),
    sexo CHAR(1),
    domicilio VARCHAR2(30),
    ciudad VARCHAR2(20),
    telefono VARCHAR2(11),
    cantidad NUMBER(6,2) NOT NULL
);

-- 3- Ingrese algunos registros:
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Susana Molina',28,'f',null,'Cordoba',null,45.50);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Marcela Mercado',36,'f','Avellaneda 345','Cordoba','4545454',22.40);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Alberto Garcia',35,'m','Gral. Paz 123','Alta Gracia','03547123456',25);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Teresa Garcia',33,'f',default,'Alta Gracia','03547123456',120);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Roberto Perez',45,'m','Urquiza 335','Cordoba','4123456',33.20);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Marina Torres',22,'f','Colon 222','Villa Dolores','03544112233',95);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Julieta Gomez',24,'f','San Martin 333','Alta Gracia',null,53.50);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Roxana Lopez',20,'f','null','Alta Gracia',null,240);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Liliana Garcia',50,'f','Paso 999','Cordoba','4588778',48);
INSERT INTO visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, cantidad) VALUES ('Juan Torres',43,'m','Sarmiento 876','Cordoba',null,15.30);

-- 4- Obtenga el total de las compras agrupados por ciudad y sexo de aquellas filas que devuelvan un valor superior a 50 (3 filas)
SELECT ciudad, sexo, SUM(cantidad) AS total_compras FROM visitantes GROUP BY ciudad, sexo HAVING SUM(cantidad) > 50;

-- 5- Obtenga el total de las compras agrupados por ciudad y sexo (group by), considerando sólo los montos de compra superiores a 50 (where), los visitantes con teléfono (where), sin considerar la ciudad de "Cordoba" (having), ordenados por ciudad (order by) (2 filas)
SELECT ciudad, sexo, SUM(cantidad) AS total_compras FROM visitantes WHERE cantidad > 50 AND telefono IS NOT NULL GROUP BY ciudad, sexo HAVING ciudad != 'Cordoba' ORDER BY ciudad;

-- 6- Muestre el monto mayor de compra agrupado por ciudad, siempre que dicho valor supere los 50 pesos (having), considerando sólo los visitantes de sexo femenino y domicilio conocido (where) (2 filas)
SELECT ciudad, MAX(cantidad) AS cantidad_maxima FROM visitantes WHERE sexo='f' AND domicilio IS NOT NULL GROUP BY ciudad HAVING MAX(cantidad) > 50;

-- 7- Agrupe por ciudad y sexo, muestre para cada grupo el total de visitantes, la suma de sus compras y el promedio de compras, ordenado por la suma total y considerando las filas con promedio superior a 30 (3 filas)
SELECT ciudad, sexo, COUNT(*) AS total_visitantes, SUM(cantidad) AS suma_total_compras, AVG(cantidad) AS promedio_total_compras FROM visitantes GROUP BY ciudad, sexo HAVING AVG(cantidad) > 30 ORDER BY suma_total_compras;

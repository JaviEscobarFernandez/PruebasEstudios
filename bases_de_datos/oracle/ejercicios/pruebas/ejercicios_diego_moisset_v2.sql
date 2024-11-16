-- Primer problema:
-- Un comercio que vende artículos de computación registra los datos de sus artículos en una tabla con ese nombre.

-- 1- Elimine la tabla:
DROP TABLE articulos;
-- 2- Cree la tabla:

CREATE TABLE articulos (
	codigo NUMBER(4) PRIMARY KEY,
	nombre VARCHAR2(20),
	descripcion VARCHAR2(30),
	precio NUMBER(8,2),
	cantidad NUMBER (3) DEFAULT 0
);

-- 3- Ingrese algunos registros:
INSERT INTO articulos (codigo, nombre, descripcion, precio, cantidad) VALUES (101,'impresora','Epson Stylus C45',400.80,20);
INSERT INTO articulos (codigo, nombre, descripcion, precio, cantidad) VALUES (203,'impresora','Epson Stylus C85',500,30);
INSERT INTO articulos (codigo, nombre, descripcion, precio, cantidad) VALUES (205,'monitor','Samsung 14',800,10);
INSERT INTO articulos (codigo, nombre, descripcion, precio, cantidad) VALUES (300,'teclado','ingles Biswal',100,50);

-- 4- El comercio quiere aumentar los precios de todos sus artículos en un 15%. Actualice todos los precios empleando operadores aritméticos.
UPDATE articulos SET precio=precio*1.15;

-- 5- Vea el resultado.
SELECT * FROM articulos;

-- 6- Muestre todos los artículos, concatenando el nombre y la descripción de cada uno de ellos separados por coma.
SELECT nombre||', '||descripcion AS articulo FROM articulos;

-- 7- Reste a la cantidad de todas las impresoras, el valor 5, empleando el operador aritmético menos ("-")
UPDATE articulos SET cantidad = cantidad-5 WHERE nombre='impresora';

-- 8- Recupere todos los datos de las impresoras para verificar que la actualización se realizó.
SELECT * FROM articulos WHERE nombre='impresora';

-- 9- Muestre todos los artículos concatenado los campos para que aparezcan de la siguiente manera "Cod. 101: impresora Epson Stylus C45 $460,92 (15)"
SELECT 'Cod. '||codigo||': '||nombre||' '||descripcion||' $'||precio||' ('||cantidad||')' AS inventario FROM articulos;

-- 10 - El comercio hace un descuento del 15% en ventas mayoristas. Necesitamos recuperar el código, nombre, decripción de todos los artículos con una columna extra que muestre el precio de cada artículo para la venta mayorista con el siguiente encabezado "precio mayorista"
SELECT codigo, nombre, descripcion, precio*0.85 AS "venta mayorista" FROM articulos;

-- 11 - Muestre los precios de todos los artículos, concatenando el nombre y la descripción con el encabezado "artículo" (sin emplear "as" ni comillas)
SELECT 'Artículo: '||nombre||': '||descripcion, precio FROM articulos;

-- 12 - Muestre todos los campos de los artículos y un campo extra, con el encabezado "monto total" en la que calcule el monto total en dinero de cada artículo (precio por cantidad)
SELECT codigo, nombre, descripcion, precio, cantidad, precio*cantidad AS total_cantidad FROM articulos;

-- 13 - Muestre la descripción de todas las impresoras junto al precio con un 20% de recargo con un encabezado que lo especifique.
SELECT descripcion, precio, precio*1.2 AS IVA FROM articulos;

-- Primer problema:
-- En una página web se guardan los siguientes datos de las visitas: nombre, mail, pais y fecha.

-- 1- Elimine la tabla "visitas" y créela con la siguiente estructura:
DROP TABLE visitas;
CREATE TABLE visitas (
	nombre VARCHAR2(30) DEFAULT 'Anonimo',
	mail VARCHAR2(50),
	pais VARCHAR2(20),
	fecha DATE
);

-- 3- Ingrese algunos registros:

INSERT INTO visitas (nombre, mail, pais, fecha) VALUES ('Ana Maria Lopez','AnaMaria@hotmail.com','Argentina',TO_DATE('2020/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO visitas (nombre, mail, pais, fecha) VALUES ('Gustavo Gonzalez','GustavoGGonzalez@hotmail.com','Chile',TO_DATE('2020/02/13 11:08:10', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO visitas (nombre, mail, pais, fecha) VALUES ('Juancito','JuanJosePerez@hotmail.com','Argentina',TO_DATE('2020/07/02 14:12:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO visitas (nombre, mail, pais, fecha) VALUES ('Fabiola Martinez','MartinezFabiola@hotmail.com','Mexico',TO_DATE('2020/06/17 20:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO visitas (nombre, mail, pais, fecha) VALUES ('Fabiola Martinez','MartinezFabiola@hotmail.com','Mexico',TO_DATE('2020/02/08 20:05:40', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO visitas (nombre, mail, pais, fecha) VALUES ('Juancito','JuanJosePerez@hotmail.com','Argentina',TO_DATE('2020/07/06 18:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO visitas (nombre, mail, pais, fecha) VALUES ('Juancito','JuanJosePerez@hotmail.com','Argentina',TO_DATE('2019/10/05 23:00:00', 'yyyy/mm/dd hh24:mi:ss'));

-- 4- Ordene los registros por fecha, en orden descendente.
SELECT * FROM visitas ORDER BY fecha DESC;

-- 5- Muestre el nombre del usuario, pais y el mes, ordenado por pais (ascendente) y el mes (descendente)
SELECT nombre, pais, extract(month from fecha) AS mes FROM visitas ORDER BY pais ASC, mes DESC;

-- 6- Muestre los mail, país, ordenado por país, de todos los que visitaron la página en octubres
SELECT mail, pais, extract(month from fecha) AS mes FROM visitas WHERE extract(month from fecha)=10 ORDER BY pais;

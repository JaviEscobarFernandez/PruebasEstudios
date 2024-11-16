/*Primer problema:
Un videoclub que alquila películas en video almacena la información de sus películas en una tabla llamada "peliculas"; para cada película necesita los siguientes datos:

 -nombre, cadena de caracteres de 20 de longitud,
 -actor, cadena de caracteres de 20 de longitud,
 -duración, valor numérico entero que no supera los 3 dígitos.
 -cantidad de copias: valor entero de un sólo dígito (no tienen más de 9 copias de cada película).*/
-- 1- Elimine la tabla "peliculas" si ya existe.
DROP TABLE peliculas;

-- 2- Cree la tabla eligiendo el tipo de dato adecuado para cada campo.
-- Note que los campos "duracion" y "cantidad", que almacenarán valores sin decimales, fueron definidos de maneras diferentes, en el primero especificamos el valor 0 como cantidad de decimales, en el segundo no especificamos cantidad de decimales, es decir, por defecto, asume el valor 0.
CREATE TABLE peliculas (
    nombre VARCHAR2(20),
    actor VARCHAR2(20),
    duracion NUMBER(3,0),
    cantidad NUMBER(1)
);

-- 3- Vea la estructura de la tabla.
DESC peliculas;

-- 4- Ingrese los siguientes registros:
INSERT INTO peliculas (nombre, actor, duracion, cantidad) VALUES ('Mision imposible','Tom Cruise',128,3);
INSERT INTO peliculas (nombre, actor, duracion, cantidad) VALUES ('Mision imposible 2','Tom Cruise',130,2);
INSERT INTO peliculas (nombre, actor, duracion, cantidad) VALUES ('Mujer bonita','Julia Roberts',118,3);
INSERT INTO peliculas (nombre, actor, duracion, cantidad) VALUES ('Elsa y Fred','China Zorrilla',110,2);

-- 5- Muestre todos los registros (4 registros)
SELECT * FROM peliculas;

-- 6- Intente ingresar una película con valor de cantidad fuera del rango permitido:
INSERT INTO peliculas (nombre, actor, duracion, cantidad) VALUES ('Mujer bonita','Richard Gere',1200,10);
-- Mensaje de error.

-- 7- Ingrese un valor con decimales en un nuevo registro, en el campo "duracion":
INSERT INTO peliculas (nombre, actor, duracion, cantidad) VALUES ('Mujer bonita','Richard Gere',120.20,4);

-- 8- Muestre todos los registros para ver cómo se almacenó el último registro ingresado.
SELECT * FROM peliculas;

-- 9- Intente ingresar un nombre de película que supere los 20 caracteres.
INSERT INTO peliculas (nombre, actor, duracion, cantidad) VALUES ('La historia más larga jamás contada en la vida','Agustín Jimenez',120.20,4);

-- Segundo problema:
-- Una empresa almacena los datos de sus empleados en una tabla "empleados" que guarda los siguientes datos: nombre, documento, sexo, domicilio, sueldobasico.

-- 1- Elimine la tabla si existe.
DROP TABLE empleados;

-- 2- Cree la tabla eligiendo el tipo de dato adecuado para cada campo:
CREATE TABLE empleados (
    nombre VARCHAR(20),
    documento NUMBER(8),
    sexo VARCHAR(1),
    domicilio VARCHAR (30),
    sueldobasico NUMBER(6,2)
);

-- 3- Verifique que la tabla existe consultando "all_tables"
SELECT * FROM all_tables WHERE table_name='EMPLEADOS';

-- 4- Vea la estructura de la tabla (5 campos)
DESC empleados;

-- 5- Ingrese algunos registros:

INSERT INTO empleados (nombre, documento, sexo, domicilio, sueldobasico) VALUES ('Juan Perez','22333444','m','Sarmiento 123',500);
INSERT INTO empleados (nombre, documento, sexo, domicilio, sueldobasico) VALUES ('Ana Acosta','24555666','f','Colon 134',650);
INSERT INTO empleados (nombre, documento, sexo, domicilio, sueldobasico) VALUES ('Bartolome Barrios','27888999','m','Urquiza 479',800);

-- 6- Seleccione todos los registros (3 registros)
SELECT * FROM empleados;

-- 7- Intente ingresar un registro con el valor "masculino" en el campo "sexo"
-- Un mensaje indica que el campo está definido para almacenar 1 solo caracter como máximo y está intentando ingresar 9 caracteres.
INSERT INTO empleados (nombre, documento, sexo, domicilio, sueldobasico) VALUES ('Pepe Julian','23456789','masculino','calle falsa 123', 1000,50);

-- 8- Intente ingresar un valor fuera de rango, en un nuevo registro, para el campo "sueldobasico"
INSERT INTO empleados (nombre, documento, sexo, domicilio, sueldobasico) VALUES  ('Pepe Julian','23456789','m','calle falsa 123', 10000,50);

-- 9- Elimine la tabla
DROP TABLE empleados;


-- Primer problema:
-- Trabaje con la tabla "libros" de una librería.

-- 1- Elimine la tabla:
DROP TABLE libros;

-- 2- Créela con los siguientes campos, estableciendo como clave primaria el campo "codigo":
CREATE TABLE libros (
    codigo NUMBER(4) NOT NULL,
    titulo VARCHAR2(40) NOT NULL,
    autor VARCHAR2(20),
    editorial VARCHAR2(15),
    PRIMARY KEY (codigo)
);

-- 3- Ingrese los siguientes registros:
INSERT INTO libros (codigo,titulo,autor,editorial) VALUES (1,'El aleph','Borges','Emece');
INSERT INTO libros (codigo,titulo,autor,editorial) VALUES (2,'Martin Fierro','Jose Hernandez','Planeta');
INSERT INTO libros (codigo,titulo,autor,editorial) VALUES (3,'Aprenda PHP','Mario Molina','Nuevo Siglo');

-- 4- Ingrese un registro con código repetido (aparece un mensaje de error)
INSERT INTO libros (codigo,titulo,autor,editorial) VALUES (3,'Maria sarmiento','Anonimo','Planeta');


-- 5- Intente ingresar el valor "null" en el campo "codigo"
INSERT INTO libros (codigo,titulo,autor,editorial) VALUES (NULL,'Maria sarmiento','Anonimo','Planeta');
INSERT INTO libros (codigo,titulo,autor,editorial) VALUES ('','Maria sarmiento','Anonimo','Planeta');


-- 6- Intente actualizar el código del libro "Martin Fierro" a "1" (mensaje de error)
UPDATE libros SET codigo=1 WHERE titulo='Martin Fierro';

-- 7- Actualice el código del libro "Martin Fierro" a "10"
UPDATE libros SET codigo=10 WHERE titulo='Martin Fierro';


-- 8- Vea qué campo de la tabla "LIBROS" fue establecido como clave primaria
SELECT uc.table_name, column_name FROM user_cons_columns ucc
INNER JOIN user_constraints uc ON ucc.constraint_name=uc.constraint_name
WHERE uc.constraint_type='P' AND uc.table_name='LIBROS';

-- 9- Vea qué campo de la tabla "libros" (en minúsculas) fue establecido como clave primaria
SELECT uc.table_name, column_name FROM user_cons_columns ucc
INNER JOIN user_constraints uc ON ucc.constraint_name=uc.constraint_name
WHERE uc.constraint_type='P' AND uc.table_name='libros';
-- La tabla aparece vacía porque Oracle no encuentra la tabla "libros", ya que almacena los nombres de las tablas con mayúsculas.


-- Segundo problema:
-- Un instituto de enseñanza almacena los datos de sus estudiantes en una tabla llamada "alumnos".

-- 1- Elimine la tabla "alumnos":
DROP TABLE alumnos2;

-- 2- Cree la tabla con la siguiente estructura intentando establecer 2 campos como clave primaria, el campo "documento" y "legajo":
CREATE TABLE alumnos2 (
    legajo VARCHAR2(4) NOT NULL,
    documento VARCHAR2(8),
    nombre VARCHAR2(30),
    domicilio VARCHAR2(30),
    PRIMARY KEY (codigo),
    PRIMARY KEY (documento)
);
-- Un mensaje indica la tabla solamente puede tener UNA clave primaria.

-- 3- Cree la tabla estableciendo como clave primaria el campo "documento":
CREATE TABLE alumnos2 (
    legajo VARCHAR2(4) NOT NULL,
    documento VARCHAR2(8),
    nombre VARCHAR2(30),
    domicilio VARCHAR2(30),
    PRIMARY KEY (documento)
);

-- 4- Verifique que el campo "documento" no admite valores nulos
DESC alumnos2;

-- 5- Ingrese los siguientes registros:

INSERT INTO alumnos2 (legajo,documento,nombre,domicilio) VALUES ('A233','22345345','Perez Mariana','Colon 234');
INSERT INTO alumnos2 (legajo,documento,nombre,domicilio) VALUES ('A567','23545345','Morales Marcos','Avellaneda 348');

-- 6- Intente ingresar un alumno con número de documento existente (no lo permite)
INSERT INTO alumnos2 (legajo,documento,nombre,domicilio) VALUES ('A233','22345345','Mario Perez','Colon 234');


-- 7- Intente ingresar un alumno con documento nulo (no lo permite)
INSERT INTO alumnos2 (legajo,documento,nombre,domicilio) VALUES ('A233','','Perez Mariana','Colon 234');

-- 8- Vea el campo clave primaria de "ALUMNOS".
SELECT uc.table_name, column_name FROM user_cons_columns ucc
INNER JOIN user_constraints uc ON ucc.constraint_name=uc.constraint_name
WHERE uc.constraint_type='P' AND  uc.table_name='ALUMNOS2';

-- Un banco tiene registrados las cuentas corrientes de sus clientes en una tabla llamada "cuentas".

-- 1- Elimine la tabla "cuentas":
DROP TABLE cuentas;

-- 2- Cree la tabla:
CREATE TABLE cuentas (
	numero NUMBER(10) NOT NULL,
	documento CHAR(8) NOT NULL,
	nombre VARCHAR2(30),
	saldo NUMBER(9,2)
);

-- 3- Ingrese un registro con valores para todos sus campos, omitiendo la lista de campos.
INSERT INTO cuentas VALUES (123, 'doc123', 'cuenta123', '12402,21');

-- 4- Ingrese un registro omitiendo algún campo que admita valores nulos.
INSERT INTO cuentas (numero, documento) VALUES (124, 'doc124');

-- 5- Verifique que en tal campo se almacenó "null"
SELECT * FROM cuentas WHERE numero=124 AND nombre IS NULL;

-- 6- Intente ingresar un registro listando 3 campos y colocando 4 valores. Un mensaje indica que hay demasiados valores.
INSERT INTO cuentas (numero, documento, nombre) VALUES (125, 'doc125', 'cuenta125', '900,21');

-- 7- Intente ingresar un registro listando 3 campos y colocando 2 valores. Un mensaje indica que no hay suficientes valores.
INSERT INTO cuentas (numero, documento, nombre) VALUES (125, 'doc125');

-- 8- Intente ingresar un registro sin valor para un campo definido "not null".
INSERT INTO cuentas (numero, documento, nombre) VALUES (125, '', 'cuenta125');

-- 9- Vea los registros ingresados.
SELECT * FROM cuentas;

/*
¿Cuál de las siguientes sentencias SQL responde a la consulta “Nombre de las cadenas que no tienen tiendas en Barcelona”?
a - Ninguna de las anteriores es correcta.
b - SELECT c.nombre FROM CADENA c MINUS SELECT c.nombre FROM CADENA c JOIN TIENDA t ON t.id_cad = c.id_cad WHERE t.localidad = 'BARCELONA';
c - SELECT c.nombre FROM cadena c JOIN tienda t ON t.id_cad = c.id_cad WHERE t.localidad NOT IN 'BARCELONA';
d - SELECT c.nombre FROM CADENA c, TIENDA t, VENTAS v WHERE t.id_cad = c.id_cad AND v.id_tienda = t.id_tienda AND t.localidad <> 'BARCELONA';
*/
-- La respuesta adecuada seria la B, ya que selecciona los nombres de las cadenas, excluyendo la consulta select de los nombres de cadenas con localidad = 'BARCELONA'
-- Mi propuesta de consulta seria:
SELECT c.nombre, t.id_tienda, t.localidad AS nombre_cadena FROM cadena c
RIGHT JOIN tienda t ON c.id_cad=t.id_cad
WHERE t.id_cad NOT IN (SELECT id_cad FROM tienda WHERE localidad='BARCELONA');
-- Y una más adecuada, ya que seleccionamos con LEFT JOIN y filtrando en el LEFT JOIN no solo que coincida el id_cad, sino tambien localidad = 'BARCELONA'
-- Así que los campos donde id_cad sea NULL serán los que nos interesen.
SELECT c.nombre, t.id_cad FROM cadena c
LEFT JOIN tienda t ON c.id_cad = t.id_cad AND t.localidad = 'BARCELONA';
-- Por lo que añadiriamos en WHERE el filtro para seleccionar los resultados NULL:
SELECT c.nombre FROM cadena c
LEFT JOIN tienda t ON c.id_cad = t.id_cad AND t.localidad = 'BARCELONA'
WHERE t.id_cad IS NULL;

-- Creamos las tablas y añadimos valores para poder comprobar los resultados mejor.
CREATE TABLE cadena (
    id_cad NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(30)
);

CREATE TABLE tienda (
    id_tienda NUMBER(5) PRIMARY KEY,
    localidad VARCHAR2(30),
    id_cad NUMBER(5),
    CONSTRAINT fk_tienda_cadena FOREIGN KEY (id_cad) REFERENCES cadena(id_cad)
);

INSERT INTO cadena (id_cad, nombre) VALUES (1, 'cadena1');
INSERT INTO cadena (id_cad, nombre) VALUES (2, 'cadena2');
INSERT INTO cadena (id_cad, nombre) VALUES (3, 'cadena3');
INSERT INTO cadena (id_cad, nombre) VALUES (4, 'cadena4');
INSERT INTO cadena (id_cad, nombre) VALUES (5, 'cadena5');
INSERT INTO cadena (id_cad, nombre) VALUES (6, 'cadena6');

INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (1, 'BARCELONA', 1);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (2, 'MADRID', 1);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (3, 'VALENCIA', 2);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (4, 'ALICANTE', 3);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (5, 'BARCELONA', 3);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (6, 'BARCELONA', 2);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (7, 'CUENCA', 6);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (8, 'ALBACETE', 6);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (9, 'BARCELONA', 4);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (10, 'BARCELONA', 1);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (11, 'BARCELONA', 3);
INSERT INTO tienda (id_tienda, localidad, id_cad) VALUES (12, 'BARCELONA', 2);

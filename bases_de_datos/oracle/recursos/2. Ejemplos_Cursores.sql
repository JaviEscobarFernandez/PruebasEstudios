DROP TABLE VENTAS;
DROP TABLE PRODUCTOS;

SET SERVEROUTPUT ON;

-- Creación de la tabla "productos"
CREATE TABLE productos (
  producto_id NUMBER PRIMARY KEY,
  nombre VARCHAR2(100),
  precio NUMBER(10, 2)
);

-- Creación de la tabla "ventas"
CREATE TABLE ventas (
  venta_id NUMBER PRIMARY KEY,
  producto_id NUMBER,
  fecha_venta DATE,
  cantidad NUMBER,
  FOREIGN KEY (producto_id) REFERENCES productos (producto_id)
);

-- Inserción de registros en la tabla "productos"
INSERT INTO productos (producto_id, nombre, precio) VALUES (1, 'Manzanas', 1.99);
INSERT INTO productos (producto_id, nombre, precio) VALUES (2, 'Peras',  2.99);
INSERT INTO productos (producto_id, nombre, precio) VALUES (3, 'Platanos', 1.80);
INSERT INTO productos (producto_id, nombre, precio) VALUES (4, 'Uvas', 3.49);
INSERT INTO productos (producto_id, nombre, precio) VALUES (5, 'Fresas', 2.25);
INSERT INTO productos (producto_id, nombre, precio) VALUES (6, 'Naranjas', 1.50);

-- Inserción de registros en la tabla "ventas"
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (101, 1, '15/10/2023', 2);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (102, 1, '16/10/2023', 3);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (103, 2, '16/10/2023', 4);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (104, 2, '17/10/2023', 2);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (105, 3, '18/10/2023', 5);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (106, 4, '19/10/2023', 3);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (107, 4, '19/10/2023', 2);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (108, 5, '20/10/2023', 4);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (109, 5, '20/10/2023', 2);
INSERT INTO ventas (venta_id, producto_id, fecha_venta, cantidad) VALUES (110, 6, '21/10/2023', 3);
  
-- Ejercicio 1) Bloque Anónimo con Cursor Implícito para Calcular Monto Total de Ventas
-- Bloque anónimo PL/SQL con cursor implícito y SELECT INTO para calcular el monto total de ventas de un producto
DECLARE
  producto_nombre VARCHAR2(100) := 'Manzanas'; -- Cambia el nombre del producto según tus necesidades
  monto_total NUMBER;
BEGIN
  -- Utiliza un cursor implícito con SELECT INTO para calcular el monto total de ventas
  SELECT SUM(v.cantidad * p.precio)
  INTO monto_total
  FROM ventas v
  JOIN productos p ON v.producto_id = p.producto_id
  WHERE p.nombre = producto_nombre;

  -- Mostrar el monto total de ventas en la salida estándar
  DBMS_OUTPUT.PUT_LINE('Monto Total de Ventas de ' || producto_nombre || ': ' || monto_total || ' €');
END;

/




-- Ejercicio 2) Bloque Anónimo con Cursores Explícitos
-- Bloque anónimo PL/SQL con cursor explícito para mostrar datos de ventas
DECLARE
  -- Declaración del cursor explícito
  CURSOR venta_cursor IS
    SELECT p.nombre, p.precio, v.fecha_venta, v.cantidad
    FROM ventas v
    JOIN productos p ON v.producto_id = p.producto_id;
  
  -- Declaración de variables
  c_venta venta_cursor%rowtype;
  precio_venta NUMBER;
BEGIN
  -- Abre el cursor explícito
  OPEN venta_cursor;
  
  -- Recorre y muestra los datos de ventas
  LOOP
    FETCH venta_cursor INTO c_venta;
    EXIT WHEN venta_cursor%NOTFOUND;
    precio_venta := c_venta.precio * c_venta.cantidad;
    -- Muestra los datos en la salida estándar
    DBMS_OUTPUT.PUT_LINE('Producto: ' || c_venta.nombre);
    DBMS_OUTPUT.PUT_LINE('Fecha de Venta: ' || c_venta.fecha_venta);
    DBMS_OUTPUT.PUT_LINE('Cantidad Vendida: ' || c_venta.cantidad);
    DBMS_OUTPUT.PUT_LINE('Precio Venta: ' || precio_venta || ' €');
    DBMS_OUTPUT.PUT_LINE('--------------------------');
    
  END LOOP;
  
  -- Cierra el cursor explícito
  CLOSE venta_cursor;
END;

/





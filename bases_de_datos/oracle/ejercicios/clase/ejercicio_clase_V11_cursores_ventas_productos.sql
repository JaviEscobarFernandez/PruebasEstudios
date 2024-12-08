DROP TABLE VENTAS;
DROP TABLE PRODUCTOS;

SET SERVEROUTPUT ON;

-- Creación de la tabla "productos"
CREATE TABLE productos_v11 (
  producto_id NUMBER PRIMARY KEY,
  nombre VARCHAR2(100),
  precio NUMBER(10, 2)
);

-- Creación de la tabla "ventas"
CREATE TABLE ventas_v11 (
  venta_id NUMBER PRIMARY KEY,
  producto_id NUMBER,
  fecha_venta DATE,
  cantidad NUMBER,
  FOREIGN KEY (producto_id) REFERENCES productos_v11 (producto_id)
);

-- Inserción de registros en la tabla "productos"
INSERT INTO productos_v11 (producto_id, nombre, precio) VALUES (1, 'Manzanas', 1.99);
INSERT INTO productos_v11 (producto_id, nombre, precio) VALUES (2, 'Peras',  2.99);
INSERT INTO productos_v11 (producto_id, nombre, precio) VALUES (3, 'Platanos', 1.80);
INSERT INTO productos_v11 (producto_id, nombre, precio) VALUES (4, 'Uvas', 3.49);
INSERT INTO productos_v11 (producto_id, nombre, precio) VALUES (5, 'Fresas', 2.25);
INSERT INTO productos_v11 (producto_id, nombre, precio) VALUES (6, 'Naranjas', 1.50);

-- Inserción de registros en la tabla "ventas"
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (101, 1, '15/10/2023', 2);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (102, 1, '16/10/2023', 3);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (103, 2, '16/10/2023', 4);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (104, 2, '17/10/2023', 2);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (105, 3, '18/10/2023', 5);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (106, 4, '19/10/2023', 3);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (107, 4, '19/10/2023', 2);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (108, 5, '20/10/2023', 4);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (109, 5, '20/10/2023', 2);
INSERT INTO ventas_v11 (venta_id, producto_id, fecha_venta, cantidad) VALUES (110, 6, '21/10/2023', 3);


-- Supongamos que tienes una base de datos que registra ventas de productos.
-- Ejercicio 1) Cursor implícito
-- Escribe un bloque anónimo PL/SQL que utilice un cursor implícito con SELECT INTO para calcular y mostrar la cantidad total de ventas para un producto específico.
DECLARE
    v_producto_id productos_v11.producto_id%TYPE := &producto;
    v_suma_total NUMBER := 0;
    product_not_found EXCEPTION;
BEGIN
    SELECT SUM(cantidad) INTO v_suma_total
    FROM ventas_v11 WHERE producto_id = v_producto_id;

    IF v_suma_total IS NULL THEN
        RAISE product_not_found;
    END IF;

    DBMS_OUTPUT.PUT_LINE('La cantidad total de ventas del producto: ' || v_producto_id || ' es: ' || v_suma_total);
EXCEPTION
    WHEN product_not_found THEN
        DBMS_OUTPUT.PUT_LINE('El producto no existe');
END;
/
-- Ejercicio 2) Cursor explicito
-- Escribe un bloque anónimo PL/SQL que utilice un cursor explícito para recorrer y mostrar las ventas de productos, incluyendo la fecha de venta y la cantidad vendida.
DECLARE
    CURSOR c_ventas_productos IS SELECT p.nombre, p.precio, v.fecha_venta, v.cantidad FROM productos_v11 p
    INNER JOIN ventas_v11 v ON p.producto_id = v.producto_id;
    v_registro_ventas c_ventas_productos%ROWTYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Ejemplo realizado con un bucle For');
    FOR registro IN c_ventas_productos LOOP
        DBMS_OUTPUT.PUT_LINE('Producto: ' || registro.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || registro.precio);
        DBMS_OUTPUT.PUT_LINE('Fecha de venta: ' || registro.fecha_venta);
        DBMS_OUTPUT.PUT_LINE('Cantidad: ' || registro.cantidad);
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Ejemplo realizado con un bucle LOOP abriendo y cerrando el cursor');
    OPEN c_ventas_productos;
    LOOP
        FETCH c_ventas_productos INTO v_registro_ventas;
        EXIT WHEN c_ventas_productos%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Producto: ' || v_registro_ventas.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || v_registro_ventas.precio);
        DBMS_OUTPUT.PUT_LINE('Fecha de venta: ' || v_registro_ventas.fecha_venta);
        DBMS_OUTPUT.PUT_LINE('Cantidad: ' || v_registro_ventas.cantidad);
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    CLOSE c_ventas_productos;
END;
/

-- Ejercicio 3) Función
-- Crea una función llamada "calcular_impuesto" que tome una cantidad total de venta como parámetro y el impuesto, y lo devuelva el total con el impuesto sumado
CREATE OR REPLACE FUNCTION calcular_impuesto(p_total_venta NUMBER, p_impuesto NUMBER) RETURN NUMBER IS
    v_total_incrementado NUMBER;
BEGIN
    v_total_incrementado := p_total_venta + (p_total_venta * 15 / 100);
    RETURN v_total_incrementado;
END;
/
DECLARE
    CURSOR c_ventas_productos IS SELECT p.producto_id, p.nombre, p.precio, SUM(v.cantidad) AS cantidad_total FROM ventas_v11 v
    INNER JOIN productos_v11 p ON p.producto_id = v.producto_id
    GROUP BY p.producto_id, p.nombre, p.precio;
    v_registro c_ventas_productos%ROWTYPE;
    v_total_compra NUMBER;
BEGIN
    OPEN c_ventas_productos;
    LOOP
        FETCH c_ventas_productos INTO v_registro;
        EXIT WHEN c_ventas_productos%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Nombre Producto: ' || v_registro.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || v_registro.precio);
        DBMS_OUTPUT.PUT_LINE('Cantidad: ' || v_registro.cantidad_total);
        v_total_compra := v_registro.precio * v_registro.cantidad_total;
        DBMS_OUTPUT.PUT_LINE('Total Compra: ' || v_total_compra || '€');
        DBMS_OUTPUT.PUT_LINE('Precio + IVA: ' || calcular_impuesto(v_total_compra, 15) || '€');
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    CLOSE c_ventas_productos;
END;
/

-- Ejercicio 4) Procedimiento
-- Crea un procedimiento llamado "actualizar_datos_producto" que tome el id de un producto y un número y agregue el porcentaje del número al precio del producto
CREATE OR REPLACE PROCEDURE actualizar_datos_producto(p_id_producto NUMBER, p_num_pct NUMBER) IS
    v_precio_incr NUMBER := 0;
    pct_invalid EXCEPTION;
BEGIN
    -- Aseguramos que el pct sea un valor valido
    IF p_num_pct > 100 OR p_num_pct <= 0 THEN
        RAISE pct_invalid;
    END IF;

    -- Seleccionamos en un cursor implicido el precio del prodcuto
    SELECT precio INTO v_precio_incr
    FROM productos_v11 WHERE producto_id = p_id_producto;

    -- Mostramos el precio que tiene
    DBMS_OUTPUT.PUT_LINE('El precio del producto con id: ' || p_id_producto || ' es: ' || v_precio_incr);

    -- Lo incrementamos con el pct
    v_precio_incr := v_precio_incr + (v_precio_incr * p_num_pct / 100);

    -- Lo actualizamos en la tabla
    UPDATE productos_v11 SET precio = v_precio_incr WHERE producto_id = p_id_producto;

    -- Mostramos el nuevo precio que tiene
    DBMS_OUTPUT.PUT_LINE('El precio del producto con id: ' || p_id_producto || ' ha sido actualizado a: ' || v_precio_incr);
EXCEPTION
    WHEN pct_invalid THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: el porcentaje a incrementar debe ser mayor a 0 y no exceder el valor 100.');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: el producto no existe.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: multiples productos seleccionados.');
END;
/

DECLARE
    v_producto_id productos_v11.producto_id%TYPE := &producto;
    v_incremento NUMBER := &incremento;
BEGIN
    actualizar_datos_producto(v_producto_id, v_incremento);
END;
/

-- Los cursores nos permiten almacenar y recorrer un conjunto de datos.
-- Hay dos tipos implicitos y explicitos.

-- implicitos: un solo registro o fila como maximo
-- explicitos: los creamos y declaramos nosotros


-- Explicito
DECLARE
    -- Declaramos el cursor (nombre cursor IS y la consulta)
    CURSOR c_productos IS SELECT * FROM producto ORDER BY precio;
    -- Creamos variable producto para almacenar la fila
    v_producto producto%ROWTYPE;

    -- Creamos un cursor para una consulta en dos tablas conjuntas
    CURSOR c_productos_fabricante IS
    SELECT p.codigo, p.nombre, p.precio, f.nombre AS nombre_fabricante
    FROM producto p, fabricante f
    WHERE p.codigo_fabricante = f.codigo ORDER BY p.precio;
BEGIN
    -- Lo vamos a realizar de dos formas diferentes, la primera abriendo el cursor
    -- Iterando el cursor y haciendo FETCH para ir fila a fila
    -- Y por ultimo cerrando el cursor.

    DBMS_OUTPUT.PUT_LINE('Cursor c_productos:');
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('-----------------------');
    DBMS_OUTPUT.PUT_LINE('');
    -- Abrimos el cursor
    OPEN c_productos;

    -- Recorremos el cursor
    LOOP
        -- En cada iteracion obtenemos la fila correspondiente y la almacenamos
        -- en v_producto, casi similar al SELECT INTO.
        FETCH c_productos INTO v_producto;

        -- Añadimos condicion de salida cuando no encuentre datos al realizar el FETCH
        EXIT WHEN c_productos%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Información producto con código: ' || v_producto.codigo);
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio);
        DBMS_OUTPUT.PUT_LINE('Código Fabricante: ' || v_producto.codigo_fabricante);
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('-----------------------');
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;

    -- Cerramos el cursor (Importante siempre cerrarlo al acabar)
    CLOSE c_productos;

    -- Y aqui la segunda forma, lo iteramos directamente con un bucle for
    DBMS_OUTPUT.PUT_LINE('Cursor c_productos_fabricante:');
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('-----------------------');
    DBMS_OUTPUT.PUT_LINE('');
    FOR registro IN c_productos_fabricante LOOP
        DBMS_OUTPUT.PUT_LINE('Información producto con código: ' || registro.codigo);
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || registro.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || registro.precio);
        DBMS_OUTPUT.PUT_LINE('Nombre Fabricante: ' || registro.nombre_fabricante);
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('-----------------------');
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

-- Cursores parametrizados (añadirle parametros como las funciones y procedimientos)
DECLARE
    CURSOR c_productos_fabricante(p_cod_fab NUMBER) IS
    SELECT * FROM producto WHERE codigo_fabricante = p_cod_fab
    ORDER BY precio;
    v_producto producto%ROWTYPE;
    v_codigo_fabricante fabricante.codigo%TYPE := &codigo;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Prueba con loop');
    DBMS_OUTPUT.PUT_LINE('');
    OPEN c_productos_fabricante(v_codigo_fabricante);
        LOOP
            FETCH c_productos_fabricante INTO v_producto;
            EXIT WHEN c_productos_fabricante%NOTFOUND;

            DBMS_OUTPUT.PUT_LINE('Información producto con código: ' || v_producto.codigo);
            DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
            DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio);
            DBMS_OUTPUT.PUT_LINE('');
            DBMS_OUTPUT.PUT_LINE('-----------------------');
            DBMS_OUTPUT.PUT_LINE('');
        END LOOP;
    CLOSE c_productos_fabricante;
    DBMS_OUTPUT.PUT_LINE('Prueba con for');
    DBMS_OUTPUT.PUT_LINE('');
    FOR registro IN c_productos_fabricante(v_codigo_fabricante) LOOP
        DBMS_OUTPUT.PUT_LINE('Información producto con código: ' || registro.codigo);
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || registro.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || registro.precio);
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('-----------------------');
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

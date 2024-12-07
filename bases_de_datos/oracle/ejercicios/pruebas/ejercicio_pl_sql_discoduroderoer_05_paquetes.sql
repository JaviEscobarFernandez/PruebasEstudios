-- Paquetes, los paquetes sirven para agrupar procedimientos y funciones
-- Para asi luego llamar al paquete.funcion o procedimiento y ejecutarlo.
-- Digamos que es como crear una clase en C# y llamar ahi a los metodos.

-- Borramos los procedimientos y funciones que teniamos
DROP PROCEDURE infoProducto;
DROP FUNCTION obtenerProducto;

-- Creamos el paquete y dentro definimos la cabecera de los procedimientos y funciones
CREATE OR REPLACE PACKAGE productos2 AS
    PROCEDURE infoProducto(p_codigo IN producto.codigo%TYPE);
    FUNCTION obtenerProducto(p_codigo IN producto.codigo%TYPE) RETURN producto%ROWTYPE;
END;
/

-- Creamos el cuerpo del paquete y en su interior creamos el contenido de los procedimientos y funciones
CREATE OR REPLACE PACKAGE BODY productos2 AS
    -- procedimiento
    PROCEDURE infoProducto(p_codigo producto.codigo%TYPE) AS
        v_producto producto%ROWTYPE;
    BEGIN
        SELECT * INTO v_producto
        FROM producto WHERE codigo = p_codigo;

        DBMS_OUTPUT.PUT_LINE('Información del producto con código: ' || p_codigo);
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio || '€');
        DBMS_OUTPUT.PUT_LINE('Código Fabricante: ' || v_producto.codigo_fabricante);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: Datos no existentes');
         WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: unknown');
    END;

    -- funcion
    FUNCTION obtenerProducto(p_codigo producto.codigo%type)
    RETURN producto%ROWTYPE AS
    -- Aqui se declara igual que si fuese un DECLARE
        v_producto producto%ROWTYPE;
    BEGIN
        SELECT * INTO v_producto
        FROM producto WHERE codigo = p_codigo;
        -- Siempre debemos retornar
        RETURN v_producto;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: No existe el producto: ' || p_codigo);
            -- En las excepciones tambien debemos retornar
            RETURN NULL;
         WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: unknown');
            RETURN NULL;
    END;
END;
/


-- Creamos un bloque anonimo y llamamos al paquete.funcion o procedimiento
DECLARE
    v_codigo producto.codigo%type := &codigo;
    v_producto producto%ROWTYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Procedimiento');
    productos2.infoProducto(v_codigo);
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Función');
    v_producto := productos2.obtenerProducto(v_codigo);

    IF v_producto.codigo IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('Información del producto con código: ' || v_codigo);
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio || '€');
        DBMS_OUTPUT.PUT_LINE('Código Fabricante: ' || v_producto.codigo_fabricante);
    END IF;
END;
/

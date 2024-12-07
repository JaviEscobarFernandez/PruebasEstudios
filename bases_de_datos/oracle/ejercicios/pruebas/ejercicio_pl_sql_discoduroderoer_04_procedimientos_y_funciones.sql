-- Procedimientos y funciones (funcion es lo mismo que procedimiento, pero devuelve un resultado)

-- procedimiento (p_ es para anotar que es parametro)
CREATE OR REPLACE PROCEDURE infoProducto(p_codigo producto.codigo%TYPE) AS
-- Aqui se declara igual que si fuese un DECLARE
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
/

DECLARE
    v_codigo producto.codigo%type := &codigo;
BEGIN
    -- Para llamarlo se pone el nombre del procedimiento y los parametros.
    infoProducto(v_codigo);
END;
/

-- Para llamarlo fuera de un bloque anonimo podemos utilizar EXEC o EXECUTE
EXECUTE infoProducto(1);

-- funcion (devuelve siempre un valor)
-- Tanto en el bloque BEGIN como EXCEPTION como en el CREATE, debe haber un RETURN con el valor
CREATE OR REPLACE FUNCTION obtenerProducto(p_codigo producto.codigo%type)
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
/

DECLARE
    v_codigo producto.codigo%type := &codigo;
    v_producto producto%ROWTYPE;
BEGIN
    v_producto := obtenerProducto(v_codigo);
    -- Aqui comprobamos que el resultado de v_producto no sea NULL
    -- El problema es que hay que especificar al ser ROWTYPE alguna columna (todas son nulas)
    IF v_producto.codigo IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('Información del producto con código: ' || v_codigo);
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio || '€');
        DBMS_OUTPUT.PUT_LINE('Código Fabricante: ' || v_producto.codigo_fabricante);
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Datos no existentes');
     WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: unknown');
END;
/

-- Mostrar funcion (dual es una tabla para ejecutar, se puede utilizar la que sea)
SELECT obtenerProducto(1) FROM dual;


-- Tipos de parametros (de entrada y salida)
-- Los parametros de entrada se pueden utilizar con IN o si no indicamos nada, toma el IN por defecto)
-- Al finalizar la funcion o procedimiento, el valor no se actualizará desde donde lo llamemos
-- Los parametros de salida, OUT al modificarlos dentro del procedimiento o funcion, al finalizar seguiran actualizados.
-- procedimiento (p_ es para anotar que es parametro)
CREATE OR REPLACE PROCEDURE infoProducto(p_codigo IN producto.codigo%TYPE, p_producto OUT producto%ROWTYPE) AS

BEGIN
    SELECT * INTO p_producto
    FROM producto WHERE codigo = p_codigo;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: No existe el producto con código: ' || p_codigo);
     WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: unknown');
END;
/

DECLARE
    v_codigo producto.codigo%type := &codigo;
    v_producto producto%ROWTYPE;
BEGIN
    -- Para llamarlo se pone el nombre del procedimiento y los parametros.
    -- Aqui estamos enviando v_codigo como parametro de entrada y v_producto de salida
    -- Asi que v_codigo no será alterado, pero v_producto vendrá con la información que se almacena dentro del procedimiento.
    infoProducto(v_codigo, v_producto);
    IF v_producto.codigo IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('Información del producto con código: ' || v_codigo);
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
        DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio || '€');
        DBMS_OUTPUT.PUT_LINE('Código Fabricante: ' || v_producto.codigo_fabricante);
    END IF;
END;
/

-- SELECT INTO siempre necesita un valor.
-- Solo vale para consultas que devuelvan un valor.
-- Tampoco puede devolver ningun valor.
-- En este ejemplo vamos a seleccionar de una tabla unas cantidades
-- y las vamos a almacenar en variables para mostrarlas
DECLARE
    v_total NUMBER(8);
    v_suma_productos NUMBER (8,2);
BEGIN
    -- Importante que las variables sigan el mismo orden que las selecciones
    SELECT COUNT(*), SUM(precio) INTO v_total, v_suma_productos
    FROM producto;
    DBMS_OUTPUT.PUT_LINE('Total de productos: ' || v_total);
    DBMS_OUTPUT.PUT_LINE('Suma precio de productos: ' || v_suma_productos);
END;
/

-- Atributo Type: sirve para declarar un tipo de una columna de la BD.
-- Por ejemplo vamos a almacenar un nombre, no sabemos si ponerle VARCHAR2(20) o VARCHAR2(50)
-- Asi que con el atributo type podemos obtener el tipo de datos de la columna.
DECLARE
    v_codigo producto.codigo%TYPE := &codigo;
    v_nombre producto.nombre%TYPE;
BEGIN
    SELECT nombre INTO v_nombre
    FROM producto WHERE codigo = v_codigo;
    DBMS_OUTPUT.PUT_LINE('Nombre del producto con codigo: ' || v_codigo || ': ' || v_nombre);
END;
/

-- Atributo RowType: se utiliza para cuando queramos almacenar toda una fila de una tabla.
-- Para evitar crear muchas variables para cada una de las columnas.
DECLARE
    v_codigo producto.codigo%TYPE := &codigo;
    v_producto producto%ROWTYPE;
BEGIN
    -- En v_producto se almacena el resultado de la consulta (lo que imprimira la consulta)
    -- Luego utilizando v_produco.nombre_de_la_columna, mostramos el valor
    SELECT * INTO v_producto
    FROM producto WHERE codigo = v_codigo;
    DBMS_OUTPUT.PUT_LINE('Información del prodcuto con código: ' || v_codigo);
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
    DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio);
    DBMS_OUTPUT.PUT_LINE('Código fabricante: ' || v_producto.codigo_fabricante);
END;
/

-- Control de excepciones: Se utiliza EXCEPTION, entre el BEGIN y el END;
DECLARE
    v_codigo producto.codigo%TYPE := &codigo;
    v_producto producto%ROWTYPE;
BEGIN
    -- En v_producto se almacena el resultado de la consulta (lo que imprimira la consulta)
    -- Luego utilizando v_produco.nombre_de_la_columna, mostramos el valor
    SELECT * INTO v_producto
    FROM producto WHERE codigo = v_codigo;
    DBMS_OUTPUT.PUT_LINE('Información del prodcuto con código: ' || v_codigo);
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
    DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio);
    DBMS_OUTPUT.PUT_LINE('Código fabricante: ' || v_producto.codigo_fabricante);
EXCEPTION
    -- Excepcion especifica (hay muchas otras especificas)
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No existe el producto ' || v_codigo);
    -- Excepcion generica (cuando quieres generalizar)
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error no especificado');
END;
/

-- Control de excepciones con RAISE: Son excepciones creadas por nostros
-- Se definen en declare igual que las variables
-- Se manejan creando la condicion en la parte del BEGIN y se llaman con RAISE
-- Luego en la parte de EXCEPTION se añade la excepcion y su accion
-- con RAISE se puede llamar a cualquier excepcion, sea personalizada o especifica.
DECLARE
    v_codigo producto.codigo%TYPE := &codigo;
    v_producto producto%ROWTYPE;
    limite_precio EXCEPTION;
BEGIN
    -- En v_producto se almacena el resultado de la consulta (lo que imprimira la consulta)
    -- Luego utilizando v_produco.nombre_de_la_columna, mostramos el valor
    SELECT * INTO v_producto
    FROM producto WHERE codigo = v_codigo;
    -- Creamos la condicion para llamar a la excepcion personalizada
    IF v_producto.precio >= 100 THEN
        RAISE limite_precio;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Información del prodcuto con código: ' || v_codigo);
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
    DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio);
    DBMS_OUTPUT.PUT_LINE('Código fabricante: ' || v_producto.codigo_fabricante);
EXCEPTION
    -- Excepcion especifica (hay muchas otras especificas)
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No existe el producto ' || v_codigo);
    -- Excepcion personalizada
    WHEN limite_precio THEN
        DBMS_OUTPUT.PUT_LINE('Limite de precio del producto superado ' || v_codigo);
    -- Excepcion generica (cuando quieres generalizar)
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error no especificado');
END;
/

-- Control de excepciones: Presonalizar mensajes de error
-- RAISE_APPLICATION_ERROR es para especificar el id del codigo especifico y modificar el mensaje
-- -20999 seria el id de NO_DATA_FOUND
DECLARE
    v_codigo producto.codigo%TYPE := &codigo;
    v_producto producto%ROWTYPE;
    limite_precio EXCEPTION;
    PRAGMA EXCEPTION_INIT (limite_precio, -20999);

BEGIN

    SELECT * INTO v_producto
    FROM producto WHERE codigo = v_codigo;

    -- Aqui comprobamos la excepcion para mostrar error
    -- Y utilizamos el codigo del error para personalizar el mensaje
    IF v_producto.precio >= 100 THEN
        RAISE_APPLICATION_ERROR(-20999, 'El producto tiene un valor superior a 100€');
    END IF;

    DBMS_OUTPUT.PUT_LINE('Información del prodcuto con código: ' || v_codigo);
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_producto.nombre);
    DBMS_OUTPUT.PUT_LINE('Precio: ' || v_producto.precio);
    DBMS_OUTPUT.PUT_LINE('Código fabricante: ' || v_producto.codigo_fabricante);

EXCEPTION
    -- Para que apareciese el error con el mensaje personalizado, habria que dejar solo el primero
    -- Sino, entra en los otros
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No existe el producto ' || v_codigo);
    -- Aqui manejamos para que nos muestre el codigo de error y el mensaje personalizado que hemos creado
    WHEN limite_precio THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: codigo: ' || sqlcode);
        DBMS_OUTPUT.PUT_LINE('mensaje error: ' || sqlerrm);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error no especificado');
END;
/

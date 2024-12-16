-- 1. Mostrar ‘Hola mundo’ por pantalla.
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hola mundo');
END;
/

-- 2. Declarar una variable numerica y mostrar si es mayor de 10 o no.
DECLARE
    v_num1 CONSTANT NUMBER(2) := 4;
BEGIN
    IF v_num1 > 10 THEN
        DBMS_OUTPUT.PUT_LINE(v_num1 || ' es mayor que 10.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_num1 || ' NO es mayor que 10.');
    END IF;
END;
/


-- 3. Declarar una variable numerica y pedir su valor y mostrarlo.
DECLARE
    v_num1 INTEGER := &numero;
BEGIN
    DBMS_OUTPUT.PUT_LINE('El valor introducido es: ' || v_num1);
END;
/

-- 4. Mostrar los numeros del 1 al 100 con un while.
DECLARE
    v_contador NUMBER(10) := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Bucle While:');
    WHILE v_contador <= 100 LOOP
        DBMS_OUTPUT.PUT_LINE(v_contador);
        v_contador := v_contador + 1;
    END LOOP;
END;
/

-- 5. Mostrar los numeros del 1 al 100 con un for.
BEGIN
    DBMS_OUTPUT.PUT_LINE('Bucle For:');
    FOR contador IN 1..100 LOOP
        DBMS_OUTPUT.PUT_LINE(contador);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Bucle For Reverse:');
    FOR contador IN REVERSE 1..100 LOOP
        DBMS_OUTPUT.PUT_LINE(contador);
    END LOOP;
END;
/

-- 6. Mostrar los numeros del 1 al 100 con un loop.
DECLARE
    v_contador NUMBER(10) := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Bucle Loop:');
    LOOP
        EXIT WHEN v_contador > 100;
        DBMS_OUTPUT.PUT_LINE(v_contador);
        v_contador := v_contador + 1;
    END LOOP;
END;
/

-- 7. Mostrar el nombre de un cliente dado su codigo.
DECLARE
    v_codigo clientes.codigocliente%TYPE := &codigo;
    v_nombre clientes.nombrecliente%TYPE;
BEGIN
    SELECT nombrecliente INTO v_nombre
    FROM clientes WHERE codigocliente = v_codigo;
    DBMS_OUTPUT.PUT_LINE('El nombre del cliente con codigo: ' || v_codigo || ' es: ' || v_nombre);
END;
/

-- 8. Mostrar el precioVenta y la gama de un producto dado su codigo.
DECLARE
    v_codigo productos.CodigoProducto%TYPE := &codigo;
    v_productos productos%ROWTYPE;
BEGIN
    SELECT * INTO v_productos
    FROM productos WHERE CodigoProducto = v_codigo;
    DBMS_OUTPUT.PUT_LINE('Información del producto con codigo: ' || v_codigo);
    DBMS_OUTPUT.PUT_LINE('Precio de venta: ' || v_productos.PrecioVenta);
    DBMS_OUTPUT.PUT_LINE('Gama: ' || v_productos.gama);
END;
/

-- 9. Mostrar toda la informacion de un pedido dado su codigo (fechaEsperada, fechaEntrega, fechapedido, estado, comentarios)
DECLARE
    v_codigo pedidos.CodigoPedido%TYPE := &codigo;
    v_pedidos pedidos%ROWTYPE;
BEGIN
    SELECT * INTO v_pedidos
    FROM pedidos WHERE CodigoPedido = v_codigo;
    DBMS_OUTPUT.PUT_LINE('Información del pedido con codigo: ' || v_codigo);
    DBMS_OUTPUT.PUT_LINE('Fecha esperada: ' || v_pedidos.fechaEsperada);
    DBMS_OUTPUT.PUT_LINE('Fecha entregada: ' || v_pedidos.fechaEntrega);
    DBMS_OUTPUT.PUT_LINE('Fecha pedido: ' || v_pedidos.fechapedido);
    DBMS_OUTPUT.PUT_LINE('Estado: ' || v_pedidos.estado);
    DBMS_OUTPUT.PUT_LINE('Comentarios: ' || v_pedidos.comentarios);
END;
/

-- 10. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el codigo por parametro.
-- 10. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el codigo por parametro.
CREATE OR REPLACE FUNCTION suma_pagos(p_codigo pagos.CodigoCliente%TYPE)
RETURN NUMBER
IS
    v_suma_pagos NUMBER := 0;
BEGIN
    SELECT SUM(cantidad) INTO v_suma_pagos
    FROM pagos WHERE CodigoCliente = p_codigo;
    RETURN v_suma_pagos;
END;
/
DECLARE
    v_codigo pagos.CodigoCliente%TYPE := &codigo;
BEGIN
    DBMS_OUTPUT.PUT_LINE('La suma total de pagos con codigo: ' || v_codigo ||
    ' es: ' || suma_pagos(v_codigo));
END;
/

select * from pedidos;
select * from pagos;
select * from detallepedidos;
select * from productos;
SELECT ped.cantidad;
-- 11. Realizar un método o procedimiento que muestre el total en euros de un pedido, pasale el codigo por parametro.
CREATE OR REPLACE PROCEDURE total_euros_pedido(p_codigo detallePedidos.CodigoPedido%TYPE)
AS
    v_total NUMBER(8,2) := 0;
    CURSOR c_detallePedidos IS
    SELECT * FROM detallePedidos WHERE CodigoPedido = p_codigo;
BEGIN
    FOR registro IN c_detallePedidos LOOP
        v_total := v_total + (registro.cantidad * registro.precioUnidad);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('El precio total del pedido con código: ' || p_codigo || ' es: ' || v_total || '€');
END;
/
DECLARE
    v_codigo detallePedidos.CodigoPedido%TYPE := &pedido;
BEGIN
    total_euros_pedido(v_codigo);
END;
/

select * from clientes;
-- 12. Mostrar el nombre de un cliente dado su codigo. Controla en caso de que no se encuentre, mostrando un mensaje por ejemplo.
DECLARE
    v_codigo clientes.CodigoCliente%TYPE := &codigo;
    v_nombre clientes.NombreCliente%TYPE;
    cliente_no_encontrado EXCEPTION;
BEGIN
    SELECT NombreCliente INTO v_nombre
    FROM clientes WHERE CodigoCliente = v_codigo;
    DBMS_OUTPUT.PUT_LINE('El nombre del cliente es: ' || v_nombre);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: El cliente no existe');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

select * from pagos;
-- 13. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el codigo por parametro. Controla en caso de que no se encuentre, en ese caso devuelve un -1.
CREATE OR REPLACE FUNCTION suma_pagos(p_codigo pagos.CodigoCliente%TYPE)
RETURN NUMBER
AS
    v_total pagos.cantidad%TYPE := 0;
    cliente_no_existente EXCEPTION;
BEGIN
    SELECT SUM(cantidad) INTO v_total
    FROM pagos WHERE CodigoCliente = p_codigo;
    IF v_total IS NULL THEN
        RAISE cliente_no_existente;
    ELSE
        RETURN v_total;
    END IF;
EXCEPTION
    WHEN cliente_no_existente THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Cliente no existente');
        RETURN -1;
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Datos no existentes');
        RETURN -1;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        RETURN -1;
END;
/

DECLARE
    v_codigo pagos.CodigoCliente%TYPE := &codigo;
    v_suma NUMBER(8,2) := 0;
BEGIN
    v_suma := suma_pagos(v_codigo);
    IF v_suma >= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Suma total: ' || suma_pagos(v_codigo) || '€');
    END IF;
END;
/

SELECT * FROM pedidos;
select * from detallepedidos;
-- 14. Realizar una función que devuelva el total en euros de un pedido, pasale el codigo por parametro.
-- Controla en caso de que no se encuentre, en ese caso devuelve un 0.
-- Pasale otro parametro, si supera ese limite, lanzaremos una excepcion propia y devolveremos un 0.
CREATE OR REPLACE FUNCTION total_pedido_en_euros(p_codigo detallePedidos.CodigoPedido%TYPE, p_limite NUMBER)
RETURN NUMBER
AS
    limite_superado EXCEPTION;
    sin_datos EXCEPTION;
    v_total NUMBER(8) := 0;
    v_detalles detallePedidos%ROWTYPE;
    CURSOR c_detalles IS
    SELECT * FROM detallePedidos WHERE CodigoPedido = p_codigo;
BEGIN
    OPEN c_detalles;
        LOOP
            FETCH c_detalles INTO v_detalles;
            IF c_detalles%NOTFOUND THEN
                IF v_total = 0 THEN
                    RAISE sin_datos;
                END IF;
                EXIT;
            END IF;
            EXIT WHEN c_detalles%NOTFOUND;
            v_total := v_total + (v_detalles.cantidad * v_detalles.PrecioUnidad);
        END LOOP;
    CLOSE c_detalles;
    IF v_total > p_limite THEN
        RAISE limite_superado;
    ELSE
        RETURN v_total;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Datos no existente.');
        RETURN 0;
    WHEN sin_datos THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Datos no existente.');
        RETURN 0;
    WHEN limite_superado THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Límite superado.');
        RETURN 0;
END;
/

DECLARE
    v_codigo detallePedidos.CodigoPedido%TYPE := &codigo;
    v_total NUMBER(8) := 0;
BEGIN
    v_total := total_pedido_en_euros(v_codigo, 10000);
    IF v_total > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Total pedido: ' || v_total || '€');
    END IF;
END;
/

select * from clientes;
select * from pagos;
SELECT * FROM clientes WHERE CodigoCliente NOT IN (SELECT CodigoCliente FROM pagos);

-- 18. Crear un cursor para ver todos los clientes que no hayan hecho pagos. Hazlo con un loop.
DECLARE
    v_registro clientes%ROWTYPE;
    CURSOR c_clientes IS
    SELECT * FROM clientes WHERE CodigoCliente NOT IN (SELECT CodigoCliente FROM pagos);
BEGIN
    DBMS_OUTPUT.PUT_LINE('Clientes morosos:');
    OPEN c_clientes;
    LOOP
        FETCH c_clientes INTO v_registro;
        EXIT WHEN c_clientes%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('Cliente con código: ' || v_registro.CodigoCliente);
        DBMS_OUTPUT.PUT_LINE('Nombre cliente: ' || v_registro.NombreCliente);
        DBMS_OUTPUT.PUT_LINE('Nombre contacto: ' || v_registro.NombreContacto);
        DBMS_OUTPUT.PUT_LINE('Apellido contacto: ' || v_registro.ApellidoContacto);
        DBMS_OUTPUT.PUT_LINE('Telefono: ' || v_registro.Telefono);
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
    END LOOP;
    CLOSE c_clientes;
END;
/

-- 19. Crear un cursor para ver todos los clientes que no hayan hecho pagos. Hazlo con un for.
DECLARE
    CURSOR c_clientes IS
    SELECT * FROM clientes WHERE CodigoCliente NOT IN (SELECT CodigoCliente FROM pagos);
BEGIN
    DBMS_OUTPUT.PUT_LINE('Clientes morosos:');
    FOR registro IN c_clientes LOOP
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('Cliente con código: ' || registro.CodigoCliente);
        DBMS_OUTPUT.PUT_LINE('Nombre cliente: ' || registro.NombreCliente);
        DBMS_OUTPUT.PUT_LINE('Nombre contacto: ' || registro.NombreContacto);
        DBMS_OUTPUT.PUT_LINE('Apellido contacto: ' || registro.ApellidoContacto);
        DBMS_OUTPUT.PUT_LINE('Telefono: ' || registro.Telefono);
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
    END LOOP;
END;

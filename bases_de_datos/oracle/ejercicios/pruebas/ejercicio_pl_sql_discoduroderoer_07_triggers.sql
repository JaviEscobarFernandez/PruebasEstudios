-- Los triggers son codigo PL/SQL que se ejecutan cuando modificamos la BD
-- Por ejemplo, cuando insertamos/borramos/actualizamos registros en una tabla
-- Podemos indicar cuando queremos que se ejecute, si antes o despues de ejecutarse la accion
-- Y si todos los registros o alguno concreto.

-- Especificamos BEFORE o AFTER y luego si queremos insert o las que queramos
CREATE OR REPLACE TRIGGER estado_operacion_before
BEFORE INSERT OR UPDATE OR DELETE ON producto
-- Aqui iria las variables y demas como si fuese un declare
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Insertando productos...');
    ELSIF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('Actualizando productos...');
    -- aqui podria ser ELSE a secas al ser el ultimo que queda
    ELSIF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('Borrando productos...');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER estado_operacion_after
-- Especificamos BEFORE o AFTER y luego si queremos insert o las que queramos
AFTER INSERT OR UPDATE OR DELETE ON producto
-- Aqui iria las variables y demas como si fuese un declare
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Producto/s insertados');
    ELSIF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('Producto/s actualizados');
    ELSIF DELETING THEN -- aqui podria ser ELSE a secas al ser el ultimo que queda
        DBMS_OUTPUT.PUT_LINE('Producto/s borrados');
    END IF;
END;
/

-- Un uso comun de los triggers es la validación de los datos
-- por ejemplo, antes de insertar un registro podemos comprobar si algo esta o no bien
-- si queremos validar por ejemplo que el precio del producto sea valido o exista X codigo de fabricante

-- FOR EACH ROW es para tratar cada fila, es decir,
-- especificamos que salte en cada fila que se añada o se actualice
CREATE OR REPLACE TRIGGER validacion_producto
BEFORE INSERT OR UPDATE ON producto FOR EACH ROW
DECLARE
    v_num_fabricantes NUMBER(4);
BEGIN
    -- :NEW es para obtener el valor nuevo, :OLD seria para el valor antiguo
    -- :NEW o :OLD solo funciona cuando se utiliza FOR EACH ROW
    IF :NEW.precio < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El precio no puede ser negativo');
    END IF;

    -- Mucho cuidado con tocar la tabla mientras se esta con un FOR EACH ROW
    -- Ya que esta cambiando y podriamos causar errores
    SELECT COUNT(*) INTO v_num_fabricantes
    FROM fabricante WHERE codigo = :NEW.codigo_fabricante;

    IF v_num_fabricantes = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'No existe el fabricante');
    END IF;
END;
/

DELETE FROM producto WHERE codigo=12;
INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) VALUES
(12, 'Nuevo producto', 100, 1);


-- Trigger para un registro concreto
-- Se utiliza OF nombre_columna antes de ON nombre_tabla
CREATE OR REPLACE TRIGGER cambio_fabricante
BEFORE UPDATE OF codigo_fabricante ON producto FOR EACH ROW
BEGIN
    -- Tablas mutantes: ejemplo
    -- Esto seria un error, no podemos tocar la misma tabla que se realiza el FOR EACH ROW
    -- UPDATE producto SET precio = precio + 10 WHERE codigo = :OLD.codigo;
    -- Si queremos modificar datos de la misma tabla, podemos hacer:
    IF :NEW.codigo_fabricante != :OLD.codigo_fabricante THEN
        :NEW.precio := :OLD.precio + 10;
    END IF;
END;
/

UPDATE producto SET codigo_fabricante = 5 WHERE codigo = 1;

DELETE FROM producto WHERE codigo=12;

-- Ejercicios DDL
/* 1. Crear las tablas
Tabla de clientes:

Debe tener las siguientes columnas: idCliente (clave primaria), nombre, direccion.

Tabla de productos:

Debe tener las siguientes columnas: idProducto (clave primaria), nombre, precio.

Tabla de pedidos:

Debe tener las siguientes columnas: idPedido (clave primaria), idCliente (clave foránea que referencia a idCliente en la tabla de clientes), fechaPedido.

Tabla de detalles de pedidos:

Debe tener las siguientes columnas: idDetalle (clave primaria), idPedido (clave foránea que referencia a idPedido en la tabla de pedidos), idProducto (clave foránea que referencia a idProducto en la tabla de productos), cantidad.
*/
CREATE TABLE clientes (
    idCliente NUMBER(5) PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    direccion VARCHAR(60)
);

CREATE TABLE productos (
    idProducto NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(30),
    precio NUMBER(10) DEFAULT 0
);

CREATE TABLE pedidos (
    idPedido NUMBER(5) PRIMARY KEY,
    idCliente NUMBER(5),
    fechaPedido DATE,
    CONSTRAINT fk_pedidos_cliente FOREIGN KEY (idCliente) REFERENCES clientes(idCliente)
);

CREATE TABLE detalles_pedidos (
    IdDetalle NUMBER(5) PRIMARY KEY,
    idPedido NUMBER(5),
    idProducto NUMBER(5),
    cantidad NUMBER(5),
    CONSTRAINT fk_detalles_pedido FOREIGN KEY (idPedido) REFERENCES pedidos(idPedido),
    CONSTRAINT fk_detalles_producto FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

-- 2. Modificar las tablas
-- Añade una nueva columna a la tabla de productos para almacenar la categoría del producto.
ALTER TABLE productos ADD categoria NUMBER(5);

-- 3. Eliminar una columna
-- Elimina la columna direccion de la tabla de clientes.
ALTER TABLE clientes DROP COLUMN direccion;

-- 4. Crear índices
--Crea un índice en la columna nombre de la tabla de clientes para mejorar la velocidad de las consultas.
-- No lo hemos visto esto en el curso, asi que lo omito de momento

-- 5. Eliminar una tabla
-- Elimina la tabla de detalles de pedidos (asegúrate de eliminar primero las restricciones que dependen de ella).
ALTER TABLE detalles_pedidos DROP CONSTRAINT fk_detalles_pedido;
ALTER TABLE detalles_pedidos DROP CONSTRAINT fk_detalles_producto;
DROP TABLE detalles_pedidos;

Ejercicio de DML
-- 1. Insertar datos
-- Inserta datos en las tablas clientes, productos, pedidos y detalles_pedidos.
INSERT INTO clientes (idcliente, nombre, direccion) VALUES (1, 'Juan Perez', 'Direccion 1');
INSERT INTO clientes (idcliente, nombre, direccion) VALUES (2, 'Rafael Sanabria', 'Direccion 2');
INSERT INTO clientes (idcliente, nombre, direccion) VALUES (3, 'Maria Lopez', 'Direccion 3');
INSERT INTO clientes (idcliente, nombre, direccion) VALUES (4, 'Sara Leon', 'Direccion 4');
INSERT INTO clientes (idcliente, nombre, direccion) VALUES (5, 'Marta Silva', 'Direccion 5');

INSERT INTO productos (idProducto, nombre, precio) VALUES (1, 'Tomates', 2);
INSERT INTO productos (idProducto, nombre, precio) VALUES (2, 'Lechugas', 3);
INSERT INTO productos (idProducto, nombre, precio) VALUES (3, 'Zanahorias', 1);
INSERT INTO productos (idProducto, nombre, precio) VALUES (4, 'Ajos', 3);
INSERT INTO productos (idProducto, nombre, precio) VALUES (5, 'Cebollas', 4);

INSERT INTO pedidos (idPedido, idcliente, fechaPedido) VALUES (1, 2, TO_DATE('06/02/2024', 'dd/mm/yyyy'));
INSERT INTO pedidos (idPedido, idcliente, fechaPedido) VALUES (2, 2, TO_DATE('07/12/2024', 'dd/mm/yyyy'));
INSERT INTO pedidos (idPedido, idcliente, fechaPedido) VALUES (3, 1, TO_DATE('11/11/2024', 'dd/mm/yyyy'));
INSERT INTO pedidos (idPedido, idcliente, fechaPedido) VALUES (4, 4, TO_DATE('10/09/2024', 'dd/mm/yyyy'));
INSERT INTO pedidos (idPedido, idcliente, fechaPedido) VALUES (5, 3, TO_DATE('03/02/2024', 'dd/mm/yyyy'));


INSERT INTO detalles_pedidos (IdDetalle, idPedido, idProducto, cantidad) VALUES (1, 1, 1, 10);
INSERT INTO detalles_pedidos (IdDetalle, idPedido, idProducto, cantidad) VALUES (2, 2, 2, 3);
INSERT INTO detalles_pedidos (IdDetalle, idPedido, idProducto, cantidad) VALUES (3, 3, 1, 5);
INSERT INTO detalles_pedidos (IdDetalle, idPedido, idProducto, cantidad) VALUES (4, 4, 5, 10);
INSERT INTO detalles_pedidos (IdDetalle, idPedido, idProducto, cantidad) VALUES (5, 5, 4, 3);

-- 2. Actualizar datos
-- Actualiza el precio de un producto y la dirección de un cliente.
UPDATE producto SET precio = 4 WHERE idProducto=1;
UPDATE clientes SET direccion='Direccion6' WHERE idCliente=1;

-- 3. Eliminar datos
-- Elimina un cliente y todos sus pedidos.
-- El ON DELETE CASCADE no lo hemos visto, asi que lo hago manual.
DELETE FROM detalles_pedidos WHERE idPedido = (SELECT pedidos WHERE idCliente=1);
DELETE FROM pedidos WHERE idCliente=1);
DELETE FROM clientes WHERE idCliente = 1;

-- 4. Seleccionar datos
-- Realiza consultas para recuperar información específica de las tablas.


Detalles de los ejercicios
1. Insertar datos
Inserta al menos 3 registros en la tabla clientes.

Inserta al menos 3 registros en la tabla productos.

Inserta al menos 2 registros en la tabla pedidos.

Inserta al menos 3 registros en la tabla detalles_pedidos.

2. Actualizar datos
Actualiza el precio de un producto específico en la tabla productos.

Actualiza el nombre de un cliente en la tabla clientes.

3. Eliminar datos
Elimina un cliente de la tabla clientes y asegúrate de eliminar también todos los pedidos y detalles de pedidos relacionados (asegúrate de tener las restricciones adecuadas para la eliminación en cascada).

4. Seleccionar datos
Recupera todos los datos de la tabla clientes.

Recupera todos los productos cuyo precio sea mayor a un valor específico.

Recupera todos los pedidos realizados por un cliente específico.

Recupera el detalle de los pedidos (incluyendo el nombre del cliente y el producto) utilizando una consulta con JOIN.

¡

-- Eliminamos todo
ALTER TABLE pedidos DROP CONSTRAINT fk_pedidos_cliente;
DROP TABLE pedidos;
DROP TABLE productos;
DROP TABLE clientes;

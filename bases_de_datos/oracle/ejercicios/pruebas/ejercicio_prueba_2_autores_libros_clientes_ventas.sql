CREATE TABLE Autores (
    autor_id NUMBER(6) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    apellido VARCHAR2(60) NOT NULL,
    nacionalidad VARCHAR2(15) NOT NULL
);

CREATE TABLE Libros (
    libro_id NUMBER(6) PRIMARY KEY,
    titulo VARCHAR2(30) NOT NULL,
    genero VARCHAR2(10) NOT NULL,
    precio NUMBER(6, 2) DEFAULT 50 NOT NULL, -- Utilizamos el precio con dos decimales.
    autor_id NUMBER(6),
    CONSTRAINT fk_autor_id FOREIGN KEY (autor_id) REFERENCES Autores(autor_id),
    CONSTRAINT chk_precio CHECK (precio >= 50) -- Establecemos el limite minimo de precio a 50
);

CREATE TABLE Ventas (
    venta_id NUMBER(6) PRIMARY KEY,
    fecha_venta DATE,
    libro_id NUMBER(6),
    cantidad NUMBER(4) DEFAULT 0 NOT NULL,
    CONSTRAINT fk_libro_id FOREIGN KEY (libro_id) REFERENCES Libros(libro_id)
);

CREATE TABLE Clientes (
    cliente_id NUMBER(6) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    apellido VARCHAR2(60) NOT NULL,
    email VARCHAR2(50)
);

CREATE TABLE Ventas_Clientes (
    venta_id NUMBER(6),
    cliente_id NUMBER(6),
    CONSTRAINT primary_keys PRIMARY KEY (venta_id, cliente_id),
    CONSTRAINT fk_venta_id FOREIGN KEY (venta_id) REFERENCES Ventas(venta_id),
    CONSTRAINT fk_cliente_id FOREIGN KEY (cliente_id) REFERENCES Clientes(cliente_id)
);

-- Modificaciones
-- Añadir una nueva columna: Supongamos que la tabla Cursos necesita una columna para almacenar la cantidad de créditos del curso.
ALTER TABLE Cursos ADD (creditos NUMBER(6) DEFAULT 0 NOT NULL);
-- Añadir una clave única: Añadir una restricción de clave única a la columna email en la tabla Profesores.
ALTER TABLE Profesores MODIFY email VARCHAR2(50) NOT NULL UNIQUE;

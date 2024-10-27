CREATE TABLE departamento (
    idDepartamento NUMBER(4) PRIMARY KEY,
    nombre NUMBER(10) NOT NULL,
    ubicacion NUMBER(5)
);

CREATE TABLE empleados (
    idEmpleado NUMBER(4) PRIMARY KEY,
    nombre VARCHAR2(30) NOT NULL,
    apellido VARCHAR2(60),
    fechaNacimiento DATE,
    idDepartamento NUMBER(4),
    FOREIGN KEY (idDepartamento) REFERENCES departamento(idDepartamento)
);

-- Modificaciones:
-- 1. Agregar una nueva columna
ALTER TABLE departamento ADD descripcion VARCHAR2(100);
-- 2. Modificar una columna existente
ALTER TABLE departamento MODIFY ubicacion VARCHAR2(30) NOT NULL;
-- 3. Eliminar una columna
ALTER TABLE departamento DROP COLUMN descripcion;
-- 4. Agregar una restricción
ALTER TABLE departamento ADD CONSTRAINT departamento_check CHECK (idDepartamento < 500);

-- Eliminaciones:
-- 1. Eliminar la tabla empleados
DROP TABLE empleados;
-- 2. Eliminar la tabla departamentos
DROP TABLE departamento;

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
ALTER TABLE departamento MODIFY nombre VARCHAR2(30);
-- 3. Eliminar una columna
ALTER TABLE departamento DROP COLUMN descripcion;
-- 4. Agregar una restricción
ALTER TABLE departamento ADD CONSTRAINT departamento_check CHECK (idDepartamento < 500);

-- Ejercicios Inserciones:
-- 1. Inserta un registro en la tabla Departamentos para el departamento de Recursos Humanos. Este departamento tiene el idDepartamento 101 y se encuentra en el Edificio A
INSERT INTO departamento (idDepartamento, nombre, ubicacion) VALUES (101, 'Recursos Humanos', 'Edificio A');

-- 2. Agrega un nuevo registro en la tabla Departamentos para el departamento de Finanzas. Este departamento tiene el idDepartamento 102 y está ubicado en el Edificio B.
INSERT INTO departamento (idDepartamento, nombre, ubicacion) VALUES (102, 'Finanzas', 'Edificio B');

-- 3. Registra el departamento de Tecnología en la tabla Departamentos. El idDepartamento de este departamento es 103, y se localiza en el Edificio C.
INSERT INTO departamento (idDepartamento, nombre, ubicacion) VALUES (103, 'Tecnología', 'Edificio C');

-- 1. Inserta un registro en la tabla Empleados para un empleado llamado Carlos Ramírez. Este empleado tiene el idEmpleado 1001, nació el 15 de junio de 1985 y pertenece al departamento con idDepartamento 101 (Recursos Humanos).
INSERT INTO empleados (idEmpleado, nombre, apellido, fechaNacimiento, idDepartamento) VALUES (1001, 'Carlos', 'Ramirez', '15-06-1985', 101);

-- 2. Agrega un nuevo registro en la tabla Empleados para una empleada llamada Laura Martínez. Este empleado tiene el idEmpleado 1002, nació el 22 de marzo de 1990 y está en el departamento con idDepartamento 102 (Finanzas).
INSERT INTO empleados (idEmpleado, nombre, apellido, fechaNacimiento, idDepartamento) VALUES (1002, 'Laura', 'Martínez', '22-03-1990', 102);

-- 3. Registra a un empleado llamado José García en la tabla Empleados. Este empleado tiene el idEmpleado 1003, nació el 8 de noviembre de 1982 y pertenece al departamento con idDepartamento 103 (Tecnología).
INSERT INTO empleados (idEmpleado, nombre, apellido, fechaNacimiento, idDepartamento) VALUES (1003, 'José', 'García', '08-11-1982', 103);

-- Eliminaciones:
-- 1. Eliminar la tabla empleados
DROP TABLE empleados;
-- 2. Eliminar la tabla departamentos
DROP TABLE departamento;

DROP TABLE empleados;
DROP TABLE departamento;



CREATE TABLE Departamentos (
    Departamento_ID NUMBER PRIMARY KEY,
    Nombre VARCHAR2(50) NOT NULL,
    Ubicacion VARCHAR2(50)
);


CREATE TABLE Empleados (
    Empleado_ID NUMBER PRIMARY KEY,
    Nombre VARCHAR2(50) NOT NULL,
    Apellido VARCHAR2(50),
    Salario NUMBER(10, 2),
    Departamento_ID NUMBER,
    CONSTRAINT fk_departamento
        FOREIGN KEY (Departamento_ID) REFERENCES Departamentos(Departamento_ID)
);




-- Insertar datos en la tabla Departamentos
INSERT INTO Departamentos (Departamento_ID, Nombre, Ubicacion) 
VALUES (1, 'Recursos Humanos', 'Edificio A');
INSERT INTO Departamentos (Departamento_ID, Nombre, Ubicacion) 
VALUES (2, 'IT', 'Edificio B');
INSERT INTO Departamentos (Departamento_ID, Nombre, Ubicacion) 
VALUES (3, 'Finanzas', 'Edificio C');

-- Insertar datos en la tabla Empleados
INSERT INTO Empleados (Empleado_ID, Nombre, Apellido, Salario, Departamento_ID) 
VALUES (101, 'Juan', 'Pérez', 3000, 1);
INSERT INTO Empleados (Empleado_ID, Nombre, Apellido, Salario, Departamento_ID) 
VALUES (102, 'Ana', 'López', 4000, 2);
INSERT INTO Empleados (Empleado_ID, Nombre, Apellido, Salario, Departamento_ID) 
VALUES (103, 'Carlos', 'García', 5000, 3);
INSERT INTO Empleados (Empleado_ID, Nombre, Apellido, Salario, Departamento_ID) 
VALUES (104, 'Lucía', 'Martínez', 4500, 2);


-- Consulta todos los empleados con todos sus campos.
SELECT * FROM Empleados;

-- Consulta los nombres y apellidos de todos los empleados.
SELECT Nombre, Apellido FROM Empleados;

-- Obtén el nombre y la ubicación de todos los departamentos.
SELECT Nombre, Ubicacion FROM Departamentos;ç




-- Consulta los nombres de los empleados que tienen un salario superior a 4000.
SELECT Nombre, Apellido FROM Empleados WHERE Salario > 4000;

-- Consulta el nombre, apellido y salario de los empleados que tienen un salario entre 3000 y 5000.
SELECT Nombre, Apellido, Salario FROM Empleados WHERE Salario BETWEEN 3000 AND 5000;

-- Consulta el nombre y apellido de los empleados cuyo nombre empieza con la letra "L".
SELECT Nombre, Apellido FROM Empleados WHERE Nombre LIKE 'L%';

-- Obtén el nombre y salario de los empleados, ordenados por salario de mayor a menor.
SELECT Nombre, Salario FROM Empleados ORDER BY Salario DESC;

-- Consulta los nombres de los empleados que tienen un salario superior al promedio de todos los salarios.
SELECT Nombre, Salario FROM Empleados WHERE Salario > (SELECT AVG(Salario) FROM Empleados);

-- Consulta el salario promedio por cada departamento, solo para aquellos departamentos donde el salario promedio sea mayor a 4000.
SELECT Departamento_ID, AVG(Salario) AS Salario_Promedio
FROM Empleados
GROUP BY Departamento_ID
HAVING AVG(Salario) > 4000;



-- Consulta el nombre y apellido de los empleados que tienen un salario superior al salario promedio de todos los empleados.
SELECT Nombre, Apellido, Salario
FROM Empleados
WHERE Salario > (SELECT AVG(Salario) FROM Empleados);

-- Obtén los nombres de los empleados que trabajan en el mismo departamento que el empleado con Empleado_ID = 102.
SELECT Nombre, Apellido
FROM Empleados
WHERE Departamento_ID = (SELECT Departamento_ID FROM Empleados WHERE Empleado_ID = 102);



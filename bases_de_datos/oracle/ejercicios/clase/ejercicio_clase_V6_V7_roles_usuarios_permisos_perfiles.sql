-- 1.	Permitir la Creación de Usuarios:
ALTER SESSION SET "_ORACLE_SCRIPT" = true;

-- 2.	Crear un tablespace:
CREATE TABLESPACE tablespace_test DATAFILE 'tablespace_test.dbf' SIZE 100M;

-- 3.	Crear un usuario: (le asignamos por defecto el tablespace_test creado)
CREATE USER usuario_test IDENTIFIED BY usuario1234 DEFAULT TABLESPACE tablespace_test;

-- 4.	Modificar usuario: (modificamos su pass)
ALTER USER usuario_test IDENTIFIED BY u1234;

-- 5.	Conceder Privilegios al Usuario nuevo: (le damos permisos de iniciar sesion y crear tablas)
GRANT CREATE SESSION, CREATE TABLE TO usuario_test;

-- 6.	Crear un Rol y Conceder Privilegios al Rol (establecemos privilegios de SELECT, UPDATE e INSERT en las tablas autores y libros)
CREATE ROLE rol_test;
GRANT SELECT, UPDATE, INSERT ON autores TO rol_test;
GRANT SELECT, UPDATE, INSERT ON libros TO rol_test;

-- 7.	Quitar privilegios de inserción a las tablas al ROL
REVOKE INSERT ON autores FROM rol_test;
REVOKE INSERT ON libros FROM rol_test;

-- 8.	Crear PERFIL establece límites en recursos y tiempo de sesión
CREATE PROFILE perfil_test LIMIT
    CPU_PER_SESSION 2000
    CPU_PER_CALL 2000
    CONNECT_TIME 60
    IDLE_TIME 30;

-- 9.	Modificamos el PERFIL con otros límites
ALTER PROFILE perfil_test LIMIT CONNECT_TIME 120;

-- 10.	Asignar el ROL y el PERFIL creados al usuario
ALTER USER usuario_test PROFILE perfil_test;
GRANT rol_test TO usuario_test;

-- Eliminamos lo que vamos a crear
DROP TABLESPACE tablespace_test including contents and datafiles;
DROP USER C##usuario_test CASCADE;
DROP ROLE C##rol_test;
DROP PROFILE C##perfil_test;


-- Paso 1: Crear un Tablespace
CREATE TABLESPACE tablespace_test
  DATAFILE 'tablespace_test.dbf' SIZE 100M;


---comprobar la existencia de tablespace
SELECT tablespace_name
FROM dba_tablespaces
WHERE tablespace_name = 'TABLESPACE_TEST';

-- Paso 2: Crear un Usuario
CREATE USER C##usuario_test IDENTIFIED BY usuario1234;
  

-- si queremos asignarlo al tablespace concreto  con DEFAULT TABLESPACE tablespace_test;

-- Paso 3: Modificar un Usuario
ALTER USER  C##usuario_test IDENTIFIED BY u1234;

-- Paso 4: Conceder Privilegios al Usuario nuevo  
-- El privilegio CREATE SESSION permite al usuario usuario_test conectarse a la base de datos.
--  El privilegio CREATE TABLE permite al usuario crear nuevas tablas en el tablespace predeterminado asignado a su cuenta.
GRANT CREATE SESSION, CREATE TABLE TO C##usuario_test;

-- Paso 5: Crear un Rol y Conceder Privilegios al Rol
CREATE ROLE C##rol_test;

--COMPROBAR EN QUE ESQUEMA ESTÁ LA TABLA PARA DARLE PERMISOS
SELECT owner, table_name
FROM all_tables
WHERE table_name = 'EMPLEADOS';


-- GRANT SELECT, INSERT, UPDATE ON onliner.* TO rol_test; -- OJO PAGINA 50 el *.* no funciona
-- Para otorgar permisos a todas las tablas en Oracle como lo har as en MySQL. Debes enumerar cada tabla individualmente en las sentencias GRANT.

GRANT UPDATE ON system.empleados TO C##rol_test;

-- comprobar los permisos de un rol
SELECT *
FROM dba_tab_privs
WHERE grantee = 'C##ROL_TEST'
AND table_name = 'EMPLEADOS';


-- Paso 6: Quitar privilegios al Rol
REVOKE SELECT, UPDATE ON system.empleados FROM C##rol_test;

-- Paso 7: Crear un Perfil y establece limites en varios aspectos de sesión para los usuarios que se asignen a este perfil. 

CREATE PROFILE C##perfil_test LIMIT
  SESSIONS_PER_USER 5
  CONNECT_TIME 30
  FAILED_LOGIN_ATTEMPTS 3;

-- Paso 8: Modficar el perfil
ALTER PROFILE C##perfil_test LIMIT
  IDLE_TIME 5
  FAILED_LOGIN_ATTEMPTS 5;
  
-- Paso 9: Asignar el rol y el perfil creados al usuario
ALTER USER C##usuario_test PROFILE C##perfil_test;
GRANT C##rol_test TO C##usuario_test;


-- Paso 10: Probar los privilegios y limites del usuario
-- Ver datos del usuario
SELECT * FROM DBA_USERS WHERE username = 'USUARIO_TEST';

CONN C##usuario_test/1234@localhost:1521/free ; -- Probar 4 veces
-- Para desbloquear el usuario
ALTER USER C##usuario_test ACCOUNT UNLOCK; 

-- Ejecutar este trozo de codigo todo junto para que sea con el usuario
CONN C##usuario_test/u1234@localhost:1521/free ; 
SELECT * FROM system.empleados; --Si debe poder consultar
UPDATE system.empleados set nombre='pedro' WHERE  idempleado='1'; -- No debe permitir 


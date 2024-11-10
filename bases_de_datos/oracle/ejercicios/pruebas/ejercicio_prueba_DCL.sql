-- activar creacion usuarios
ALTER SESSION SET "_ORACLE_SCRIPT"=true;

-- crear nuevo usuario
CREATE USER pepito10 IDENTIFIED BY "pepito";

-- crear nuevo tablespace tamaño 100Mb
CREATE TABLESPACE tablespace_pepito10 DATAFILE 'tablespace_pepito10.dbf' SIZE 100M;

-- crear nuevo rol
CREATE ROLE rol_alumno;

-- asignar permisos a dicho rol en la tabla alumnos
GRANT SELECT, UPDATE, INSERT, DELETE, ALTER ON javi_test.alumnos TO rol_alumno;

-- asignar permisos de acceso al usuario
GRANT CREATE SESSION TO pepito10;

-- eliminar permisos de alter en la tabla alumnos al rol
REVOKE ALTER ON javi_test.alumnos FROM rol_alumno;

-- asignar el rol al usuario
GRANT rol_alumno TO pepito10;

-- asignar el tablespace al usuario
ALTER USER pepito10 DEFAULT TABLESPACE tablespace_pepito10;

-- crear un nuevo perfil para el usuario y establecer tiempo de conexion de 1 hora
CREATE PROFILE perfil_pepito10 LIMIT CONNECT_TIME 60;

-- asignar el perfil al usuario
ALTER USER pepito10 PROFILE perfil_pepito10;

-- establecer limite del tablespace al usuario en 15Mb
ALTER USER pepito10 QUOTA 15M ON tablespace_pepito10;

-- establecer a ilimitado el limite del tablespace al usuario
ALTER USER pepito10 QUOTA UNLIMITED ON tablespace_pepito10;

-- Probar conexion del usuario:
CONN pepito10/pepito@localhost:1521;

-- establecer limite de 3 intentos fallidos
ALTER PROFILE perfil_pepito10 LIMIT FAILED_LOGIN_ATTEMPTS 3;

-- probar conexion erronea del usuario 4 veces para ver error cuenta bloqueada
CONN pepito10/pepito2@localhost:1521;

-- desbloquear cuenta y volver a probar conexion
ALTER USER pepito10 ACCOUNT UNLOCK;
CONN pepito10/pepito@localhost:1521;

-- cambiar contraseña usuario
ALTER USER pepito10 IDENTIFIED BY "pepitonueva";

-- eliminar usuario (cascade para eliminar lo que haya hecho el usuario)
DROP USER pepito10 CASCADE;

-- eliminar rol asignado al usuario
DROP ROLE rol_alumno;

-- eliminar tablespace (INCLUDING CONTENTS AND DATAFILES para eliminar el archivo tablespace generado)
DROP TABLESPACE tablespace_pepito10 INCLUDING CONTENTS AND DATAFILES;

-- eliminar perfil del usuario
DROP PROFILE perfil_pepito10;

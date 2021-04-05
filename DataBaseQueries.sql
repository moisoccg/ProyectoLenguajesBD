--------------------------------------------------------
--  File created - Wednesday-March-31-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence CPROVEEDOR
--------------------------------------------------------

   CREATE SEQUENCE  "USQL"."CPROVEEDOR"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence CROL
--------------------------------------------------------

   CREATE SEQUENCE  "USQL"."CROL"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence CUSUARIO
--------------------------------------------------------

   CREATE SEQUENCE  "USQL"."CUSUARIO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
   
--------------------------------------------------------
--  DDL for Sequence CTIPOPRODUCTO
--------------------------------------------------------

   CREATE SEQUENCE  "USQL"."CTIPOPRODUCTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
   
--------------------------------------------------------
--  DDL for Sequence CPRODUCTO
--------------------------------------------------------

   CREATE SEQUENCE  "USQL"."CPRODUCTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table CANTON
--------------------------------------------------------

  CREATE TABLE "USQL"."CANTON" 
   (	"IDCANTON" NUMBER(*,0), 
	"DESCRIPCIONCANTON" VARCHAR2(20 BYTE), 
	"IDPROVINCIA" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CORREO
--------------------------------------------------------

  CREATE TABLE "USQL"."CORREO" 
   (	"IDCORREO" NUMBER(*,0), 
	"CORREOELECTRONICO" VARCHAR2(30 BYTE), 
	"IDUSUARIO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DIRECCION
--------------------------------------------------------

  CREATE TABLE "USQL"."DIRECCION" 
   (	"IDDIRECCION" NUMBER(*,0), 
	"CALLE" VARCHAR2(50 BYTE), 
	"IDSUCURSAL" NUMBER(*,0), 
	"IDDISTRITO" NUMBER(*,0), 
	"IDCANTON" NUMBER(*,0), 
	"IDPROVINCIA" NUMBER(*,0), 
	"IDUSUARIO" NUMBER(*,0), 
	"IDTIPODIRECCION" CHAR(18 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DISTRITO
--------------------------------------------------------

  CREATE TABLE "USQL"."DISTRITO" 
   (	"IDDISTRITO" NUMBER(*,0), 
	"DESCRIPCIONDISTRITO" VARCHAR2(20 BYTE), 
	"IDCANTON" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table METODOPAGO
--------------------------------------------------------

  CREATE TABLE "USQL"."METODOPAGO" 
   (	"IDMETODO" NUMBER(*,0), 
	"TIPOMETODOPAGO" VARCHAR2(20 BYTE), 
	"IDORDEN" NUMBER(*,0), 
	"IDUSUARIO" NUMBER(*,0), 
	"IDSUCURSAL" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ORDEN
--------------------------------------------------------

  CREATE TABLE "USQL"."ORDEN" 
   (	"IDORDEN" NUMBER(*,0), 
	"FECHAORDEN" DATE, 
	"IDUSUARIO" NUMBER(*,0), 
	"IDSUCURSAL" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ORDENPRODUCTO
--------------------------------------------------------

  CREATE TABLE "USQL"."ORDENPRODUCTO" 
   (	"IDSUCURSAL" NUMBER(*,0), 
	"IDORDEN" NUMBER(*,0), 
	"IDUSUARIO" NUMBER(*,0), 
	"IDPRODUCTO" NUMBER(*,0), 
	"IDTIPOPRODUCTO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "USQL"."PRODUCTO" 
   (	"IDPRODUCTO" NUMBER(*,0), 
	"DESCRIPCIONPRODUCTO" VARCHAR2(30 BYTE), 
	"PRECIOPRODUCTO" NUMBER(*,0), 
	"FECHAELABORADO" DATE, 
	"FECHAVENCIMIENTO" DATE, 
	"IDTIPOPRODUCTO" NUMBER(*,0), 
	"NUMEROSERIE" NUMBER(*,0), 
	"CANTIDADSTOCK" NUMBER(*,0), 
	"CANTIDADMINIMA" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRODUCTOPROVEEDOR
--------------------------------------------------------

  CREATE TABLE "USQL"."PRODUCTOPROVEEDOR" 
   (	"IDPRODUCTO" NUMBER(*,0), 
	"IDPROVEEDOR" NUMBER(*,0), 
	"IDTIPOPRODUCTO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROVEEDOR
--------------------------------------------------------

  CREATE TABLE "USQL"."PROVEEDOR" 
   (	"IDPROVEEDOR" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(40 BYTE), 
	"CEDULAJURIDICA" VARCHAR2(20 BYTE), 
	"TELEFONOPROVEEDOR" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROVINCIA
--------------------------------------------------------

  CREATE TABLE "USQL"."PROVINCIA" 
   (	"IDPROVINCIA" NUMBER(*,0), 
	"DESCRIPCIONPROVINCIA" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ROLES
--------------------------------------------------------

  CREATE TABLE "USQL"."ROLES" 
   (	"IDROL" NUMBER(*,0), 
	"NOMBREROL" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SUCURSAL
--------------------------------------------------------

  CREATE TABLE "USQL"."SUCURSAL" 
   (	"IDSUCURSAL" NUMBER(*,0), 
	"NOMBRESUCURSAL" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SUCURSALPRODUCTO
--------------------------------------------------------

  CREATE TABLE "USQL"."SUCURSALPRODUCTO" 
   (	"IDPRODUCTO" NUMBER(*,0), 
	"IDTIPOPRODUCTO" NUMBER(*,0), 
	"IDSUCURSAL" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TELEFONO
--------------------------------------------------------

  CREATE TABLE "USQL"."TELEFONO" 
   (	"IDTELEFONO" NUMBER(*,0), 
	"TELEFONO" VARCHAR2(10 BYTE), 
	"IDUSUARIO" NUMBER(*,0), 
	"IDTIPOTELEFONO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPODIRECCION
--------------------------------------------------------

  CREATE TABLE "USQL"."TIPODIRECCION" 
   (	"IDTIPODIRECCION" CHAR(18 BYTE), 
	"TIPODIRECCION" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPOPRODUCTO
--------------------------------------------------------

  CREATE TABLE "USQL"."TIPOPRODUCTO" 
   (	"IDTIPOPRODUCTO" NUMBER(*,0), 
	"NOMBRETIPOPRODUCTO" VARCHAR2(20 BYTE), 
	"DESCRIPCIONTIPOPRODUCTO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPOTELEFONO
--------------------------------------------------------

  CREATE TABLE "USQL"."TIPOTELEFONO" 
   (	"IDTIPOTELEFONO" NUMBER(*,0), 
	"TIPOTELEFONO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "USQL"."USUARIO" 
   (	"IDUSUARIO" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(30 BYTE), 
	"APELLIDOS" VARCHAR2(40 BYTE), 
	"CONTRASEÑA" VARCHAR2(20 BYTE), 
	"CEDULA" VARCHAR2(20 BYTE), 
	"IDROL" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into USQL.CANTON
SET DEFINE OFF;
REM INSERTING into USQL.CORREO
SET DEFINE OFF;
REM INSERTING into USQL.DIRECCION
SET DEFINE OFF;
REM INSERTING into USQL.DISTRITO
SET DEFINE OFF;
REM INSERTING into USQL.METODOPAGO
SET DEFINE OFF;
REM INSERTING into USQL.ORDEN
SET DEFINE OFF;
REM INSERTING into USQL.ORDENPRODUCTO
SET DEFINE OFF;
REM INSERTING into USQL.PRODUCTO
SET DEFINE OFF;
REM INSERTING into USQL.PRODUCTOPROVEEDOR
SET DEFINE OFF;
REM INSERTING into USQL.PROVEEDOR
SET DEFINE OFF;
Insert into USQL.PROVEEDOR (IDPROVEEDOR,NOMBRE,CEDULAJURIDICA,TELEFONOPROVEEDOR) values (2,'Dos Pinos','301230456','2298-5050');
REM INSERTING into USQL.PROVINCIA
SET DEFINE OFF;
REM INSERTING into USQL.ROLES
SET DEFINE OFF;
Insert into USQL.ROLES (IDROL,NOMBREROL) values (1,'Administrador');
Insert into USQL.ROLES (IDROL,NOMBREROL) values (2,'Vendedor');
REM INSERTING into USQL.SUCURSAL
SET DEFINE OFF;
REM INSERTING into USQL.SUCURSALPRODUCTO
SET DEFINE OFF;
REM INSERTING into USQL.TELEFONO
SET DEFINE OFF;
REM INSERTING into USQL.TIPODIRECCION
SET DEFINE OFF;
REM INSERTING into USQL.TIPOPRODUCTO
SET DEFINE OFF;
REM INSERTING into USQL.TIPOTELEFONO
SET DEFINE OFF;
REM INSERTING into USQL.USUARIO
SET DEFINE OFF;
Insert into USQL.USUARIO (IDUSUARIO,NOMBRE,APELLIDOS,"CONTRASEÑA",CEDULA,IDROL) values (4,'Raquel','ARAYA','ABC','1',1);
Insert into USQL.USUARIO (IDUSUARIO,NOMBRE,APELLIDOS,"CONTRASEÑA",CEDULA,IDROL) values (43,'Guissell','Miranda','SOS','1011101111',1);
--------------------------------------------------------
--  DDL for Index XPKCANTON
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKCANTON" ON "USQL"."CANTON" ("IDCANTON") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKCORREO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKCORREO" ON "USQL"."CORREO" ("IDCORREO", "IDUSUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKDIRECCION
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKDIRECCION" ON "USQL"."DIRECCION" ("IDDIRECCION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKDISTRITO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKDISTRITO" ON "USQL"."DISTRITO" ("IDDISTRITO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKMETODOPAGO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKMETODOPAGO" ON "USQL"."METODOPAGO" ("IDMETODO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKORDEN
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKORDEN" ON "USQL"."ORDEN" ("IDORDEN", "IDUSUARIO", "IDSUCURSAL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKORDENPRODUCTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKORDENPRODUCTO" ON "USQL"."ORDENPRODUCTO" ("IDORDEN", "IDUSUARIO", "IDSUCURSAL", "IDPRODUCTO", "IDTIPOPRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKPRODUCTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKPRODUCTO" ON "USQL"."PRODUCTO" ("IDPRODUCTO", "IDTIPOPRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKPRODUCTOPROVEEDOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKPRODUCTOPROVEEDOR" ON "USQL"."PRODUCTOPROVEEDOR" ("IDPRODUCTO", "IDPROVEEDOR", "IDTIPOPRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKPROVEEDOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKPROVEEDOR" ON "USQL"."PROVEEDOR" ("IDPROVEEDOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKPROVINCIA
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKPROVINCIA" ON "USQL"."PROVINCIA" ("IDPROVINCIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKROLES
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKROLES" ON "USQL"."ROLES" ("IDROL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKSUCURSAL
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKSUCURSAL" ON "USQL"."SUCURSAL" ("IDSUCURSAL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKSUCURSALPRODUCTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKSUCURSALPRODUCTO" ON "USQL"."SUCURSALPRODUCTO" ("IDPRODUCTO", "IDTIPOPRODUCTO", "IDSUCURSAL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKTELEFONO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKTELEFONO" ON "USQL"."TELEFONO" ("IDTELEFONO", "IDUSUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKTIPODIRECCION
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKTIPODIRECCION" ON "USQL"."TIPODIRECCION" ("IDTIPODIRECCION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKTIPOPRODUCTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKTIPOPRODUCTO" ON "USQL"."TIPOPRODUCTO" ("IDTIPOPRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKTIPOTELEFONO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKTIPOTELEFONO" ON "USQL"."TIPOTELEFONO" ("IDTIPOTELEFONO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index XPKUSUARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "USQL"."XPKUSUARIO" ON "USQL"."USUARIO" ("IDUSUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger TRIG_PROVEEDOR
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "USQL"."TRIG_PROVEEDOR" 
BEFORE INSERT ON PROVEEDOR
FOR EACH ROW
BEGIN
SELECT cProveedor.NEXTVAL INTO :NEW.idproveedor FROM DUAL;
END;
/
ALTER TRIGGER "USQL"."TRIG_PROVEEDOR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIG_ROL
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "USQL"."TRIG_ROL" 
BEFORE INSERT ON ROLES
FOR EACH ROW
BEGIN
SELECT cRol.NEXTVAL INTO :NEW.idrol FROM DUAL;
END;
/
ALTER TRIGGER "USQL"."TRIG_ROL" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIG_USUARIO
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "USQL"."TRIG_USUARIO" 
BEFORE INSERT ON Usuario
FOR EACH ROW
BEGIN
SELECT cUsuario.NEXTVAL INTO :NEW.idusuario FROM DUAL;
END;
/
ALTER TRIGGER "USQL"."TRIG_USUARIO" ENABLE;
--------------------------------------------------------
--  DDL for Procedure PR_ACTPROVEEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_ACTPROVEEDOR" (
p_id in proveedor.idproveedor%TYPE,
p_nombre in proveedor.nombre%TYPE,
p_cedula in proveedor.cedulajuridica%type,
p_telefono in proveedor.telefonoproveedor%TYPE) is

begin

UPDATE Proveedor SET NOMBRE = p_nombre, CEDULAJURIDICA= p_cedula, telefonoproveedor= p_telefono WHERE IDPROVEEDOR = p_id;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure PR_ACTUSUARIO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_ACTUSUARIO" (
p_id in usuario.idusuario%TYPE,
p_contraseña in usuario.contraseña%TYPE,
p_idrol in usuario.idrol%TYPE) is

begin

UPDATE USUARIO SET CONTRASEÑA = p_contraseña, IDROL= p_idrol WHERE IDUSUARIO=p_id;
commit;
end;

/

--------------------------------------------------------
--  DDL for Procedure PR_ACTTIPOPRODUCTO
--------------------------------------------------------
CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_ACTTIPOPRODUCTO" (
p_nombretipo in tipoproducto.nombretipoproducto%TYPE,
p_descripcion in tipoproducto.descripciontipoproducto%TYPE,
p_id in tipoproducto.idtipoproducto%TYPE) is

begin

UPDATE TipoProducto
SET NOMBRETIPOPRODUCTO = p_nombretipo, descripciontipoproducto=p_descripcion
WHERE IDTIPOPRODUCTO=p_id;

commit;
end;

--------------------------------------------------------
--  DDL for Procedure PR_ACTTIPOPRODUCTO
--------------------------------------------------------
CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_ACTPRODUCTO" (
p_idprod in producto.idproducto%TYPE,
p_descproducto in producto.descripcionproducto%TYPE,
p_precio in producto.precioproducto%TYPE,
p_fechaelab in producto.fechaelaborado%TYPE,
p_fechavenc in producto.fechavencimiento%TYPE,
p_idtipoproducto in tipoproducto.idtipoproducto%TYPE,
p_numeroserie in producto.numeroserie%TYPE,
p_cantstock in producto.cantidadstock%TYPE,
p_cantmin in producto.cantidadminima%TYPE) is

begin

UPDATE producto
SET
descripcionproducto = p_descproducto, precioproducto = p_precio, fechaelaborado = p_fechaelab,
fechavencimiento = p_fechavenc, idtipoproducto = p_idtipoproducto, numeroserie = p_numeroserie, cantidadstock = p_cantstock,
cantidadminima = p_cantmin
WHERE 
idproducto=p_idprod;
        
commit;
end;

--------------------------------------------------------
--  DDL for Procedure PR_AGREGARPROVEEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_AGREGARPROVEEDOR" (
p_nombre in proveedor.nombre%TYPE,
p_cedula in proveedor.cedulajuridica%TYPE,
p_telefono in proveedor.telefonoproveedor%TYPE) is

begin

INSERT INTO Proveedor("NOMBRE", "CEDULAJURIDICA", "TELEFONOPROVEEDOR")
VALUES (p_nombre, p_cedula, p_telefono);

commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure PR_AGREGARUSUARIO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_AGREGARUSUARIO" (
p_nombre in usuario.nombre%TYPE,
p_apellidos in usuario.apellidos%TYPE,
p_contraseña in usuario.contraseña%TYPE,
p_cedula in usuario.cedula%TYPE,
p_idrol in usuario.idrol%TYPE) is

begin

INSERT INTO USUARIO("NOMBRE", "APELLIDOS", "CONTRASEÑA", "CEDULA", "IDROL")
VALUES (p_nombre, p_apellidos, p_contraseña, p_cedula, p_idrol);

commit;
end;

/

--------------------------------------------------------
--  DDL for Procedure PR_AGREGARTIPOPRODUCTO
--------------------------------------------------------
CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_AGREGARTIPOPRODUCTO" (
p_nombretipo in tipoproducto.nombretipoproducto%TYPE,
p_descripcion in tipoproducto.descripciontipoproducto%TYPE) is

begin

INSERT INTO TipoProducto(NOMBRETIPOPRODUCTO, DESCRIPCIONTIPOPRODUCTO)
VALUES (p_nombretipo, p_descripcion);

commit;
end;

--------------------------------------------------------
--  DDL for Procedure PR_AGREGARPRODUCTO
--------------------------------------------------------
CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_AGREGARPRODUCTO" (
p_descproducto in producto.descripcionproducto%TYPE,
p_precio in producto.precioproducto%TYPE,
p_fechaelab in producto.fechaelaborado%TYPE,
p_fechavenc in producto.fechavencimiento%TYPE,
p_idtipoproducto in tipoproducto.idtipoproducto%TYPE,
p_numeroserie in producto.numeroserie%TYPE,
p_cantstock in producto.cantidadstock%TYPE,
p_cantmin in producto.cantidadminima%TYPE) is

begin

INSERT INTO producto (
    idproducto,
    descripcionproducto,
    precioproducto,
    fechaelaborado,
    fechavencimiento,
    idtipoproducto,
    numeroserie,
    cantidadstock,
    cantidadminima
) VALUES (
    CTIPOPRODUCTO.NEXTVAL,
    p_descproducto,
    p_precio,
    p_fechaelab,
    p_fechavenc,
    p_idtipoproducto,
    p_numeroserie,
    p_cantstock,
    p_cantmin
);

commit;
end;

--------------------------------------------------------
--  DDL for Procedure PR_ELIMINARPROVEEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_ELIMINARPROVEEDOR" (
p_id in proveedor.idproveedor%TYPE) is

begin

DELETE FROM Proveedor WHERE idproveedor=p_id;

commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure PR_ELIMINARUSUARIO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "USQL"."PR_ELIMINARUSUARIO" (
p_id in usuario.idusuario%TYPE) is

begin

DELETE FROM USUARIO WHERE idusuario=p_id;

commit;
end;

/
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "USQL"."PRODUCTO" MODIFY ("IDPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTO" MODIFY ("DESCRIPCIONPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTO" MODIFY ("PRECIOPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTO" MODIFY ("IDTIPOPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTO" MODIFY ("NUMEROSERIE" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTO" MODIFY ("CANTIDADSTOCK" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTO" MODIFY ("CANTIDADMINIMA" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTO" ADD CONSTRAINT "XPKPRODUCTO" PRIMARY KEY ("IDPRODUCTO", "IDTIPOPRODUCTO")
  USING INDEX "USQL"."XPKPRODUCTO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ROLES
--------------------------------------------------------

  ALTER TABLE "USQL"."ROLES" MODIFY ("IDROL" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ROLES" MODIFY ("NOMBREROL" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ROLES" ADD CONSTRAINT "XPKROLES" PRIMARY KEY ("IDROL")
  USING INDEX "USQL"."XPKROLES"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPODIRECCION
--------------------------------------------------------

  ALTER TABLE "USQL"."TIPODIRECCION" MODIFY ("IDTIPODIRECCION" NOT NULL ENABLE);
  ALTER TABLE "USQL"."TIPODIRECCION" ADD CONSTRAINT "XPKTIPODIRECCION" PRIMARY KEY ("IDTIPODIRECCION")
  USING INDEX "USQL"."XPKTIPODIRECCION"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDEN
--------------------------------------------------------

  ALTER TABLE "USQL"."ORDEN" MODIFY ("IDORDEN" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDEN" MODIFY ("FECHAORDEN" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDEN" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDEN" MODIFY ("IDSUCURSAL" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDEN" ADD CONSTRAINT "XPKORDEN" PRIMARY KEY ("IDORDEN", "IDUSUARIO", "IDSUCURSAL")
  USING INDEX "USQL"."XPKORDEN"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TELEFONO
--------------------------------------------------------

  ALTER TABLE "USQL"."TELEFONO" MODIFY ("IDTELEFONO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."TELEFONO" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."TELEFONO" MODIFY ("IDTIPOTELEFONO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."TELEFONO" ADD CONSTRAINT "XPKTELEFONO" PRIMARY KEY ("IDTELEFONO", "IDUSUARIO")
  USING INDEX "USQL"."XPKTELEFONO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PROVINCIA
--------------------------------------------------------

  ALTER TABLE "USQL"."PROVINCIA" MODIFY ("IDPROVINCIA" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PROVINCIA" ADD CONSTRAINT "XPKPROVINCIA" PRIMARY KEY ("IDPROVINCIA")
  USING INDEX "USQL"."XPKPROVINCIA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SUCURSALPRODUCTO
--------------------------------------------------------

  ALTER TABLE "USQL"."SUCURSALPRODUCTO" MODIFY ("IDPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."SUCURSALPRODUCTO" MODIFY ("IDTIPOPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."SUCURSALPRODUCTO" MODIFY ("IDSUCURSAL" NOT NULL ENABLE);
  ALTER TABLE "USQL"."SUCURSALPRODUCTO" ADD CONSTRAINT "XPKSUCURSALPRODUCTO" PRIMARY KEY ("IDPRODUCTO", "IDTIPOPRODUCTO", "IDSUCURSAL")
  USING INDEX "USQL"."XPKSUCURSALPRODUCTO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CANTON
--------------------------------------------------------

  ALTER TABLE "USQL"."CANTON" MODIFY ("IDCANTON" NOT NULL ENABLE);
  ALTER TABLE "USQL"."CANTON" MODIFY ("DESCRIPCIONCANTON" NOT NULL ENABLE);
  ALTER TABLE "USQL"."CANTON" ADD CONSTRAINT "XPKCANTON" PRIMARY KEY ("IDCANTON")
  USING INDEX "USQL"."XPKCANTON"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPOPRODUCTO
--------------------------------------------------------

  ALTER TABLE "USQL"."TIPOPRODUCTO" MODIFY ("IDTIPOPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."TIPOPRODUCTO" ADD CONSTRAINT "XPKTIPOPRODUCTO" PRIMARY KEY ("IDTIPOPRODUCTO")
  USING INDEX "USQL"."XPKTIPOPRODUCTO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CORREO
--------------------------------------------------------

  ALTER TABLE "USQL"."CORREO" MODIFY ("IDCORREO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."CORREO" MODIFY ("CORREOELECTRONICO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."CORREO" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."CORREO" ADD CONSTRAINT "XPKCORREO" PRIMARY KEY ("IDCORREO", "IDUSUARIO")
  USING INDEX "USQL"."XPKCORREO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DISTRITO
--------------------------------------------------------

  ALTER TABLE "USQL"."DISTRITO" MODIFY ("IDDISTRITO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."DISTRITO" ADD CONSTRAINT "XPKDISTRITO" PRIMARY KEY ("IDDISTRITO")
  USING INDEX "USQL"."XPKDISTRITO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SUCURSAL
--------------------------------------------------------

  ALTER TABLE "USQL"."SUCURSAL" MODIFY ("IDSUCURSAL" NOT NULL ENABLE);
  ALTER TABLE "USQL"."SUCURSAL" MODIFY ("NOMBRESUCURSAL" NOT NULL ENABLE);
  ALTER TABLE "USQL"."SUCURSAL" ADD CONSTRAINT "XPKSUCURSAL" PRIMARY KEY ("IDSUCURSAL")
  USING INDEX "USQL"."XPKSUCURSAL"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDENPRODUCTO
--------------------------------------------------------

  ALTER TABLE "USQL"."ORDENPRODUCTO" MODIFY ("IDSUCURSAL" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDENPRODUCTO" MODIFY ("IDORDEN" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDENPRODUCTO" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDENPRODUCTO" MODIFY ("IDPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDENPRODUCTO" MODIFY ("IDTIPOPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."ORDENPRODUCTO" ADD CONSTRAINT "XPKORDENPRODUCTO" PRIMARY KEY ("IDORDEN", "IDUSUARIO", "IDSUCURSAL", "IDPRODUCTO", "IDTIPOPRODUCTO")
  USING INDEX "USQL"."XPKORDENPRODUCTO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "USQL"."USUARIO" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."USUARIO" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "USQL"."USUARIO" MODIFY ("CONTRASEÑA" NOT NULL ENABLE);
  ALTER TABLE "USQL"."USUARIO" MODIFY ("CEDULA" NOT NULL ENABLE);
  ALTER TABLE "USQL"."USUARIO" ADD CONSTRAINT "XPKUSUARIO" PRIMARY KEY ("IDUSUARIO")
  USING INDEX "USQL"."XPKUSUARIO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DIRECCION
--------------------------------------------------------

  ALTER TABLE "USQL"."DIRECCION" MODIFY ("IDDIRECCION" NOT NULL ENABLE);
  ALTER TABLE "USQL"."DIRECCION" MODIFY ("CALLE" NOT NULL ENABLE);
  ALTER TABLE "USQL"."DIRECCION" ADD CONSTRAINT "XPKDIRECCION" PRIMARY KEY ("IDDIRECCION")
  USING INDEX "USQL"."XPKDIRECCION"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PROVEEDOR
--------------------------------------------------------

  ALTER TABLE "USQL"."PROVEEDOR" MODIFY ("IDPROVEEDOR" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PROVEEDOR" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PROVEEDOR" ADD CONSTRAINT "XPKPROVEEDOR" PRIMARY KEY ("IDPROVEEDOR")
  USING INDEX "USQL"."XPKPROVEEDOR"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCTOPROVEEDOR
--------------------------------------------------------

  ALTER TABLE "USQL"."PRODUCTOPROVEEDOR" MODIFY ("IDPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTOPROVEEDOR" MODIFY ("IDPROVEEDOR" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTOPROVEEDOR" MODIFY ("IDTIPOPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."PRODUCTOPROVEEDOR" ADD CONSTRAINT "XPKPRODUCTOPROVEEDOR" PRIMARY KEY ("IDPRODUCTO", "IDPROVEEDOR", "IDTIPOPRODUCTO")
  USING INDEX "USQL"."XPKPRODUCTOPROVEEDOR"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPOTELEFONO
--------------------------------------------------------

  ALTER TABLE "USQL"."TIPOTELEFONO" MODIFY ("IDTIPOTELEFONO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."TIPOTELEFONO" ADD CONSTRAINT "XPKTIPOTELEFONO" PRIMARY KEY ("IDTIPOTELEFONO")
  USING INDEX "USQL"."XPKTIPOTELEFONO"  ENABLE;
--------------------------------------------------------
--  Constraints for Table METODOPAGO
--------------------------------------------------------

  ALTER TABLE "USQL"."METODOPAGO" MODIFY ("IDMETODO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."METODOPAGO" MODIFY ("TIPOMETODOPAGO" NOT NULL ENABLE);
  ALTER TABLE "USQL"."METODOPAGO" ADD CONSTRAINT "XPKMETODOPAGO" PRIMARY KEY ("IDMETODO")
  USING INDEX "USQL"."XPKMETODOPAGO"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CANTON
--------------------------------------------------------

  ALTER TABLE "USQL"."CANTON" ADD CONSTRAINT "R_54" FOREIGN KEY ("IDPROVINCIA")
	  REFERENCES "USQL"."PROVINCIA" ("IDPROVINCIA") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CORREO
--------------------------------------------------------

  ALTER TABLE "USQL"."CORREO" ADD CONSTRAINT "R_43" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "USQL"."USUARIO" ("IDUSUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DIRECCION
--------------------------------------------------------

  ALTER TABLE "USQL"."DIRECCION" ADD CONSTRAINT "R_47" FOREIGN KEY ("IDSUCURSAL")
	  REFERENCES "USQL"."SUCURSAL" ("IDSUCURSAL") ON DELETE SET NULL ENABLE;
  ALTER TABLE "USQL"."DIRECCION" ADD CONSTRAINT "R_56" FOREIGN KEY ("IDDISTRITO")
	  REFERENCES "USQL"."DISTRITO" ("IDDISTRITO") ON DELETE SET NULL ENABLE;
  ALTER TABLE "USQL"."DIRECCION" ADD CONSTRAINT "R_57" FOREIGN KEY ("IDCANTON")
	  REFERENCES "USQL"."CANTON" ("IDCANTON") ON DELETE SET NULL ENABLE;
  ALTER TABLE "USQL"."DIRECCION" ADD CONSTRAINT "R_58" FOREIGN KEY ("IDPROVINCIA")
	  REFERENCES "USQL"."PROVINCIA" ("IDPROVINCIA") ON DELETE SET NULL ENABLE;
  ALTER TABLE "USQL"."DIRECCION" ADD CONSTRAINT "R_59" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "USQL"."USUARIO" ("IDUSUARIO") ON DELETE SET NULL ENABLE;
  ALTER TABLE "USQL"."DIRECCION" ADD CONSTRAINT "R_63" FOREIGN KEY ("IDTIPODIRECCION")
	  REFERENCES "USQL"."TIPODIRECCION" ("IDTIPODIRECCION") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DISTRITO
--------------------------------------------------------

  ALTER TABLE "USQL"."DISTRITO" ADD CONSTRAINT "R_53" FOREIGN KEY ("IDCANTON")
	  REFERENCES "USQL"."CANTON" ("IDCANTON") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table METODOPAGO
--------------------------------------------------------

  ALTER TABLE "USQL"."METODOPAGO" ADD CONSTRAINT "R_61" FOREIGN KEY ("IDORDEN", "IDUSUARIO", "IDSUCURSAL")
	  REFERENCES "USQL"."ORDEN" ("IDORDEN", "IDUSUARIO", "IDSUCURSAL") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDEN
--------------------------------------------------------

  ALTER TABLE "USQL"."ORDEN" ADD CONSTRAINT "R_11" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "USQL"."USUARIO" ("IDUSUARIO") ENABLE;
  ALTER TABLE "USQL"."ORDEN" ADD CONSTRAINT "R_18" FOREIGN KEY ("IDSUCURSAL")
	  REFERENCES "USQL"."SUCURSAL" ("IDSUCURSAL") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDENPRODUCTO
--------------------------------------------------------

  ALTER TABLE "USQL"."ORDENPRODUCTO" ADD CONSTRAINT "R_20" FOREIGN KEY ("IDORDEN", "IDUSUARIO", "IDSUCURSAL")
	  REFERENCES "USQL"."ORDEN" ("IDORDEN", "IDUSUARIO", "IDSUCURSAL") ENABLE;
  ALTER TABLE "USQL"."ORDENPRODUCTO" ADD CONSTRAINT "R_21" FOREIGN KEY ("IDPRODUCTO", "IDTIPOPRODUCTO")
	  REFERENCES "USQL"."PRODUCTO" ("IDPRODUCTO", "IDTIPOPRODUCTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "USQL"."PRODUCTO" ADD CONSTRAINT "R_16" FOREIGN KEY ("IDTIPOPRODUCTO")
	  REFERENCES "USQL"."TIPOPRODUCTO" ("IDTIPOPRODUCTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRODUCTOPROVEEDOR
--------------------------------------------------------

  ALTER TABLE "USQL"."PRODUCTOPROVEEDOR" ADD CONSTRAINT "R_14" FOREIGN KEY ("IDPRODUCTO", "IDTIPOPRODUCTO")
	  REFERENCES "USQL"."PRODUCTO" ("IDPRODUCTO", "IDTIPOPRODUCTO") ENABLE;
  ALTER TABLE "USQL"."PRODUCTOPROVEEDOR" ADD CONSTRAINT "R_15" FOREIGN KEY ("IDPROVEEDOR")
	  REFERENCES "USQL"."PROVEEDOR" ("IDPROVEEDOR") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SUCURSALPRODUCTO
--------------------------------------------------------

  ALTER TABLE "USQL"."SUCURSALPRODUCTO" ADD CONSTRAINT "R_45" FOREIGN KEY ("IDPRODUCTO", "IDTIPOPRODUCTO")
	  REFERENCES "USQL"."PRODUCTO" ("IDPRODUCTO", "IDTIPOPRODUCTO") ENABLE;
  ALTER TABLE "USQL"."SUCURSALPRODUCTO" ADD CONSTRAINT "R_46" FOREIGN KEY ("IDSUCURSAL")
	  REFERENCES "USQL"."SUCURSAL" ("IDSUCURSAL") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TELEFONO
--------------------------------------------------------

  ALTER TABLE "USQL"."TELEFONO" ADD CONSTRAINT "R_34" FOREIGN KEY ("IDUSUARIO")
	  REFERENCES "USQL"."USUARIO" ("IDUSUARIO") ENABLE;
  ALTER TABLE "USQL"."TELEFONO" ADD CONSTRAINT "R_62" FOREIGN KEY ("IDTIPOTELEFONO")
	  REFERENCES "USQL"."TIPOTELEFONO" ("IDTIPOTELEFONO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "USQL"."USUARIO" ADD CONSTRAINT "R_13" FOREIGN KEY ("IDROL")
	  REFERENCES "USQL"."ROLES" ("IDROL") ON DELETE SET NULL ENABLE;

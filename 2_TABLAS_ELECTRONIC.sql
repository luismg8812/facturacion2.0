CREATE  TABLE TIPO_DOCUMENTO (
  TIPO_DOCUMENTO_ID                smallint NOT NULL,
  NOMBRE                           VARCHAR(50),
  CONSTRAINT PK_TIPO_DOCUMENTO
    PRIMARY KEY ( TIPO_DOCUMENTO_ID ) 
);

CREATE TABLE RECEPTOR (
	RECEPTOR_ID		bigint NOT NULL,
	NOMBRE          VARCHAR(100),
	IDENTIFICACION  VARCHAR(50),
	CONSTRAINT PK_RECEPTOR
    PRIMARY KEY ( RECEPTOR_ID) 
);

CREATE  TABLE EMPRESA (
  EMPRESA_ID                       smallint NOT NULL,
  NOMBRE                           VARCHAR(50),
  REPRESENTE                       VARCHAR(100),
  NIT                              VARCHAR(50),
  REGIMEN                          VARCHAR(20),
  DIRECCION                        VARCHAR(50),
  BARRIO                           VARCHAR(50),
  CIUDAD                           VARCHAR(50),
  DEPARTAMENTO                     VARCHAR(50),
  TELEFONO_FIJO                    VARCHAR(50),
  CEL                              int,
  PREFIJO                          VARCHAR(10),
  fecha_resolucion                 timestamp,
  autorizacion_desde               bigint,
  autorizacion_hasta               bigint,
  CONSTRAINT PK_EMPRESA
    PRIMARY KEY ( EMPRESA_ID ) 
);

CREATE  TABLE DOCUMENTO (
  DOCUMENTO_ID                     bigint NOT NULL,
  TIPO_DOCUMENTO_ID                smallint,
  ESTADO						smallint,
  RECEPTOR_ID                      int,
  FECHA_REGISTRO                   timestamp,
  FECHA_ACTUALIZA                  timestamp,
  NUMERO_DOCUMENTO                 varchar(20),
  TOTAL                            decimal,
  EXCENTO                          decimal,
  GRAVADO                          decimal,
  IVA                              decimal,
  iva_5                           decimal,
  iva_19                            decimal,
  base_5                            decimal,
  base_19                           decimal,
  retefuente                        decimal,
  PREFIJO 			 		 	    VARCHAR(10),
  CONSTRAINT PK_DOCUMENTO
    PRIMARY KEY ( DOCUMENTO_ID ) 
);

ALTER TABLE DOCUMENTO ADD CONSTRAINT FK_DOCU_REFERENCE_RECEPTOR
  FOREIGN KEY (RECEPTOR_ID)
    REFERENCES RECEPTOR (RECEPTOR_ID);





ALTER TABLE DOCUMENTO ADD CONSTRAINT FK_DOCU_REFERENCE_TIPO
  FOREIGN KEY (TIPO_DOCUMENTO_ID)
    REFERENCES TIPO_DOCUMENTO (TIPO_DOCUMENTO_ID);

CREATE  TABLE DOCUMENTO_DETALLE (
  DOCUMENTO_DETALLE_ID             bigint NOT NULL,
  DOCUMENTO_ID                     bigint,
  PRODUCTO_ID                      int,
  PRODUCTO_NOMBRE				  VARCHAR(100),
  FECHA_REGISTRO                   timestamp,
  FECHA_ACTUALIZA                  timestamp,
  CANTIDAD                         decimal,
  CONSTRAINT PK_DOCUMENTO_DETALLE
    PRIMARY KEY ( DOCUMENTO_DETALLE_ID ) 
);

ALTER TABLE DOCUMENTO_DETALLE ADD CONSTRAINT FK_DETALLE_REFERENCE_DOCU
  FOREIGN KEY (DOCUMENTO_ID)
    REFERENCES DOCUMENTO (DOCUMENTO_ID);

commit; 
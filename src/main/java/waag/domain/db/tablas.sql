

--BULTOS
CREATE TABLE bultos (
    idbulto integer NOT NULL primary key,
    tipo text,
    bultosaman text,
    bultoaduana text,
    UNIQUE(tipo)
);
CREATE TABLE bultos_error (
    idbulto double precision,
    tipo text,
    bultosaman text,
    bultoaduana text
);
CREATE SEQUENCE bultos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--BUQUES
CREATE TABLE buques (
    idbuque integer NOT NULL primary key,
    buque text,
    UNIQUE(buque)
);
CREATE TABLE buques_error (
    idbuque double precision,
    buque text
);
CREATE SEQUENCE buques_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


-- CLIENTES
CREATE TABLE clientes (
    idcliente integer NOT NULL primary key,
    exportador text,
    direccion text,
    ruc text,
    tel text,
    fax text,
    nromercantil text,
    UNIQUE(exportador)
);
CREATE TABLE clientes_error (
    idcliente double precision,
    exportador text,
    direccion text,
    ruc text,
    tel text,
    fax text,
    nromercantil text
);
CREATE SEQUENCE clientes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


-- COMISIONISTAS
CREATE TABLE comisionistas (
    idcomisionista integer NOT NULL primary key,
    comisionista text,
    UNIQUE(comisionista)
);
CREATE TABLE comisionistas_error (
    idcomisionista double precision,
    comisionista text
);
CREATE SEQUENCE comisionistas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


-- COMPVEND
CREATE TABLE compvend (
    idcompvend integer NOT NULL primary key,
    cliente text,
    direccion text,
    registrofiscal text,
    tel text,
    fax text,
    UNIQUE(cliente)
);
CREATE TABLE compvend_error (
    idcompvend double precision,
    cliente text,
    direccion text,
    registrofiscal text,
    tel text,
    fax text
);
CREATE SEQUENCE compvend_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--DESTINOS
CREATE TABLE destinos (
    iddestino integer NOT NULL primary key,
    ciudad text,
    codigo text,
    pais text,
    codaduana text,
    formulaa text
);
CREATE TABLE destinos_error (
    iddestino double precision,
    ciudad text,
    codigo text,
    pais text,
    codaduana text,
    formulaa text
);
CREATE SEQUENCE destinos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--MARCAS
CREATE TABLE marcas (
    idmarca integer NOT NULL primary key,
    marca text,
    UNIQUE(marca)
);
CREATE TABLE marcas_error (
    idmarca double precision,
    marca text
);
CREATE SEQUENCE marcas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--MEDIOTRANSPORTE    
CREATE TABLE mediotransporte (
    idmedio integer NOT NULL primary key,
    medio text,
    ingles text,
    UNIQUE(medio)
);
CREATE TABLE mediotransporte_error (
    idmedio double precision,
    medio text,
    ingles text
);
CREATE SEQUENCE mediotransporte_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--OPERACIONES
CREATE TABLE operaciones (
    codigo integer NOT NULL primary key,
    operacion text,
    UNIQUE(operacion)
);
CREATE TABLE operaciones_error (
    codigo double precision,
    operacion text
);
CREATE SEQUENCE operaciones_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--RECEPTORIAS
CREATE TABLE receptorias (
    idreceptoria integer NOT NULL primary key,
    receptoria text,
    UNIQUE(receptoria)
);
CREATE TABLE receptorias_error (
    idreceptoria double precision,
    receptoria text
);
CREATE SEQUENCE receptorias_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ENCARGADOS
CREATE TABLE encargados (
    IdEncargado integer NOT NULL primary key,
    Nombre TEXT,
    Iniciales TEXT,
    UNIQUE(nombre)
);
CREATE TABLE encargados_error (
    IdEncargado DOUBLE PRECISION,
    Nombre TEXT,
    Iniciales TEXT
);
CREATE SEQUENCE encargados_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--DESCCOMERCIAL
CREATE TABLE desccomercial(
    Iddescripcion integer NOT NULL primary key,
    NCM TEXT,
    Descripcion TEXT,
    UNIQUE(Descripcion)
);
CREATE TABLE desccomercial_error(
    Iddescripcion DOUBLE PRECISION,
    NCM TEXT,
    Descripcion TEXT
);
CREATE SEQUENCE desccomercial_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--MERCADERIA
CREATE TABLE mercaderias (
    idMercaderia integer NOT NULL primary key,
    CODIGOMGAP TEXT,
    VARIEDAD TEXT,
    Mercaderia TEXT,
    NCM TEXT,
    NCM_DC TEXT,
    GLOSA TEXT,
    SA TEXT, 
    GLOSA_SA TEXT,
    UNIQUE(Mercaderia)
);
CREATE TABLE mercaderias_error (
    idMercaderia DOUBLE PRECISION,
    CODIGOMGAP TEXT,
    VARIEDAD TEXT,
    Mercaderia TEXT,
    NCM TEXT,
    NCM_DC TEXT,
    GLOSA TEXT,
    SA TEXT, 
    GLOSA_SA TEXT
);
CREATE SEQUENCE mercaderias_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--ESTADOS
CREATE TABLE estados (
    IdEstado integer NOT NULL primary key, 
    Estado TEXT,
    UNIQUE(Estado)
);
CREATE TABLE estados_error (
    IdEstado DOUBLE PRECISION, 
    Estado TEXT
);
CREATE SEQUENCE estados_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--UNIDADCOMERCIAL
CREATE TABLE unidadComercial(
    IdUnidad integer NOT NULL primary key, 
    CodAduana TEXT, 
    CodMGAP TEXT, 
    UnidadComercial TEXT,
    UNIQUE(UnidadComercial)
);
CREATE TABLE unidadComercial_error(
    IdUnidad DOUBLE PRECISION, 
    CodAduana TEXT, 
    CodMGAP TEXT, 
    UnidadComercial TEXT
);
CREATE SEQUENCE unidadComercial_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- FACTURAS --
CREATE TABLE facturas_aux
(
  ID integer NOT NULL primary key
, FACTURA TEXT
, FECHA TIMESTAMP
, ETA TIMESTAMP
, TIPOCARGA TEXT
, ValorFOB DOUBLE PRECISION
, BULTOS DOUBLE PRECISION
, KilosNetos DOUBLE PRECISION
, KilosBrutos DOUBLE PRECISION
, TONSNEG DOUBLE PRECISION
, TONSEMB DOUBLE PRECISION
, Observaciones TEXT
, FormaPago TEXT
, Importe TEXT
, Neg TEXT
, RECIBODOCDEF TIMESTAMP
, SI_NO CHAR(1)
, idcompvend INTEGER
, idbulto INTEGER
, idcliente INTEGER
, iddestino INTEGER
, idbuque INTEGER
, idmedio INTEGER
, idreceptoria INTEGER
, idmarca INTEGER
, cod_operacion INTEGER
, idestado INTEGER
, idencargado INTEGER
, idmercaderia INTEGER
, idunidad INTEGER
, iddescripcion INTEGER
, UNIQUE(FACTURA)
)
;

CREATE TABLE facturas_aux_error
(
  ID DOUBLE PRECISION
, FACTURA TEXT
, FECHA TIMESTAMP
, ETA TIMESTAMP
, TIPOCARGA TEXT
, ValorFOB DOUBLE PRECISION
, BULTOS DOUBLE PRECISION
, KilosNetos DOUBLE PRECISION
, KilosBrutos DOUBLE PRECISION
, TONSNEG DOUBLE PRECISION
, TONSEMB DOUBLE PRECISION
, Observaciones TEXT
, FormaPago TEXT
, Importe TEXT
, Neg TEXT
, RECIBODOCDEF TIMESTAMP
, SI_NO CHAR(1)
, idcompvend INTEGER
, idbulto INTEGER
, idcliente INTEGER
, iddestino INTEGER
, idbuque INTEGER
, idmedio INTEGER
, idreceptoria INTEGER
, idmarca INTEGER
, cod_operacion INTEGER
, idestado INTEGER
, idencargado INTEGER
, idmercaderia INTEGER
, idunidad INTEGER
, iddescripcion INTEGER
)
;

CREATE SEQUENCE facturas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
CREATE TABLE buscador.productos
(
    pk    bigserial primary key,
    codigo        VARCHAR(40) not null,
    nombre VARCHAR(200) not null,
    cantidad integer,
    precio double precision,
    ubicacion VARCHAR(200) not null,
    vencimiento DATE
)
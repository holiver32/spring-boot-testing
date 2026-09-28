create table reserva (
   id bigint,
   cliente_id bigint,
   vuelo_number varchar
);

create table cliente (
   id bigint,
   name varchar
);

create table vuelo (
   vuelo_number varchar,
   aerolinea varchar
);

create table user (
   id bigint,
   name varchar,
   email varchar,
   registration_date timestamp
);

create sequence hibernate_sequence;
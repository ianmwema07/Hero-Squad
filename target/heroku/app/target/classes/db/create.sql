SET MODE PostgreSQL;

CREATE DATABASE herosquad;

\c herosquad;
CREATE TABLE heroes(id SERIAL PRIMARY KEY, name VARCHAR, age INTEGER, weakness VARCHAR, squad_id INTEGER);
CREATE TABLE squads(id SERIAL PRIMARY KEY, name VARCHAR, max_size INTEGER, cause VARCHAR);

CREATE DATABASE herosquad_test WITH TEMPLATE herosquad;
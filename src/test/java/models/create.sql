SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heroes(
id int PRIMARY KEY auto_increment,
name VARCHAR ,
age int,
special_power VARCHAR ,
weakness varchar,
squad_id INT
);

CREATE TABLE IF NOT EXISTS squads(
id int PRIMARY KEY auto_increment,
name VARCHAR ,
max_size int ,
cause VARCHAR
);
SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heroes(
id int PRIMARY KEY auto_increment,
name VARCHAR ,
age int,
special_power VARCHAR ,
weakness varchar
);
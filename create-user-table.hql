CREATE DATABASE 'demo';
USE demo;

create table users (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	state varchar(20) NOT NULL,
	PRIMARY KEY (id)
);


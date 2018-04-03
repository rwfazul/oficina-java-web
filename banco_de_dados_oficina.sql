


CREATE DATABASE oficina;

USE oficina;

CREATE TABLE usuario (id_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						login varchar(30) not null,
                        senha varchar(20) not null);
                        
CREATE TABLE livro (isbn INT NOT NULL PRIMARY KEY,
						autor VARCHAR(50) NOT NULL,
                        titulo VARCHAR(100) NOT NULL,
                        editora VARCHAR(50) NOT NULL,
                        ano INT NOT NULL);
                        

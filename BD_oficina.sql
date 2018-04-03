DROP DATABASE IF EXISTS oficina;
CREATE DATABASE IF NOT EXISTS oficina;
USE oficina;

CREATE TABLE usuario (
    id_usuario          INT             AUTO_INCREMENT,
    login               VARCHAR(30)     NOT NULL,
    senha               VARCHAR(20)     NOT NULL,
    PRIMARY KEY         (id_usuario)
);
                        
CREATE TABLE livro (
    isbn                INT,
    autor               VARCHAR(50)     NOT NULL,
    titulo              VARCHAR(100)    NOT NULL,
    editora             VARCHAR(50)     NOT NULL,
    ano                 INT             NOT NULL,
    PRIMARY KEY	        (isbn)
);

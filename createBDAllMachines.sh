#!/bin/bash
count=5
for i in {1..54}
do
    if (( $count < 10 )); then
        echo '-- criando database oficina_hp0'$count
        echo 'drop database if exists oficina_hp0'$count';'
        echo 'create database if not exists oficina_hp0'$count';'
        echo use database oficina_hp0$count';'
    else
        echo '-- criando database oficina_hp'$count
        echo 'drop database if exists oficina_hp0'$count';'
        echo 'create database if not exists oficina_hp'$count';'
        echo use database oficina_hp$count';'
    fi
    (( count += 1 ))
    echo -e '\ncreate table usuario (
            id_usuario int auto_increment primary key, 
            nome varchar(50) not null, 
            senha varchar(50) not null\n);\n'
    echo -e 'create table livro (
           isbn int primary key,
           autor varchar(50) not null,
           titulo varchar(100) not null,
           editora varchar(50) not null,
           ano int not null\n);\n\n'
done;


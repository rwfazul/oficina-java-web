/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.model;

import java.io.Serializable;

/**
 *
 * @author rhau
 */
public class Livro implements Serializable {
    
    private Integer isbn;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    
    public Livro() {

    }

    public Livro(Integer isbn) {
        this.isbn = isbn;
    }  

    public Livro(String titulo, String autor, String editora, Integer ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
    }
    
    public Livro(Integer isbn, String titulo, String autor, String editora, Integer ano) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Livro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", ano=" + ano + '}';
    }    

}
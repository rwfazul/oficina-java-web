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
public class Usuario implements Serializable {
    
    private Integer id;
    private String login;
    private String senha;

    public Usuario() {
        
    }
    
    public Usuario(Integer id) {
        this.id = id;
    }  
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
        
    public Usuario(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + '}';
    }
    
}

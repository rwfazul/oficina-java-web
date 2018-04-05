/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import util.ConexaoMySQL;

/**
 *
 * @author rhau
 *
 * CREATE TABLE usuario (
    id_usuario          INT             AUTO_INCREMENT,
    login               VARCHAR(30)     NOT NULL,
    senha               VARCHAR(20)     NOT NULL,
    PRIMARY KEY         (id_usuario)
   );
 */
public class UsuarioDAO {
    
    public Boolean autenticar(Usuario u) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // se retornou um registro existe usuario com aquele login e senha, logo autenticado
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean inserir(Usuario u) {
        String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?);";
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            ps.execute(); 
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Collection<Usuario> listar() { 
        String sql = "SELECT * FROM usuario;";
        Collection<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // manipular o resultado da instrucao sql (percorrer os registros retornados)
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public Boolean deletar(Usuario u) {
        String sql = "Delete FROM usuario WHERE id_usuario = ?;";
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Usuario buscar(Integer idUsuario) {
        String sql = "SELECT * FROM usuario WHERE id_usuario =  ?;";
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(idUsuario);
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Boolean atualizar(Usuario u) {
        String sql = "UPDATE usuario SET login = ?, senha = ? WHERE id_usuario = ?;";
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            ps.setInt(3, u.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
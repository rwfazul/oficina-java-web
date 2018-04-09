/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.model.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import br.csi.util.ConexaoMySQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rhau
 * 
 * CREATE TABLE livro (
       isbn                INT,
       autor               VARCHAR(50)     NOT NULL,
       titulo              VARCHAR(100)    NOT NULL,
       editora             VARCHAR(50)     NOT NULL,
       ano                 INT             NOT NULL,
       PRIMARY KEY	        (isbn)
   );
 */
public class LivroDAO {
    
    public Boolean inserir(Livro l) {
        String sql = "INSERT INTO livro (isbn, autor, titulo, editora, ano) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setInt(1, l.getIsbn());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getTitulo());
            ps.setString(4, l.getEditora());
            ps.setInt(5, l.getAno());
            ps.execute(); 
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Boolean deletar(Livro l) {
        String sql = "DELETE FROM livro WHERE isbn = ?;";
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setInt(1, l.getIsbn());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public Collection<Livro> listar() { 
        String sql = "SELECT * FROM livro;";
        Collection<Livro> livros = new ArrayList<>();
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livro l = new Livro();
                l.setIsbn(rs.getInt("isbn"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setEditora(rs.getString("editora"));
                l.setAno(rs.getInt(rs.getInt("ano")));
                livros.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }
    
    public Livro buscar(Integer isbn) {
        String sql = "SELECT * FROM livro WHERE isbn = ?;";
        Livro livro = null;
        try {
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                livro = new Livro();
                livro.setIsbn(rs.getInt("isbn"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
            }
            return livro;
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livro;
    }
    
    public Boolean atualizar(Livro l) {
        try {
            String sql = "UPDATE livro SET titulo = ?, autor = ?, editora = ?, ano = ? WHERE isbn = ?;";
            PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getEditora());
            ps.setInt(4, l.getAno());
            ps.setInt(5, l.getIsbn());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}

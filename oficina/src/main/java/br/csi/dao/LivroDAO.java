/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import Model.Livro;
import java.sql.SQLException;
import Util.ConexaoMySQL;

/**
 *
 * @author Claiton
 */
public class LivroDAO {
    
    /*Não precisa autenticar livro  
    public boolean autenticar(Livro l) throws SQLException{
        String sql = "SELECT * FROM livro WHERE titulo = ? AND ano = ?";
        PreparedStatement ps = ConexãoMySQL.getConexao().prepareStatement(sql);
        ps.setString(1, l.getTitulo());
        ps.setInt(2, l.getAno());
        ResultSet rs = ps.executeQuery();
        return rs.next(); // true se existe usuario com esse login e senha
        
    }*/
    
    public Collection<Livro> listar() throws Exception { 
        String sql = "SELECT * FROM livro;";
        Collection<Livro> livros = new ArrayList<>();
        PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Livro l = new Livro();
            l.setISBN(rs.getInt("isbn"));
            l.setTitulo(rs.getString("titulo"));
            l.setAutor(rs.getString("autor"));
            l.setEditora(rs.getString("editora"));
            l.setAno(rs.getInt(rs.getInt("ano")));
            livros.add(l);
        }
        return livros;
    }
    public Boolean inserir(Livro l) throws SQLException{
        String sql = "INSERT INTO livro (isbn, autor, titulo, editora, ano) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
        
        ps.setInt(1, l.getISBN());
        ps.setString(2, l.getAutor());
        ps.setString(3, l.getTitulo());
        ps.setString(4, l.getEditora());
        ps.setInt(5, l.getAno());
        ps.execute();
        return true; // se entrar na excecao nao vai retornar true
    }
    public Boolean deletar(Livro l) throws SQLException {
        
        String sql = "Delete FROM livro WHERE isbn = ?;";
        PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
        
        ps.setInt(1, l.getISBN());
        ps.execute();
        return true;
    }
    
    public Livro getLivro(Integer isbn) throws SQLException{
        String sql = "SELECT * FROM livro WHERE isbn = ?;";
        PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
        ps.setInt(1, isbn);
        ResultSet rs = ps.executeQuery();
        Livro livro = new Livro();
        if (rs.next()) {
            livro.setISBN(rs.getInt("isbn"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutor(rs.getString("autor"));
        } 
        return livro;
    }
    
    public Boolean atualizar(Livro l) throws Exception {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, editora = ?, ano = ? WHERE isbn = ?;";
        PreparedStatement ps = ConexaoMySQL.getConexao().prepareStatement(sql);
        ps.setString(1, l.getTitulo());
        ps.setString(2, l.getAutor());
        ps.setString(3, l.getEditora());
        ps.setInt(4, l.getAno());
        ps.executeUpdate(); 
        return true;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rhau
 */
public class ConexaoMySQL {
    
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USUARIO = "mysql";
    private static final String SENHA = "mysql";
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/oficina?useSSL=false";    
    
    public static Connection getConexao() {
        Connection c = null;
        try {
            Class.forName(JDBC_DRIVER);
            c = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver " + JDBC_DRIVER + " não foi encontrado na memória.");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
}

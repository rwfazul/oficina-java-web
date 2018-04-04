/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeDAOs;

import dao.UsuarioDAO;
import java.util.Collection;
import model.Usuario;

/**
 *
 * @author rhau
 */
public class TesteUsuarioDAO {
 
    private static UsuarioDAO udao = new UsuarioDAO();
    
    public static void main(String[] args) { 
        Usuario u1 = new Usuario("Pedro", "1234"); // cria um usuario com login e senha
        Usuario u2 = new Usuario("João", "4567");
        udao.inserir(u1);                          // insere usuario no banco
        udao.inserir(u2);
        
        Collection<Usuario> usuarios = udao.listar();  // seleciona todas usuarios do banco
        System.out.println("Listando usuarios....");
        for (Usuario usuario : usuarios)  // percorre colecao para listar usuarios
            System.out.println(usuario.toString());   
    
        Usuario testeAutenticar = new Usuario("teste", "0000");
        if ( udao.autenticar(testeAutenticar) )
            System.out.println("Usuario " + testeAutenticar.getLogin() + " autenticado!");
        else
            System.out.println("\nUsuario " + testeAutenticar.getLogin() + " nao autenticado");
        
        if ( udao.autenticar(u1) )
            System.out.println("Usuario " + u1.getLogin() + " autenticado!");
        else
            System.out.println("Usuario " + u1.getLogin() + " nao autenticado");   
    }
      
}
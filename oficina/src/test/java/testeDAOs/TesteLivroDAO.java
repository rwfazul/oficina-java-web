/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeDAOs;

import br.csi.dao.LivroDAO;
import br.csi.model.Livro;
import java.util.Collection;

/**
 *
 * @author rhau
 */
public class TesteLivroDAO {
 
    private static LivroDAO ldao = new LivroDAO();
    
    public static void main(String[] args) { 
        Livro l1 = new Livro(1520, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Raincoast", 1997); 
        Livro l2 = new Livro(3090, "A Game of Thrones", "George R. R. Martin", "Voyager Books", 1996);
        ldao.inserir(l1);                         
        ldao.inserir(l2);
        
        System.out.println("Listando livros....");
        for (Livro livro : ldao.listar()) 
            System.out.println(livro.toString());          
        
        l2.setEditora("Bantam Spectra");
        ldao.atualizar(l2);
        for (Livro livro : ldao.listar()) 
            System.out.println(livro.toString());          
        
        ldao.deletar(l1);
        ldao.deletar(l2);
        System.out.println("Listando livros....");
        for (Livro livro : ldao.listar()) 
            System.out.println(livro.toString());   
    }
      
}
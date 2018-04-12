/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.LivroDAO;
import br.csi.model.Livro;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author isabella
 */

@Controller
public class LivrosController {
    @Autowired
    LivroDAO livroDAO;
    
    @RequestMapping("meus-livros")
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroDAO.listar()); // livros é o resultado que receberemos no front
        return "livros"; // livros aqui é o nome da página (livros.jsp)
    }
    
    @RequestMapping("inserirLivro")
    public String cadastrar(@Valid Livro livro) {
        livroDAO.inserir(livro);
        return "redirect:meus-livros";
    }
    
    @RequestMapping("excluirLivro/{isbn}")
    public String excluir(Model model, @PathVariable("isbn") int isbn) {
        Livro livro = new Livro(isbn);
        livroDAO.deletar(livro);
        return "redirect:/meus-livros";
    }
    
    @RequestMapping("buscarLivro/{isbn}")
    public String getlivro(Model model, @PathVariable("isbn") int isbn) {
        Livro livro = livroDAO.buscar(isbn); 
        model.addAttribute("livroBusca", livro);
        return listarLivros(model);
    }
    
    @RequestMapping("alterarLivro")
    public String alterar(@Valid Livro livro, @RequestParam("isbn") Integer isbn){
        livro.setIsbn(isbn);
        livroDAO.atualizar(livro);
        return "redirect:meus-livros";
    }
    
}

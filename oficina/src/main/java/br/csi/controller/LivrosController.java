/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.LivroDAO;
import br.csi.model.Livro;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author isabella
 */

@Controller
public class LivrosController {
    @Autowired
    LivroDAO livroDAO;
    
    @RequestMapping("/livros")
    public String index(){
        return "livro";
    }
    
    
    @RequestMapping("/inserirLivro")
    public String cadastrar(@Valid Livro livro, BindingResult result, Model model, HttpSession session) {
        if(result.hasErrors()) {   
            return "livro";
        }
        try {
           livroDAO.inserir(livro);
        } catch (Exception e) {
        }
        return "redirect:/livros/listar";
    }
}

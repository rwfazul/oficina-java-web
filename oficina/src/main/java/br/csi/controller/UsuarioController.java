/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rhau
 */

@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioDAO udao; 
    
    @RequestMapping("usuarioLogar")
    public String autenticar(Model model, Usuario u) {
        if (udao.autenticar(u)) {
            model.addAttribute("usuarioLogado", u);
            return "dashboard";
        } else {
            model.addAttribute("msg", "Erro: Usuário ou senha inválidos.");
        }
        return "index";
    }
        
    @RequestMapping("cadastroUsuario")
    public String paginaCadastro(){
        return "cadastrar";
    }
    
    @RequestMapping("inserirUsuario")
    public String registar(Model model, Usuario u) {
        if ( !udao.inserir(u) ) {
            model.addAttribute("msg", "Não foi possível inserir o usuário.");
            return "cadastrar";
        }
        return "index";
    }
   
}
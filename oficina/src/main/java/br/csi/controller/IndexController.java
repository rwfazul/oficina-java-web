/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author rhau
 */

@Controller
public class IndexController {
    
    // opcao 1
    /* @RequestMapping( value = {"", "/"} )
    public String index() {
        // rediect: lado usr, forward: lado server
        return "redirect:home";  // retornar index direto da problemas com css
    } */
    
    // opcao 2
    @RequestMapping( value = {"", "/"} )
    public RedirectView home2() {
        return new RedirectView("home", true); // true = path relativo a aplicacao
    }
    
    @RequestMapping("home")
    public String home() {
        return "index";
    }
    
}

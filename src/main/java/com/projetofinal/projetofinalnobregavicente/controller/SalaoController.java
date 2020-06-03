package com.projetofinal.projetofinalnobregavicente.controller;

import com.projetofinal.projetofinalnobregavicente.entity.Salao;
import com.projetofinal.projetofinalnobregavicente.services.SalaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/salao")
public class SalaoController {
    
    @Autowired
    SalaoService salaoService;

    @GetMapping("/template")
    public ModelAndView getTemplate() {
        ModelAndView mv = new ModelAndView("salaoTemplate");
        mv.addObject("salao", new Salao());
        mv.addObject("saloes", salaoService.getAllSalaos());
        return mv;
    }

    // Posts
    @PostMapping("/cadastrar")
    public String saveSalao(@ModelAttribute Salao salao) {
        salaoService.saveSalao(salao);
        return "redirect:/salao/template";
    }
}
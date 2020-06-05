package com.projetofinal.projetofinalnobregavicente.controller;

import com.projetofinal.projetofinalnobregavicente.entity.Funcionario;
import com.projetofinal.projetofinalnobregavicente.services.FuncionarioService;
import com.projetofinal.projetofinalnobregavicente.services.SalaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private SalaoService salaoService;

    @GetMapping("/template")
    public ModelAndView getTemplate(){
        ModelAndView mv= new ModelAndView("funcionarioTemplate");
        mv.addObject("funcionario", new Funcionario());
        mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
        mv.addObject("saloes", salaoService.getAllSalaos());
        return mv;
    }

    @PostMapping("/cadastrar")
    public String savefuncionario(@ModelAttribute Funcionario funcionario){
        funcionarioService.saveFuncionario(funcionario);
        return "redirect:/funcionario/template";
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhesFuncionario(@PathVariable(name="id")Integer id){
    ModelAndView mv = new ModelAndView("detalhesfuncionarioT");
    mv.addObject("funcionario", funcionarioService.getFuncionarioById(id));
    return mv;
    }
}
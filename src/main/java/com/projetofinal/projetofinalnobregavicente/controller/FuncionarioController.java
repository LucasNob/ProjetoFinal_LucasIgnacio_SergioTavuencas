package com.projetofinal.projetofinalnobregavicente.controller;

import com.projetofinal.projetofinalnobregavicente.entity.Funcionario;
import com.projetofinal.projetofinalnobregavicente.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcService;

    @GetMapping("/listarfuncionarios")
    public ModelAndView listarFuncionarios(){
        ModelAndView mv= new ModelAndView("listarFuncionariosT");
        mv.addObject("funcionarios", funcService.getAllFuncionarios());
        return mv;
    }

    @GetMapping("/cadastrofuncionario")
    public ModelAndView cadastroFuncionario(){
        ModelAndView mv = new ModelAndView("cadastrarFuncionarioT");
        mv.addObject("funcionarios", funcService.getAllFuncionarios());
        return mv;
    }

    @PostMapping("/salvarfuncionario")
    public String salvarfuncionario(@ModelAttribute Funcionario func){
        funcService.saveFuncionario(func);
        return "redirect:/cadastrofuncionario";
    }

    @GetMapping("/detalhesfuncionario/{id}")
    public ModelAndView detalhesFuncionario(@PathVariable(name="id")Integer id){
    ModelAndView mv = new ModelAndView("detalhesfuncionarioT");
    mv.addObject("funcionario", funcService.getFuncionarioById(id));
    return mv;
    }
}
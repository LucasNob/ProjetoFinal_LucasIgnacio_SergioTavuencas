package com.projetofinal.projetofinalnobregavicente.controller;

import com.projetofinal.projetofinalnobregavicente.entity.Funcionario;
import com.projetofinal.projetofinalnobregavicente.services.AgendaService;
import com.projetofinal.projetofinalnobregavicente.services.FuncionarioService;
import com.projetofinal.projetofinalnobregavicente.services.SalaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private SalaoService salaoService;
    
    @Autowired 
    private AgendaService agendaService;

    // Gets
    @GetMapping("/template")
    public ModelAndView getTemplate(){
        ModelAndView mv= new ModelAndView("funcionarioTemplate");
        mv.addObject("funcionario", new Funcionario());
        mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
        mv.addObject("saloes", salaoService.getAllSalaos());
        return mv;
    }

    @GetMapping("/agendamentos/{id}")
    public ModelAndView getAgendamentosSalao(@PathVariable("id") Integer funcionario_id) {
        ModelAndView mv = new ModelAndView("funcionarioAgendamentos");
        mv.addObject("funcionario", funcionarioService.getFuncionarioById(funcionario_id));
        mv.addObject("agendamentos", funcionarioService.getFuncionarioById(funcionario_id).getAgendamentos());
        return mv;
    }

    @GetMapping("/editar")
    public ModelAndView getFuncionario(@RequestParam Integer funcionario_id) {
        ModelAndView mv = new ModelAndView("funcionarioEditar");
        mv.addObject("funcionario", funcionarioService.getFuncionarioById(funcionario_id));
        mv.addObject("saloes", salaoService.getAllSalaos());
        return mv;
    }

    @GetMapping("/remove")
    public String removeFuncionario(@RequestParam Integer funcionario_id) {
        Funcionario funcionario = funcionarioService.getFuncionarioById(funcionario_id);
        agendaService.removeAgendamentosFuncionario(funcionario);
        funcionarioService.removeFuncionario(funcionario);
        return "redirect:/funcionario/template";
    }

    // Posts
    @PostMapping("/cadastrar")
    public String savefuncionario(@ModelAttribute Funcionario funcionario){
        funcionarioService.saveFuncionario(funcionario);
        return "redirect:/funcionario/template";
    }
}
package com.projetofinal.projetofinalnobregavicente.controller;

import com.projetofinal.projetofinalnobregavicente.entity.Salao;
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
@RequestMapping("/salao")
public class SalaoController {
    
    @Autowired
    private SalaoService salaoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private AgendaService agendaService;

    // Gets
    @GetMapping("/template")
    public ModelAndView getTemplate() {
        ModelAndView mv = new ModelAndView("salaoTemplate");
        mv.addObject("salao", new Salao());
        mv.addObject("saloes", salaoService.getAllSalaos());
        return mv;
    }

    @GetMapping("/agendamentos/{id}")
    public ModelAndView getAgendamentosSalao(@PathVariable("id") Integer salao_id) {
        ModelAndView mv = new ModelAndView("salaoAgendamentos");
        mv.addObject("salao", salaoService.getSalaoById(salao_id));
        mv.addObject("agendamentos", salaoService.getSalaoById(salao_id).getAgendamentos());
        return mv;
    }

    @GetMapping("/editar")
    public ModelAndView getSalao(@RequestParam Integer salao_id) {
        ModelAndView mv = new ModelAndView("salaoEditar");
        mv.addObject("salao", salaoService.getSalaoById(salao_id));
        return mv;
    }

    @GetMapping("/remove")
    public String removeSalao(@RequestParam Integer salao_id) {
        Salao salao = salaoService.getSalaoById(salao_id);
        funcionarioService.removeFuncionariosSalao(salao);
        agendaService.removeAgendamentosSalao(salao);
        salaoService.removeSalao(salao);
        
        return "redirect:/salao/template";
    }

    // Posts
    @PostMapping("/cadastrar")
    public String saveSalao(@ModelAttribute Salao salao) {
        salaoService.saveSalao(salao);
        return "redirect:/salao/template";
    }
}
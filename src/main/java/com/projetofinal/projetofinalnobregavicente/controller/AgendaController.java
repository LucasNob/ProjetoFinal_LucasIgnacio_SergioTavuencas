package com.projetofinal.projetofinalnobregavicente.controller;

import com.projetofinal.projetofinalnobregavicente.entity.Agenda;
import com.projetofinal.projetofinalnobregavicente.services.AgendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
    
    @Autowired
    AgendaService agendaService;

    // Gets
    @GetMapping("/template")
    public ModelAndView getTemplate() {
        ModelAndView mv = new ModelAndView("agendaTemplate");
        mv.addObject("agenda", new Agenda());
        mv.addObject("agendamentos", agendaService.getAllAgendas());
        return mv;
    }

    // Sets
    @PostMapping("/agendar")
    public String saveAuthor(@ModelAttribute Agenda agenda) {
        agendaService.saveAgenda(agenda);
        return "redirect:/agenda/template";
    }
}
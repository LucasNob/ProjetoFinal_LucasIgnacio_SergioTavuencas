package com.projetofinal.projetofinalnobregavicente.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import com.projetofinal.projetofinalnobregavicente.entity.Agenda;
import com.projetofinal.projetofinalnobregavicente.services.AgendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String saveAgenda(
        @ModelAttribute Agenda agenda, 
        @RequestParam("date") String date,
        @RequestParam("hour") String hour) {
            
        String dataFormatada = date + " " + hour + ":00.000";
        agenda.setData(Timestamp.valueOf(dataFormatada));
        return "redirect:/agenda/template";
    }
}
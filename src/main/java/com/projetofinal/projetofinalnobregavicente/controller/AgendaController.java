package com.projetofinal.projetofinalnobregavicente.controller;

import java.sql.Timestamp;

import com.projetofinal.projetofinalnobregavicente.entity.Agenda;
import com.projetofinal.projetofinalnobregavicente.entity.Salao;
import com.projetofinal.projetofinalnobregavicente.services.AgendaService;
import com.projetofinal.projetofinalnobregavicente.services.ClienteService;
import com.projetofinal.projetofinalnobregavicente.services.FuncionarioService;

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
    private AgendaService agendaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    // Gets
    @GetMapping("/template")
    public ModelAndView getTemplate() {
        ModelAndView mv = new ModelAndView("agendaTemplate");
        mv.addObject("agenda", new Agenda());
        mv.addObject("agendas", agendaService.getAllAgendas());
        mv.addObject("clientes", clienteService.getAllClientes());
        mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
        return mv;
    }

    @GetMapping("/editar")
    public ModelAndView getAgenda(@RequestParam Integer agenda_id) {
        ModelAndView mv = new ModelAndView("agendaEditar");
        mv.addObject("agenda", agendaService.getAgendaById(agenda_id));
        mv.addObject("clientes", clienteService.getAllClientes());
        mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
        return mv;
    }

    @GetMapping("/remove")
    public String removeAgenda(@RequestParam Integer agenda_id) {
        //Agenda agenda = agendaService.getAgendaById(agenda_id);
        agendaService.removeAgenda(agenda_id);
        
        return "redirect:/agenda/template";
    }

    // Posts
    @PostMapping("/agendar")
    public ModelAndView saveAgenda(
        @ModelAttribute Agenda agenda, 
        @RequestParam("date") String date,
        @RequestParam("hour") String hour) {      
            
        String str;  //mensagem de erro no html
        ModelAndView mv;

        String dataFormatada = date + " " + hour + ":00.000";
        Salao salao = agenda.getFuncionario().getSalao();

        if((str=agendaService.verifyAgenda(Timestamp.valueOf(dataFormatada),agenda.getFuncionario()))!=null){
            mv = new ModelAndView("agendaTemplate");
            mv.addObject("erro",str);
            mv.addObject("agenda", new Agenda());
            mv.addObject("agendas", agendaService.getAllAgendas());
            mv.addObject("clientes", clienteService.getAllClientes());
            mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
            return mv;
        }
        agenda.setData(Timestamp.valueOf(dataFormatada));
        agenda.setSalao(salao);
        agenda.getCliente().getAgendamento().add(agenda);

        agendaService.saveAgenda(agenda);
        return mv = new ModelAndView("redirect:/agenda/template");
    }
}
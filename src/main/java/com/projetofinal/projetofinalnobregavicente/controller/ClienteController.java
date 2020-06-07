package com.projetofinal.projetofinalnobregavicente.controller;

import com.projetofinal.projetofinalnobregavicente.entity.Cliente;
import com.projetofinal.projetofinalnobregavicente.services.AgendaService;
import com.projetofinal.projetofinalnobregavicente.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AgendaService agendaService;

    // Gets
    @GetMapping("/template")
    public ModelAndView getTemplate() {
        ModelAndView mv = new ModelAndView("clienteTemplate");
        mv.addObject("cliente", new Cliente());
        mv.addObject("clientes", clienteService.getAllClientes());
        return mv;
    }

    @GetMapping("/editar")
    public ModelAndView getCliente(@RequestParam Integer cliente_id) {
        ModelAndView mv = new ModelAndView("clienteEditar");
        mv.addObject("cliente", clienteService.getClienteById(cliente_id));
        return mv;
    }

    @GetMapping("/remove")
    public String removeCliente(@RequestParam Integer cliente_id) {
        Cliente cliente = clienteService.getClienteById(cliente_id);
        agendaService.removeAgendamentos(cliente);
        clienteService.removeCliente(cliente);
        
        return "redirect:/cliente/template";
    }

    // Posts
    @PostMapping("/cadastrar")
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/template";
    }
}
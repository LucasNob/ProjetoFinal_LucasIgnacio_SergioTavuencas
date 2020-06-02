package com.projetofinal.projetofinalnobregavicente.services;

import java.util.List;

import com.projetofinal.projetofinalnobregavicente.entity.Agenda;
import com.projetofinal.projetofinalnobregavicente.repository.AgendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

    public void saveAgenda(Agenda agenda) {
        agendaRepository.save(agenda);
    }

    public Agenda getAgendaById(int id) {
        return agendaRepository.findById(id).get();
    }

    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }
}
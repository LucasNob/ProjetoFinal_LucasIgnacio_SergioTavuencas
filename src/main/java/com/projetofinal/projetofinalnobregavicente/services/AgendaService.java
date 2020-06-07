package com.projetofinal.projetofinalnobregavicente.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.projetofinal.projetofinalnobregavicente.entity.Agenda;
import com.projetofinal.projetofinalnobregavicente.entity.Cliente;
import com.projetofinal.projetofinalnobregavicente.entity.Funcionario;
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

    public void removeAgenda(int id) {
        agendaRepository.deleteById(id);
    }

    public String verifyAgenda(Timestamp t,Funcionario f){
        int intervalo=30; //intervalo entre agendamentos em minutos
        List<Agenda> agendas = getAllAgendas();
        //Timestamp datainicial   = new Timestamp(System.currentTimeMillis()); //data e hora atual
        //Timestamp datafinal     = new Timestamp(System.currentTimeMillis());
        Calendar    datafinal= Calendar.getInstance(), 
                    datainicial = Calendar.getInstance(),
                    d=Calendar.getInstance();

        datafinal.setTimeInMillis(t.getTime());
        if(datafinal.before(datainicial))// impede agendamento no passado
            return "Data invalida";
        

        datainicial=datafinal;
        datafinal.add(Calendar.MINUTE, intervalo);

        for (Agenda a : agendas) 
        {
        if(a.getFuncionario().getId()==f.getId()){
            d.setTimeInMillis(a.getData().getTime());
        
            if(datainicial.before(d) && datafinal.after(d))
                return "Funcionario ja esta agendado nesta faixa horario";   
            }  
        }

        
          //  if(a.getFuncionario().getId()==f.getId() && a.getData().equals(t)) // impede o agendamento de um funcionario na mesma hora exata
              //  return "Funcionario ja esta agendado neste horario"; 
    
        return null;
    }

    public void removeAgendamentos(Funcionario func){
        int id= func.getId();
        for (Agenda a : agendaRepository.findAll()) {
            if(a.getFuncionario().getId() == id)
                agendaRepository.deleteById(a.getId());
        }
    }
    public void removeAgendamentos(Cliente cliente){
        int id= cliente.getId();
        for (Agenda a : agendaRepository.findAll()) {
            if(a.getCliente().getId() == id)
                agendaRepository.deleteById(a.getId());
        }
    }
}
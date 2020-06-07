package com.projetofinal.projetofinalnobregavicente.services;

import java.util.List;

import com.projetofinal.projetofinalnobregavicente.entity.Agenda;
import com.projetofinal.projetofinalnobregavicente.entity.Funcionario;
import com.projetofinal.projetofinalnobregavicente.repository.AgendaRepository;
import com.projetofinal.projetofinalnobregavicente.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    @Autowired
    AgendaRepository agendaRepository;

    public void saveFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public Funcionario getFuncionarioById(int id) {
        return funcionarioRepository.findById(id).get();
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void removeFuncionario(Funcionario funcionario) {
        funcionarioRepository.deleteById(funcionario.getId());
    } 
}
package com.projetofinal.projetofinalnobregavicente.services;

import java.util.List;

import com.projetofinal.projetofinalnobregavicente.entity.Salao;
import com.projetofinal.projetofinalnobregavicente.repository.SalaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaoService {
    
    @Autowired
    SalaoRepository salaoRepository;

    public void saveSalao(Salao salao) {
        salaoRepository.save(salao);
    }

    public Salao getSalaoById(int id) {
        return salaoRepository.findById(id).get();
    }

    public List<Salao> getAllSalaos() {
        return salaoRepository.findAll();
    }

    public void removeSalao(Salao salao) {
        salaoRepository.delete(salao);
    }
}
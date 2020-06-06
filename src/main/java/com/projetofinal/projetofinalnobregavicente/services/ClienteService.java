package com.projetofinal.projetofinalnobregavicente.services;

import java.util.List;

import com.projetofinal.projetofinalnobregavicente.entity.Cliente;
import com.projetofinal.projetofinalnobregavicente.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente getClienteById(int id) {
        return clienteRepository.findById(id).get();
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public void removeCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
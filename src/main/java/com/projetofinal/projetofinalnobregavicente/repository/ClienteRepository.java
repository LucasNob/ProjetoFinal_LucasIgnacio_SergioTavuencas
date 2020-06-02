package com.projetofinal.projetofinalnobregavicente.repository;

import com.projetofinal.projetofinalnobregavicente.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    
}
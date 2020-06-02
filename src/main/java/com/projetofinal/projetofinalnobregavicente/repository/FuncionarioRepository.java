package com.projetofinal.projetofinalnobregavicente.repository;

import com.projetofinal.projetofinalnobregavicente.entity.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {
    
}
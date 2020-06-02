package com.projetofinal.projetofinalnobregavicente.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Salao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;

    @OneToMany
    @JoinColumn(name = "SALAO_FUNC")
    private List<Funcionario> funcionarios;

    @OneToMany
    @JoinColumn(name = "SALAO_AGENDA")
    private List<Agenda> agendamentos;
    
}
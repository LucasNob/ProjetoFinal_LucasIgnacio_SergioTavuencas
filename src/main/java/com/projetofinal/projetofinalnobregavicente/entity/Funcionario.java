package com.projetofinal.projetofinalnobregavicente.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Funcionario implements Serializable{
    
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private String cpf;

    @ManyToOne
    @JoinColumn(name ="FUNCIONARIO_SALAO")
    private Salao salao;

    @OneToMany
    @JoinColumn(name="FUNCIONARIO_AGENDA")
    private List<Agenda> agendamentos;
}
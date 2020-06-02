package com.projetofinal.projetofinalnobregavicente.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Agenda implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean status;
    //implementar status no html

    @OneToOne
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="AGENDA_FUNCIOANRIO")
    private Funcionario funcioanrio;



    
}
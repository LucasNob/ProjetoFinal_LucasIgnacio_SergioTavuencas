package com.projetofinal.projetofinalnobregavicente.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente implements Serializable {

	/**
	 *
	 */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    @OneToOne
    @JoinColumn(name="AGENDA_CLIENTE")
    private Agenda agendamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Agenda getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agenda agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public String toString() {
        return "Cliente [agendamento=" + agendamento.getData() + ", cpf=" + cpf + ", id=" + id + ", nome=" + nome + ", telefone="
                + telefone + "]";
    }
} 
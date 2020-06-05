package com.projetofinal.projetofinalnobregavicente.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Agenda implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp data;
    //implementar status no html

    @OneToOne
    @JoinColumn(name="AGENDA_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="AGENDA_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name="AGENDA_SALAO")
    private Salao salao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }

    @Override
    public String toString() {
        return "Agenda [cliente=" + cliente.getNome() + ", data=" + data + ", funcionario=" + funcionario.getNome() + ", id=" + id
                + ", salao=" + salao.getNome() + "]";
    }

    
}
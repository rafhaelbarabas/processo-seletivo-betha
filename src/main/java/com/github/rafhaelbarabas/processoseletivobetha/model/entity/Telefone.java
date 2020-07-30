package com.github.rafhaelbarabas.processoseletivobetha.model.entity;

import javax.persistence.*;

public class Telefone {

    public Telefone() {
    }

    public Telefone(Integer id, Funcionario funcionario, String numero, String tipo, Boolean principal) {
        this.id = id;
        this.funcionario = funcionario;
        this.numero = numero;
        this.tipo = tipo;
        this.principal = principal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_funcionario")
    private Funcionario funcionario;

    @Column(length = 15, nullable = false) // TODO: Gravar sem formatacao
    private String numero;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Boolean principal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }
}

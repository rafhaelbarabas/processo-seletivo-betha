package com.github.rafhaelbarabas.processoseletivobetha.model.entity;

import javax.persistence.*;

@Entity
public class Telefone {

    public Telefone() {
    }

    public Telefone(Integer id, Funcionario funcionario, String numero, String tipo) {
        this.id = id;
        this.funcionario = funcionario;
        this.numero = numero;
        this.tipo = tipo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_funcionario", foreignKey = @ForeignKey(name="fk_telefone_funcionario"))
    private Funcionario funcionario;

    @Column(length = 15, nullable = false)
    private String numero;

    @Column(length = 1, nullable = false)
    private String tipo;

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
}

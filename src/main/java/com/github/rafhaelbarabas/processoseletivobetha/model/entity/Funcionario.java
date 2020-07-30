package com.github.rafhaelbarabas.processoseletivobetha.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Funcionario {

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String cpf, LocalDate dataAniversario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataAniversario = dataAniversario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "data_aniversario")
    private LocalDate dataAniversario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
// TODO: Criar entity Endereco e Telefone relacionado com Funcionario
}

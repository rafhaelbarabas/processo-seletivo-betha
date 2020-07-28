package com.github.rafhaelbarabas.processoseletivobetha.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Funcionario {

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String cpf, LocalDate data_aniversario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_aniversario = data_aniversario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    @Column
    private LocalDate data_aniversario;

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

    public LocalDate getData_aniversario() {
        return data_aniversario;
    }

    public void setData_aniversario(LocalDate data_aniversario) {
        this.data_aniversario = data_aniversario;
    }
// TODO: Criar entity Endereco e Telefone relacionado com Funcionario
}

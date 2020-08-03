package com.github.rafhaelbarabas.processoseletivobetha.api.rest.dto;

import java.util.Objects;

public class EnderecoDTO {

    private Integer idFuncionario;
    private String logradouro;
    private String cidade;
    private String uf;
    private String cep;
    private String principal;

    public EnderecoDTO() {
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoDTO that = (EnderecoDTO) o;
        return idFuncionario.equals(that.idFuncionario) &&
                logradouro.equals(that.logradouro) &&
                cidade.equals(that.cidade) &&
                uf.equals(that.uf) &&
                Objects.equals(cep, that.cep) &&
                Objects.equals(principal, that.principal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncionario, logradouro, cidade, uf, cep, principal);
    }

    @Override
    public String toString() {
        return "EnderecoDTO{" +
                "idFuncionario=" + idFuncionario +
                ", logradouro='" + logradouro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                ", principal='" + principal + '\'' +
                '}';
    }
}

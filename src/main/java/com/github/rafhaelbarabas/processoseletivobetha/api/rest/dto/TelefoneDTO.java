package com.github.rafhaelbarabas.processoseletivobetha.api.rest.dto;

import java.util.Objects;

public class TelefoneDTO {

    private Integer idFuncionario;
    private String numero;
    private String tipo;

    public TelefoneDTO() {
    }

    public TelefoneDTO(Integer idFuncionario, String numero, String tipo) {
        this.idFuncionario = idFuncionario;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefoneDTO that = (TelefoneDTO) o;
        return idFuncionario.equals(that.idFuncionario) &&
                numero.equals(that.numero) &&
                tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncionario, numero, tipo);
    }

    @Override
    public String toString() {
        return "TelefoneDTO{" +
                "idFuncionario=" + idFuncionario +
                ", numero='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

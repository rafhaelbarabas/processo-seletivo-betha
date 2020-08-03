package com.github.rafhaelbarabas.processoseletivobetha.model.repository;

import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Endereco;
import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
    @Query("SELECT t FROM Telefone t JOIN t.funcionario f WHERE f.id = :idFuncionario")
    List<Telefone> findByIdFuncionario(@Param("idFuncionario") Integer idFuncionario);
}

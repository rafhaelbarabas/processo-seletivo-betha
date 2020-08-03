package com.github.rafhaelbarabas.processoseletivobetha.model.repository;

import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT e FROM Endereco e JOIN e.funcionario f WHERE f.id = :idFuncionario")
    List<Endereco> findByIdFuncionario(@Param("idFuncionario") Integer idFuncionario);

}

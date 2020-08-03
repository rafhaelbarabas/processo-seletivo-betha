package com.github.rafhaelbarabas.processoseletivobetha.model.repository;

import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}

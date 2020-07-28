package com.github.rafhaelbarabas.processoseletivobetha.api.rest;

import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Funcionario;
import com.github.rafhaelbarabas.processoseletivobetha.model.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    private final FuncionarioRepository repository;

    public FuncionarioController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping
    public List<Funcionario> list() {
        return repository.findAll();
    }
}

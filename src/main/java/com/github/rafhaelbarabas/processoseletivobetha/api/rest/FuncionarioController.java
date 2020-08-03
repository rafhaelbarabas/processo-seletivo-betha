package com.github.rafhaelbarabas.processoseletivobetha.api.rest;

import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Funcionario;
import com.github.rafhaelbarabas.processoseletivobetha.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository repository;

    @Autowired
    public FuncionarioController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario save(@Valid @RequestBody Funcionario funcionario) throws Exception {
        return repository.save(funcionario);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository
            .findById(id)
                .map(funcionario -> {
                    repository.delete(funcionario);
                    return Void.TYPE;
                })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado."));
    }

    @GetMapping
    public List<Funcionario> list() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Funcionario findOne(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado."));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @Valid @RequestBody Funcionario funcionarioUpdated){
        repository.findById(id)
                .map( funcionario -> {
                    funcionarioUpdated.setId(funcionario.getId());
                    return repository.save(funcionarioUpdated);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado."));
    }
}
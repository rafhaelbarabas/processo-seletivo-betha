package com.github.rafhaelbarabas.processoseletivobetha.api.rest;

import com.github.rafhaelbarabas.processoseletivobetha.api.rest.dto.TelefoneDTO;
import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Funcionario;
import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Telefone;
import com.github.rafhaelbarabas.processoseletivobetha.model.repository.FuncionarioRepository;
import com.github.rafhaelbarabas.processoseletivobetha.model.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/telefones")
@CrossOrigin("*")
public class TelefoneController {

    private final TelefoneRepository repository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public TelefoneController(TelefoneRepository repository, FuncionarioRepository funcionarioRepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public Telefone save(@RequestBody TelefoneDTO dto){

        Telefone telefone = new Telefone();

        Integer idFuncionario = dto.getIdFuncionario();

        Funcionario funcionario = funcionarioRepository
                .findById(idFuncionario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionário não encontrado."));

        telefone.setNumero(dto.getNumero());
        telefone.setTipo(dto.getTipo());
        telefone.setFuncionario(funcionario);

        return repository.save(telefone);
    }

    @GetMapping
    public List<Telefone> listTelefones(@RequestParam(value = "idFuncionario", required = false) Integer idFuncionario){
        if(idFuncionario == null){
            return repository.findAll();
        }else{
            return repository.findByIdFuncionario(idFuncionario);
        }
    }
}

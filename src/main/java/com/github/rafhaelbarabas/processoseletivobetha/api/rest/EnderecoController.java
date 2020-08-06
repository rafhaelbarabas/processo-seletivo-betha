package com.github.rafhaelbarabas.processoseletivobetha.api.rest;

import com.github.rafhaelbarabas.processoseletivobetha.api.rest.dto.EnderecoDTO;
import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Endereco;
import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Funcionario;
import com.github.rafhaelbarabas.processoseletivobetha.model.repository.EnderecoRepository;
import com.github.rafhaelbarabas.processoseletivobetha.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecos")
@CrossOrigin("*")
public class EnderecoController {

    private final EnderecoRepository repository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public EnderecoController(EnderecoRepository repository, FuncionarioRepository funcionarioRepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public Endereco save(@RequestBody EnderecoDTO dto){

        Endereco endereco = new Endereco();

        Integer idFuncionario = dto.getIdFuncionario();

        Funcionario funcionario = funcionarioRepository
                .findById(idFuncionario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionário não encontrado."));

        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCidade(dto.getCidade());
        endereco.setUf(dto.getUf());
        endereco.setCep(dto.getCep());
        endereco.setPrincipal(Boolean.parseBoolean(dto.getPrincipal()));
        endereco.setFuncionario(funcionario);

        return repository.save(endereco);
    }

    @GetMapping
    public List<Endereco> listEnderecos(@RequestParam(value = "idFuncionario", required = false) Integer idFuncionario){
        if(idFuncionario == null){
            return repository.findAll();
        }else{
            return repository.findByIdFuncionario(idFuncionario);
        }
    }
}

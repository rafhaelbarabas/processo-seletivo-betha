package com.github.rafhaelbarabas.processoseletivobetha;

import com.github.rafhaelbarabas.processoseletivobetha.model.entity.Funcionario;
import com.github.rafhaelbarabas.processoseletivobetha.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ProcessoSeletivoBethaApplication {

	@Bean
	public CommandLineRunner CommandLineRunner(@Autowired FuncionarioRepository repository){
		return args -> {
			Funcionario funcionario = new Funcionario();
			funcionario.setNome("Rafhael Andrade");
			funcionario.setCpf("08588042983");
			funcionario.setDataAniversario(LocalDate.now());
			repository.save(funcionario);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProcessoSeletivoBethaApplication.class, args);
	}

}

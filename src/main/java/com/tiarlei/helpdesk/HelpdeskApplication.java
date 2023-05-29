package com.tiarlei.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiarlei.helpdesk.domain.Chamado;
import com.tiarlei.helpdesk.domain.Cliente;
import com.tiarlei.helpdesk.domain.Tecnico;
import com.tiarlei.helpdesk.domain.enums.Perfil;
import com.tiarlei.helpdesk.domain.enums.Prioridade;
import com.tiarlei.helpdesk.domain.enums.Status;
import com.tiarlei.helpdesk.repositories.ChamadoRepository;
import com.tiarlei.helpdesk.repositories.ClienteRepository;
import com.tiarlei.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Tiarlei Noeremberg", "48796577798", "tiarlei@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Santos Dumond", "24132688894", "santosdu@hotmail.com", "123");
	
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}

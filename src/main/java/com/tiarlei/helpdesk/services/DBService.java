package com.tiarlei.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiarlei.helpdesk.domain.Chamado;
import com.tiarlei.helpdesk.domain.Cliente;
import com.tiarlei.helpdesk.domain.Tecnico;
import com.tiarlei.helpdesk.domain.enums.Perfil;
import com.tiarlei.helpdesk.domain.enums.Prioridade;
import com.tiarlei.helpdesk.domain.enums.Status;
import com.tiarlei.helpdesk.repositories.ChamadoRepository;
import com.tiarlei.helpdesk.repositories.ClienteRepository;
import com.tiarlei.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Tiarlei Noeremberg", "809.932.000-01", "tiarlei@gmail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "866.038.320-62", "stallman@mail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "737.286.470-47", "shannon@mail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "575.640.860-68", "lee@mail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "812.839.840-75", "linus@mail.com", encoder.encode("123"));
		
		Cliente cli1 = new Cliente(null, "Santos Dumond", "114.866.520-00", "santosdu@hotmail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Albert Einstein", "878.125.920-49", "einstein@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Marie Curie", "009.507.300-09", "curie@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Charles Darwin", "737.834.090-12", "darwin@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Stephen Hawking", "370.506.910-11", "hawking@mail.com", encoder.encode("123"));
		Cliente cli6 = new Cliente(null, "Max Planck", "585.833.510-15", "planck@mail.com", encoder.encode("123"));
	
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
	}
}

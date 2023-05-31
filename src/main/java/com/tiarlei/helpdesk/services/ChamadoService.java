package com.tiarlei.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiarlei.helpdesk.domain.Chamado;
import com.tiarlei.helpdesk.domain.Cliente;
import com.tiarlei.helpdesk.domain.Tecnico;
import com.tiarlei.helpdesk.domain.dtos.ChamadoDTO;
import com.tiarlei.helpdesk.domain.enums.Prioridade;
import com.tiarlei.helpdesk.domain.enums.Status;
import com.tiarlei.helpdesk.repositories.ChamadoRepository;
import com.tiarlei.helpdesk.services.exception.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}
	
	public List<Chamado> findAll() {
		return repository.findAll();
	}
	
	public Chamado create(@Valid ChamadoDTO objDTO) {
		objDTO.setId(null);
		return repository.save(newChamado(objDTO));
	}
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
	}
}
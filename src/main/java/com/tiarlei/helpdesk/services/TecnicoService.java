package com.tiarlei.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiarlei.helpdesk.domain.Tecnico;
import com.tiarlei.helpdesk.domain.dtos.TecnicoDTO;
import com.tiarlei.helpdesk.repositories.TecnicoRepository;
import com.tiarlei.helpdesk.services.exception.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		//return obj.orElse(null);	//Caso objeto não encontrado, retorne null.
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}
}

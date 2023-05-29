package com.tiarlei.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiarlei.helpdesk.domain.Tecnico;
import com.tiarlei.helpdesk.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")	//adicionando rota
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
		Tecnico obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

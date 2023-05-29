package com.tiarlei.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiarlei.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}

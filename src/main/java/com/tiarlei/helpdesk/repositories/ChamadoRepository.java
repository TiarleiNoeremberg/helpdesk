package com.tiarlei.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiarlei.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}

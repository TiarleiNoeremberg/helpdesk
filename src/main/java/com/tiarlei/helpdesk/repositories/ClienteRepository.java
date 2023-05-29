package com.tiarlei.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiarlei.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

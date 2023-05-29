package com.tiarlei.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiarlei.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}

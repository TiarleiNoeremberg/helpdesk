package com.tiarlei.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiarlei.helpdesk.domain.Cliente;
import com.tiarlei.helpdesk.domain.enums.Perfil;

import jakarta.validation.constraints.NotNull;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L; 

	protected Integer id;
	@NotNull(message = "O campo NOME é requerido")
	protected String nome;
	@NotNull(message = "O campo CPF é requerido")
	protected String cpf;
	@NotNull(message = "O campo E-MAIL é requerido")
	protected String email;
	@NotNull(message = "O campo SENHA é requerido")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();	//Lista de Integer conflitará com o
														//parametro perfis do construtor com argumento.
														//na classe Pessoa a lista é convertida de Integer para lista de Perfil
														//nesta classe precisa ser feito o mesmo processo..
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public ClienteDTO() {
		super();
		addPerfis(Perfil.CLIENTE);
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		//Solucionando o problema da linha 20 "protected Set<Integer> perfis = new HashSet<>();"
		//fazendo a conversão do tipo primitivo.
		this.dataCriacao = obj.getDataCriacao();
		addPerfis(Perfil.CLIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*
	public Set<Perfil> getPerfis() {
		return perfis;
	}
	//Usando esta sentenca, os valores retornados no Postman, no item "perfis" sao
	//os codigos. Alterando parta sentenca abaixo, nos e retornado a descricao em perfis
	//em vez de "0, 1" retornará "CLIENTE, ADMIN"
	*/
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
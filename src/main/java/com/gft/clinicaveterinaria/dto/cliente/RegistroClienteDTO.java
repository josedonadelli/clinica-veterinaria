package com.gft.clinicaveterinaria.dto.cliente;

import java.util.Arrays;
import java.util.List;

import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;

public class RegistroClienteDTO {
	private Integer id;
	private String username;
	private String password;
	private List<String> roles;
	
	private String documento;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private List<Cachorro> cachorros;
	public RegistroClienteDTO() {
	}

	public RegistroClienteDTO(Integer id, String nome, String username, String password,List<String> roles, String documento, Endereco endereco, Contato contato) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.roles = roles;
	}
	
	public RegistroClienteDTO(Integer id, String nome, String username, String password, List<String> roles, String documento, Endereco endereco, Contato contato, List<Cachorro> cachorros ) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.cachorros = cachorros;
		this.roles = roles;
	}
	
	public RegistroClienteDTO(Integer id, String nome, String username, String password, List<String> roles, String documento, Endereco endereco, Contato contato, Cachorro cachorro ) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.roles = roles;
		this.cachorros = Arrays.asList(cachorro);
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Cachorro> getCachorros() {
		return cachorros;
	}

	public void setCachorros(List<Cachorro> cachorros) {
		this.cachorros = cachorros;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}

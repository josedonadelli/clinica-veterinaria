package com.gft.clinicaveterinaria.dto.veterinario;

import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;

public class RegistroVeterinarioDTO {
	private Integer id;
	private String username;
	private String password;
	private String crmv;
	private String nome;
	private Endereco endereco;
	private Contato contato;

	public RegistroVeterinarioDTO() {
	}

	public RegistroVeterinarioDTO(Integer id, String nome, String username, String password, String crmv, Endereco endereco, Contato contato) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.crmv = crmv;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crvm) {
		this.crmv = crvm;
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

}

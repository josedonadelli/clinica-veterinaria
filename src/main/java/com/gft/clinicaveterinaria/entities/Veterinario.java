package com.gft.clinicaveterinaria.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veterinario")
@PrimaryKeyJoinColumn(name = "id_user")
public class Veterinario extends Usuario{

	@Column(name = "veterinario_id", nullable = false, unique = true)
	private String crmv;
	@Column(name = "nome", unique = true)
	private String nome;
	private Endereco endereco;
	private Contato contato;

	public Veterinario() {
		super();
	}

	public Veterinario(Integer id, String nome, String username, String password, String crmv,  Endereco endereco, Contato contato) {
		super(id, nome, username, password, Arrays.asList("USERS", "MANAGERS"));
		this.crmv = crmv;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}

	/*
	 * public Veterinario(String crmv, String nome, Endereco endereco, Contato
	 * contato) { this.crmv = crmv; this.nome = nome; this.endereco = endereco;
	 * this.contato = contato; }
	 */
	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
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

}

package com.gft.clinicaveterinaria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	// TODO - refatorar código. Razao: fazendo igual ao passo a passo do vídeo.
	// Necessário refatorar para aplicar no código
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role_id")
	private List<String> roles = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(Integer id, String nome, String username, String password, List<String> roles) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.roles = roles;
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

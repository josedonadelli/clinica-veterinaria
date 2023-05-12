package com.gft.clinicaveterinaria.entities;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
@PrimaryKeyJoinColumn(name = "id_user")
public class Cliente extends Usuario{

	@Column(name = "cliente_id", nullable = false, unique = true)
	private String documento;

	private String nome;
	private Endereco endereco;
	private Contato contato;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Cachorro> cachorros;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String username, String password, String documento,  Endereco endereco, Contato contato) {
		super(id, nome, username, password, Arrays.asList("USERS"));
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Cliente(Integer id, String nome, String username, String password, String documento,  Endereco endereco, Contato contato, List<Cachorro> cachorros) {
		super(id, nome, username, password, Arrays.asList("USERS"));
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.cachorros = cachorros;
	}
	
	/*
	 * public Cliente(String documento, String nome, Endereco endereco, Contato
	 * contato, List<Cachorro> cachorros) { this.documento = documento; this.nome =
	 * nome; this.endereco = endereco; this.contato = contato; this.cachorros =
	 * cachorros; }
	 */

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
	

}

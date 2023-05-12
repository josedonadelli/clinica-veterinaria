package com.gft.clinicaveterinaria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cachorro")
public class Cachorro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dog_id")
	private Long id;
	private String nome;

	@ManyToOne
	@JoinTable(name = "tb_cachorro_raca", joinColumns = @JoinColumn(name = "cachorro_id"), inverseJoinColumns = @JoinColumn(name = "raca_id"))
	private Raca raca;
	// private String raca;

	@OneToMany(mappedBy = "cachorro", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Consulta> historicoConsultas;

	//@ManyToOne(optional = false)
	@ManyToOne
	@JoinTable(name = "tb_tutor", joinColumns = @JoinColumn(name = "cachorro_id"), inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	@JsonIgnore
	private Cliente cliente;

	public Cachorro() {
	}

	public Cachorro(Long id, String nome, Raca raca, Cliente cliente) {
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.cliente = cliente;
	}

	public Cachorro(Long id, String nome, Raca raca, Cliente cliente, List<Consulta> historicoConsultas) {
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.cliente = cliente;
		this.historicoConsultas = historicoConsultas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Consulta> getHistoricoConsultas() {
		return historicoConsultas;
	}

	public void setHistoricoConsultas(List<Consulta> historicoConsultas) {
		this.historicoConsultas = historicoConsultas;
	}

}

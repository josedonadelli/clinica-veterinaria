package com.gft.clinicaveterinaria.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "veterinario_id")
	private Veterinario veterinario;


	@ManyToOne
	@JoinTable(name = "tb_consulta_cachorro", joinColumns = @JoinColumn(name = "consulta_id"), inverseJoinColumns = @JoinColumn(name = "cachorro_id"))

	@JsonIgnore
	private Cachorro cachorro;

	private Date data; // TODO Trocar DATATIME para DATA e TIME (quebrar em 2 atributos)
	private Double peso;
	private Double altura;
	private int idade;
	private String diagnostico;
	private String comentarios;

	public Consulta() {
	}

	public Consulta(Long id, Veterinario veterinario, Cachorro cachorro, Date data, Double peso, Double altura,
			int idade, String diagnostico, String comentarios) {
		cachorro.setHistoricoConsultas(null);
		this.id = id;
		this.veterinario = veterinario;
		this.cachorro = cachorro;
		this.data = data;
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.diagnostico = diagnostico;
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Cachorro getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}

}

package com.gft.clinicaveterinaria.dto.consulta;

import java.util.Date;

import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Veterinario;

public class RegistroConsultaDTO {

	Veterinario veterinario;
	Cachorro cachorro;
	private Date data;
	private Double peso;
	private Double altura;
	private int idade;
	private String diagnostico;
	private String comentarios;

	public RegistroConsultaDTO() {
	}

	public RegistroConsultaDTO(Veterinario veterinario, Cachorro cachorro, Date data, Double peso, Double altura,
			int idade, String diagnostico, String comentarios) {
		this.veterinario = veterinario;
		this.cachorro = cachorro;
		this.data = data;
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.diagnostico = diagnostico;
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

}

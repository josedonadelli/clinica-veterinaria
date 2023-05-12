package com.gft.clinicaveterinaria.dto.veterinario;

import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;

public class ConsultaVeterinarioDTO {

	private String crvm;
	private String nome;
	private Endereco endereco;
	private Contato contato;

	public ConsultaVeterinarioDTO() {
	}

	public ConsultaVeterinarioDTO(String crvm, String nome, Endereco endereco, Contato contato) {
		this.crvm = crvm;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}

	public String getCrvm() {
		return crvm;
	}

	public void setCrvm(String crvm) {
		this.crvm = crvm;
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

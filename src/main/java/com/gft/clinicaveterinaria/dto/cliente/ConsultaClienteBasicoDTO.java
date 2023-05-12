package com.gft.clinicaveterinaria.dto.cliente;

import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;

public class ConsultaClienteBasicoDTO {
	private String documento;

	private String nome;
	private Endereco endereco;
	private Contato contato;

	public ConsultaClienteBasicoDTO() {
	}

	public ConsultaClienteBasicoDTO(String documento, String nome, Endereco endereco, Contato contato) {
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
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

}

package com.gft.clinicaveterinaria.dto.cliente;

import java.util.Arrays;
import java.util.List;

import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;

public class ConsultaClienteDTO {

	private String documento;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private List<Cachorro> cachorros;
	public ConsultaClienteDTO() {
	}

	public ConsultaClienteDTO(String documento, String nome, Endereco endereco, Contato contato) {
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public ConsultaClienteDTO(String documento, String nome, Endereco endereco, Contato contato, List<Cachorro> cachorros) {
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.cachorros = cachorros;
	}
	
	public ConsultaClienteDTO(String documento, String nome, Endereco endereco, Contato contato, Cachorro cachorro) {
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
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

	
}

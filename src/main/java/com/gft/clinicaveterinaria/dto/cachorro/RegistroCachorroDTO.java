package com.gft.clinicaveterinaria.dto.cachorro;

import java.util.Arrays;
import java.util.List;

import com.gft.clinicaveterinaria.entities.Cliente;
import com.gft.clinicaveterinaria.entities.Consulta;
import com.gft.clinicaveterinaria.entities.Raca;

public class RegistroCachorroDTO {

	private String nome;
	private Raca raca;
	private Cliente cliente;// Objeto cliente, ou apenas um Integer para guardar o documento (pk)?
	private List<Consulta> historicoConsulta;
	
	public RegistroCachorroDTO() {
	}

	public RegistroCachorroDTO(String nome, Raca raca, Cliente cliente) {
		this.nome = nome;
		this.raca = raca;
		this.cliente = cliente;
	}
	
	

	

	public RegistroCachorroDTO(String nome, Raca raca, Cliente cliente, List<Consulta> historicoConsulta) {
		this.nome = nome;
		this.raca = raca;
		this.cliente = cliente;
		this.historicoConsulta = historicoConsulta;
	}
	
	public RegistroCachorroDTO(String nome, Raca raca, Cliente cliente, Consulta consulta) {
		this.nome = nome;
		this.raca = raca;
		this.cliente = cliente;
		this.historicoConsulta = Arrays.asList(consulta);
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

	public List<Consulta> getHistoricoConsulta() {
		return historicoConsulta;
	}

	public void setHistoricoConsulta(List<Consulta> historicoConsulta) {
		this.historicoConsulta = historicoConsulta;
	}

	
}

package com.gft.clinicaveterinaria.dto.raca;

public class ConsultaRacaSimplesDTO {
	private Long idRaca;
	private Long id;
	private String nome;
	

	public ConsultaRacaSimplesDTO() {
	}



	public ConsultaRacaSimplesDTO(Long idRaca, Long id, String nome) {
		this.idRaca = idRaca;
		this.id = id;
		this.nome = nome;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public Long getIdRaca() {
		return idRaca;
	}



	public void setIdRaca(Long idRaca) {
		this.idRaca = idRaca;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



}

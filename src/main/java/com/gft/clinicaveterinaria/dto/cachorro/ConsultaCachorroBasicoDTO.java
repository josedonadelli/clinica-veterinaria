package com.gft.clinicaveterinaria.dto.cachorro;

public class ConsultaCachorroBasicoDTO {
	private Long id;
	private String nome;
	private String raca;
	private String nomeTutor;
	private String documentoTutor;

	public ConsultaCachorroBasicoDTO() {
	}

	public ConsultaCachorroBasicoDTO(Long id, String nome, String raca, String nomeTutor, String documentoTutor) {
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.nomeTutor = nomeTutor;
		this.documentoTutor = documentoTutor;
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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNomeTutor() {
		return nomeTutor;
	}

	public void setNomeTutor(String nomeTutor) {
		this.nomeTutor = nomeTutor;
	}

	public String getDocumentoTutor() {
		return documentoTutor;
	}

	public void setDocumentoTutor(String documentoTutor) {
		this.documentoTutor = documentoTutor;
	}

}

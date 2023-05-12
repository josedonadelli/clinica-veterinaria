package com.gft.clinicaveterinaria.dto.consulta;

import java.util.Date;

public class ConsultaConsultaBasicoDTO {
	private Long id;
	private String nomeVeterinario;
	private String crmvVeterinario;
	private String nomeCachorro;
	private Long idCachorro;

	private Date data;
	private Double peso;
	private Double altura;
	private int idade;
	private String diagnostico;
	private String comentarios;

	public ConsultaConsultaBasicoDTO() {
	}

	public ConsultaConsultaBasicoDTO(Long id, String nomeVeterinario, String crmvVeterinario, String nomeCachorro,
			Long idCachorro, Date data, Double peso, Double altura, int idade, String diagnostico, String comentarios) {
		this.id = id;
		this.nomeVeterinario = nomeVeterinario;
		this.crmvVeterinario = crmvVeterinario;
		this.nomeCachorro = nomeCachorro;
		this.idCachorro = idCachorro;
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

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}

	public String getCrmvVeterinario() {
		return crmvVeterinario;
	}

	public void setCrmvVeterinario(String crmvVeterinario) {
		this.crmvVeterinario = crmvVeterinario;
	}

	public String getNomeCachorro() {
		return nomeCachorro;
	}

	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}

	public Long getIdCachorro() {
		return idCachorro;
	}

	public void setIdCachorro(Long idCachorro) {
		this.idCachorro = idCachorro;
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

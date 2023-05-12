package com.gft.clinicaveterinaria.dto.cliente;

import java.util.List;

import com.gft.clinicaveterinaria.entities.Consulta;

public class ConsultaClienteCachorroDTO {
	private Long cachorroId;
	private String nomeCachorro;
	private List<Consulta> historicoConsulta;
	
	
	public ConsultaClienteCachorroDTO() {
	}
	public ConsultaClienteCachorroDTO(Long cachorroId, String nomeCachorro, List<Consulta> historicoConsulta) {
		this.cachorroId = cachorroId;
		this.nomeCachorro = nomeCachorro;
		this.historicoConsulta = historicoConsulta;
	}
	public Long getCachorroId() {
		return cachorroId;
	}
	public void setCachorroId(Long cachorroId) {
		this.cachorroId = cachorroId;
	}
	public String getNomeCachorro() {
		return nomeCachorro;
	}
	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}
	public List<Consulta> getHistoricoConsulta() {
		return historicoConsulta;
	}
	public void setHistoricoConsulta(List<Consulta> historicoConsulta) {
		this.historicoConsulta = historicoConsulta;
	}
	
	
}

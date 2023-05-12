package com.gft.clinicaveterinaria.dto.cachorro;

import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Raca;

public class CachorroMapper {

	public static ConsultaCachorroDTO fromEntity(Cachorro cachorro) {
		return new ConsultaCachorroDTO(cachorro.getId(), cachorro.getNome(), cachorro.getRaca(), cachorro.getCliente(), cachorro.getHistoricoConsultas());
	}
	
	public static Cachorro fromDTO(RegistroCachorroDTO dto) {
		
		return new Cachorro(null, dto.getNome(), new Raca(dto.getRaca().getIdAPI(), dto.getRaca().getName()), dto.getCliente(), dto.getHistoricoConsulta());
	}
	
	public static ConsultaCachorroBasicoDTO basicoFromEntity(Cachorro cachorro) {
		String nomeTutor = null;
		String documentoTutor = null;
		
		if(cachorro.getCliente()!=null) {
			nomeTutor = cachorro.getCliente().getNome();
			documentoTutor = cachorro.getCliente().getDocumento();
		}
		return new ConsultaCachorroBasicoDTO(cachorro.getId(), cachorro.getNome(), cachorro.getRaca().getName(), nomeTutor, documentoTutor); 
	}
	
	/*
	 * public static ConsultaApiRacaDTO racaFromEntity(Raca raca) { return new
	 * ConsultaApiRacaDTO(raca.getId(), raca.getName(), raca.getBreed_for(),
	 * raca.getBreed_group(), raca.getLife_span(), raca.getTemperament(),
	 * raca.getOrigin()); }
	 */
	
	public static ConsultaApiRacaDTO racaFromEntity(Raca raca) {
		return new ConsultaApiRacaDTO(raca.getId(), raca.getName(), raca.getBred_for(), raca.getBreed_group(), raca.getLife_span(), raca.getTemperament(), raca.getOrigin(), raca.getHeight(), raca.getWeight());
	}
}

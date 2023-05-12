package com.gft.clinicaveterinaria.dto.raca;

import com.gft.clinicaveterinaria.entities.Raca;

public class RacaMapper {

	public static ConsultaRacaDTO fromEntity(Raca raca) {
		return new ConsultaRacaDTO(raca.getId(), raca.getIdAPI(), raca.getName(), raca.getBred_for(),
				raca.getBreed_group(), raca.getLife_span(), raca.getOrigin(), raca.getTemperament(), raca.getHeight(),
				raca.getWeight());
	}

	public static Raca fromDTO(RegistroRacaDTO dto) {
		return new Raca(null, dto.getIdAPI(), dto.getName(), dto.getBred_for(), dto.getBreed_group(),
				dto.getLife_span(), dto.getTemperament(), dto.getOrigin(), dto.getHeight(), dto.getWeight());
	}

	public static ConsultaRacaSimplesDTO fromApiEntity(Raca raca) {
		return new ConsultaRacaSimplesDTO(raca.getId(), raca.getIdAPI(), raca.getName());
	}
}

package com.gft.clinicaveterinaria.dto.veterinario;

import com.gft.clinicaveterinaria.entities.Veterinario;

public class VeterinarioMapper {

	public static ConsultaVeterinarioDTO fromEntity(Veterinario vet) {
		return new ConsultaVeterinarioDTO(vet.getCrmv(), vet.getNome(), vet.getEndereco(), vet.getContato());
	}
	
	public static Veterinario fromDTO(RegistroVeterinarioDTO dto) {
		return new Veterinario(null, dto.getNome(), dto.getUsername(), dto.getPassword(),dto.getCrmv(),dto.getEndereco(), dto.getContato());
	}
}

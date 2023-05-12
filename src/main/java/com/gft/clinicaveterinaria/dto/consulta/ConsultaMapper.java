package com.gft.clinicaveterinaria.dto.consulta;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.gft.clinicaveterinaria.entities.Consulta;

public class ConsultaMapper {

	public static ConsultaConsultaDTO fromEntity(Consulta consulta) {
		return new ConsultaConsultaDTO(consulta.getId(),consulta.getCachorro(), consulta.getData(), consulta.getPeso(), consulta.getAltura(), consulta.getIdade(), consulta.getDiagnostico(), consulta.getComentarios(), consulta.getVeterinario());
	}
	
	public static Consulta fromDTO(RegistroConsultaDTO dto) {
		return new Consulta(null,dto.getVeterinario(), dto.getCachorro(), dto.getData(), dto.getPeso(), dto.getAltura(), dto.getIdade(), dto.getDiagnostico(), dto.getComentarios());
	}
	
	public static ConsultaConsultaBasicoDTO fromEntityBasico(Consulta consulta) {
		return new ConsultaConsultaBasicoDTO(consulta.getId(), consulta.getVeterinario().getNome(), consulta.getVeterinario().getCrmv(), consulta.getCachorro().getNome(), consulta.getCachorro().getId(),
												consulta.getData(), consulta.getPeso(), consulta.getAltura(), consulta.getIdade(), consulta.getDiagnostico(), consulta.getComentarios()) ;
	}
	
	public static Page<ConsultaConsultaBasicoDTO> toPageFromEntity(Pageable pageable, List<Consulta> consultas){
		final Page<ConsultaConsultaBasicoDTO> page = new PageImpl<>(consultas, pageable, consultas.size()).map(ConsultaMapper::fromEntityBasico);
		
		return page;
	}
}

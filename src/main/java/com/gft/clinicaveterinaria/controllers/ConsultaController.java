package com.gft.clinicaveterinaria.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.clinicaveterinaria.dto.consulta.ConsultaConsultaBasicoDTO;
import com.gft.clinicaveterinaria.dto.consulta.ConsultaConsultaDTO;
import com.gft.clinicaveterinaria.dto.consulta.ConsultaMapper;
import com.gft.clinicaveterinaria.dto.consulta.RegistroConsultaDTO;
import com.gft.clinicaveterinaria.entities.Consulta;
import com.gft.clinicaveterinaria.services.ConsultaService;

@RestController
@RequestMapping("/v1/consultas")
public class ConsultaController {
	
	private final ConsultaService consultaService;


	
	public ConsultaController(ConsultaService consultaService) {
		this.consultaService = consultaService;
	}


	
	@GetMapping
	public ResponseEntity<Page<ConsultaConsultaDTO>> listarConsultas(@PageableDefault Pageable pageable){
		return ResponseEntity.ok(consultaService.listarConsultas(pageable).map(ConsultaMapper::fromEntity));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaConsultaBasicoDTO> buscarConsulta(@PathVariable Long id){
		return ResponseEntity.ok(ConsultaMapper.fromEntityBasico(consultaService.buscarConsulta(id)));
	}

	@PostMapping
	public ResponseEntity<ConsultaConsultaDTO> salvarConsulta(@RequestBody RegistroConsultaDTO dto){
		Consulta consulta = ConsultaMapper.fromDTO(dto);
		return ResponseEntity.ok(ConsultaMapper.fromEntity(consultaService.salvarConsulta(consulta)));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaConsultaDTO> alterarConsulta(@RequestBody RegistroConsultaDTO dto, @PathVariable Long id){
		Consulta consulta = consultaService.alterarConsulta(ConsultaMapper.fromDTO(dto), id);
		return ResponseEntity.ok(ConsultaMapper.fromEntity(consulta));
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaConsultaDTO> excluirConsulta(@PathVariable Long id){
		consultaService.excluirConsulta(id);
		return ResponseEntity.ok().build();
	}
}

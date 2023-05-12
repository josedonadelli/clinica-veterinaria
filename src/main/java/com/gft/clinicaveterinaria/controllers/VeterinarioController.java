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

import com.gft.clinicaveterinaria.dto.veterinario.ConsultaVeterinarioDTO;
import com.gft.clinicaveterinaria.dto.veterinario.RegistroVeterinarioDTO;
import com.gft.clinicaveterinaria.dto.veterinario.VeterinarioMapper;
import com.gft.clinicaveterinaria.entities.Veterinario;
import com.gft.clinicaveterinaria.services.VeterinarioService;

@RestController
@RequestMapping("/v1/veterinarios")
public class VeterinarioController {
	
	VeterinarioService veterinarioService;
	
	
	public VeterinarioController(VeterinarioService veterinarioService) {
		this.veterinarioService = veterinarioService;
	}


	@GetMapping
	public ResponseEntity<Page<ConsultaVeterinarioDTO>> listarVeterinarios(@PageableDefault Pageable pageable){
		return ResponseEntity.ok(veterinarioService.listarVeterinarios(pageable).map(VeterinarioMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaVeterinarioDTO> salvarVeterinario(@RequestBody RegistroVeterinarioDTO dto){
		Veterinario veterinario = VeterinarioMapper.fromDTO(dto);
		if(veterinario.getCrmv() != null)
			return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinarioService.salvarVeterinario(veterinario)));
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("{crmv}")
	public ResponseEntity<ConsultaVeterinarioDTO> buscarVeterinario(@PathVariable String crmv){
		return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinarioService.buscarVeterinario(crmv))) ;
	}
	
	@PutMapping("{crmv}")
	public ResponseEntity<ConsultaVeterinarioDTO> alterarVeterinario(@RequestBody RegistroVeterinarioDTO dto, @PathVariable String crmv){
		Veterinario veterinario = veterinarioService.alterarVeterinario(VeterinarioMapper.fromDTO(dto), crmv);
		return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinario));
	}
	
	@DeleteMapping("{crmv}")
	public ResponseEntity<ConsultaVeterinarioDTO> excluirVeterinario(@PathVariable String crmv){
		veterinarioService.excluirVeterinario(crmv);
		return ResponseEntity.ok().build();
	}
		
	
}

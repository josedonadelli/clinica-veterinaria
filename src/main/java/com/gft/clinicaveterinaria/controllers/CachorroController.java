package com.gft.clinicaveterinaria.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

import com.gft.clinicaveterinaria.dto.cachorro.CachorroMapper;
import com.gft.clinicaveterinaria.dto.cachorro.ConsultaApiRacaDTO;
import com.gft.clinicaveterinaria.dto.cachorro.ConsultaCachorroBasicoDTO;
import com.gft.clinicaveterinaria.dto.cachorro.ConsultaCachorroDTO;
import com.gft.clinicaveterinaria.dto.cachorro.RegistroCachorroDTO;
import com.gft.clinicaveterinaria.dto.consulta.ConsultaConsultaBasicoDTO;
import com.gft.clinicaveterinaria.dto.consulta.ConsultaMapper;
import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Consulta;
import com.gft.clinicaveterinaria.entities.Raca;
import com.gft.clinicaveterinaria.services.CachorroService;
import com.gft.clinicaveterinaria.services.RacaService;

@RestController
@RequestMapping("v1/cachorros")
public class CachorroController {
	private final CachorroService cachorroService;
	private final RacaService racaService;

	public CachorroController(CachorroService cachorroService, RacaService racaService) {
		this.cachorroService = cachorroService;
		this.racaService = racaService;
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaCachorroBasicoDTO>> listarCachorros(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(cachorroService.listarCachorros(pageable).map(CachorroMapper::basicoFromEntity));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaCachorroBasicoDTO> buscarCachorro(@PathVariable Long id) {
		return ResponseEntity.ok(CachorroMapper.basicoFromEntity(cachorroService.buscarCachorro(id)));
	}

	@GetMapping("{id}/consultas")
	public ResponseEntity<Page<ConsultaConsultaBasicoDTO>> buscarConsultaCachorro(@PageableDefault Pageable pageable,
			@PathVariable Long id) {

		List<Consulta> consultas = cachorroService.buscarCachorro(id).getHistoricoConsultas();

		return ResponseEntity.ok(ConsultaMapper.toPageFromEntity(pageable, consultas));
	}

	@PostMapping
	public ResponseEntity<ConsultaCachorroBasicoDTO> salvarCachorro(@RequestBody RegistroCachorroDTO dto) {
		Cachorro cachorro = cachorroService.salvarCachorro(CachorroMapper.fromDTO(dto));
		
		
		return ResponseEntity.ok(CachorroMapper.basicoFromEntity(cachorro));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaCachorroDTO> alterarCachorro(@RequestBody RegistroCachorroDTO dto,
			@PathVariable Long id) {
		Cachorro cachorro = cachorroService.alterarCachorro(CachorroMapper.fromDTO(dto), id);
		return ResponseEntity.ok(CachorroMapper.fromEntity(cachorro));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaCachorroDTO> excluirCachorro(@PathVariable Long id) {
		cachorroService.excluirCachorro(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("raca/{nome}")
	public ResponseEntity<List<ConsultaApiRacaDTO>> buscarRaca(@PathVariable String nome) {
		List<Raca> racas = racaService.buscarRaca(nome);
		if (racas == null)
			racas = Arrays.asList(racaService.buscarRacaPorNome(nome));
		
		return ResponseEntity.ok(racas.stream().map(CachorroMapper::racaFromEntity).collect(Collectors.toList()));
	}
}

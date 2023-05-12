package com.gft.clinicaveterinaria.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.clinicaveterinaria.dto.raca.ConsultaRacaSimplesDTO;
import com.gft.clinicaveterinaria.dto.raca.RacaMapper;
import com.gft.clinicaveterinaria.entities.Raca;
import com.gft.clinicaveterinaria.services.RacaService;

@RestController
@RequestMapping("v1/racas")
public class RacaController {

	private final RacaService racaService;

	public RacaController(RacaService racaService) {
		this.racaService = racaService;
	}

	@GetMapping // TODO Paginaçao não está funcionando como esperado por conta do retorno ser um
				// PageImpl()
	public ResponseEntity<Page<ConsultaRacaSimplesDTO>> listarTodasAsRacas(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(racaService.listarRacasAPI(pageable).map(RacaMapper::fromApiEntity));
	}

	@GetMapping("{nome}")
	public ResponseEntity<List<ConsultaRacaSimplesDTO>> buscarRacaPorNome(@PathVariable String nome) {
		List<Raca> racas;
		racas = Arrays.asList(racaService.buscarRacaPorNome(nome));

		return ResponseEntity.ok(racas.stream().map(RacaMapper::fromApiEntity).collect(Collectors.toList()));
	}

}

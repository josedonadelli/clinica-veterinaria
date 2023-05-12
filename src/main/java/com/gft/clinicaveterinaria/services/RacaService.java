package com.gft.clinicaveterinaria.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.gft.clinicaveterinaria.entities.Raca;
import com.gft.clinicaveterinaria.exception.EntityNotFoundException;
import com.gft.clinicaveterinaria.repositories.RacaRepository;

@Service
public class RacaService {

	private final RacaRepository racaRepository;

	public RacaService(RacaRepository racaRepository) {
		this.racaRepository = racaRepository;
	}

	public Raca salvarRaca(Raca raca) {
		try {
			raca = buscarRacaIdAPI(raca.getId());
		} catch (Exception e) {
		}
		return racaRepository.save(raca);
	}

	public Page<Raca> listarRacas(Pageable pageable) {
		return racaRepository.findAll(pageable);
	}

	public Raca buscarRacaIdAPI(Long id) {
		Optional<Raca> raca = racaRepository.findByIdAPI(id);
		if (!raca.isEmpty())
			System.out.println("RACA ID API " + raca.get().getIdAPI());
		return raca.orElseThrow(() -> new EntityNotFoundException("IdAPI nao encontrado"));
	}

	public Raca buscarRaca(Long id) {
		Optional<Raca> raca = racaRepository.findById(id);
		return raca.orElseThrow(() -> new EntityNotFoundException("IdAPI nao encontrado"));
	}

	public Page<Raca> buscarRaca(Pageable pageable, String nome) {
		return racaRepository.findByNameContains(pageable, nome);
	}

	public List<Raca> buscarRaca(String nome) {
		return racaRepository.findByNameContains(nome);
	}

	public Raca buscarRacaNomeRepo(String nome) {
		Optional<Raca> raca = racaRepository.findByName(nome);
		return raca.orElseThrow(() -> new EntityNotFoundException("Nome da raca nao encontrada no banco"));
	}

	// API

	public Page<Raca> listarRacasAPI(Pageable pageable) {
		List<Raca> racas;
		Page<Raca> racasPage;
		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("api.thedogapi.com/v1")
				.path("breeds").build();
		ResponseEntity<Raca[]> raca = template.getForEntity(uri.toUriString(), Raca[].class);

		racas = Arrays.asList(raca.getBody());
		racasPage = new PageImpl<Raca>(racas, pageable, racas.size());
		return racasPage;
	}

	public Raca[] buscarRacaPorNome(String nome) {

		RestTemplate template = new RestTemplate();

		// https://api.thedogapi.com/v1/breeds
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("api.thedogapi.com/v1")
				.path("breeds/search").queryParam("q", nome).build();

		ResponseEntity<Raca[]> raca = template.getForEntity(uri.toUriString(), Raca[].class);
		return raca.getBody();
	}

	public Raca buscarRacaNaAPIPorId(Long id) {

		RestTemplate template = new RestTemplate();

		// https://api.thedogapi.com/v1/breeds
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("api.thedogapi.com/v1")
				.path("breeds/" + id).build();

		ResponseEntity<Raca> raca = template.getForEntity(uri.toUriString(), Raca.class);
		return raca.getBody();
	}

}

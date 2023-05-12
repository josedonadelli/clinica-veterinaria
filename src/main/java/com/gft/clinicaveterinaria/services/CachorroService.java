package com.gft.clinicaveterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Cliente;
import com.gft.clinicaveterinaria.entities.Raca;
import com.gft.clinicaveterinaria.exception.EntityNotFoundException;
import com.gft.clinicaveterinaria.repositories.CachorroRepository;

@Service
public class CachorroService {

	private final CachorroRepository cachorroRepository;
	@Autowired
	private RacaService racaService;
	@Lazy
	@Autowired
	private ClienteService clienteService;

	public CachorroService(CachorroRepository cachorroRepository) {
		this.cachorroRepository = cachorroRepository;
	}

	public Page<Cachorro> listarCachorros(Pageable pageable) {
		return cachorroRepository.findAll(pageable);
	}

	public List<Cachorro> listarCachorros() {
		return cachorroRepository.findAll();
	}

	public Cachorro buscarCachorro(Long id) {
		Optional<Cachorro> cachorro = cachorroRepository.findById(id);
		return cachorro.orElseThrow(() -> new EntityNotFoundException("Cachorro não encontrado."));
	}

	public Cachorro salvarCachorro(Cachorro cachorro) {
		Raca raca;
		Raca aux = cachorro.getRaca();
		System.out.println(aux.getIdAPI() + " " + aux.getName());// TODO APAGAR SYSOUR
		
		
		if(aux.getIdAPI() != null) {
			try {
				raca = racaService.buscarRacaIdAPI(aux.getIdAPI());
			} catch (Exception e) {
				raca = racaService.buscarRacaNaAPIPorId(aux.getIdAPI());
				raca.setIdAPI(aux.getIdAPI());
				raca = racaService.salvarRaca(raca);
			}
		}else {
			raca = racaService.buscarRaca(2L);
		}

		Cliente cliente = clienteService.buscarCliente(cachorro.getCliente().getDocumento());
		cachorro.setRaca(raca);
		cachorro.setCliente(cliente);
		return cachorroRepository.save(cachorro);
	}

	public Cachorro alterarCachorro(Cachorro cachorro, Long id) {
		Cachorro original = buscarCachorro(id);
		cachorro.setId(original.getId());
		return cachorroRepository.save(cachorro);
	}

	public void excluirCachorro(Long id) {
		Cachorro cachorro = buscarCachorro(id);
		cachorroRepository.delete(cachorro);
	}

	/*
	 * public Raca[] buscaRacaAPI(String nome) { return
	 * ConsumeAPI.racaPorNome(nome); }
	 */
}

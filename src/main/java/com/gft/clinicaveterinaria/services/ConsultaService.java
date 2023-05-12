package com.gft.clinicaveterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.clinicaveterinaria.entities.Consulta;
import com.gft.clinicaveterinaria.exception.EntityNotFoundException;
import com.gft.clinicaveterinaria.repositories.ConsultaRepository;

@Service
public class ConsultaService {

	private final ConsultaRepository consultaRepository;

	public ConsultaService(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;
	}

	public Page<Consulta> listarConsultas(Pageable pageable) {
		return consultaRepository.findAll(pageable);
	}
	
	public List<Consulta> listarConsultas(){
		return consultaRepository.findAll();	
	}

	public Consulta buscarConsulta(Long id) {
		Optional<Consulta> consulta = consultaRepository.findById(id);
		return consulta.orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada"));
	}

	public Consulta salvarConsulta(Consulta consulta) {
		Consulta novaConsulta = consultaRepository.save(consulta);
		
		return novaConsulta;
	}

	public Consulta alterarConsulta(Consulta consulta, Long id) {
		Consulta original = buscarConsulta(id);
		consulta.setId(original.getId());
		return salvarConsulta(consulta);
	}

	public void excluirConsulta(Long id) {
		Consulta consulta = buscarConsulta(id);
		consultaRepository.delete(consulta);
	}

}

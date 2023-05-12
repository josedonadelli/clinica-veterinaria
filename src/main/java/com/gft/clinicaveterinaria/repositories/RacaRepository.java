package com.gft.clinicaveterinaria.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.clinicaveterinaria.entities.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long>{

	
	Page<Raca> findAll(Pageable pageable);
	Page<Raca> findByNameContains(Pageable pageable, String nome);
	List<Raca> findByNameContains(String nome);
	Optional<Raca> findByName(String nome);
	Optional<Raca> findByIdAPI(Long idAPI);
}

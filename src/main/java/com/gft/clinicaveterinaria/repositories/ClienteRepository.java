package com.gft.clinicaveterinaria.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.clinicaveterinaria.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

	Page<Cliente> findAll(Pageable pageable);
	Optional<Cliente> findByDocumento(String documento);
	Optional<Cliente> findByUsername(String username);
	
}

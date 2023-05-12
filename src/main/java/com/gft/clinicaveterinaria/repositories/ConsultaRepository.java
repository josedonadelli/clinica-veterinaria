package com.gft.clinicaveterinaria.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.clinicaveterinaria.entities.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

	Page<Consulta> findAll(Pageable pageable);

}

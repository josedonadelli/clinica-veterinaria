package com.gft.clinicaveterinaria.dto.raca;

import com.gft.clinicaveterinaria.entities.Altura;
import com.gft.clinicaveterinaria.entities.Peso;

public class ConsultaRacaDTO {
	private Long idRaca;
	private Long id;
	private String name;
	private String bred_for;
	private String breed_group;
	private String life_span;
	private String origin;
	private String temperament;
	private Altura height;
	private Peso weight;
	
	
	public ConsultaRacaDTO() {
	}
	public ConsultaRacaDTO(Long idRaca, Long id, String name, String bred_for, String breed_group, String life_span, String origin,
			String temperament, Altura height, Peso weight) {
		this.idRaca = idRaca;
		this.id = id;
		this.name = name;
		this.bred_for = bred_for;
		this.breed_group = breed_group;
		this.life_span = life_span;
		this.origin = origin;
		this.temperament = temperament;
		this.height = height;
		this.weight = weight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBred_for() {
		return bred_for;
	}
	public void setBred_for(String bred_for) {
		this.bred_for = bred_for;
	}
	public String getBreed_group() {
		return breed_group;
	}
	public void setBreed_group(String breed_group) {
		this.breed_group = breed_group;
	}
	public String getLife_span() {
		return life_span;
	}
	public void setLife_span(String life_span) {
		this.life_span = life_span;
	}
	public String getTemperament() {
		return temperament;
	}
	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}
	public Altura getHeight() {
		return height;
	}
	public void setHeight(Altura height) {
		this.height = height;
	}
	public Peso getWeight() {
		return weight;
	}
	public void setWeight(Peso weight) {
		this.weight = weight;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Long getIdRaca() {
		return idRaca;
	}
	public void setIdRaca(Long idRaca) {
		this.idRaca = idRaca;
	}
	
	
}

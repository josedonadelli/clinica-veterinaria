package com.gft.clinicaveterinaria.dto.raca;

import com.gft.clinicaveterinaria.entities.Altura;
import com.gft.clinicaveterinaria.entities.Peso;

public class RegistroRacaDTO {
	private Long idAPI;
	private String name;
	private String bred_for;
	private String breed_group;
	private String life_span;
	private String temperament;
	private String origin;
	private Altura height;
	private Peso weight;

	public RegistroRacaDTO() {
	}

	public RegistroRacaDTO(Long idAPI, String name, String bred_for, String breed_group, String life_span,
			String temperament, String origin, Altura height, Peso weight) {
		this.idAPI = idAPI;
		this.name = name;
		this.bred_for = bred_for;
		this.breed_group = breed_group;
		this.life_span = life_span;
		this.temperament = temperament;
		this.origin = origin;
		this.height = height;
		this.weight = weight;
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
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

	public Long getIdAPI() {
		return idAPI;
	}

	public void setIdAPI(Long idAPI) {
		this.idAPI = idAPI;
	}



}

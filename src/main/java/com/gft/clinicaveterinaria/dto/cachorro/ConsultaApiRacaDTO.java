package com.gft.clinicaveterinaria.dto.cachorro;

import com.gft.clinicaveterinaria.entities.Altura;
import com.gft.clinicaveterinaria.entities.Peso;

public class ConsultaApiRacaDTO {
	private Long id;
	private String name;
	private String bred_for;
	private String breed_group;
	private String life_span;
	private String temperament;
	private String origin;
	private Altura height;
	private Peso weight;

	/*
	 * private String weight; // apenas kg private String height; // apenas cm
	 */

	// descobrir como pegar apenas o peso em kilos e altura em cmkm

	public ConsultaApiRacaDTO() {
	}
	/*
	 * // Construtor sem Peso e Altura public ConsultaApiRacaDTO(Long id, String
	 * name, String breed_for, String breed_group, String life_span, String
	 * temperament, String origin) { this.id = id; this.name = name; this.breed_for
	 * = breed_for; this.breed_group = breed_group; this.life_span = life_span;
	 * this.temperament = temperament; this.origin = origin;
	 * 
	 * }
	 */

	public Long getId() {
		return id;
	}

	public ConsultaApiRacaDTO(Long id, String name, String bred_for, String breed_group, String life_span,
			String temperament, String origin, Altura height, Peso weight) {
		this.id = id;
		this.name = name;
		this.bred_for = bred_for;
		this.breed_group = breed_group;
		this.life_span = life_span;
		this.temperament = temperament;
		this.origin = origin;
		this.height = height;
		this.weight = weight;
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

	public void setBred_for(String breed_for) {
		this.bred_for = breed_for;
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

	/*
	 * public String getWeight() { return weight; } public void setWeight(String
	 * weight) { this.weight = weight; } public String getHeight() { return height;
	 * } public void setHeight(String height) { this.height = height; }
	 */

}

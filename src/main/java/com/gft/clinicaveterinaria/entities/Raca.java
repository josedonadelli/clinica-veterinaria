package com.gft.clinicaveterinaria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_raca")
public class Raca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idAPI; // ID retornada pela API
	private String name;
	private String bred_for;
	private String breed_group;
	private String life_span;
	private String temperament;
	private String origin;
	private Altura height;
	private Peso weight;

	public Raca() {
	}

	public Raca(Long idAPI) {
		this.idAPI = idAPI;
	}
	public Raca(Long idAPI, String name) {
		this.idAPI = idAPI;
		this.name = name;
	}

	public Raca(Long id, Long idAPI, String name, String bred_for, String breed_group, String life_span,
			String temperament, String origin, Altura height, Peso weight) {
		this.id = id;
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

	public void setBreed_for(String breed_for) {
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

	public Long getIdAPI() {
		return idAPI;
	}

	public void setIdAPI(Long idAPI) {
		this.idAPI = idAPI;
	}

	public void setBred_for(String bred_for) {
		this.bred_for = bred_for;
	}

}

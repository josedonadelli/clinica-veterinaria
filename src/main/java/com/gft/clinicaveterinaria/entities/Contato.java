package com.gft.clinicaveterinaria.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {
	private String telefone;
	private String email;
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

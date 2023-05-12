package com.gft.clinicaveterinaria.builders;

import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;
import com.gft.clinicaveterinaria.entities.Veterinario;

public class VeterinarioBuilder {

	private Veterinario instancia;

	public VeterinarioBuilder() {
		instancia = new Veterinario();
	}

	public VeterinarioBuilder comCrmv(String crmv) {
		instancia.setCrmv(crmv);
		return this;
	}

	public VeterinarioBuilder comNome(String nome) {
		instancia.setNome(nome);
		return this;
	}
	public VeterinarioBuilder comEndereco(String cep, String logradouro, String numero, String complemento) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		return this;
	}

	public VeterinarioBuilder comContato(String telefone, String email) {
		Contato contato = new Contato();
		contato.setEmail(email);
		contato.setTelefone(telefone);
		instancia.setContato(contato);
		return this;
	}

	public Veterinario build() {
		return instancia;
	}
}

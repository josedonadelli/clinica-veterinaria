package com.gft.clinicaveterinaria.builders;

import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Cliente;
import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;

public class ClienteBuilder {

	private Cliente instancia;

	public ClienteBuilder() {
		instancia = new Cliente();
	}
	
	public ClienteBuilder comDocumento(String documento) {
		instancia.setDocumento(documento);
		return this;
	}
	public ClienteBuilder comNome(String nome) {
		instancia.setNome(nome);
		return this;
	}
	public ClienteBuilder comEndereco(String cep, String logradouro, String numero, String complemento) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		return this;
	}
	public ClienteBuilder comContato(String telefone, String email) {
		Contato contato = new Contato();
		contato.setEmail(email);
		contato.setTelefone(telefone);
		instancia.setContato(contato);
		return this;
	}
	public ClienteBuilder comCachorros(Cachorro cachorro) {
		instancia.getCachorros().add(cachorro);
		return this;
	}
	
	public Cliente build() {
		return instancia;
	}
}

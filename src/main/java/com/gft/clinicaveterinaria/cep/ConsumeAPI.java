package com.gft.clinicaveterinaria.cep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.gft.clinicaveterinaria.entities.Endereco;

public class ConsumeAPI {

	public static Endereco enderecoPorCep(String cep, String numero) {
		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("viacep.com.br")
				.path("ws/" + cep + "/json").build();

		ResponseEntity<Endereco> endereco = template.getForEntity(uri.toUriString(), Endereco.class);
		endereco.getBody().setNumero(numero);
		return endereco.getBody();
	}
}

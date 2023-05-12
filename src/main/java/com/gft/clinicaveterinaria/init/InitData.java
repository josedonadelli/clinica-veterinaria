
package com.gft.clinicaveterinaria.init;

import java.util.Arrays;
import java.util.Date;

import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Cliente;
import com.gft.clinicaveterinaria.entities.Consulta;
import com.gft.clinicaveterinaria.entities.Contato;
import com.gft.clinicaveterinaria.entities.Endereco;
import com.gft.clinicaveterinaria.entities.Raca;
import com.gft.clinicaveterinaria.entities.Veterinario;
import com.gft.clinicaveterinaria.services.CachorroService;
import com.gft.clinicaveterinaria.services.ClienteService;
import com.gft.clinicaveterinaria.services.ConsultaService;
import com.gft.clinicaveterinaria.services.VeterinarioService;



public class InitData {

	private final CachorroService cachorroService;

	private final ClienteService clienteService;

	private final VeterinarioService veterinarioService;
	
	private final ConsultaService consultaService;


	/*
	 * public InitData(CachorroService cachorroService, ClienteService
	 * clienteService, VeterinarioService veterinarioService) { this.cachorroService
	 * = cachorroService; this.clienteService = clienteService;
	 * this.veterinarioService = veterinarioService;
	 * 
	 * }
	 */
	
	public InitData(CachorroService cachorroService, ClienteService clienteService,
			VeterinarioService veterinarioService, ConsultaService consultaService) {
		this.cachorroService = cachorroService;
		this.clienteService = clienteService;
		this.veterinarioService = veterinarioService;
		this.consultaService = consultaService;
	}

	public void popular() {

		int tamanho = 0;

		tamanho = clienteService.listarClientes().size() + veterinarioService.listarVeterinarios().size()
				+ cachorroService.listarCachorros().size();

		if (tamanho == 0) {
			Cliente cliente = new Cliente();
			Cachorro cachorro = new Cachorro();
			Veterinario veterinario = new Veterinario();
			Consulta consulta = new Consulta();
			Contato contato = new Contato();
			Endereco endereco = new Endereco();
			Raca raca = new Raca();
			contato.setEmail("email_aleatorio@hotmail.com");
			contato.setTelefone("12341121");
			endereco.setNumero("12");
			endereco.setCep("13484360");
			
			cliente.setUsername("cliente1");
			cliente.setPassword("123cliente456");
			cliente.setDocumento("132315674");
			cliente.setNome("Andre");
			cliente.setEndereco(endereco);
			cliente.setContato(contato);
			cliente.getRoles().add("USERS");
			clienteService.salvar(cliente);
			
			
			raca.setIdAPI(210L);
			cachorro.setRaca(raca);
			cachorro.setNome("Rex");
			cachorro.setCliente(cliente);
			cachorroService.salvarCachorro(cachorro);

		
			veterinario.setUsername("vetporamor");
			veterinario.setPassword("mentiraehpelodinheiro");
			veterinario.setRoles(Arrays.asList("USERS", "MANAGERS"));
			veterinario.setCrmv("12345");
			veterinario.setContato(contato);
			veterinario.setEndereco(endereco);
			veterinario.setNome("Brisa");
			veterinarioService.salvarVeterinario(veterinario);
			
			consulta.setCachorro(cachorro);
			consulta.setVeterinario(veterinario);
			consulta.setData(new Date());
			consulta.setDiagnostico("Tá tudo bem");
			consulta.setComentarios("");
			consulta.setAltura(55d);
			consulta.setIdade(1);
			consulta.setPeso(13d);
			consultaService.salvarConsulta(consulta);
			
		}
	}




}

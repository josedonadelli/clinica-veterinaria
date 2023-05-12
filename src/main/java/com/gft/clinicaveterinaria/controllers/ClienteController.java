package com.gft.clinicaveterinaria.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.clinicaveterinaria.dto.cliente.ClienteMapper;
import com.gft.clinicaveterinaria.dto.cliente.ConsultaClienteBasicoDTO;
import com.gft.clinicaveterinaria.dto.cliente.ConsultaClienteDTO;
import com.gft.clinicaveterinaria.dto.cliente.RegistroClienteDTO;
import com.gft.clinicaveterinaria.dto.consulta.ConsultaConsultaBasicoDTO;
import com.gft.clinicaveterinaria.dto.consulta.ConsultaMapper;
import com.gft.clinicaveterinaria.entities.Cliente;
import com.gft.clinicaveterinaria.entities.Consulta;
import com.gft.clinicaveterinaria.services.ClienteService;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;

	}

	@GetMapping
	public ResponseEntity<Page<ConsultaClienteBasicoDTO>> listarTodosOsClientes(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(clienteService.listarClientes(pageable).map(ClienteMapper::fromEntityBasico));
	}

	@GetMapping("{documento}")
	public ResponseEntity<ConsultaClienteDTO> buscarCliente(@PathVariable String documento) {
		return ResponseEntity.ok(ClienteMapper.fromEntity(clienteService.buscarCliente(documento)));
	}

	@GetMapping("{documento}/cachorros/{id}/consultas")

	public ResponseEntity<Page<ConsultaConsultaBasicoDTO>> listarConsultasCachorroCliente(

			@PageableDefault Pageable pageable, @PathVariable String documento, @PathVariable Long id) {
		List<Consulta> consultas = clienteService.buscarCachorroDoCliente(documento, id).getHistoricoConsultas();

		return ResponseEntity.ok(ConsultaMapper.toPageFromEntity(pageable, consultas));
	}

	@PostMapping
	public ResponseEntity<ConsultaClienteDTO> salvarCliente(@RequestBody RegistroClienteDTO dto) {
		Cliente cliente = clienteService.salvar(ClienteMapper.fromDTO(dto));
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}

	@PutMapping("{documento}")
	public ResponseEntity<ConsultaClienteDTO> alterarCliente(@RequestBody RegistroClienteDTO dto,
			@PathVariable String documento) {
		Cliente cliente = clienteService.alterarCliente(ClienteMapper.fromDTO(dto), documento);

		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}

	@DeleteMapping("{documento}")
	public ResponseEntity<ConsultaClienteDTO> excluirCliente(@PathVariable String documento) {
		clienteService.excluirCliente(documento);
		return ResponseEntity.ok().build();
	}

}

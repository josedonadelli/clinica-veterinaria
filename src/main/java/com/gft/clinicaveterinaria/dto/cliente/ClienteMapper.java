package com.gft.clinicaveterinaria.dto.cliente;

import com.gft.clinicaveterinaria.entities.Cliente;

public class ClienteMapper {

	public static ConsultaClienteDTO fromEntity(Cliente cliente) {
		return new ConsultaClienteDTO(cliente.getDocumento(), cliente.getNome(), cliente.getEndereco(), cliente.getContato(), cliente.getCachorros());
	}
	
	public static Cliente fromDTO(RegistroClienteDTO dto) {
		return new Cliente(null, dto.getNome(), dto.getUsername(), dto.getPassword(), dto.getDocumento(), dto.getEndereco(), dto.getContato(), dto.getCachorros());
	}
	
	public static ConsultaClienteBasicoDTO fromEntityBasico(Cliente cliente) {
		return new ConsultaClienteBasicoDTO(cliente.getDocumento(), cliente.getNome(), cliente.getEndereco(), cliente.getContato());
	}
	

	
	
}

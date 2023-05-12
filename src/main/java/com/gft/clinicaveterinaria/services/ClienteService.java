package com.gft.clinicaveterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gft.clinicaveterinaria.cep.ConsumeAPI;
import com.gft.clinicaveterinaria.entities.Cachorro;
import com.gft.clinicaveterinaria.entities.Cliente;
import com.gft.clinicaveterinaria.exception.EntityNotFoundException;
import com.gft.clinicaveterinaria.repositories.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final CachorroService cachorroService;
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	private PasswordEncoder encoder;
	public ClienteService(ClienteRepository clienteRepository, CachorroService cachorroService) {
		this.clienteRepository = clienteRepository;
		this.cachorroService = cachorroService;
	}

	public Cliente salvar(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		cliente.setEndereco(ConsumeAPI.enderecoPorCep(cep, cliente.getEndereco().getNumero()));
		String pass = cliente.getPassword();
		cliente.setPassword(encoder.encode(pass));
		return clienteRepository.save(cliente);
	}

	public Page<Cliente> listarClientes(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Cliente buscarCliente(String documento) {
		Optional<Cliente> cliente = clienteRepository.findByDocumento(documento);
		return cliente.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));
	}

	public Cliente alterarCliente(Cliente cliente, String documento) {
		Cliente original = buscarCliente(documento);

		cliente.setDocumento(original.getDocumento());
		return clienteRepository.save(cliente);

	}

	public void excluirCliente(String documento) {
		Cliente cliente = buscarCliente(documento);
		clienteRepository.delete(cliente);
	}

	public Cachorro buscarCachorroDoCliente(String username, Long id) {
		Cliente cliente = buscarCliente(username);
		Cachorro cachorro = cachorroService.buscarCachorro(id);

		if (cachorro == null) {
			throw new EntityNotFoundException("Cachorro não encontrado");
		}
		if (cachorro.getCliente().getUsername() != cliente.getUsername())
			throw new EntityNotFoundException("Nome de usuários do cliente diferente do nome de usuário do tutor do cachorro");

		return cachorro;
	}

}

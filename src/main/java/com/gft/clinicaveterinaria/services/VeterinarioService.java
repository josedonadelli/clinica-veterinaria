package com.gft.clinicaveterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gft.clinicaveterinaria.cep.ConsumeAPI;
import com.gft.clinicaveterinaria.entities.Veterinario;
import com.gft.clinicaveterinaria.exception.EntityNotFoundException;
import com.gft.clinicaveterinaria.repositories.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	private PasswordEncoder encoder;
	private final VeterinarioRepository veterinarioRepository;

	public VeterinarioService(VeterinarioRepository veterinarioRepository) {
		this.veterinarioRepository = veterinarioRepository;
	}

	public Veterinario salvarVeterinario(Veterinario veterinario) {
		veterinario.setEndereco(ConsumeAPI.enderecoPorCep(veterinario.getEndereco().getCep(), veterinario.getEndereco().getNumero()));
		String pass = veterinario.getPassword();
		veterinario.setPassword(encoder.encode(pass));
		return veterinarioRepository.save(veterinario);
	}

	public Veterinario buscarVeterinario(String crmv) {
		Optional<Veterinario> veterinario = veterinarioRepository.findById(crmv);

		return veterinario.orElseThrow(() -> new EntityNotFoundException("Veterinario não encontrado."));
	}

	public Page<Veterinario> listarVeterinarios(Pageable pageable) {
		return veterinarioRepository.findAll(pageable);
	}

	public List<Veterinario> listarVeterinarios() {
		return veterinarioRepository.findAll();
	}

	public Veterinario alterarVeterinario(Veterinario veterinario, String crmv) {
		Veterinario original;
		original = buscarVeterinario(crmv);

		veterinario.setCrmv(original.getCrmv());
		return veterinarioRepository.save(veterinario);
	}

	public void excluirVeterinario(String crmv) {

		Veterinario veterinario;
		veterinario = buscarVeterinario(crmv);
		veterinarioRepository.delete(veterinario);

	}

}

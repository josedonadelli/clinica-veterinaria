package com.gft.clinicaveterinaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gft.clinicaveterinaria.entities.Usuario;
import com.gft.clinicaveterinaria.exception.EntityNotFoundException;
import com.gft.clinicaveterinaria.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Usuario criarUsuario(Usuario usuario) {
		String pass = usuario.getPassword();
		usuario.setPassword(encoder.encode(pass));
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarUsuario(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return usuario.orElseThrow(()->new EntityNotFoundException("Usuario não encontrado"));
	}

	public void excluirUsuario(Integer id) {
		Usuario usuario = buscarUsuario(id);
		usuarioRepository.delete(usuario);
	}
}

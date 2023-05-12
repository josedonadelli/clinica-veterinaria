package com.gft.clinicaveterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.clinicaveterinaria.entities.Usuario;
import com.gft.clinicaveterinaria.services.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {
	
	@Autowired UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		usuarioService.criarUsuario(usuario);
		return ResponseEntity.ok().build();
	}
	
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable Integer id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.ok().build();
	}
	

}

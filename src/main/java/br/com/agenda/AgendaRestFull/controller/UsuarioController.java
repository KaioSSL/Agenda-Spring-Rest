package br.com.agenda.AgendaRestFull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.AgendaRestFull.models.DTO.UsuarioDTO;
import br.com.agenda.AgendaRestFull.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;

	@PostMapping
	public ResponseEntity<UsuarioDTO> insertUsuario(@Validated @RequestBody UsuarioDTO usuario) {
		return service.insert(usuario);
	}

	@PutMapping
	public ResponseEntity<UsuarioDTO> updateUsuario(@Validated @RequestBody UsuarioDTO usuario) {
		return service.update(usuario);
	}

	@DeleteMapping
	public ResponseEntity<UsuarioDTO> deleteUsuario(@Validated @RequestBody UsuarioDTO usuario) {
		return service.delete(usuario);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
		return service.get();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable(name = "id", required = true) Integer id) {
		return service.get(id);
	}
}

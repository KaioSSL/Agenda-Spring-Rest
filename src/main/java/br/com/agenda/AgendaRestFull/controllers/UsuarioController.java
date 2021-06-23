package br.com.agenda.AgendaRestFull.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.agenda.AgendaRestFull.models.Usuario;
import br.com.agenda.AgendaRestFull.repositorys.UsuarioRepository;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping
	public ResponseEntity<Usuario> insertUsuario(@Validated @RequestBody Usuario usuario) {
		if (usuarioRepository.save(usuario) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usuario);
		}
	}

	@PutMapping
	public ResponseEntity<Usuario> updateUsuario(@Validated @RequestBody Usuario usuario) {
		if (usuarioRepository.findById(usuario.getId()).isPresent()) {
			if (usuarioRepository.save(usuario) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(usuario);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usuario);
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Usuario> deleteUsuario(@Validated @RequestBody Usuario usuario) {
		try {
			if (usuarioRepository.findById(usuario.getId()).isPresent()) {
				usuarioRepository.delete(usuario);
				return ResponseEntity.status(HttpStatus.OK).body(usuario);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usuario);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable(name = "id", required = true) Integer id) {
		Optional<Usuario> opUsuario = usuarioRepository.findById(id);
		Usuario usuario = opUsuario.isPresent() ? opUsuario.get() : null;
		if (usuario != null) {
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping
	public ResponseEntity<Iterable<Usuario>> getUsuarios() {
		Iterable<Usuario> itUsuario = usuarioRepository.findAll();
		if (itUsuario.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(itUsuario);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}

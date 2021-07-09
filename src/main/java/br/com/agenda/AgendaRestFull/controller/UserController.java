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
import br.com.agenda.AgendaRestFull.service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	//CRUD Usuário --------
	@PostMapping(path ="/insert")
	public ResponseEntity<UsuarioDTO> insertUsuario(@Validated @RequestBody UsuarioDTO usuario) {
		return service.insertUser(usuario);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<UsuarioDTO> updateUsuario(@Validated @RequestBody UsuarioDTO usuario) {
		return service.updateUser(usuario);
	}

	@DeleteMapping(path = "/delete")
	public ResponseEntity<UsuarioDTO> deleteUsuario(@Validated @RequestBody UsuarioDTO usuario) {
		return service.deleteUser(usuario);
	}
	
	@GetMapping(path = "/list")
	public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
		return service.getUsers();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable(name = "id", required = true) Integer id) {
		return service.getUser(id);
	}
	//CRUD Usuário --------
	
	//Login Usuário ------
	@PostMapping(path = "/login")
	public ResponseEntity<UsuarioDTO> login(@Validated @RequestBody UsuarioDTO usuario){
		return service.login(usuario);
	}
	//Login Usuário ------	

}

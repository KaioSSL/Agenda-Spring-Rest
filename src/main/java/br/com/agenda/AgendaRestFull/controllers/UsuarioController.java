package br.com.agenda.AgendaRestFull.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		if(usuarioRepository.save(usuario) != null) {			
			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		}else{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usuario);
		}
	}
	
	@PutMapping
	public ResponseEntity<Usuario> updateUsuario(@Validated @RequestBody Usuario usuario){
		if(usuarioRepository.save(usuario) != null){
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usuario);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Usuario> deleteUsuario(@Validated @RequestBody Usuario usuario){
		try {
			if(!usuarioRepository.findById(usuario.getId()).isEmpty()) {
				usuarioRepository.delete(usuario);
				return ResponseEntity.status(HttpStatus.OK).body(usuario);				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usuario);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@RequestParam(name = "id",required = true) Integer id){
		Usuario usuario = usuarioRepository.findById(id).get();
		if(usuario!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Usuario>> getUsuarios(){
		Iterable<Usuario> itUsuario = usuarioRepository.findAll();
		if(itUsuario.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(itUsuario);			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
	}
}

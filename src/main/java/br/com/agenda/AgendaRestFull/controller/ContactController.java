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

import br.com.agenda.AgendaRestFull.models.DTO.ContatoDTO;
import br.com.agenda.AgendaRestFull.models.DTO.EnderecoDTO;
import br.com.agenda.AgendaRestFull.models.DTO.GrupoDTO;
import br.com.agenda.AgendaRestFull.service.ContactService;

@RestController
@RequestMapping(path = "/api/contact")
public class ContactController {
	
	@Autowired
	ContactService service;
	
	//CRUD Endereco --------
	@PostMapping(path = "/address")
	public ResponseEntity<EnderecoDTO> insertEndereco(@Validated @RequestBody EnderecoDTO endereco){
		return service.insertEndereco(endereco);
	}
	
	@PutMapping(path = "/address")
	public ResponseEntity<EnderecoDTO> updateEndereco(@Validated @RequestBody EnderecoDTO endereco){
		return service.updateEndereco(endereco);
	}

	@DeleteMapping(path = "/address")
	public ResponseEntity<EnderecoDTO> deleteEndereco(@Validated @RequestBody EnderecoDTO endereco){
		return service.deleteEndereco(endereco);
	}

	@GetMapping(path = "/address/list")
	public ResponseEntity<List<EnderecoDTO>> getEnderecos(){
		return service.getEnderecos();
	}

	@GetMapping(path = "/address/{id}")
	public ResponseEntity<EnderecoDTO> getEndereco(@PathVariable(name = "id", required = true) Integer id){
		return service.getEndereco(id);
	}
	//CRUD Endereco --------	

	
	//CRUD Grupo --------
	@PostMapping(path = "/group")
	public ResponseEntity<GrupoDTO> insertGrupo(@Validated @RequestBody GrupoDTO grupo) {
		return service.insertGrupo(grupo);
	}

	@PutMapping(path = "/group")
	public ResponseEntity<GrupoDTO> updateGrupo(@Validated @RequestBody GrupoDTO grupo) {	
		return service.updateGrupo(grupo);
	}

	@DeleteMapping(path = "/group")
	public ResponseEntity<GrupoDTO> deleteGrupo(@Validated @RequestBody GrupoDTO grupo) {
		return service.deleteGrupo(grupo);
	}
	
	@GetMapping(path = "/group/list")
	public ResponseEntity<List<GrupoDTO>> getGrupos() {
		return service.getGrupos();
	}

	@GetMapping(path = "/group/{id}")
	public ResponseEntity<GrupoDTO> getGrupo(@PathVariable(name = "id", required = true) Integer id) {
		return service.getGrupo(id);
	}
	//CRUD Grupo --------
	
	//CRUD Contato --------
	
	@PostMapping
	public ResponseEntity<ContatoDTO> insertContato(@Validated @RequestBody ContatoDTO contato) {
		return service.insertContato(contato);
	}

	@PutMapping
	public ResponseEntity<ContatoDTO> updateContato(@Validated @RequestBody ContatoDTO contato) {
		return service.updateContato(contato);
	}

	@DeleteMapping
	public ResponseEntity<ContatoDTO> deleteContato(@Validated @RequestBody ContatoDTO contato) {
		return service.deleteContato(contato);
	}
	
	@GetMapping(path = "/list")
	public ResponseEntity<List<ContatoDTO>> getContatos(){
		return service.getContatos();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ContatoDTO> getContato(@PathVariable(name = "id", required = true) Integer id){
		return service.getContato(id);
	}
	//CRUD Contato --------	
}

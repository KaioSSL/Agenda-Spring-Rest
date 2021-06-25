package br.com.agenda.AgendaRestFull.controller;

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

import br.com.agenda.AgendaRestFull.models.Entity.ContatoEntity;
import br.com.agenda.AgendaRestFull.repositorys.ContatoRepository;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;

	@PostMapping
	public ResponseEntity<ContatoEntity> insertContato(@Validated @RequestBody ContatoEntity contato) {
		if (contatoRepository.save(contato) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(contato);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping
	public ResponseEntity<ContatoEntity> updateContato(@Validated @RequestBody ContatoEntity contato) {
		if (contatoRepository.findById(contato.getId()).isPresent()) {
			if (contatoRepository.save(contato) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(contato);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping
	public ResponseEntity<ContatoEntity> deleteContato(@Validated @RequestBody ContatoEntity contato) {
		try {
			if(contatoRepository.findById(contato.getId()).isPresent()) {
				contatoRepository.delete(contato);
				return ResponseEntity.status(HttpStatus.OK).body(contato);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ContatoEntity> getContato(@PathVariable(name = "id", required = true) Integer id){
		Optional<ContatoEntity> opContato = contatoRepository.findById(id);
		ContatoEntity contato = opContato.isPresent()?opContato.get():null;
		if(contato != null) {
			return ResponseEntity.status(HttpStatus.OK).body(contato);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Iterable<ContatoEntity>> getContatos(){
		Iterable<ContatoEntity> contatos = contatoRepository.findAll();
		if(contatos.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(contatos);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}

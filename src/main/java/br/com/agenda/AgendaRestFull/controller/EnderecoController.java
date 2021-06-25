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

import br.com.agenda.AgendaRestFull.models.Entity.Endereco;
import br.com.agenda.AgendaRestFull.repositorys.EnderecoRepository;

@RestController
@RequestMapping(path = "/api/endereco")
public class EnderecoController {

	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping
	public ResponseEntity<Endereco> insertEndereco(@Validated @RequestBody Endereco endereco){
		if(enderecoRepository.save(endereco)!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Endereco> updateEndereco(@Validated @RequestBody Endereco endereco){
		if(enderecoRepository.findById(endereco.getId()).isPresent()) {
			if(enderecoRepository.save(endereco) !=null) {
				return ResponseEntity.status(HttpStatus.OK).body(endereco);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Endereco> deleteEndereco(@Validated @RequestBody Endereco endereco){
		try {
			if(enderecoRepository.findById(endereco.getId()).isPresent()) {
				enderecoRepository.delete(endereco);
				return ResponseEntity.status(HttpStatus.OK).body(endereco);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Endereco>> getEnderecos(){
		Iterable<Endereco> itEndereco = enderecoRepository.findAll();
		if(itEndereco.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(itEndereco);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Endereco> getEndereco(@PathVariable(name = "id", required = true) Integer id){
		Optional<Endereco> opEndereco = enderecoRepository.findById(id);
		Endereco endereco = opEndereco.isPresent()?opEndereco.get():null;
		if(endereco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(endereco);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
}

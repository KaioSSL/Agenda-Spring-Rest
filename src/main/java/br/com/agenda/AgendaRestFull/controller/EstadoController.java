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

import br.com.agenda.AgendaRestFull.models.Entity.Estado;
import br.com.agenda.AgendaRestFull.repositorys.EstadoRepository;

@RestController
@RequestMapping(path = "/api/estado")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;

	@PostMapping
	public ResponseEntity<Estado> insertEstado(@Validated @RequestBody Estado estado) {
		if (estadoRepository.save(estado) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(estado);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping
	public ResponseEntity<Estado> updateEstado(@Validated @RequestBody Estado estado) {
		if (estadoRepository.findById(estado.getId()).isPresent()) {
			if (estadoRepository.save(estado) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(estado);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Estado> deleteEstado(@Validated @RequestBody Estado estado) {
		try {
			if (estadoRepository.findById(estado.getId()).isPresent()) {
				estadoRepository.delete(estado);
				return ResponseEntity.status(HttpStatus.OK).body(estado);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping
	public ResponseEntity<Iterable<Estado>> getEstados(){
		Iterable<Estado> itEstado = estadoRepository.findAll();
		if(itEstado.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(itEstado);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Estado> getEstado(@PathVariable(name = "id",required = true) Integer id){
		Optional<Estado> opEstado = estadoRepository.findById(id);
		Estado estado = opEstado.isPresent()?opEstado.get():null;
		if(estado !=null ) {
			return ResponseEntity.status(HttpStatus.OK).body(estado);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}

package br.com.agenda.AgendaRestFull.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.agenda.AgendaRestFull.models.DTO.UsuarioDTO;
import br.com.agenda.AgendaRestFull.models.Entity.UsuarioEntity;
import br.com.agenda.AgendaRestFull.repositorys.UsuarioRepository;

public class UsuarioService implements AgendaService<UsuarioDTO>{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseEntity<UsuarioDTO> insert(UsuarioDTO usuarioDto) {
		try {
			UsuarioEntity usuario = modelMapper.map(usuarioDto, UsuarioEntity.class);
			if (usuarioRepository.save(usuario) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@Transactional
	public ResponseEntity<UsuarioDTO> update(UsuarioDTO usuarioDto) {
		try {
			UsuarioEntity usuario = modelMapper.map(usuarioDto, UsuarioEntity.class);
			if (usuarioRepository.findById(usuario.getId()).isPresent()) {
				if (usuarioRepository.save(usuario) != null) {
					return ResponseEntity.status(HttpStatus.OK).body(usuarioDto);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@Transactional
	public ResponseEntity<UsuarioDTO> delete(UsuarioDTO usuarioDto) {
		try {
			UsuarioEntity usuario = modelMapper.map(usuarioDto, UsuarioEntity.class);
			if (usuarioRepository.findById(usuario.getId()).isPresent()) {
				usuarioRepository.delete(usuario);
				return ResponseEntity.status(HttpStatus.OK).body(usuarioDto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@Transactional
	public ResponseEntity<List<UsuarioDTO>> get() {
		try {
			Iterable<UsuarioEntity> itUsuario = usuarioRepository.findAll();
			List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
			itUsuario.forEach(x -> listUsuarioDTO.add(modelMapper.map(x,UsuarioDTO.class)));			
			if (itUsuario.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listUsuarioDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@Transactional
	public ResponseEntity<UsuarioDTO> get(Integer id) {
		try{
			Optional<UsuarioEntity> opUsuario = usuarioRepository.findById(id);
			UsuarioDTO usuarioDTO = opUsuario.isPresent() ? modelMapper.map(opUsuario.get(),UsuarioDTO.class) : null;
			if (usuarioDTO != null) {
				return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

}

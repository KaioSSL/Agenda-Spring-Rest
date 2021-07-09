package br.com.agenda.AgendaRestFull.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.AgendaRestFull.models.DTO.UsuarioDTO;
import br.com.agenda.AgendaRestFull.models.Entity.UsuarioEntity;
import br.com.agenda.AgendaRestFull.repositorys.UsuarioRepository;

@Service
public class UserService {
	
	//Repositorys to manipulate entity objects
	@Autowired
	UsuarioRepository repository;
	//Object used to encrypt password
	@Autowired
	PasswordEncoder encoder;
	
	//ModelMapper, to map the entity to dto, and dto to entity
	@Autowired
	ModelMapper mapper;

	//CRUD Usuário----------
	@Transactional
	public ResponseEntity<UsuarioDTO> insertUser(UsuarioDTO usuarioDto) {
		try {
			UsuarioEntity usuario = mapper.map(usuarioDto, UsuarioEntity.class);
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			if (repository.save(usuario) != null) {
				usuarioDto = mapper.map(usuario,UsuarioDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<UsuarioDTO> updateUser(UsuarioDTO usuarioDto) {
		try {
			UsuarioEntity usuario = mapper.map(usuarioDto, UsuarioEntity.class);
			if (repository.findById(usuario.getId()).isPresent()) {
				usuario.setSenha(encoder.encode(usuario.getSenha()));
				if (repository.save(usuario) != null) {
					usuarioDto = mapper.map(usuario,UsuarioDTO.class);
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
	
	@Transactional
	public ResponseEntity<UsuarioDTO> deleteUser(UsuarioDTO usuarioDto) {
		try {
			UsuarioEntity usuario = mapper.map(usuarioDto, UsuarioEntity.class);
			if (repository.findById(usuario.getId()).isPresent()) {
				repository.delete(usuario);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<List<UsuarioDTO>> getUsers() {
		try {
			Iterable<UsuarioEntity> itUsuario = repository.findAll();
			List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
			itUsuario.forEach(x -> listUsuarioDTO.add(mapper.map(x,UsuarioDTO.class)));			
			if (listUsuarioDTO.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listUsuarioDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@Transactional
	public ResponseEntity<UsuarioDTO> getUser(Integer id) {
		try{
			Optional<UsuarioEntity> opUsuario = repository.findById(id);
			UsuarioDTO usuarioDTO = opUsuario.isPresent() ? mapper.map(opUsuario.get(),UsuarioDTO.class) : null;
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
	//CRUD Usuário --------
	
	//Login Usuário ------ 	
	public ResponseEntity<UsuarioDTO> login(UsuarioDTO usuarioDto){
		try {
			if(usuarioDto.getLogin() == null || usuarioDto.getSenha() == null) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}		
			UsuarioEntity usuarioE = repository.findByLogin(usuarioDto.getLogin());	
			if(usuarioE.getLogin().equals(usuarioDto.getLogin()) && encoder.matches(usuarioDto.getSenha(),usuarioE.getSenha())){
				usuarioDto = mapper.map(usuarioE, UsuarioDTO.class);
				return ResponseEntity.status(HttpStatus.OK).body(usuarioDto);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	//Login Usuário ------ 
}

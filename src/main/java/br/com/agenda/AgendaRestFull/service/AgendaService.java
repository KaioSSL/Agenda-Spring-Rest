package br.com.agenda.AgendaRestFull.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public abstract interface AgendaService<T> {
	public ResponseEntity<T> insert(T modelDto);
	public ResponseEntity<T> update(T modelDto);
	public ResponseEntity<T> delete(T modelDto);
	public ResponseEntity<List<T>> get();
	public ResponseEntity<T> get(Integer id);
}

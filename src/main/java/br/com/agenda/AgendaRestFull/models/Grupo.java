package br.com.agenda.AgendaRestFull.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AG_GRUPO")
public class Grupo {

	private Integer id;
	private String desc;
	private Date data_cadastro;
}

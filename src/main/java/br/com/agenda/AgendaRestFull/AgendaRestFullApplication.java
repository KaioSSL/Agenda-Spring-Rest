package br.com.agenda.AgendaRestFull;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendaRestFullApplication {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(AgendaRestFullApplication.class, args);
	}

}

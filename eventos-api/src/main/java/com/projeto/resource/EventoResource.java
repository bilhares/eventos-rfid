package com.projeto.resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Evento;
import com.projeto.model.Usuario;

@RestController
@RequestMapping("/api")
public class EventoResource {

	// retorna uma lista de eventos
	@RequestMapping(value = "/eventos", method = RequestMethod.GET)
	public void eventos() {
	}

	// cadastra um novo evento
	@RequestMapping(value = "/eventos", method = RequestMethod.POST)
	public void eventos(@RequestBody Evento evento) {
	}

	// retorna uma lista de eventos relacionados com um user especifico
	@RequestMapping(value = "/eventos/user", method = RequestMethod.POST)
	public void eventosUsuarios(Usuario user) {
	}

	// Retorna todos os participantes de um evento
	@RequestMapping(value = "/eventos/participantes", method = RequestMethod.POST)
	public void participantes(Evento evento) {
	}

	// retorna as tags relacionadas ao evento
	@RequestMapping(value = "/eventos/tags", method = RequestMethod.POST)
	public void getTags(Evento evento) {
	}
}

package com.projeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.EventosController;
import com.projeto.model.Evento;
import com.projeto.model.Usuario;

@RestController
@RequestMapping("/api")
public class EventoResource {
	@Autowired
	EventosController evControl;

	// localhost:8081/api/eventos?size=1&page=0

	// retorna uma lista de eventos
	@RequestMapping(value = "/eventos", method = RequestMethod.GET)
	public Page<Evento> eventos(Pageable page) {
		return evControl.getEventos(page);
	}

	// retorna uma lista de eventos virgens
	@RequestMapping(value = "/eventos/sem-tag", method = RequestMethod.GET)
	public List<Evento> eventosVirgens() {
		return evControl.getEventosSemTag();
	}

	// retorna um evento
	@RequestMapping(value = "/eventos/{id}", method = RequestMethod.GET)
	public Evento evento(@PathVariable("id") Long id) {
		return evControl.getById(id);
	}

	// cadastra um novo evento
	@RequestMapping(value = "/eventos", method = RequestMethod.POST)
	public void eventos(@RequestBody Evento evento) {
		evControl.saveEventp(evento);
	}

	// deleta um novo evento
	@RequestMapping(value = "/eventos/{id}", method = RequestMethod.DELETE)
	public void deletaEvento(@PathVariable("id") Long id) {
		evControl.delete(id);
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

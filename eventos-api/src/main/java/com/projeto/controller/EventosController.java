package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.projeto.model.Evento;
import com.projeto.model.Usuario;
import com.projeto.repository.EventoRepository;

@Controller
public class EventosController {
	@Autowired
	EventoRepository evRepo;

	public Page<Evento> getEventos(Pageable page) {
		return evRepo.findAll(page);
	}

	public void saveEventp(Evento e) {
		evRepo.save(e);
	}
	
	public void eventosByUser(Pageable page, Usuario user) {
		//evRepo.getEventosByUser(page, user.getId());
	}

}

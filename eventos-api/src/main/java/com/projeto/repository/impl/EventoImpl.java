package com.projeto.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;

import com.projeto.model.Evento;

@Controller
public class EventoImpl {

	@PersistenceContext
	EntityManager manager;
	
	
	public List<Evento> eventosSemTag(){
		Query query = manager.createNativeQuery("select * from tb_evento e\r\n" + 
				"where e.id not in (select i.id_evento from rfid i);", Evento.class);
		List<Evento> resultList = query.getResultList();
		return resultList;
	}
}

package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	// -- todos eventos de um user
	// use eventos;
	// select e.* from tb_evento e
	// join tb_ingresso_usuario i on (i.id_evento = e.id)
	// join tb_usuario u on (i.id_usuario = u.id)
	// where u.id = 1;
	//
	// -- todos user num evento
	// select u.* from tb_evento e
	// join tb_ingresso_usuario i on (i.id_evento = e.id)
	// join tb_usuario u on (i.id_usuario = u.id)
	// where e.id = 1;
}
